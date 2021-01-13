@nonCore @vol_3_system_interface @adp1_fat2 @MDTA_UI_CARA_01
Feature: As an Integrity user, I want Customer Account Revenue Agent not to Image Certification & Court Hearing

  Scenario: Verify Image Certification & Court Hearing not available
    Given MDTA Integrity application
    When a valid User logs in with "CustAcctRevAgent" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "Unpaid" should be available in menu
    When User click on "Unpaid" menu option
    Then "DMV REVIEW" link should be available
    Then "Image Certification" link should not be available
    Then "COURT HEARING" link should not be available
