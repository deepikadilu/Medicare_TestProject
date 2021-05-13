Feature: Test CRUD methods in Sample URI REST API testing

Scenario: GET List of Users
Given I am in reqres site
When Send a GET HTTP request for user listing 
Then check the total users to be twelve
And I receive valid response code

Scenario: Create a User with PUT
Given I Set POST user api endpoint
When Send a POST HTTP request with user details
Then I receive valid response code for creating