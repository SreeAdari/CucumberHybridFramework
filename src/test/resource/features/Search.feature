Feature: Search functionality 

Scenario: User searches for a valid product
Given User openes the application 
When User enters valid product "HP" into the search box field 
And User clicks on search button 
Then User should get valid product displayed in search field

Scenario: User searches for an invalid product 
Given User openes the application 
When User enters invalid product "Honda" into search box field 
And User clicks on search button 
Then User should get a message about no product matching 

Scenario: User searches without any product 
Given User openes the application 
When User dont enter any product into search box field 
And User clicks on search button 
Then User should get a message about no product matching 
