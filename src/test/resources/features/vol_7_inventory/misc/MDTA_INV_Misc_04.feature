@nonCore @vol_7_inventory @misc @MDTA_INV_Misc_04
Feature: As an Integrity user, I want retailers & inventory Retailer page , so that user can search for transponder with customer retained status

  Scenario:user can search for transponder with customer retained status
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Transponder Inventory" in retailers and inventory
    Then "Agency Orders" tab should display
    When User goes to search tab and search for transponder with customer retained status from dropdown filter
    Then Search results display transponders with the status customer retained