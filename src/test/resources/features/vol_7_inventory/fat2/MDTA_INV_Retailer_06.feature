@nonCore @vol_7_inventory @fat2 @MDTA_INV_Retailer_06
Feature: As an Maryland user, I want retailers & inventory - retailers page, so that I can make Retailer Payment

  Scenario: Validate user can make Retailer Payment
    Given Maryland Retailer application
    When a valid retailer driveezmd User logs in with "Retailer.Driveezmd" credentials
    Then User click on hamburger goes to "Orders" in driveezmd Pages
    Then Validate All PoNumber is Displayed
    When User click "Retailer Payment" button
    Then Validate "RETAILER PAYMENT" Screen Display
    When User click first purches order selete button
    Then Verify order details screen displayed
    Then User enter the amount to be paid in order details
    And user get invoice and purchase Order Number
    When User enter "Visa" Card
    When User click "PAY NOW" on button
    Then Verify Payment Confirmation Screen Displayed
    When User click "CLOSE" on button
    Then Validate All PoNumber is Displayed
    When User click on hamburger goes to "Payments" in driveezmd Pages
    Then Verify payments page displayed
    When User sort the Date Column
    Then Verify the payment displays