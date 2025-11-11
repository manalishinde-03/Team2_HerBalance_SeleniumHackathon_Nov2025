Feature: Subscription Plans UI and Functionality

  Background:
    Given User completes onboarding process until step 10

  Scenario: Title is displayed
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Choose Your Transformation Journey" header should be visible

  Scenario: Sub text for header
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "All plans include personalization based on your menstrual cycle phases for optimal results." sub-text header should be visible

  Scenario: Total number of Sections
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then There should be exactly 3 subscription plan tiles displayed

  Scenario: Free Plan title
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Free Plan - 7 Days Trial" section tile should be displayed inside Free plan tile

  Scenario: Free Plan subtext
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "AI-generated 7-day meal plan, workouts and yoga personalized to your menstrual cycle - absolutely free!" section title should be displayed

  Scenario: Free Plan header and subtext
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "7 days access" subtext under header should be visible
   

  Scenario: Free Plan checklist
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then the following lines preceded with checkmark should be visible:
      | Cycle-based diet plan (adjusted to your current phase) |
      | Daily workouts & yoga |
      | AI tips for stress relief |
      | Blood report analysis + expert recommendations |

  Scenario: Free Plan Subscribe Now button
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then Subscribe Now button should be visible and enabled

  Scenario: Monthly Plan Most Popular badge
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Most Popular" badge text should be displayed on Monthly plan tile

  Scenario: Monthly Plan subheader and subtext
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Monthly Plan - 30 Days" subheader should be displayed inside Monthly plan tile
    And "Unlock a full month of AI personalized diet, fitness and community support tailored to your menstrual cycle" subtext should be displayed

  Scenario: Monthly Plan header and subtext
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Billed monthly" subtext under header should be visible


  Scenario: Monthly Plan checklist
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then the following lines preceded with checkmark should be visible:
      | 30-day AI diet plan synced with your cycle |
      | Daily workout + yoga matching hormonal phases |
      | Community access & motivation |
      | Health tracking & progress dashboard |
      | Blood report analysis + expert recommendations |

  Scenario: Monthly Plan Subscribe Now button
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then Subscribe Now button should be visible and enabled

  Scenario: 3-Month Plan Best Value badge
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "Best Value" badge text should be displayed on 3 Month Plan tile

  Scenario: 3-Month Plan subheader and subtext
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "3-Month Plan -- Full Transformation" subheader should be displayed
    And "A 90-day journey using menstrual cycle-aligned health planning. If you don't see results, we offer a money-back guarantee" subtext should be displayed

  Scenario: 3-Month Plan header and subtext
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then "One-time payment for 3 months" subtext under header should be visible
    

  Scenario: 3-Month Plan checklist
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then the following lines preceded with checkmark should be visible:
      | AI meal & workout plans synced with each menstrual phase |
      | Full access to community, yoga and stress relief |
      | Blood report analysis + expert recommendations |
      | Milestone tracking & habit building |
    And "Money-back if 10% weight not reduced" text preceded with star symbol should be visible

  Scenario: 3-Month Plan Get Started button
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after entering the required medication details
    Then Get Started button should be visible

  Scenario: Free Plan user navigation
    Given User is on step 11 onboarding process
    When User clicks on "Complete" after finishing all onboarding steps
    And User is on subscribe plan page
    Then User should be redirected to Dashboard page
