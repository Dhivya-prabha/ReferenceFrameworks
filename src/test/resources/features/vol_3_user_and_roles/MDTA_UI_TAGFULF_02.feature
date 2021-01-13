@nonCore @vol_3_user_and_roles @MDTA_UI_TAGFULF_02
Feature: As an Integrity user, Tag Fulfilment should not access Report

  Scenario: Verify Retailer should not access Report
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    When User click on hamburger menu
    And "REPORTS" should not be available in menu