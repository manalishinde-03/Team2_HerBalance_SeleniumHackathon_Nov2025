Feature: Workout Page UI verification

  Background: 
    Given User logged into the application

  Scenario: Verify the workout page title
    Given User is on the dashboard page
    When user clicks workout button on navigation bar
    Then User should see page title as "Daily Personalized Workouts"