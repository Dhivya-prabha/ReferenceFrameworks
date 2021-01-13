@nonCore @vol_3_user_and_roles @MDTA_UI_EZOM_02
Feature: As an Integrity user, I want E-ZPass Operations Manager not to access Configuration

  Scenario: Verify Configuration not available for selection
    Given MDTA Integrity application
    When a valid User logs in with "OperationManager" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "CONFIGURATION" should not be available in menu
