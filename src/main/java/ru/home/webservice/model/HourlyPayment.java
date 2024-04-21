package ru.home.webservice.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"year", "month", "salary", "hour_income", "workdays_month"})
public class HourlyPayment {
    private int year;
    private String month;
    private int salary;
    private BigDecimal hour_income;
    private int workDays_month;
}
