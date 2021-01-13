@nonCore @vol_7_inventory @retailers_options @MDTA_INV_RetOpt_04
Feature: As an Integrity user, I want retailers & inventory - retailers page, so that I can validate order history of a retailer

  Scenario: Validate order history of a retailer in retailers page
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    When User click on hamburger goes to "Retailers" in retailers and inventory
    Then "Retailers" tab should display
    When User choose Edit in Action of Retailer "GIANT"
    Then "RETAILER DETAIL" window should display
    When User update Retailer Details
    Then "The Retailer was updated successfully" toast message should display
    And revert the Retailer Details back