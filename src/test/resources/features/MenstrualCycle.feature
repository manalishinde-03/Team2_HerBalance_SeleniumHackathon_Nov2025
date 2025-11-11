Feature: Menstrual Phase Logs - UI Verification
  As a logged-in user
  I want to view my Menstrual Phase Logs
  So that I can see my cycle-related sections

  Background:
    Given the user is logged in to Her Balance
    And the "Activity Insights" submenu is expanded

  Scenario: Verify 5 sections are visible on Menstrual Phase Logs page
    When the user clicks on Menstrual Phase Logs
    Then the following sections should be visible:
      | Current Cycle Status   |
      | Upcoming Phases        |
      | Recommended Activities |
      | Nutrition Tips         |
      | Next Period            |

  Scenario: Verify Update Cycle Information button is visible
    When the user clicks on Menstrual Phase Logs
    Then the "Update Cycle Information" button should be visible

  Scenario: Verify Back to Dashboard button is visible on Menstrual Phase Logs
    When the user clicks on Menstrual Phase Logs
    Then the "Back to Dashboard" button should be visible

  Scenario: "Add Period Log" button is visible
    When the user clicks on Menstrual Phase Logs
    Then the "Add Period Log" button should be visible

  Scenario: "Cycle Overview" tab is visible
    When the user clicks on Menstrual Phase Logs
    Then the "Cycle Overview" tab should be visible

  Scenario: "Menstrual Calendar" tab is visible
    When the user clicks on Menstrual Phase Logs
    Then the "Menstrual Calendar" tab should be visible

  Scenario: "Period History" tab is visible
    When the user clicks on Menstrual Phase Logs
    Then the "Period History" tab should be visible
