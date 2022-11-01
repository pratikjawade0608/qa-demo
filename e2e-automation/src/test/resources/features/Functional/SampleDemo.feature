@DemoFeature
Feature: Test Demo

  @windowsHandling
  Scenario: Handling the child window
    Given User is on the login page of Sample Test application
    When User click on the hyperlink click here
    And the child window opens
    Then the user enters email in the text box
    And User navigates back to parent window


  @radioButton
  Scenario: Using the reusable method for radio button
    Given User is on the login page of the medibuddysite
    When User scrolls down to the e-card section and click on it
    Then User will be navigated to the ecard page
    And User will select any other radio button and enter the details in the employee id
 
	
	