Feature: Weight Tracking UI Verification

  Background: 
    Given User clicks activity insights button after logged in

  Scenario: Header text is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Should see  header text Weight Tracking

  Scenario: Back to Dashboard is visible
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then "Back to Dashboard" button should be visible

  Scenario: 3 Cards for Weight info
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then 3 cards should be present

  Scenario: Card text is displayed correctly
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Starting weight , Current weight and Goal weight card should be displayed

  Scenario: Labels and weight values are aligned
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Label and weight values should be center-aligned

  Scenario: Starting weight value is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Weight value should be mapped from the onboarding process

  Scenario: Current weight value is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Current Weight should be x value

  Scenario: Goal weight value is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Goal weight should be displayed

  Scenario: Progress section is visible
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Header should be Progress overview

  Scenario: Weight lost is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then weight lost should be displayed

  Scenario: Remaining weight is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Remaining weight  should be displayed

  Scenario: Graph section header is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Graph section header should be Weight Progression over Time

  Scenario: X-axis labels are displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Graph should be visible with x-axis showing days (Day "1" to Day "7")

  Scenario: Y-axis labels are displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Y-axis should display weight values in kg
