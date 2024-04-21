package ru.home.webservice.util;

public enum ErrorMessage {
    YEAR_NOT_CORRECT("Year is not correct!"),
    MONTH_NOT_CORRECT("Month is not correct!"),
    SALARY_NOT_POSITIVE("Salary must be over 0!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
