@OnboardingScenariosStep1
Feature: Onboarding Process Step1

  Background: 
    Given The browser is open
    And User enters the correct HerBalance URL
  
  @TC1
  Scenario: Title of the onboarding step1
    Given User clicks on sign up
    And User is on sign up page
   # When User clicks register button after entering valid details
   # Then Title of the page should be Upload Your Recent Blood Work
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
