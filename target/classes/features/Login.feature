Feature: Login Functionality

Scenario Outline: Login with vallid credentials
Given User navigates to login page
When  User enters valid email address <username> into email field
And User had entered valid password <password> into password field
And User clicks on login button
Then User should get logged in successfully
Examples:

|username          |password |
|srinu01@gmail.com |	12345  |
|srinu02@gmail.com |	12345  |
|srinu03@gmail.com |	12345  |

Scenario: Login with invalid credentials
Given User navigates to login page 
When User enters invalid email address into email field
And User enters invalid password "Sree@401" into password field
And User clicks on login button 
Then User should get proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password credentials 
Given User navigates to login page 
When User enters valid email address "srinivasadari201@gmail.com" into email field
And User enters invalid password "Sree@801" into password field
And User clicks on login button 
Then User should get proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password credentials 
Given User navigates to login page 
When User enters invalid email address into email field
And User had entered valid password "Sree@201" into password field
And User clicks on login button 
Then User should get proper warning message about credentials mismatch

Scenario: Login without providing any credentials 
Given User navigates to login page  
When User dont enter email id into the email field
And User dont enter password into the password field 
And User clicks on login button
Then User should get proper warning message about credentials mismatch 


