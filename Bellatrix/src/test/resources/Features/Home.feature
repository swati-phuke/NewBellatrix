
Feature: To verify home page fuctionality


Scenario: Verify search results for Falcon
 Given Application is launched completely
 When User searches Falcon in searchComponent
 Then All result must contain Falcon word in product title
 

Scenario Outline: To verify search results for product using DDT testing
Given Row number <num_row>
When Retrive data from excel sheet
Then Verify product title must contain product name

Examples: 
|num_row| 
|1|
|2|
|3|
|4|

Scenario: Dropdown list selection
Given The user on the website with dropDown list
When The user click on the dropDown list
And The user select option sort by price:low to high from dropDown list
Then The user should see the corrosponding contain for sort by price: low to high


Scenario: To verify get information about product
Given Open the homePage
Then Get information about product

@Smoke
Scenario: abe
Given Open myntra


