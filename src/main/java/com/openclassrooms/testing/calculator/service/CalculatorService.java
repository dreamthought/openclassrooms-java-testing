package com.openclassrooms.testing.calculator.service;

import com.openclassrooms.testing.calculator.domain.Calculator;
import com.openclassrooms.testing.calculator.domain.model.CalculationModel;

public class CalculatorService implements Solver{
    Calculator calculator;
    private SolutionFormatter formatter;

    public CalculatorService(Calculator calculator, SolutionFormatter formatter) {
        this.calculator = calculator;
    }

    public CalculationModel calculate(CalculationModel calculationModel) {
        // FIXME : This really needs a custom exception
        if (null == calculationModel) {
            return null;
        }

        return solve(calculationModel, calculator, formatter);
    }
}
