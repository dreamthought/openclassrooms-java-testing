# Test Your Own Calculator
## P3-C3 : CucumberJVM
This repository contains the screencasts for the Test Your Own 
Java Application course.

Each screencast will have a branch which is referred to in the course notes.

## A Fun Challenge

### Scenario
Given a student is using the Calculator
When 2 and 5 are subtracted
Then the student is shown 7

### Your task
1. Add a subtraction feature to src/test/resources/features/arithmetic-calcuations.feature
1. Edit src\test\java\com\openclassrooms\testing\calculator\cucumber\steps\CalculatorSteps.java
1. Change the @When to match "{int} and {int} are {string}"
1. Store the operation to a field in the instance. Eg. the value of "subtracted" or "added"
1. Modify the @Then so that "ADDITION" is no longer hard-coded. Use the value you stored in the previous step to decide
 on whether we're adding or subtracting.

