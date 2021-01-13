@nonCore @vol_3_system_interface @adp1_fat2 @MDTA_UI_SYSADMIN_02
Feature: As an System Administration user, I want account's transaction page , so that user can verify select action dropdown with "Court Hearing"

  Scenario: Verify user can select action dropdown with "Court Hearing"
    Given MDTA Integrity application
    When a valid User logs in with "AccountLead" credentials
    Then Home page should display
    When User search for an account ID "14371762"
    Then The account "14371762" displays
    And User click and goes to accounts "Transactions" page
    When User select actions dropdown with "COURT HEARING" as status
    Then Verify the following option should displays as "Print Receipt"