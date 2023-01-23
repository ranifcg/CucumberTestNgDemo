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
@tagoutline
Feature: Search the hotel in Adactin app
  I want to test Search functionality in Adactin app

  Scenario Outline: Search results displayed upon filling mandatory values
     	Given user is on the login page
    	When user enters "<username>", "<password>"
    	And user clicks on login button    
    	And login is succesful
    	And search Page is displayed
    	And user selects "<location>","<rooms>","<checkin date>","<checkout date>","<adults>"
    	And user clicks on Search button
    	Then search results should be displayed
    	
    Examples: 
      | username  | password | location  |	rooms  | checkin date  | checkout date| adults |
      | raniselen | adactin | Sydney | 1 | 13/01/2023  | 15/01/2023| 2 |
      | santosh13 | Snoopy1234 | Melbourne | 3 | 16/01/2023  | 18/01/2023| 1 |
      | vasuvespag | vasu1234 | London | 2 | 18/01/2023  | 19/01/2023| 3 |
      