@nonCore @vol_3_user_and_roles @MDTA_UI_FINMGR_01
Feature: As an Integrity user, Finance Manager can access journal entry

  Scenario: Verify Finance Manager can access journal entry
    Given MDTA Integrity application
    When a valid User logs in with "FinanceManager" credentials
    Then Home page should display
    When User click on hamburger menu
    Then click on "Finance" menu
    And "Journal Entry" link should be available