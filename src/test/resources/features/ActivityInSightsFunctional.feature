Feature: Weight Tracking functional verification


  Background: 
    Given User clicks track weight in activity insight after reaching dashobard

  Scenario: New tracking record appears after logging weight
    Given User is on the Weight tracker
    When User clicks Log Weight button after entering valid value in weight
    Then Entered weight should be added to the tracking record