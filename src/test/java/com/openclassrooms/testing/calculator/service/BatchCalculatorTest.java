package com.openclassrooms.testing.calculator.service;

import com.openclassrooms.testing.calculator.domain.model.CalculationModel;
import com.openclassrooms.testing.calculator.domain.model.CalculationType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BatchCalculatorTest {
    // index of fixtures by type
    private static final int MULTIPLICATION_INDEX = 0;
    private static final int ADDITION_INDEX = 1;

    @Mock
    BatchCalculationFileService batchCalculationFileService;

    @Mock
    CalculatorService calculatorService;

    // The class we're testing
    BatchCalculator classUnderTest;

    @Before
    public void setup() throws IOException {
        // This is our fake file content
        Stream<String> calculations = Arrays.asList("3 x 2", "4 + 2").stream();

        // Let's make sure that the batch calculation service returns this
        when(batchCalculationFileService.read(Mockito.any(String.class))).thenReturn(calculations);

        // Set up the calculator
        CalculationModel model = new CalculationModel(
                CalculationType.MULTIPLICATION, 3, 2);
        model.setSolution(6);

        when(calculatorService.calculate(ArgumentMatchers.any(CalculationModel.class)))
                .thenReturn(model);

        classUnderTest = new BatchCalculator(batchCalculationFileService, calculatorService);
    }

    @Test
    public void calculateFromFile_shouldOpenTheRightFile_whenGivenAPath() throws IOException {
        // ACT
        List<CalculationModel> actual = classUnderTest.calculateFromFile("/path/to/fake/file");

        // ASSERT we get back usable models
        verify(batchCalculationFileService).read("/path/to/fake/file");
    }

    @Test
    public void calculateFromFile_shouldReturnTwoSolutions_forTwoCalculations() throws IOException {
        // ACT
        List<CalculationModel> actual = classUnderTest.calculateFromFile("/path/to/fake/fail");

        // ASSERT we get back usable models
        assertThat(actual, hasSize(2));
    }

    @Test
    @Ignore("Needs a mock CalculatorService with multiple solutions")
    public void calculateFromFile_shouldReturnTheCorrectAnswer_forAdditions() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile("/path/to/fake/fail");
        Integer answer = solutions.get(ADDITION_INDEX).getSolution();

        // ASSERT we get back usable models
        assertThat(answer, is(equalTo(4)));
    }

    @Test
    @Ignore("Needs a mock CalculatorService with multiple solutions")
    public void calculateFromFile_shouldCorrectlyAddWithTheCalculator_forAdditions() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile("/path/to/fake/fail");
        Integer answer = solutions.get(ADDITION_INDEX).getSolution();

        // ASSERT we get back usable models
        verify(calculatorService, times(1)).calculate(any());
    }

    @Test
    public void calculateFromFile_shouldUseACorrectModel_forTheFirstCalculation() throws IOException {
        // ARRANGE
        ArgumentCaptor<CalculationModel> calculationModelCaptor = ArgumentCaptor.forClass(CalculationModel.class);

        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile("/path/to/fake/fail");

        // ASSERT (Addition and Multiplication)
        verify(calculatorService, times(2)).calculate(calculationModelCaptor.capture());
        List<CalculationModel> calculationModels = calculationModelCaptor.getAllValues();
        assertThat(calculationModels.get(0).getType(), is(equalTo(CalculationType.MULTIPLICATION))); // 3x2
        assertThat(calculationModels.get(0).getLeftArgument(), is(equalTo(3))); // 3x2
        assertThat(calculationModels.get(0).getRightArgument(), is(equalTo(2))); // 3x2
    }

    @Test
    public void calculateFromFile_shouldUseACorrectModel_forTheSecondCalculation() throws IOException {
        // ARRANGE
        ArgumentCaptor<CalculationModel> calculationModelCaptor = ArgumentCaptor.forClass(CalculationModel.class);

        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile("/path/to/fake/fail");

        // ASSERT (Addition and Multiplication)
        verify(calculatorService, times(2)).calculate(calculationModelCaptor.capture());
        List<CalculationModel> calculationModels = calculationModelCaptor.getAllValues();
        assertThat(calculationModels.get(1).getType(), is(equalTo(CalculationType.ADDITION)));
        assertThat(calculationModels.get(1).getLeftArgument(), is(equalTo(4))); // 4+2
        assertThat(calculationModels.get(1).getRightArgument(), is(equalTo(2))); // 4+2
    }


    @Test
    public void calculateFromFile_shouldReturnTheCorrectAnswer_forMultiplication() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile("/path/to/fake/fail");
        Integer answer = solutions.get(MULTIPLICATION_INDEX).getSolution();

        // ASSERT we get back usable models
        assertThat(answer, is(equalTo(6)));
    }

    @Test
    public void calculateFromFile_shouldCorrectlyMultiplyWithTheCalculator_forProducts() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile("/path/to/fake/fail");
        Integer answer = solutions.get(ADDITION_INDEX).getSolution();

        // ASSERT we get back usable models
        verify(calculatorService, times(2)).calculate(any());
    }

    @Test
    public void calculateFromFile_shouldPassbackTheCorrectModel_forCalculatoins() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile("/path/to/fake/fail");
        CalculationModel answer = solutions.get(MULTIPLICATION_INDEX);

        // ASSERT we get back usable models
        assertThat(answer, allOf(
                hasProperty("leftArgument", is(3)),
                hasProperty("rightArgument", is(2)),
                hasProperty("type", is(equalTo(CalculationType.MULTIPLICATION))),
                hasProperty("solution", is(6))));
    }


}