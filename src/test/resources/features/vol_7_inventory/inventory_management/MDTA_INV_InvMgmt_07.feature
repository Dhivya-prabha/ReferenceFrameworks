@nonCore @vol_7_inventory @inventory_management @MDTA_INV_InvMgmt_07
Feature: As an Integrity user, I want retailers & inventory transponder inventory page , so that user can create quick search

  Scenario:user can create quick search
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Home page should display
    When User click on hamburger goes to "Transponder Inventory" in retailers and inventory
    Then "Agency Orders" tab should display
    When User goes to search tab and search for business with flex transponder from dropdown filter
    Then Search results display transponders model flex
    When User save quick search and select refine search
    Then Search screen displays with the new record quick search
    When User deletes the new record quick search
    Then New record should not be displayed in quick search list