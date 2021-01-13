@nonCore @vol_7_inventory @fat_deferred @SIT_MDTA_Vol7_Sale_02
Feature: As an Integrity user, I want Journal Entry page , so that user can verify The new journal entry created and it is Pending Status

  Scenario: Verify the new journal entry created and it is Pending Status
    Given MDTA Integrity application
    When a valid User logs in with "FinanceManager" credentials
    Then Home page should display
    When User click on hamburger menu
    Then hamburger menu should display
    When User click on "Finance" menu option
    Then "Finance" page should display
    And User select "New Journal Entry"
    And User set Category as "Asset" in row "1"
    And User set GL Code as "CASH - Bank Account" in row "1"
    And User set Debit as "66.00" in row "1"
    And User set Category as "Asset" in row "2"
    And User set GL Code as "Accounts Receivable - OTG Retailer MVA" in row "2"
    And User set Credit as "$66.00" in row "2"
    And User Enter comment in Memo section as "Automation"
    When User click "Save"
    Then Verify The new journal entry created and it is "Pending" Status

  Scenario: Verify the Intentional Pause to verify Journal Entry next day
    Given MDTA Integrity application
    When a valid User logs in with "Apollo" credentials
    Then Home page should display
    When User click on hamburger menu
    Then hamburger menu should display
    When User click on "Finance" menu option
    Then "Finance" page should display
    And User select the entry actions list and select "Review"
    And User select the "Approved" radio button
    When User click "Save"
    Then Verify Intentional Pause to verify Journal Entry next day