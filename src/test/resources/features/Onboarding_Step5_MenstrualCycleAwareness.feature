@OnboardingScenariosStep5
Feature: Onboarding Process

  Background: 
    Given User is on Personal Details page
    When User enters valid personal details "TestUser","30" and "I'm not sure" and clicks on Continue Button

  @TC41
  Scenario: Continue is visible
    Then Continue button should be visible

  @TC42
  Scenario: State of Continue button
    Then Continue button should be enabled

  @TC43
  Scenario: Navigation to onboarding step5
    Then Verify user navigates to Step5 after clicking Continue button

  @TC44
  Scenario: Description text for step5
    Then Verify description text for step5

  @TC45
  Scenario: Presence of question in step 5
    Then User should see the question on Step5

  @TC46
  Scenario: Total number of radio buttons in Step5
    Then Total number of radio buttons in Step5 should be 5

  @TC47
  Scenario: Radio button options in Step5
    Then Following Radio options for  menstrual cycle awareness should be displayed
      | Yes                                      |
      | No                                       |
      | My cycle is irregular                    |
      | I'm perimenopausal                       |
      | I no longer menstruate (e.g., menopause) |

  @TC48
  Scenario: Display onboarding progress
    Then Verify Onboarding progress bar is displayed

  @TC49
  Scenario: Progress bar is visible
    Then Progress bar shows the current step as  5 of 10

  @TC50
  Scenario: Back button is visible
    Then Back button is displayed

  @TC51
  Scenario: State of Back button
    Then Back button should be enabled
    
     @TC52
  Scenario: Navigating back to step 4
  	When User clicks on Back Button on Step5
    Then User should navigate to step4 Personal Details
