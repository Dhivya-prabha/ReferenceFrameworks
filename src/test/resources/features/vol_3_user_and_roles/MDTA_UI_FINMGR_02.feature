@nonCore @vol_3_user_and_roles @MDTA_UI_FINMGR_02
Feature: As an Integrity user, Finance Manager should not access Retail and Inventory

  Scenario: Verify Finance Manager should not access Retail and Inventory
    Given MDTA Integrity application
    When a valid User logs in with "FinanceManager" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "Retail and Inventory" should not be available in menu