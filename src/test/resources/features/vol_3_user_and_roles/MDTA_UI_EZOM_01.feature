@nonCore @vol_3_user_and_roles @MDTA_UI_EZOM_01
Feature: As an Integrity user, I want Retail and Inventory for E-ZPass Operations Manager

  Scenario: Verify Retailer Location displayed in Retailer
    Given MDTA Integrity application
    When a valid User logs in with "OperationManager" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "Retail & Inventory" should be available in menu
    When User click on "Retail & Inventory" menu option
    Then "Retailers" should be available in menu
    When User click on "Retailers" menu option
    Then "Retailer Locations" link should be available