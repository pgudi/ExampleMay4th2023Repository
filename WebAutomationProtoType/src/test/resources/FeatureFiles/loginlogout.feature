#Author:
#Functionality:
#Feature Description:
#Feature Name:
@Execute
Feature: Verify the Login logout functionality

Scenario Outline: Login with valid credentials
Given I launch the Chrome Browser
And I navigate the Application
When I enter the <UserName> in username text field
And I enter the "<Password>" in password text field
And I click on Login button
Then I find the Home page
And I minimize flyout window
Given I find the Home page
When I click on Logout link
Then I find the login page
And I close the Application

Examples:
|UserName|Password|
|admin|manager|
|user1|welcome|
|user2|welcome|
