@nonCore @vol_3_user_and_roles @MDTA_UI_MDTAFINMGR_02
Feature: As an Integrity user, I want Financial Manager not to access end shift

  Scenario: Verify end shift for Financial Manager
    Given MDTA Integrity application
    When a valid User logs in with "MdtaFinMgr" credentials
    Then Home page should display
    When User click on user icon
    Then End shift should not be displayed
