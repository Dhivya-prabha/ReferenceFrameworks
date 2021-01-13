@nonCore @vol_7_inventory @fat_deferred @SIT_MDTA_Vol7_PO_02
Feature: As an Integrity user,I want transponder inventory page ,so that I can verify order is removed by Cancel Order

  Scenario: verify order is removed from the Retailer orders list
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    When User click on hamburger goes to "Fulfillment" in retailers and inventory
    Then "Retailer Transponder Orders" page is the default
    When Locate an order with "Active Request" status and select the action list drop down
    Then verify "Process Order" and "Cancel Order" are options displayed
    When User Select Actions Dropdown as "Cancel Order"
    Then Enter the reason as "Automation" and select save
    And verify order is removed from the Retailer orders list
