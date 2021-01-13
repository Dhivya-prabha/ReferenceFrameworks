@nonCore @vol_3_user_and_roles @MDTA_UI_QASPEC_01
Feature: As an Integrity user, I want QA Specialist to have Document Management access

  Scenario: Verify Search in Document Management page
    Given MDTA Integrity application
    When a valid User logs in with "QASpecialist" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "DOCUMENT MANAGEMENT" should be available in menu
    When User click on "DOCUMENT MANAGEMENT" menu option
    Then "SEARCH" link should be available
    When User click on "SEARCH" link
    Then "SEARCH" button should be displayed
    When User click on "SEARCH"
    Then "Export to Excel" link should be available