@yelp
Feature: yelp functions

  @wyelp1
  Scenario: I'm looking for food
    Given I open the page "Yelp"
    When I enter my location "94542"
    When I chose food "chipotle" in a food field
    When I click search button
    When I chose my favorite filters
    When I chose first restaurant on the page
    Then I verify that header "Chipotle" is present

