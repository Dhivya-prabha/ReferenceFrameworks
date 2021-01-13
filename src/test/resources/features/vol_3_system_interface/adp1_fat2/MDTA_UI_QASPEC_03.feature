@nonCore @vol_3_system_interface @adp1_fat2 @MDTA_UI_QASPEC_03
Feature: As an Integrity user, I want Retail and Inventory for E-ZPass Operations Manager

  Scenario: Verify account type dropdown contains expected options displays
    Given MDTA Integrity application
    When a valid User logs in with "QASpecialist" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "CREATE ACCOUNT" should be available in menu
    When User click on "CREATE ACCOUNT" menu option
    Then Account type page displays
    When User select the account type dropdown
    Then Private E-ZPass, Business, Hatem A and Non-Revenue options should displays
      |Business E-ZPass|Non-revenue|Hatem A|Private E-ZPass|Pay-By-Plate|