@nonCore @vol_7_inventory @inventory_management @MDTA_INV_InvMgmt_04
Feature: As an Integrity user, I want retailers & inventory transponder inventory page , so that user can create transponder inventory purchase order

  Scenario: User can create transponder inventory purchase order
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Transponder Inventory" in retailers and inventory
    Then "Agency Orders" tab should display
    When User create purchase order with location Warehouse
    Then User inspect the columns of new transponder inventory purchase order data are displaying