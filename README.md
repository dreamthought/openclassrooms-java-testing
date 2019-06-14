# Test Your Own Calculator 
## P2 - C4: Mockito

This repository contains the screencasts for the Test Your Own 
Java Application course.

Each screencast will have a branch which is referred to in the course notes.

# A Fun Challange

Do you remember the AgeValidator class? Have a look at it again!
*src\main\java\com\openclassrooms\testing\calculator\validation\AgeValidator.java*

We're going to use it from our CalculationService:

1. Write a failing test in the CalculatorServiceTest which tests
CalculatorService's validateAge(int age) method.
1. Add a mock AgeValidator to the test
1. Modify the real CalculatorService to have a validateAge(int age) method 
1. Add an AgeValidator to it. You'll want to be able to pass this into the constructor.
  _Have a look at the Calculator instance passed to CalculatorSerivce._

Let your tests drive your design and remember to use a mock AgeValidator.
It should be quite similar to the existing tests in CalculatorService,
except you're adding a new collaborator.

Have fun!