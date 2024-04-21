package ru.home.webservice.util;

import lombok.experimental.UtilityClass;
import ru.home.webservice.model.HourlyPayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
@UtilityClass
public class IsDayOffServiceUtil {
    private final char WORKDAYS = '0';
    private final char HALF_HOLIDAY = '2';

    public long workDays(String content) {
        return content.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c == WORKDAYS)
                .count();
    }

    public long halfHoliday(String content) {
        return content.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c == HALF_HOLIDAY)
                .count();
    }

    public BigDecimal hour_income(BigDecimal salary, long workdays, long halfHoliday) {
        long workHours = workdays * 8 + halfHoliday * 7;
        return salary.divide(BigDecimal.valueOf(workHours),2, RoundingMode.HALF_UP);
    }

    public HourlyPayment getHourlyPayment(
            String year,
            String month,
            String salary,
            BigDecimal hour_income,
            int workDays_month) {
        Month value = Month.of(Integer.parseInt(month));
        return new HourlyPayment(
                Integer.parseInt(year),
                value.name(),
                Integer.parseInt(salary),
                hour_income,
                workDays_month);
    }
}
