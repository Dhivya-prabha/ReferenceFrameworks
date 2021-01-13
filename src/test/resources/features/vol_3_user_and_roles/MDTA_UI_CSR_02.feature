@nonCore @vol_3_user_and_roles @MDTA_UI_CSR_02
Feature: As an Integrity user, Unpaid does not display

  Scenario: Validate Unpaid does not display
    Given MDTA Integrity application
    When  a valid User logs in with "csRepresentative" credentials
    Then Home page should display
    When  click on hamburger
    Then  click on "Unpaid" menu
    Then  unpaid doesnot display Image Certification