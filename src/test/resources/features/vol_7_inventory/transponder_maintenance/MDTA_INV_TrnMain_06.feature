@nonCore @vol_7_inventory @transponder_maintenance @MDTA_INV_TrnMain_06
Feature: As an Integrity user, I want retailers & inventory transponder inventory page , so that user can search for migrated transponder number in listview and history

  Scenario:user can search for migrated transponder number in listview and history
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User select "Advanced Search" from the top of the screen
    Then Advanced search options are displayed
    When User enter "Transponder Number" "02948685" in the input field and click "SEARCH"
    Then Account associated with the transponder is displayed with account number "1391549"
    When User select "Vehicles / Transponders" tab for the account
    Then "Vehicle/Transponders" tab for the account display
    And Transponder number "02948685" is shown in listview and Account history as "Migrated"