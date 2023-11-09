Feature:  Contact form fuctionality
Scenario: To verify click on contact btn open contact form.
Given Click on contact button
Then Contact form display successfully

Scenario: To verify all required field is incomplete form should not submit  
Given Open the contact form
When Fill the form incomplete
Then Form should not submit


Scenario: To verify all required field is fulfill and submit the form
Given Open the contact form1
When Fill the form completely
Then Form should submit successfully
@Smoke
Scenario: To verify form should not submit with incorrect info
Given Open the contact form
When Fill the form with incorrect information
Then Form should not submit

