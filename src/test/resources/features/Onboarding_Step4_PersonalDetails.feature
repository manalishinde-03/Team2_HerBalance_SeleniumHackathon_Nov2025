@OnboardingScenariosStep4
Feature: Onboarding Process Step4

  Background: 
    Given User is on Health Conditions page
    When User selects "Sleep apnea" health condition and clicks on Continue Button

  @TC26
  Scenario: Continue is visible
    Then Continue button should be visible

  @TC27
  Scenario: State of Continue button
    Then Continue button should be enabled

  @TC28
  Scenario: Title of the onboarding step4
    Then Title of the page should be Personal Details

  @TC29
  Scenario: Description text for step4
    Then Verify description text for step4

  @TC30
  Scenario: Input box count
    Then Verify input box count is 2 on step4

  @TC31
  Scenario: Field lables
    Then User should see the following input field labels:
      | What's your first name? |
      | What's your age?        |

  @TC32
  Scenario: Helper text for the fields
    Then User should see the following helper text under the input fields:
      | Personalizing your experience starts with knowing your name.                                                                                      |
      | Your age helps us tailor recommendations suitable for your life stage.                                                                            |
      | Understanding your blood pressure status helps us tailor workouts and nutrition plans that are safe and effective for your cardiovascular health. |

  @TC33
  Scenario: Total number of radio buttons in Step4
    Then Total number of radio buttons should be 4

  @TC34
  Scenario: Blood pressure description options
    Then Blood pressure description options should be :
      | I have been diagnosed with high blood pressure and take medication for it |
      | I have been diagnosed but don't take medication                           |
      | I have never been diagnosed                                               |
      | I'm not sure                                                              |

  @TC35
  Scenario: Display onboarding progress
    Then Verify Onboarding progress bar is displayed

  @TC36
  Scenario: Progress bar is visible
    Then Progress bar shows the current step as  4 of 10

  @TC37
  Scenario: Back button is visible
    Then Back button is displayed

  @TC38
  Scenario: State of Back button
    Then Back button should be enabled
    
     @TC39
  Scenario: Navigating back to step 3
  	When User clicks on Back Button on Step4
    Then User should navigate to step3 Health Conditions

  @TC40
  Scenario: Navigation to Step 5
  	When User clicks on Continue Button on Step4
    Then Verify user navigates to Step5 after clicking Continue button
    
     @TC400
  Scenario Outline: Navigation to onboarding step5
    When User enters valid personal details for "<testcase>" and clicks on Continue Button
    Then Verify user navigates to Step5 after clicking Continue button

    Examples: 
      | testcase       |
      | validInputData |
      
      @TC401
  Scenario Outline: Error Message for invalid personal details onboarding step4
    When User enters valid personal details for "<testcase>" and clicks on Continue Button
    Then Verify user gets error message on Step4

    Examples: 
      | testcase       |
      | invalidInputData |

  
