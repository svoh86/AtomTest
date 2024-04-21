package ru.home.webservice.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.home.webservice.cache.Cache;
import ru.home.webservice.model.HourlyPayment;
import ru.home.webservice.serice.ExternalService;
import ru.home.webservice.serice.IsDayOffService;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static ru.home.webservice.util.IsDayOffServiceUtil.*;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
@WebServlet(urlPatterns = "/hourly_payment")
public class GetHourlyPaymentServlet extends HttpServlet {
    private final ExternalService externalService = new IsDayOffService();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Cache cache;

    @Override
    public void init(ServletConfig config){
        this.cache = (Cache) config.getServletContext().getAttribute("cache");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String year = req.getParameter("year");
        final String month = req.getParameter("month");
        final String salary = req.getParameter("salary");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json;
        String cacheKey = String.join("", List.of(year, month, salary));
        Optional<String> value = cache.get(cacheKey);
        if (value.isPresent()) {
            json = value.get();
        } else {
            String content = externalService.getContent(year, month);
            long workDays = workDays(content);
            long halfHoliday = halfHoliday(content);
            int workDays_month = (int) (workDays + halfHoliday);
            BigDecimal hour_income = hour_income(new BigDecimal(salary), workDays, halfHoliday);
            HourlyPayment hourlyPayment = getHourlyPayment(year, month, salary, hour_income, workDays_month);
            json = objectMapper.writeValueAsString(hourlyPayment);
            cache.put(cacheKey, json);
        }
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
        }
    }
}
