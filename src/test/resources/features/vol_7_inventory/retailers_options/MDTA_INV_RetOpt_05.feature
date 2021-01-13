@nonCore @vol_7_inventory @retailers_options @MDTA_INV_RetOpt_05 @MDTA_INV_RetOpt_06
Feature: As an Integrity user, I want retailers & inventory - retailers page, so that I can Create Purchase Order with 5 transponders

  Scenario: Validate creation of new purchase order with 5 transponders in Orders page
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    When User click on hamburger goes to "Retailers" in retailers and inventory
    Then "Retailers" tab should display
    When User select "ORDERS" tab
    Then "Retailer Orders" tab should display
    When User click on "CREATE PURCHASE ORDER"
    Then "CREATE PURCHASE ORDER" window should display
    When User create retailer purchase order
      | color     | Black   |
      | quantity  | 5       |
    Then "The Retailer Order was added successfully" toast message should display
    And user select purchase order to review for the scenario "MDTA_INV_RetOpt_05"