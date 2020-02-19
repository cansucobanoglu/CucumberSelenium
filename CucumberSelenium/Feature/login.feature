Feature: Login Action

Scenario: Succesfully login with valid username and password

Given User is on the login page
When Verify page title
When Verify header name
When Verify status message
When Verify info message
And User enters username and password 
And User click on login button
Then Message displayed login successfully
Then Close the browser