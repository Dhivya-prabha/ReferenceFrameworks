@nonCore @vol_7_inventory @transponder_maintenance @MDTA_INV_TrnMain_03
Feature: As an Integrity user, I want retailers & inventory transponder inventory page , so that user can update transponder location on agency orders tab

  Scenario:user can update transponder location on agency orders tab
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Transponder Inventory" in retailers and inventory
    Then "Agency Orders" tab should display
    When User click edit from action drop down next to purchase order number
    Then "PURCHASE ORDER DETAILS" window should display
    When User update the location to "Baltimore Harbor Tunnel" and click save
    Then Success message should display and location updated to "Baltimore Harbor Tunnel"