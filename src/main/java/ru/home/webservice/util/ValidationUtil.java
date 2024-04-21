package ru.home.webservice.util;

import lombok.experimental.UtilityClass;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
@UtilityClass
public class ValidationUtil {
    private static final int MIN_YEAR = 2004;
    private static final int MAX_YEAR = 2025;

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    public boolean isYear(String year) {
        if (year.isEmpty()) {
            return false;
        }
        int i = Integer.parseInt(year);
        return i >= MIN_YEAR && i <= MAX_YEAR;
    }

    public boolean isMonth(String month) {
        if (month.isEmpty()) {
            return false;
        }
        int i = Integer.parseInt(month);
        return i >= MIN_MONTH && i <= MAX_MONTH;
    }

    public boolean isSalary(String salary) {
        if (salary.isEmpty()) {
            return false;
        }
        int i = Integer.parseInt(salary);
        return i > 0;
    }
}
