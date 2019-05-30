package com.openclassrooms.testing.calculator.domain;

import org.springframework.stereotype.Component;

@Component
public class SolutionFormatterImpl implements SolutionFormatter {
    @Override
    public String format(Integer solution) {
        return String.format("%,d", solution);
    }
}
