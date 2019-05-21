package com.openclassrooms.testing.calculator.service;

import com.openclassrooms.testing.calculator.model.CalculationModel;
import com.openclassrooms.testing.calculator.model.CalculationType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BatchCalculatorComponentIntegrationTest {


    // index of fixtures by type
    private static final int MULTIPLICATION_INDEX = 0;
    private static final int ADDITION_INDEX = 1;

    private String FIXTURE_FILE;


    @Spy
    private BatchCalculationFileService batchCalculationFileService = new BatchCalculationFileServiceImpl();

    @Spy
    private Calculator calculator = new Calculator();

    // The class we're testing
    BatchCalculator classUnderTest;

    @Before
    public void setup() throws IOException {
        classUnderTest = new BatchCalculator(batchCalculationFileService, calculator);
        FIXTURE_FILE =
                getClass().getClassLoader().getResource("data/calculations").getPath();
        FIXTURE_FILE = FIXTURE_FILE.substring(1);
    }

    @Test
    public void calculateFromFile_shouldOpenTheRightFile_whenGivenAPath() throws IOException {
        // ACT
        List<CalculationModel> actual = classUnderTest.calculateFromFile(FIXTURE_FILE);
        // ASSERT we get back usable models
        //verify(batchCalculationFileService).read(FIXTURE_FILE);
    }

    @Test
    public void calculateFromFile_shouldReturnTwoSolutions_forTwoCalculations() throws IOException {
        // ACT
        List<CalculationModel> actual = classUnderTest.calculateFromFile(FIXTURE_FILE);

        // ASSERT we get back usable models
        assertThat(actual, hasSize(2));
    }

    @Test
    public void calculateFromFile_shouldReturnTheCorrectAnswer_forAdditions() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile(FIXTURE_FILE);
        Integer answer = solutions.get(ADDITION_INDEX).getSolution();

        // ASSERT we get back usable models
        assertThat(answer, is(equalTo(4)));
    }

    @Test
    public void calculateFromFile_shouldCorrectlyAddWithTheCalculator_forAdditions() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile(FIXTURE_FILE);
        Integer answer = solutions.get(ADDITION_INDEX).getSolution();

        // ASSERT we get back usable models
        verify(calculator, times(1)).add(2, 2);
    }

    @Test
    public void calculateFromFile_shouldReturnTheCorrectAnswer_forMultiplication() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile(FIXTURE_FILE);
        Integer answer = solutions.get(MULTIPLICATION_INDEX).getSolution();

        // ASSERT we get back usable models
        assertThat(answer, is(equalTo(6)));
    }

    @Test
    public void calculateFromFile_shouldCorrectlyMultiplyWithTheCalculator_forProducts() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile(FIXTURE_FILE);
        Integer answer = solutions.get(ADDITION_INDEX).getSolution();

        // ASSERT we get back usable models
        verify(calculator, times(1)).multiply(3, 2);
    }

    @Test
    public void calculateFromFile_shouldPassbackTheCorrectModel_forCalculatoins() throws IOException {
        // ACT
        List<CalculationModel> solutions = classUnderTest.calculateFromFile(FIXTURE_FILE);
        CalculationModel answer = solutions.get(ADDITION_INDEX);

        // ASSERT we get back usable models
        assertThat(answer, allOf(
                hasProperty("leftArgument", is(2)),
                hasProperty("rightArgument", is(2)),
                hasProperty("type", is(equalTo(CalculationType.ADDITION))),
                hasProperty("solution", is(4))));
    }


}