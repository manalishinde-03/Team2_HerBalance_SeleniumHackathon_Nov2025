Feature: Menstrual Phase Logs - UI Verification
  As a logged-in user
  I want to view my Menstrual Phase Logs
  So that I can see my cycle-related sections

  Background:
    Given the user is logged in to Her Balance
    And the "Activity Insights" submenu is expanded

  Scenario: Verify all key sections, buttons, and tabs on Menstrual Phase Logs page
    # --- 1️⃣ Section visibility ---
    When the user clicks on Menstrual Phase Logs
    Then the following sections should be visible:
      | Current Cycle Status   |
      | Upcoming Phases        |
      | Recommended Activities |
      | Nutrition Tips         |
      | Next Period            |

    # --- 2️⃣ Buttons ---
    When the user clicks on Menstrual Phase Logs
    Then the "Update Cycle Information" button should be visible
    Then the "Back to Dashboard" button should be visible
    Then the "Add Period Log" button should be visible

    # --- 3️⃣ Tabs ---
    When the user clicks on Menstrual Phase Logs
    Then the "Cycle Overview" tab should be visible
    Then the "Menstrual Calendar" tab should be visible
    Then the "Period History" tab should be visible
