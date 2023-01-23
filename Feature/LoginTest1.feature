#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: AdactinApp Login Feature
  This feature is for checking login functionality of Adactin App

  Scenario: Succesful login with valid credentials as parameters
    Given user is on the login page
    When user enters "raniselen", "adactin"
    And user clicks on login button    
    Then Login is succesful
    And Search Page is displayed

  