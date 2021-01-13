@nonCore @vol_3_user_and_roles @MDTA_UI_QASPEC_02
Feature: As an Integrity user, I want QA Specialist not to have Configuration access

  Scenario: Verify Configuration not available for selection
    Given MDTA Integrity application
    When a valid User logs in with "QASpecialist" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "CONFIGURATION" should not be available in menu