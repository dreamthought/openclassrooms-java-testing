package com.openclassrooms.testing.calculator;

import com.openclassrooms.testing.calculator.domain.CalculatorTest;
import com.openclassrooms.testing.calculator.domain.ConversionCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, ConversionCalculatorTest.class})
public class CalculationTestSuite {
}
