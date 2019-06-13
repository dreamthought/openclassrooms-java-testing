# Test Your Own Calculator
## P3-C2: Component Integration Tests

This repository contains the screencasts for the Test Your Own 
Java Application course.

Each screencast will have a branch which is referred to in the course notes.

## Fun things to try out

* Have a look at CalculatorIT
* Try running this test.
* Have a look at the POM file to see how we made Tests ending with "IT" work.

## A Fun Challenge

See if you can add another integration test to the CalculatorServiceIT to test
that you get the right exception when you try to divide by zero!
* Have a look at the Calculator::divide method
  * When you try to pass a second argument of zero, it throws 
    `new IllegalArgumentException("Divisor cannot be zero!")`
* Use @Test(expected=IllegalArgumentException.class) to test what happens when you
create a CalculationModel which divides by 0.
* Your test will be just like the existing test, except it will set the 
