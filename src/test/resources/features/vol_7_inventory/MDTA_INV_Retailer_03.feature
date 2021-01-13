@nonCore @vol_7_inventory @Retailer @MDTA_INV_Retailer_01 @MDTA_INV_Retailer_03
Feature: As an Maryland user, I want order page, so that I can verify purchase Orders with respective order status.

  Scenario: Verify Purchase Orders by their respective Order Status.
    Given MDTA staging application
    Then Verify home screen displayed
    When User click "On the Go" from menu item
    Then User clicks on "Retailer Portal Login" link
    And Verify retailer login screen displayed
    When a valid retailer driveezmd User logs in with "Retailer.Driveezmd" credentials
    When User click on hamburger goes to "Orders" in driveezmd Pages
    Then Validate All PoNumber is Displayed
    When User sort the "PO Number" Column
    Then Verify order date for the first PO number

