@nonCore @vol_7_inventory @retailers_options @MDTA_INV_RetOpt_06
Feature: As an Integrity user, I want retailers & inventory - fulfillment page, to add Purchase Order to Shipments queue

  Scenario: Validate the addition of Purchase Order to Shipments queue
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    When User click on hamburger goes to "Fulfillment" in retailers and inventory
    Then "Retailer Transponder Orders" tab should display
    When User filters by purchase order created in scenario "MDTA_INV_RetOpt_05"
    Then purchase order number should display
    When User choose Process Order in Action of selected Purchase Order
    Then "Process Order" window should display
    When User click on "Next"
    Then "SELECT TYPE" tab should display
    When User select Multiple transponders and click Next
    Then "INPUT TRANSPONDERS" tab should display
    When User enter transponder details and click next
    Then "CONFIRM" tab should display
    When User select all transponders and click ship later
    Then "The Retailer Process Order was successfully Completed" toast message should display
    And "RETAILER ORDERS" link should display
    When User click on hamburger goes to "Shipments" in retailers and inventory
    Then "QUEUE" link should display
    When User select "QUEUE" tab
    Then "Shipment Queue" tab should display
    When User filters by number created in scenario "MDTA_INV_RetOpt_05"
    Then purchase order number should display