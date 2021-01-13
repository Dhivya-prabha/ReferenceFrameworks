@nonCore @vol_3_user_and_roles @MDTA_UI_CERT_02
Feature: As an Integrity user, I want Image Certification not to access dispute Review

  Scenario: Verify Dispute Review not available for selection
    Given MDTA Integrity application
    When a valid User logs in with "ImageCertification" credentials
    Then Home page should display
    When User click on hamburger menu
    Then "Unpaid" should be available in menu
    When User click on "Unpaid" menu option
    Then "Dispute Review" link should not be available
