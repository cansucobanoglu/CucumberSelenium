Feature: Login Action

Scenario: Succesfully login with valid username and password

Given User is on the login page
When User enters username and password 
And User click on login button
Then Message displayed login successfully
Then Close the browser