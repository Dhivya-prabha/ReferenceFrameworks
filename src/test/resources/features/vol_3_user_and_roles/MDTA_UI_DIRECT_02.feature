@nonCore @vol_3_user_and_roles @MDTA_UI_DIRECT_02
Feature: As an Integrity user, I want MDTA Director not to access Orders

  Scenario: Verify Orders not available for selection
    Given MDTA Integrity application
    When a valid User logs in with "MdtaDirector" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "Retail & Inventory" should be available in menu
    When User click on "Retail & Inventory" menu option
    Then "Transponder Inventory" should not be available in menu
    Then "Orders" should not be available in menu