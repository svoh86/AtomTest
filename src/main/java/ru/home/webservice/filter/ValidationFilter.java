package ru.home.webservice.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.home.webservice.util.ErrorMessage;

import java.io.IOException;
import java.io.PrintWriter;

import static ru.home.webservice.util.ValidationUtil.*;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
@WebFilter(urlPatterns = "/hourly_payment")
public class ValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String salary = req.getParameter("salary");
        if (!isYear(year)) {
            validate(ErrorMessage.YEAR_NOT_CORRECT, req, resp);
            return;
        }
        if (!isMonth(month)) {
            validate(ErrorMessage.MONTH_NOT_CORRECT, req, resp);
            return;
        }
        if (!isSalary(salary)) {
            validate(ErrorMessage.SALARY_NOT_POSITIVE, req, resp);
            return;
        }
        chain.doFilter(request, response);
    }

    private void validate(
            ErrorMessage message,
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.include(req, resp);
        writer.write(message.getMessage());
    }
}
