package com.openclassrooms.testing.calculator.service;

import com.openclassrooms.testing.calculator.domain.Calculator;
import com.openclassrooms.testing.calculator.domain.model.CalculationModel;
import com.openclassrooms.testing.calculator.domain.model.CalculationType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorServiceIT {

    private Calculator calculator = new Calculator();
    private SolutionFormatter formatter = new SolutionFormatterImpl();
    private CalculatorService underTest = new CalculatorService(calculator, formatter);

    @Test
    public void calculatorService_shouldCalculateASolution_whenGivenACalculationModel() {
        // ARRANGE
        CalculationModel calculation = new CalculationModel(CalculationType.ADDITION,
                100, 101);
        // ACT
        CalculationModel result = underTest.calculate(calculation);

        // ASSERT
        assertThat(result.getSolution(), is(equalTo(201)));
    }
}

