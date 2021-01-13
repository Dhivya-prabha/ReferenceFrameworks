@nonCore @vol_3_user_and_roles @MDTA_UI_CSR_03
Feature: As an Integrity user,CSR Should not have the option to select NON REVENUE Account type

  Scenario: Verify NON REVENUE Account type not displayed for CSR
    Given MDTA Integrity application
    When a valid User logs in with "csRepresentative" credentials
    Then Home page should display
    When User click on hamburger menu
    And Click on "CREATE ACCOUNT"
    Then User select the account type dropdown
    And Validate "Non-revenue" is not listed