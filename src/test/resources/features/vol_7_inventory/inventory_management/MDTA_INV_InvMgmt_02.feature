@nonCore @vol_7_inventory @inventory_management @MDTA_INV_InvMgmt_02
Feature: As an Integrity user, I want retailers & inventory Shipment page, so that user can validate Inbound Type will only be RMA

  Scenario: Validate inbound Type will only be RMA in shipment page
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Shipments" in retailers and inventory
    Then "Inbound Transponders" tab should display
    And User Validate Inbound Type will only be RMA