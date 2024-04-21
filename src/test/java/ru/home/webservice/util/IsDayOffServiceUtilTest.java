package ru.home.webservice.util;

import org.junit.jupiter.api.Test;
import ru.home.webservice.model.HourlyPayment;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class IsDayOffServiceUtilTest {

    @Test
    public void whenWorkDays8() {
        String content = "1100001100002";
        long result = IsDayOffServiceUtil.workDays(content);
        assertThat(result).isEqualTo(8L);
    }

    @Test
    public void whenWorkDaysZero() {
        String content = "11221112";
        long result = IsDayOffServiceUtil.workDays(content);
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void whenHalfHoliday2() {
        String content = "002211100";
        long result = IsDayOffServiceUtil.halfHoliday(content);
        assertThat(result).isEqualTo(2L);
    }

    @Test
    public void whenHalfHolidayZero() {
        String content = "0000011100";
        long result = IsDayOffServiceUtil.halfHoliday(content);
        assertThat(result).isEqualTo(0L);
    }

    @Test
    public void whenHour_incomeValid() {
        BigDecimal salary = new BigDecimal("1000");
        long workdays = 20;
        long halfHoliday = 2;
        BigDecimal result = IsDayOffServiceUtil.hour_income(salary, workdays, halfHoliday);
        assertThat(result).isEqualTo(new BigDecimal("5.75"));
    }

    @Test
    public void whenGetHourlyPaymentValid() {
        String year = "2021";
        String month = "5";
        String salary = "5000";
        BigDecimal hourIncome = new BigDecimal("10.00");
        int workDaysMonth = 20;
        HourlyPayment result = IsDayOffServiceUtil.
                getHourlyPayment(year, month, salary, hourIncome, workDaysMonth);

        assertThat(result.getYear()).isEqualTo(2021);
        assertThat(result.getMonth()).isEqualTo("MAY");
        assertThat(result.getSalary()).isEqualTo(5000);
        assertThat(result.getHour_income()).isEqualTo(new BigDecimal("10.00"));
        assertThat(result.getWorkDays_month()).isEqualTo(20);
    }
}