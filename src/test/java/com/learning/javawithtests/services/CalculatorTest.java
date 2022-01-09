package com.learning.javawithtests.services;

import com.learning.javawithtests.exceptions.CannotDivideByZeroException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void shouldSumTwoValues() {
        int n1 = 8;
        int n2 = 6;

        int result = calculator.sum(n1, n2);

        assertEquals(14, result);
    }

    @Test
    public void shouldSubtractTwoValues() {
        int n1 = 8;
        int n2 = 6;

        int result = calculator.subtract(n1, n2);

        assertEquals(2, result);
    }

    @Test
    public void shouldDivideTwoValues() throws CannotDivideByZeroException {
        double n1 = 8d;
        double n2 = 6d;

        double result = calculator.divide(n1, n2);

        assertEquals(1.3, result, 1);
    }

    @Test(expected = CannotDivideByZeroException.class)
    public void shouldThrowAnExceptionWhenDividingByZero() throws CannotDivideByZeroException {
        double n1 = 8d;
        double n2 = 0d;

        calculator.divide(n1, n2);
    }
}
