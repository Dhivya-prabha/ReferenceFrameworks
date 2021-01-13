@nonCore @vol_3_user_and_roles @MDTA_UI_COURT_02
Feature: As an Integrity user, I want MDTA Director not to access Orders

  Scenario: Verify Orders not available for selection
    Given MDTA Integrity application
    When a valid User logs in with "Court" credentials
    Then Home page should display
    When User search for an account ID "8283517"
    Then The account "8283517" displays
    When User click on "Account Actions" button
    Then Bankruptcy option should be disabled