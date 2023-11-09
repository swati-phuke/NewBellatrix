Feature: Login page fuctionality
Scenario: To verify click on myaccount btn login page should display breadcrum
Given Click on myaccount btn
Then Breadcrum should display 

Scenario: To verify email field is empty and click on login btn will get error msg.
Given  Click on myaccount btn
When Fill required field without email
Then Error msg should display

Scenario: To verify if required field is fullfill and click on login btn will login successfully.
Given  Click on myaccount btn
When Fill all required fields
Then  Login successfully

Scenario: To verify email field is incorrect and click on login btn will get error msg.
Given  Click on myaccount btn
When Fill email with incorrect value
Then Error msg should displayed