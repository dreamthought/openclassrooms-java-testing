package com.openclassrooms.testing.calculator.domain;

import org.springframework.stereotype.Component;

@Component
public interface SolutionFormatter {
    /**
     * Formats a numeric value for presentation
     * @param solution value
     * @return formatted string for presentation
     */
    String format(Integer solution);
}
