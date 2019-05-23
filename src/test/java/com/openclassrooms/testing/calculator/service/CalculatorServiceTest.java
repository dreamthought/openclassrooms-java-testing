package com.openclassrooms.testing.calculator.service;

import com.openclassrooms.testing.calculator.domain.Calculator;
import com.openclassrooms.testing.calculator.domain.model.CalculationModel;
import com.openclassrooms.testing.calculator.domain.model.CalculationType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {
    private CalculatorService underTest;

    @Mock
    private Calculator calculator;

    @Mock
    private SolutionFormatter formatter;

    @Before
    public void setUp() {
        underTest = new CalculatorService(calculator, formatter);
    }

    // DIVISION
    @Test
    public void calculate_usesCalculatorToDivide_whenGivenADivisionCalculation() {
        // Arrange
        when(calculator.divide(4,2)).thenReturn(2);
        CalculationModel calculationModel = new CalculationModel(
                CalculationType.DIVISION, 4, 2);
        // Act
        CalculationModel responseModel = underTest.calculate(calculationModel);

        // Assert
        verify(calculator, times(1)).divide(4,2);
    }

    @Test
    public void calculate_returnsAModelWithASolution_whenGivenADivisionCalculation() {
        // Arrange
        when(calculator.divide(4,2)).thenReturn(2);
        CalculationModel calculationModel = new CalculationModel(
                CalculationType.DIVISION, 4, 2);
        // Act
        CalculationModel responseModel = underTest.calculate(calculationModel);

        // Assert
        assertThat(responseModel.getSolution(), is(equalTo(2)));
    }

    @Test
    public void calculate_returnsAModelWithALeftArgument_whenGivenADivisionCalculation() {
        // Arrange
        when(calculator.divide(4,2)).thenReturn(2);
        CalculationModel calculationModel = new CalculationModel(
                CalculationType.DIVISION, 4, 2);
        // Act
        CalculationModel responseModel = underTest.calculate(calculationModel);

        // Assert
        assertThat(responseModel.getLeftArgument(), is(equalTo(4)));
    }

    @Test
    public void calculate_returnsAModelWithARightArgument_whenGivenADivisionCalculation() {
        // Arrange
        when(calculator.divide(4,2)).thenReturn(2);
        CalculationModel calculationModel = new CalculationModel(
                CalculationType.DIVISION, 4, 2);
        // Act
        CalculationModel responseModel = underTest.calculate(calculationModel);

        // Assert
        assertThat(responseModel.getSolution(), is(equalTo(2)));
    }


    @Test
    @Ignore("TODO - Remove: This just retests calculator")
    public void calculate_returnsTheQuotient_whenDividingTwoPositiveNumbers() {
        // Arrange
        CalculationModel calculation = new CalculationModel(
                CalculationType.DIVISION, 4, 2);

        // Act
        CalculationModel response = underTest.calculate(calculation);

        // Assert
        assertThat(response.getSolution(), is(equalTo(2)));
    }

    @Test
    @Ignore("TODO - Remove: This just retests calculator")
    public void calculate_returnsTheQuotient_whenDividingTwoNegativeNumbers() {
        // Arrange
        CalculationModel calculation = new CalculationModel(
                CalculationType.DIVISION, -2, -2);

        // Act
        CalculationModel response = underTest.calculate(calculation);

        // Assert
        assertThat(response.getSolution(), is(equalTo(1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculate_shouldThrowAnException_whenDividingByZero() {
        // Arrange
        when(calculator.divide(1, 0)).thenThrow(new IllegalArgumentException(("Division by zero")));
        CalculationModel calculation = new CalculationModel(
                CalculationType.DIVISION, 1, 0);

        // Act
        CalculationModel response = underTest.calculate(calculation);
    }

    @Test
    public void calculate_shouldReturnNull_ifGivenANullModel() {
        // Act
        CalculationModel calculation = null;
        CalculationModel response = underTest.calculate(calculation);
        // assert
        assertThat(response, is(nullValue()));
    }

    @Test
    public void calculate_shouldNotUtiliseTheCalculator_ifGivenANullModel() {
        // Act
        CalculationModel calculation = null;
        CalculationModel response = underTest.calculate(calculation);
        // assert
        verifyZeroInteractions(calculator);
    }

    @Test
    public void calculate_shouldReturnAFormattedSolution_forAnyLargeCalculation() {
        // Arrange
        when(calculator.add(100000, 20)).thenReturn(100020);
        when(formatter.format(100020)).thenReturn("100,020");
        CalculationModel calculation = new CalculationModel(
                CalculationType.ADDITION, 100000, 20);

        // Act
        CalculationModel response = underTest.calculate(calculation);

        // Assert
        assertThat(response.getFormattedSolution(), is(equalTo("100,020")));
    }
}