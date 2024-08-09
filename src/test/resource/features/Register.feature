Feature: Registration Functionality 

Scenario: User creates an account only with mandatory fields
Given User navigates to Registration page 
When User enters the details into below fields 
|firstName			   |Srinu				    |
|lastName				   |Adari				    |
|telephone      	 |1234567890    |
|password          |12345         |
And User selects privacy policy 
And User clicks on continue button 
Then User account should get created successfully
 
Scenario: User creates an account only with all fields
Given User navigates to Registration page 
When User enters the details into below fields 
|firstName			   |Srinu				    |
|lastName				   |Adari			    |
|telephone      	 |1234567890    |
|password          |12345         |
And User selects Yes for Newsletter
And User selects privacy policy 
And User clicks on continue button 
Then User account should get created successfully

Scenario: User creates duplicate account only with all fields
Given User navigates to Registration page 
When User enters the details into below fields with duplicate email
|firstName			   |Srinu				 |
|lastName				   |Adari				 |
|email					   |srinivasadari201@gmail.com|
|telephone      	 |1234567890   |
|password          |hdksjd@021   |
And User selects Yes for Newsletter
And User selects privacy policy 
And User clicks on continue button 
Then User should get proper warning message about duplicate email

Scenario: User created account without filling details
Given User navigates to Registration page 
When User dont enters any details into the page 
And User clicks on continue button 
Then User should get proper warning messages for every mandatory field 
 

