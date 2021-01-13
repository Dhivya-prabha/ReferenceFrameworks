@nonCore @vol_7_inventory @transponder_maintenance @MDTA_INV_TrnMain_05
Feature: As an Integrity user, I want retailers & inventory transponder inventory page , so that user can review transponder summary and history

  Scenario:user can can review transponder summary and history
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Transponder Inventory" in retailers and inventory
    Then "Agency Orders" tab should display
    When User select "TRANSPONDERS" tab
    Then "Transponders" tab should display
    When User select transponder number from the listview
    Then "TRANSPONDER DETAIL" window should display
    And User review information in the summary tab
    When User select "HISTORY" from window tab
    Then "Transponder History" tab should display
    And User review information in the history tab and close window