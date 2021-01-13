@nonCore @vol_3_system_interface @adp1_fat2 @MDTA_UI_ALCL_01
Feature: As an Account Lead user, I want account page , so that user can Set as Deceased for an Account

  Scenario: Verify Upload Death Certificate is displayed, When account is Set as Deceased
    Given MDTA Integrity application
    When a valid User logs in with "AccountLead" credentials
    Then Home page should display
    When User search for an account ID "19697241"
    Then The account "19697241" displays
    When User Select Set as Deceased
    Then The "Upload Death Certificate" window displays