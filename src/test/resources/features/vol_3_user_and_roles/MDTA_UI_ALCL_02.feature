@nonCore @vol_3_user_and_roles @MDTA_UI_ALCL_02
Feature: As an Integrity user, I want Account Lead/Court Liaison not to have Transponder option

  Scenario: Verify Transponder option not displayed in Transponder Inventory
    Given MDTA Integrity application
    When a valid User logs in with "AccountLead" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "Retail & Inventory" should be available in menu
    When User click on "Retail & Inventory" menu option
    Then "Transponder Inventory" should not be available in menu