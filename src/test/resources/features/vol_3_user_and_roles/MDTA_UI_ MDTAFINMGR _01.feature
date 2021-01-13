@nonCore @vol_3_user_and_roles @MDTA_UI_MDTAFINMGR_01
Feature: As an Integrity user, I want Financial Manager to access Balance Sheet & Host Reconciliation Snapshot Report

  Scenario: Verify Balance Sheet & Host Reconciliation Snapshot Report for 7 days
    Given MDTA Integrity application
    When a valid User logs in with "MdtaFinMgr" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "REPORTS" should be available in menu
    When User click on "REPORTS" menu option
    Then "Accounting" link should be available
    Then "Finance" link should be available
    When User click on "Accounting" link
    Then "Balance Sheet" link should be available
    When User click on "Balance Sheet" link
    Then "Report Parameters" link should be available
    When Select today date using calendar icon
    When User click on "View"
    Then "Balance Sheet" report should be displayed
    When User click on "Finance" link
    Then "Host Reconciliation Snapshot" link should be available
    When User click on "Host Reconciliation Snapshot" link
    Then "Report Parameters" link should be available
    When Select 7 days radio button
    When User click on "View"
    Then "Host Reconciliation Snapshot" report should be displayed