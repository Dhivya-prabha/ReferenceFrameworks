@nonCore @vol_3_user_and_roles @MDTA_UI_CCS_03
Feature: As an Integrity user, Finance does not display

  Scenario: Validate Finance does not display
    Given MDTA Integrity application
    When a valid User logs in with "ccSupervisor" credentials
    Then Home page should display
    When click on hamburger
    Then Verify the FINANCE menu