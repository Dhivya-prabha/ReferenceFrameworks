@nonCore @vol_7_inventory @retailers_options @MDTA_INV_RetOpt_11
Feature: As an Integrity user, I want retailers & inventory - retailers page, to create New Retailer User Account

  Scenario: Validate creation of New Retailer User Account in Retailer Users page
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    When User click on hamburger goes to "Retailers" in retailers and inventory
    Then "Retailers" tab should display
    When User select "RETAILER USERS" tab
    Then "RETAILER USER" tab should display
    When User click on "Add New User"
    Then "RETAILER USER ACCOUNT" window should display
    When User enter New Retailer User Account Details and click Save button
    Then Retailer Users list should be updated