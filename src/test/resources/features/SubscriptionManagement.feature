Feature: Subscription Management UI and Functional Verification

  Background:
    Given User clicks profile button labelled as [user's name] after logged in

  Scenario: Title is displayed
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Subscription Management" should be visible

  Scenario: Two Sections visibility
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then Exactly 2 sections should be visible

  Scenario: Section heading text
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Current Subscription" and "Subscription History" section headers should be displayed

  Scenario: Header text inside the Current Subscription section
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Current Subscription" header should be displayed

  Scenario: Sub text for Current Subscription header
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Your active subscription plan details" subtext should be displayed

  Scenario: Subheaders inside the Current Subscription section
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Subscription Information" and "Subscription Benefits" subheaders should be visible

  Scenario: Information displayed under Subscription Information subheader
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Status", "Plan", "Start Date", and "End Date" details should be visible

  Scenario: Go to Dashboard button presence and state
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Go to Dashboard" button should be visible and enabled



  Scenario: Header text inside the Subscription History section
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Subscription History" header should be displayed

  Scenario: Sub text for Subscription History header
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Your Subscription payment history" subtext should be displayed

  Scenario: Two sections visibility inside Subscription History
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then Exactly 2 sections should be visible

  Scenario: Section heading text inside Subscription History
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then "Free Plan" and "Go to Dashboard" section headers should be displayed

  Scenario: Details displayed under Free Plan in Subscription History
    Given User is on the Her Balance Dashboard with the Profile submenu expanded
    When User clicks on Subscription
    Then The following details should be visible:
      | Start Date - End Date |
      | Cost            |
      | Transaction Id |
