@nonCore @vol_7_inventory @transponder_maintenance @MDTA_INV_TrnMain_04
Feature: As an Integrity user, I want retailers & inventory transponder inventory page , so that user can select transponder and choose agent and transponder location

  Scenario:user can select transponder and choose agent and transponder location
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Transponder Inventory" in retailers and inventory
    Then "Agency Orders" tab should display
    When User select "TRANSPONDERS" tab
    Then "Transponders" tab should display
    When User filters status by initializing and choose assign transponder from action dropdown
    Then "ACTION" window should display
    When User choose "Brandon Nero" from employee name dropdown and "Baltimore Harbor Tunnel" from location dropdown and click Save button
    Then "Transponder assigned successfully" toast message should display
    And Agent "BNERO" and location "Baltimore Harbor Tunnel" are updated in the list for that transponder