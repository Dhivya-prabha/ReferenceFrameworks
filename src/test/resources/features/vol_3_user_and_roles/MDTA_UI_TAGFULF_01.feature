@nonCore @vol_3_user_and_roles @MDTA_UI_TAGFULF_01
Feature: As an Integrity user, so that user can Validate retailer adding functionality

  Scenario: Successful Login with Valid Credentials then user Validate retailer adding functionality
    Given MDTA Integrity application
    When a valid User logs in with "Retailer" credentials
    Then Home page should display
    Then Click on "Retailers"
    And User Validate retailer adding functionality
    Then Success message should display for retailer adding