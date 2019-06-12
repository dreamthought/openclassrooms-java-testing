package com.openclassrooms.testing.calculator.service;

import java.math.BigDecimal;

/**
 * A very simple calculator
 */
public class Calculator {

    /**
     * Adds two values
     * @param augend
     * @param addend
     * @return Sum of the two arguments
     */
    public Double add(Double augend, Double addend) {
        return augend+addend;
    }

    /**
     * Multiplies two values
     * @param multiplicand
     * @param multiplyer
     * @return The product of multiplying two values
     */
    public Double multiply(Double multiplicand, Double multiplyer) {
        BigDecimal product = BigDecimal.ZERO;
        for (int counter = 0; counter<multiplyer.intValue(); counter++) {
            product = product.add(new BigDecimal(multiplicand.toString()));
        }

        return product.doubleValue();
    }

    public void cos(double v) {
        throw new UnsupportedOperationException("Trigonometry not supported!");
    }

    public void slowCalculation() {
        try {
            Thread.sleep(0001L);
        } catch (InterruptedException e) {
            System.out.println("THIS OPERATION COMPLETED AFTER 3 SECONDS");
        }
    }
}
