@nonCore @vol_7_inventory @retailers_options @MDTA_INV_RetOpt_01
Feature: As an Integrity user, I want retailers & inventory - retailers page, so that I can validate order history of a retailer

  Scenario: Validate order history of a retailer in retailers page
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    When User click on hamburger goes to "Retailers" in retailers and inventory
    Then "Retailers" tab should display
    When User choose Edit in Action of Retailer "GIANT"
    Then "RETAILER DETAIL" window should display
    When User select History tab
    Then Order History list view should display
    When User click on "CANCEL"
    Then "Retailers" tab should display