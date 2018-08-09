@ups
Feature: Bevager scenarios

  @ups1
  Scenario: Verify Bevager functionality
    Given I open the page "Bevager"
    When I click log in bar
    When I fill out log in "sample@bar.com" and password "bevdemo" fields
    When I click "Sign in" button and log in
#    Then I verify that Im on the main page
    When I click on recipes1
    When I click on recipes two
    When I click on "New Recipe" button
    When I chose menu list type
#     new name requared every time
    When I name my recipe as "test scenario № "
    When I click on create new recipe