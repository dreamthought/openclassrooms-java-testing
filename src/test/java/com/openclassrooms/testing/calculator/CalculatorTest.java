package com.openclassrooms.testing.calculator;

import com.openclassrooms.testing.calculator.service.Calculator;
import org.junit.*;

import java.time.Duration;
import java.time.Instant;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    private static Instant startTime;
    private Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        startTime = Instant.now();
    }

    @AfterClass
    public static void afterClass() {
        Instant endedAt = Instant.now();
        Duration duration = Duration.between(startTime, endedAt);
    }

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void add_shouldReturnTheSum_ofTwoPositiveNumbers() {
        // arrange
        Double expected = 3.0; // 1+2

        // act
        Double result = calculator.add(1.0, 2.0);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void add_shouldReturnTheSum_ofNegativeNumbers() {
        // arrange
        Double expected = -3.0; // -1+-2

        // act
        Double result = calculator.add(-1.0, -2.0);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void add_shouldReturnTheSum_ofAPositiveAndNegativeNumber() {
        // arrange
        Double expected = 1.0; // -2+3

        // act
        Double result = calculator.add(-2.0, 3.0);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoPositiveNumbers() {
        // arrange
        Double expected = 6.0;

        // act
        Double product = calculator.multiply(2.0, 3.0);

        // assert that product is equal to 6
        assertThat(product, is(equalTo(expected))); // 2x3
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofADecimalByALargeNumber() {
        Double expected = 20.20;
        Double product = calculator.multiply(0.2, 101.0);
        assertThat(product, is(equalTo(expected)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cos_shouldNotBeSupported_whenCalledWithAnyValue() {
        // arrange is done in @Before
        // act
        calculator.cos(0.8);
        // assertion happens in the @Test
    }

    @Test(timeout = 0020)
    public void slowCalculation_shouldTakeUnreasonablyLong_whenCalled() {
        // Act by calling a slow calculation
        calculator.slowCalculation();
    }

}
