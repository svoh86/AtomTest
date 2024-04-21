package ru.home.webservice.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import ru.home.webservice.util.ErrorMessage;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

class ValidationFilterTest {
    ValidationFilter filter = new ValidationFilter();
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    FilterChain chain = mock(FilterChain.class);
    RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
    PrintWriter writer = mock(PrintWriter.class);

    @Test
    public void whenDoFilterValidParams() throws ServletException, IOException {
        when(request.getParameter("year")).thenReturn("2022");
        when(request.getParameter("month")).thenReturn("10");
        when(request.getParameter("salary")).thenReturn("5000");

        filter.doFilter(request, response, chain);
        verify(chain).doFilter(request, response);
    }

    @Test
    public void whenDoFilterYearNotValid() throws ServletException, IOException {
        when(request.getParameter("year")).thenReturn("1990");
        when(request.getParameter("month")).thenReturn("10");
        when(request.getParameter("salary")).thenReturn("5000");
        when(request.getRequestDispatcher("/")).thenReturn(requestDispatcher);
        when(response.getWriter()).thenReturn(writer);

        filter.doFilter(request, response, chain);
        verify(response.getWriter()).write(ErrorMessage.YEAR_NOT_CORRECT.getMessage());
    }

    @Test
    public void whenDoFilterMonthNotValid() throws ServletException, IOException {
        when(request.getParameter("year")).thenReturn("2012");
        when(request.getParameter("month")).thenReturn("15");
        when(request.getParameter("salary")).thenReturn("5000");
        when(request.getRequestDispatcher("/")).thenReturn(requestDispatcher);
        when(response.getWriter()).thenReturn(writer);

        filter.doFilter(request, response, chain);
        verify(response.getWriter()).write(ErrorMessage.MONTH_NOT_CORRECT.getMessage());
    }

    @Test
    public void whenDoFilterSalaryNotValid() throws ServletException, IOException {
        when(request.getParameter("year")).thenReturn("2012");
        when(request.getParameter("month")).thenReturn("10");
        when(request.getParameter("salary")).thenReturn("-5000");
        when(request.getRequestDispatcher("/")).thenReturn(requestDispatcher);
        when(response.getWriter()).thenReturn(writer);

        filter.doFilter(request, response, chain);
        verify(response.getWriter()).write(ErrorMessage.SALARY_NOT_POSITIVE.getMessage());
    }
}