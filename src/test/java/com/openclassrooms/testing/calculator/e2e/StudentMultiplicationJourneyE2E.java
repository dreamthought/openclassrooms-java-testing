package com.openclassrooms.testing.calculator.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentMultiplicationJourneyE2E {

    @LocalServerPort
    private Integer port;
    private WebDriver webDriver = null;
    private String baseUrl;

    @BeforeClass
    public static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        baseUrl = "http://localhost:" + port + "/calculator";
    }

    @After
    public void tearDown() {
        if (null != webDriver) {
            webDriver.quit();
        }
    }

    @Test
    public void aStudentUsesTheCalculatorToMultiplyTwoBySixteen() {
        webDriver.get(baseUrl);
        WebElement submitButton = webDriver.findElement(By.id("submit"));
        WebElement leftField = webDriver.findElement(By.id("left"));
        WebElement rightField = webDriver.findElement(By.id("right"));
        WebElement typeDropdown = webDriver.findElement(By.id("type"));

        // ACT: Fill in 2 x 16
        leftField.sendKeys("2");
        typeDropdown.sendKeys("x");
        rightField.sendKeys("16");
        submitButton.click();

        // ASSERT
        WebDriverWait waiter = new WebDriverWait(webDriver, 5);
        WebElement solutionElement = waiter.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("solution")));

        String solution = solutionElement.getText();
        assertThat(solution, is(equalTo("32"))); // 2 x 16
    }
}