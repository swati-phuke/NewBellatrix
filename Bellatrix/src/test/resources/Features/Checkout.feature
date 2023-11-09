Feature: In this feature file we can check scenario checkout form
Scenario: To verify open checkout page
Given Click on checkout button

Scenario: To verify if required field is empty and click on placeorder btn  will get error msg.
Given Open the checkout form
When fill the form and skip some required field
Then should  display error msg