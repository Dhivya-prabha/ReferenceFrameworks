@nonCore @vol_3_system_interface @access_control @MDTA_UI_Layout_01
Feature: Login as system admin ,validate admin can access configuration,agent location and system.

  Scenario: Validate admin can access configuration management, agent location and different menus under system
    Given MDTA Integrity application
    When a valid User logs in with valid credentials
    Then Validate the Home Page with role-specific dashboard choices in the Tab
    When click on hamburger
    Then Validate Main Menu items displayed
    When click on left pointing arrow
    Then Validate Main menu items should be hidden
    When click on hamburger
    Then Validate Main Menu items displayed
    Then Click on "CONFIGURATION"
    Then Validate menus Under Configuration
    When Click on "Agency Locations"
    Then Agency Location Window Displays
    When Click on "ADD NEW LOCATION" button
    Then Validate "ADD LOCATION" pop-up Modal Window displayed
    And Validate required fields underlined in red in Add Location
    When Click on "CANCEL" button
    Then Agency Location Window Displays
    When Click on System down arrow
    Then User Menu displays
    When Click on EndShift link
    Then Validate "END SHIFT" pop-up Modal Window displayed
    When Click on Close button
    Then Agency Location Window Displays
    When Click on System down arrow
    Then User Menu displays
    When Click on ChangePassword
    Then Validate "Change Password" pop-up Modal Window displayed
    When Click on "CANCEL" button
    Then Agency Location Window Displays
    When Click on System down arrow
    Then User Menu displays
    When Click on My Preferences
    Then Validate "MY PREFERENCES" pop-up Modal Window displayed
    And Validate it  displays with Language and Theme choices
    When Click on "CANCEL" button
    Then Agency Location Window Displays
    When Click on System down arrow
    Then User Menu displays
    When Click on Logout
    Then Pop shown for Logout
    When Click on "No" button
    Then Redirect to Login Page