
Feature: Weight Tracking UI Verification
Background:
	Given  User clicks activity insights button after logged in
	 
  Scenario: Header text is displayed
    Given User is on the Her Balance Dashboard with the activity insights submenu expanded
    When User clicks on track weight
    Then Should see  header text Weight Tracking
    
    
    
