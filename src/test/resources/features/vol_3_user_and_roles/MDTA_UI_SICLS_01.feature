@nonCore @vol_3_user_and_roles @MDTA_UI_SICLS_01
Feature: As an Integrity user, I want Case Management for Stop-In Center Lead Supervisor

  Scenario: Verify Case Queue displayed in Case Management
    Given MDTA Integrity application
    When a valid User logs in with "StopInLead" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "CASE MANAGEMENT" should be available in menu
    When User click on "CASE MANAGEMENT" menu option
    Then "CASE QUEUE" link should be available