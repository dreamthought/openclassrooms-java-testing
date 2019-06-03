package com.openclassrooms.testing.calculator.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorSteps {

    @Autowired
    MockMvc mockMvc;

    private Integer lastLeftArgument;
    private Integer lastRightArgument;
    private String calculationType;

    @Before
    public void setup() {
        lastLeftArgument = null;
        lastRightArgument = null;
        calculationType = null;
    }

    @Given("a student is using the Calculator")
    public void a_student_is_using_the_Calculator() throws Exception {
        mockMvc.perform(get("/calculator")).
                andExpect( status().is2xxSuccessful()).
                andExpect( content().string(containsString( "leftArgument"))).
                andExpect( content().string(containsString( "rightArgument"))).
                andExpect( content().string(containsString( "calculationType"))).
                andExpect( content().string(containsString( "Open Calculator")));
    }

    @When("{int} and {int} are added")
    public void and_are_added(Integer leftArgument, Integer rightArgument) throws Exception {
        this.lastLeftArgument = leftArgument;
        this.lastRightArgument = rightArgument;
        this.calculationType = "ADDITION";
    }

    @Then("the student is shown {int}")
    public void the_student_is_shown(Integer expectedResult) throws Exception {
        mockMvc.perform(post("/calculator").
                param("leftArgument", lastLeftArgument.toString()).
                param("rightArgument", lastRightArgument.toString()).
                param("calculationType", "ADDITION")
        ).
                andExpect(status().is2xxSuccessful()).
                andExpect(
                        content().string(
                                containsString(">" + expectedResult + "<")));
    }
}
