package ru.home.webservice.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidationUtilTest {

    @Test
    public void whenIsYearTrue() {
        assertThat(ValidationUtil.isYear("2021")).isTrue();
    }

    @Test
    public void whenIsYearFalse() {
        assertThat(ValidationUtil.isYear("1990")).isFalse();
    }

    @Test
    public void whenIsYearEmpty() {
        assertThat(ValidationUtil.isYear("")).isFalse();
    }

    @Test
    public void whenIsMonthTrue() {
        assertThat(ValidationUtil.isMonth("11")).isTrue();
    }

    @Test
    public void whenIsMonthFalse() {
        assertThat(ValidationUtil.isMonth("15")).isFalse();
    }

    @Test
    public void whenIsMonthEmpty() {
        assertThat(ValidationUtil.isMonth("")).isFalse();
    }

    @Test
    public void whenIsSalaryPositive() {
        assertThat(ValidationUtil.isSalary("1000")).isTrue();
    }

    @Test
    public void whenIsSalaryNegative() {
        assertThat(ValidationUtil.isSalary("-1000")).isFalse();
    }

    @Test
    public void whenIsSalaryEmpty() {
        assertThat(ValidationUtil.isSalary("")).isFalse();
    }
}