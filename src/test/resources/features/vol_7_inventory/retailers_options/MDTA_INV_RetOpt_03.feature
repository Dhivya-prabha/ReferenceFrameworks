@nonCore @vol_7_inventory @retailers_options @MDTA_INV_RetOpt_03
Feature: As an Integrity user, I want retailers & inventory - retailers page, so that I can Add New Location in Retailer Locations section

  Scenario: Validate newly added retailer location of a retailer in Retailer Locations page
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    When User click on hamburger goes to "Retailers" in retailers and inventory
    Then "Retailers" tab should display
    When User select "GIANT" in Retailers list
    And User click on "ADD NEW LOCATION"
    Then "ADD RETAILER LOCATION" window should display
    When User enter Retailer Location Details and click Save button
    Then "The Retailer Location was added successfully" toast message should display
    And Retailer Locations list should be updated