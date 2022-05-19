Feature: To verify cucumber functionalities

  Background:
    Given User is on Landing Page
    When User clicks on the Login link
    Then User should be navigated to Login Page



  @HappyPath
  Scenario: To verify the login functionality happy path
    When User logs in with username "sitanshupt5.sp@gmail.com" and password "Bapuna10@"
    Then User should be logged in successfully

  @ErrorPath
  Scenario: To verify the login functionality error path
    When User logs in with username "sitanshupt5.sp@gmail.com" and password "Bapuna01@"
    Then User should not be logged in successfully