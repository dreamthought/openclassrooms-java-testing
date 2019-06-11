package com.openclassrooms.testing.calculator.e2e;

import com.openclassrooms.testing.calculator.e2e.page.CalculatorPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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
    public void aStudentUsesTheCalculatorToAddTwoToSixteen() throws InterruptedException {
        webDriver.get(baseUrl);
        CalculatorPage calculatorPage = new CalculatorPage(webDriver);
        PageFactory.initElements(webDriver,calculatorPage);
        String solution = calculatorPage.add("2", "16");
        assertThat(solution, is(equalTo("18"))); // 2 + 16
    }

}
