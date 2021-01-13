@nonCore @vol_3_user_and_roles @MDTA_UI_DIRECT_01
Feature: As an Integrity user, I want MDTA Director to access CSR Activity Detail

  Scenario: Verify CSR Activity Detail for 7 days
    Given MDTA Integrity application
    When a valid User logs in with "MdtaDirector" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "REPORTS" should be available in menu
    When User click on "REPORTS" menu option
    Then "Finance" link should be available
    When User click on "Finance" link
    Then "CSR Activity Detail" link should be available
    When User click on "CSR Activity Detail" link
    Then "Report Parameters" link should be available
    When Select 7 days radio button
    When User click on "View"
    #Then "CSR Activity Detail" report should be displayed