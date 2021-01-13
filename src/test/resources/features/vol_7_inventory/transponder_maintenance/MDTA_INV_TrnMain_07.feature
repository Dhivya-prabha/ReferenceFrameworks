@nonCore @vol_7_inventory @transponder_maintenance @MDTA_INV_TrnMain_07
Feature: As an Integrity user, I want retailers & inventory Retailer page , so that user can search for transponder and update transponder status to lost

  Scenario:user can search for transponder and update transponder status to lost
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Transponder Inventory" in retailers and inventory
    Then "Agency Orders" tab should display
    When User select "SEARCH" tab
    Then "SEARCH" tab should display
    When User enter "Transponder Number" "01070427" in the input field and click "Search"
    Then "TRANSPONDER SEARCH RESULTS" tab should display
    And "01070427" link should be available
    When User select "01070427" tab
    Then "TRANSPONDER DETAIL" window should display
    And User click on "Close"
    When User select "Advanced Search" from the top of the screen
    Then Advanced search options are displayed
    When User enter "Transponder Number" "01070427" in the input field and click "SEARCH"
    Then Account associated with the transponder is displayed with account number "7971237"
    When User select "Vehicles / Transponders" tab for the account
    Then "Vehicle/Transponders" tab for the account display
    When User select the action dropdown next to a transponder number "01070427" and choose "Change Transponder Status"
    Then "Change Transponder Status" tab should display
    And Transponder current status "Good"
    When User Select New Status dropdown choose "Lost" and select Save button
    Then Popup display "Are you sure you want to change the status as Lost"
    When User click on "OK"
    Then "Transponder status updated successfully" toast message should display
    And Transponder number "01070427" status updated to "Lost"
    When User select the action dropdown next to a transponder number "01070427" and choose "Change Transponder Status"
    Then "Change Transponder Status" tab should display
    And Transponder current status "Lost"
    When User Select New Status dropdown choose "Good" and select Save button
    Then "Transponder status updated successfully" toast message should display
    And Transponder number "01070427" status updated to "Good"
