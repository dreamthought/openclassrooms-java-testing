package com.openclassrooms.testing.calculator.service;

public interface SolutionFormatter {
    /**
     * Formats a numeric value for presentation
     * @param solution value
     * @return formatted string for presentation
     */
    String format(Integer solution);
}
