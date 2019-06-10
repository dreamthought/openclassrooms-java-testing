package com.openclassrooms.testing.calculator.e2e.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    public static final String ADDITION_SYMBOL = "+";
    public static final String SUBTRACTION_SYMBOL = "-";
    public static final String DIVISION_SYMBOL = "/";
    public static final String MULTIPLICATION_SYMBOL = "x";
    @FindBy(id="submit")
    private WebElement submitButton;

    @FindBy(id="leftArgument")
    private WebElement leftArgument;

    @FindBy(id="rightArgument")
    private WebElement rightArgument;

    @FindBy(id="calculationType")
    private WebElement calculationType;

    @FindBy(id="solution")
    private WebElement solution;

    private WebDriver webDriver;

    public CalculatorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String add(String leftValue, String rightValue) {
        return calculate(ADDITION_SYMBOL, leftValue, rightValue);
    }

    public String subtract(String leftValue, String rightValue) {
        return calculate(SUBTRACTION_SYMBOL, leftValue, rightValue);
    }

    public String divide(String leftValue, String rightValue) {
        return calculate(DIVISION_SYMBOL, leftValue, rightValue);
    }

    public String multiply(String leftValue, String rightValue) {
        return calculate(MULTIPLICATION_SYMBOL, leftValue, rightValue);
    }

    private String calculate(String calculationTypeValue, String leftValue, String rightValue) {
        leftArgument.sendKeys(leftValue);
        calculationType.sendKeys(calculationTypeValue);
        rightArgument.sendKeys(rightValue);
        submitButton.click();

        WebDriverWait waiter = new WebDriverWait(webDriver, 5);
        waiter.until(ExpectedConditions.visibilityOf(solution));

        return solution.getText();
    }

}
