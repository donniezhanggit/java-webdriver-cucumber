@yelp
Feature: yelp functions

  @wyelp1
  Scenario: I'm looking for food
    Given I open the page "Yelp"
    When I enter my location "94542"
    When I chose food "Chipotle" in a food field
    When I click search button
    When I chose my favorite filters
    When I chose first restaurant on the page
    Then I verify that header "Chipotle" is present


  @wyelp2
  Scenario: I'm looking for food using page object pattern
    Given I open the page "Yelp" p
    When I enter my location "94542" p
    When I chose food "Chipotle" in a food field p
    When I click search button p
    When I chose my favorite filters p
    When I chose first restaurant on the page p
    Then I verify that header "Chipotle" is present p
