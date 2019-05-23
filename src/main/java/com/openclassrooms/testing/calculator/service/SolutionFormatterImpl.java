package com.openclassrooms.testing.calculator.service;

public class SolutionFormatterImpl implements SolutionFormatter {
    @Override
    public String format(Integer solution) {
        return String.format("%,d", solution);
    }
}
