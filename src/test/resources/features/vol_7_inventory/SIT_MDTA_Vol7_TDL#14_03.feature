@nonCore @vol_7_inventory @TDL @SIT_MDTA_Vol7_TDL#14_03
Feature: As an Integrity user, I want shipment page , so that user can process the shipment

  Scenario: verify that user can process the shipment and review the manifest
    Given MDTA Integrity application
    When a valid User logs in with "Apollo" credentials
    Then Home page should display
    When User click on hamburger goes to "Shipments" in retailers and inventory
    When User select "QUEUE" tab
    Then "Shipment Queue" tab should display
    When User select the shipment queue actions list and select "Process Shipment"
    Then Validate "Ship Order" Screen Display
    When User select shipmentDate as today's date
    Then Verify the current date is displayed
    When User select shipper type as "USPS"
    Then Verify shipper type is selected as "USPS"
    When User select service Level as "Priority Mail 2-Day"
    Then Verify service Level is selected as "Priority Mail 2-Day"
    And User type the tracking number as "1Y23456789"
    Then Verify tracking number is entered as "1Y23456789"
    When User select expected delivery Date at "2" days from today
    Then Verify the expected delivery date is displayed
    When User click on complete shipment button at ship order window
    And verify "The Retailer Process Order was successfully Completed" message displayed