@nonCore @vol_3_user_and_roles @MDTA_UI_ACCTSPEC_02
Feature: As an Integrity user, Configuration does not display and can not continue

  Scenario: Validate Configuration does not display and can not continue
    Given MDTA Integrity application
    When  a valid User logs in with "AccountSpecialist" credentials
    Then Home page should display
    When click on hamburger
    Then Configuration  page should not display