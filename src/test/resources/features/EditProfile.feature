Feature: Edit Your Profile UI

  Background: 
    Given User clicks "Edit Profile" submenu from Dashboard Profile page

  # Edit Profile Main UI Verification
  Scenario: Title is displayed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on "Edit Profile"
    Then "Edit your Profile" should be visible

  Scenario: Sub text for title is displayed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on "Edit Profile"
    Then "Update your personal information and preferences" should be visible

  Scenario: Total number of tabs
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on "Edit Profile"
    Then There should be exactly 3 tabs

  Scenario: Tabs header are displayed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on "Edit Profile"
    Then "Basic Information", "Body Metrics", "Preferences & Health" tabs should be visible

  Scenario: Default tab
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on "Edit Profile"
    Then "Basic Information" should be visible by default

  Scenario: Back Button presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on "Edit Profile"
    Then "Back" Button should be visible

   Basic Information Tab UI Verification
  Scenario: Header text inside the section
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Basic Information" tab
    Then "Basic Information" should be visible inside section

  Scenario: Sub text for header
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Basic Information" tab
    Then "Update your name and age" sub text should be visible

  Scenario: Name input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Basic Information" tab
    Then Should display the user’s Name as entered during the onboarding process

  Scenario: Age input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Basic Information" tab
    Then Should display the user’s Age as entered during the onboarding process

  Scenario: Input field alignment and spacing
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Basic Information" tab
    Then Name and Age fields should be properly aligned vertically with equal spacing

  Scenario: "Next: Body Metrics" button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Basic Information" tab
    Then "Next: Body Metrics" button should be visible and enabled

   Body Metrics Tab UI Verification
  Scenario: Header text inside the section
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "Body Metric" should be visible inside section

  Scenario: Sub text for header
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "Update your weight and height information" should be visible

  Scenario: Weight input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then Should display the user’s Weight as entered during the onboarding process

  Scenario: Height input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then Should display the user’s Height as entered during the onboarding process

  Scenario: Instruction for entering Weight and Height
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "Please enter your height in decimal format" should be visible

  Scenario: Dropdown for weight measurement presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "kg" or "lb" unit values in dropdown should be visible and enabled

  Scenario: Dropdown for height measurement presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "ft/in" or "cm" unit values in dropdown should be visible and enabled

  Scenario: Input field alignment and spacing
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then Weight and Height fields should be properly aligned vertically with equal spacing

  Scenario: BMI Calculation section is visible
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "BMI Calculation Number" should be displayed with a gradient slider and labels

  Scenario: BMI Category section is visible
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "BMI Category" section should be present

  Scenario: BMI Category note is visible
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "BMI Category note" should be visible

  Scenario: Gradient color representation
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then Slider should display a continuous gradient from blue → yellow → orange → red

  Scenario: "Back" Button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "Back" Button should be visible and enabled

  Scenario: "Next: Body Metrics" button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Body Metrics" tab
    Then "Next: Body Metrics" button should be visible and enabled

  Scenario: Header text
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" tab
    Then "Preferences & Health" should be visible

  Scenario: Sub text for header
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" tab
    Then "Update your dietary preferences and medications" should be visible

  Scenario: Dietary Preferences RadioButtons options presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" tab
    Then "Pescatarian Diet", "Non-Vegetarian", "Vegetarian diet", "Vegan Diet" RadioButtons should be visible and enabled

  Scenario: "Add Medication" Button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" tab
    Then "Add Medication" Button should be visible and enabled

  Scenario: Medication & Supplements section presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" tab
    Then "Information text for Medication & Supplements" should be visible

  Scenario: "Back" Button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" tab
    Then "Back" Button should be visible and enabled

  Scenario: "Save Profile" Button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" tab
    Then "Save Profile" Button should be visible and enabled

  Scenario: Header text
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" section
    And User is on the "Preferences & Health" section
    When User clicks on "Add Medication" Button
    Then "Enter Medication name" should be visible

  Scenario: Enter Medication name Input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" section
    And User is on the "Preferences & Health" section
    When User clicks on "Add Medication" Button
    Then Should display empty input field for entering medication name

  Scenario: Button text
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" section
    And User is on the "Preferences & Health" section
    When User clicks on "Add Medication" Button
    Then "Ok" and "Cancel" buttons should be displayed

  Scenario: Total no of Buttons
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" section
    And User is on the "Preferences & Health" section
    When User clicks on "Add Medication" Button
    Then There should be exactly 2 buttons  "Ok" and "Cancel"

  Scenario: Adding Medication to the profile
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" section
    And User is on the "Preferences & Health" section
    When User clicks on "Ok" button after adding medication
    Then User should see success message "Your Medication name is saved"

  Scenario: Cancel the Medication pop up window
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And clicks "Preferences & Health" section
    And User is on the "Preferences & Health" section
    When User clicks on "Cancel" button without adding medication details
    Then User should navigate back to "Preferences & Health" section page
