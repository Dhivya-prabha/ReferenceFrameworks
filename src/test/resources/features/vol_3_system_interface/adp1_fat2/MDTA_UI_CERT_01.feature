@nonCore @vol_3_system_interface @adp1_fat2 @MDTA_UI_CERT_01
Feature: As an Image Certification user, I want account's transaction page , verify additional court hearing tab does not display

  Scenario: Verify Additional court hearing does not display
    Given MDTA Integrity application
    When a valid User logs in with "ImageCertification" credentials
    Then Home page should display
    When User click on hamburger menu
    Then hamburger menu should display
    When User click on "Unpaid" menu option
    Then Unpaid page should display
    When Select Image Certification
    Then Image Certification displays with an image to approve or reject
    And Verify the Court Hearing tab does not display