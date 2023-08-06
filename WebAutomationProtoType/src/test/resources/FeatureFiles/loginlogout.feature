#Author:
#Functionality:
#Feature Description:
#Feature Name:
Feature: Verify the Login logout functionality

Scenario: Login with valid credentials
Given I launch the Chrome Browser
And I navigate the Application
When I enter the username in username text field
And I enter the password in password text field
And I click on Login button
Then I find the Home page
And I minimize flyout window

Scenario: Logout from the Application
Given I find the Home page
When I click on Logout link
Then I find the login page
And I close the Application