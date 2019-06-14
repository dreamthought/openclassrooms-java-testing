# Test Your Own Calculator
## P3 - C4 : End to End Testing
This repository contains the screencasts for the Test Your Own 
Java Application course.

Each screencast will have a branch which is referred to in the course notes.

## A Fun Challenge

Try to write an end to end test which checks the error returned when you do not
provide a left or right number.

* Add another end to end test in the same class which attempts to submit an empty form
without any values in it.
* Use By.className("error") instead of By.id(); Have a look the HTML and look for 
class="error" to see where an error would be displayed
* Test that you get back a message which says "must not be null"

### TIPS
This will be very similar to the existing test.