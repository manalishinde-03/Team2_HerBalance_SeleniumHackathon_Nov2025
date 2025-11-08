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
