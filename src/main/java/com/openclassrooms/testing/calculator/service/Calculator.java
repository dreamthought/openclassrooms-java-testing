package com.openclassrooms.testing.calculator.service;

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
    public Integer add(int augend, int addend) {
        return augend+addend;
    }

    /**
     * Multiplies two values
     * @param multiplicand
     * @param multiplyer
     * @return The product of multiplying two values
     */
    public Integer multiply(int multiplicand, int multiplyer) {
        return multiplicand*multiplyer;
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
