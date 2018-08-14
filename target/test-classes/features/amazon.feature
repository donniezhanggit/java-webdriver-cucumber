@ups
Feature: Amazon scenarios

  @ups1
  Scenario: check Amazon functionality
    Given I open the page "Amazon" page
    When I type "protein bars" into "Search" field
    When I click submit button
    When I chose protein bar
    Then I verify that bar contains "Pack 1.76-Ounce Bar (Pack of 18)"