package com.learning.javawithtests.services;

import com.learning.javawithtests.exceptions.CannotDivideByZeroException;

public class Calculator {

    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int subtract(int n1, int n2) {
        return n1 - n2;
    }

    public double divide(double n1, double n2) throws CannotDivideByZeroException {
        if (n2 == 0)
            throw new CannotDivideByZeroException();

        return n1 / n2;
    }
}
