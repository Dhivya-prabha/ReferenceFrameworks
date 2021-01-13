@nonCore @vol_3_user_and_roles @MDTA_UI_SICLS_02
Feature: As an Integrity user, I want Stop-In Center Lead Supervisor user not to access Reports

  Scenario: Verify Reports not to be displayed in menu
    Given MDTA Integrity application
    When a valid User logs in with "StopInLead" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "REPORTS" should not be available in menu