@OnboardingScenariosStep6
Feature: Onboarding Process

  Background: 
    Given User is on Menstrual Cycle Awareness page
    When User selects "Yes" radio option on step5 and clicks on Continue Button

  @TC53
  Scenario: Title of the onboarding step6
    Then Title of the page should be Last Period Date

  @TC54
  Scenario: Continue is visible
    Then Continue button should be visible

  @TC55
  Scenario: State of Continue button Step 6
    Then Continue button should be enabled

  @TC56
  Scenario: Description text for step 6
    Then Verify description text for step6

  @TC57
  Scenario: Presence of question in step 6
    Then User should see the question on Step6

  @TC58
  Scenario: Presence of calendar icon in step 6
    Then User should see the calendar icon in step6

  @TC59
  Scenario: Placeholder text for date field in step 6
    Then Date input field with placeholder "mm/dd/yyyy" should be displayed

  @TC60
  Scenario: Label below the date field
    Then Label "Cycle Length (days)" should be visible

  @TC61
  Scenario: Slider for cycle length
    Then Slider control for cycle length should be displayed

  @TC62
  Scenario: Default cycle length in slider
    Then Default cycle length value "28" should be shown beside the slider

  @TC63
  Scenario: Information text for cycle length
    Then Information text "Average cycle length is 28 days, but can vary from 21 to 45 days" should be visible

  @TC64
  Scenario: Display onboarding progress
    Then Verify Onboarding progress bar is displayed

  @TC65
  Scenario: Progress bar is visible
    Then Progress bar shows the current step as  6 of 10

  @TC66
  Scenario: Back button is visible
    Then Back button is displayed

  @TC67
  Scenario: State of Back button
    Then Back button should be enabled

  @TC68
  Scenario: Navigating back to step 5
    When User clicks on Back Button on Step6
    Then User should navigate to step5 Menstrual Cycle Awareness
