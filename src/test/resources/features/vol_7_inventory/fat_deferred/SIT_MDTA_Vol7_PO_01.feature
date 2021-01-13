@nonCore @vol_7_inventory @fat_deferred @SIT_MDTA_Vol7_PO_01
Feature: As an Integrity user, I want retailers & inventory transponder inventory page ,so that I can Validate User can update transponder quantity

  Scenario: Validate User can update transponder quantity in Purchase Order
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Retailers" in retailers and inventory
    Then "Retailers" tab should display
    When User select "ORDERS" tab
    Then "Retailer Orders" tab should display
    When Select Orders with the Fulfillment status of "Active Request"
    Then "PURCHASE ORDER DETAILS" tab Title should display
    When User update the Transponder Quantity as "4" and select Save
    Then Transponder quantity should be updated as "4"
