@nonCore @vol_3_system_interface @access_controls @MDTA_UI_Access_01 @MDTA_UI_Access_04
Feature: Login as UserRole01 and UserRole02 and validate the access

  Scenario: Validate admin can access configuration management, agent location and different menus under system
    Given MDTA Integrity application
    When a valid User logs in with "FirstUser" credentials
    Then Validate the Home Page with role-specific dashboard choices in the Tab
    When click on hamburger
    Then Validate Main Menu items displayed
    When Click on System down arrow
    And Click on Logout
    Then Pop shown for Logout
    When Click on "No" button
    Then Redirect to Login Page
    When a valid User logs in with "SecondUser" credentials
    Then Home page should display
    When click on hamburger
    When Click on System down arrow
    And Click on Logout
    Then Pop shown for Logout
    When Click on "Yes" button
    Then Validate "FUNDS" tab
    When User enter Password "Psquare@123"
    When Click on "Continue" button
    Then Validate "AMOUNT" tab
    When User enter Check amount "0"
    When Click on "Continue" button
    Then Validate "CONFIRM" tab
    When Click on "End Shift" button
    Then Validate "Deposit" pop-up Modal Window displayed
    When Click on Close button
    Then Redirect to Login Page