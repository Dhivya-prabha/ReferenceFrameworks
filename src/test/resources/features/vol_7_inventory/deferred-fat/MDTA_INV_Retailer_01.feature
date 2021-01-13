@nonCore @vol_7_inventory @deferred-fat @MDTA_INV_Retailer_01
Feature: As an Maryland user, I want retailers & inventory - retailers page, so that I can make Retailer Payment

  Scenario: Validate user can make Retailer Payment
    Given Maryland Retailer application
    When a valid retailer driveezmd User logs in with "Retailer.Driveezmd" credentials
    Then User click on hamburger goes to "Orders" in driveezmd Pages
    Then Validate All PoNumber is Displayed
    When User click "Create Purchase Order" button
    Then Validate "CREATE PURCHASE ORDER" Screen Display
    When User enter transponder quantity as "2"
    Then User click "SAVE"
    And verify "created successfully" message displayed
    When User sort the "PO Number" Column
    Then User clicks the column value with "order-number"
    When User enter transponder quantity as "1"
    Then User click "SAVE"
    And verify "Retailer Order Updated Successfully" message displayed