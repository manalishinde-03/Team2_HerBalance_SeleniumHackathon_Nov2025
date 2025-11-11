Feature: Workout Page UI verification

  Background: 
    Given User logged into the application

  Scenario: Verify the workout page title
    Given User is on the dashboard page
    When user clicks workout button on navigation bar
    Then User should see page title as "Daily Personalized Workouts"

  Scenario: Verify the presence of  "Back to Dashboard" text on the Workout page.
    Given User is on the dashboard page
    When user clicks workout button on navigation bar
    Then User should see the link Back to dashboard

  Scenario: Verify the presence of daily workout plan section
    Given User is on the dashboard page
    When user clicks workout button on navigation bar
    Then User should see the "Daily Workout Plan" section

  Scenario: Verify the description under daily workout plan section
    Given User is on the dashboard page
    When user clicks workout button on navigation bar
    Then User should see the description as "Fresh AI-powered workout tailored to your current cycle phase.".

  Scenario: Verify the message under daily workout plan section
    Given User is on the dashboard page
    When user clicks workout button on navigation bar
    Then User should see the message as "No workout plan found"

  Scenario: Verify the alignment of message under daily workout plan section
    Given User is on the dashboard page
    When user clicks workout button on navigation bar
    Then User should see the message as "No workout plan found Generate a personalized daily workout based on your current cycle phase (luteal) A new workout is generated each day with Gemini Flash 2.0 AI" aligned centre
