#Author:
#FeatureName:
#Purpose:
#Description
Feature: Verify User Functionality

Scenario: Verify Create User Functionality
Given I provide createUser EndPoint
And I get RequestSpecification object
And I Create user Request object
When I post the request object and get the Response
Then I get 201 status code
And I get user_id from newly created user
Given I provide displayUser EndPoint
And I get RequestSpecification object
When I Get the Response object
Then I get 200 status code
Given I provide deleteUser EndPoint
And I get RequestSpecification object
When I delete the resource from server
Then I get 200 status code