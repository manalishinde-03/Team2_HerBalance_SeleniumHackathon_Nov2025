
Feature: Launch Page in Her Balance - Non functional


  Scenario: Cycle phases information is displayed
    Given User is on the browser
    When User enters app url
    Then Display cards for 'Menstrual Phase', 'Follicular Phase', 'Ovulation Phase', and 'Luteal Phase'
