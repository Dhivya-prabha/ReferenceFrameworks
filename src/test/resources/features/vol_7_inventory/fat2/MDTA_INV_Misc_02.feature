@nonCore @vol_7_inventory @fat2 @MDTA_INV_Misc_02
Feature: As an Integrity user, I want retailers & inventory - retailers page, so that I can Create Purchase Order with Orange transponder

  Scenario: Validate creation of new purchase order with Orange transponder in Orders page
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Retailers" in retailers and inventory
    Then "Retailers" tab should display
    When User select "ORDERS" tab
    Then "Retailer Orders" tab should display
    When User click on "CREATE PURCHASE ORDER"
    Then "CREATE PURCHASE ORDER" window should display
    When User create retailer purchase order
      | color     | Orange  |
      | quantity  | 1       |
    Then "The Retailer Order was added successfully" toast message should display
    And user select purchase order to review for the scenario "MDTA_INV_Misc_02"