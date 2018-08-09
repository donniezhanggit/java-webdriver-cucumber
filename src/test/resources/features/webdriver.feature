@webdriver
Feature: Webdriver functions

  @webdriver1
  Scenario: Open the page
    Given I go to "Google" page and print details
    And I go to "Sample" page and print details
    And I go back and forward, then refresh the page
    And I print logs to the console

  @webdriver2
  Scenario: Array exercises
    Given I open "https://stackoverflow.com" then "https://yandex.ru/" then "https://www.bing.com/"

  @webdriver3
  Scenario: Working with window size
    Given I go to "sample" page and print details
    And I change resolution to "phone"
    And I change resolution to "desktop"


  @webdriver4
  Scenario: Element steps
    Given I go to "sample" page and print details
    When I fill out first name "Andrei" and last name "Travkin"
    When I fill out required fields
    When I fill out all non required fields
    Then I verify email field behavior
    When I submit the page
    Then I verify that fields values recorded correctly
    Then I verify that first name is "Andrei" and last name is "Travkin"


  @webdriver5
  Scenario: Project with USPS
    When I open the page "usps"
    When I go to the page by adress
    When I put the data "25928 Westview Way" and "Hayward"
    When I search for result
    Then I verify the data by "94542"


  @webdriver6
  Scenario: Project with USPS 2
    When I open the page "https://www.usps.com/"
    When I go to the page by adress
    When I put the data "4970 El Camino Real" and "Los Altos"
    When I search for result
    Then I verify the data by "94022"


  @webdriver7
  Scenario: Project with USPS 3
    When I open the page "https://www.usps.com/"
    When I go	to Calculate Price Page
    And I select "United Kingdom" with "Postcard" shape
    When I define 2 quantity
    When I submit a new page using "//input[@type='button']"
    Then I verify the price


  @webdriver8
  Scenario: Cinema Century
    Given I open the page "cinemark"
    When I looking for my location "94542"




  @webdriver9
  Scenario: Project with USPS 4
    Given  I open the page "USPS"
    When I go to postal store
    When I fill out the form with "12345"
    Then I Verify that search does not match any products

  @webdriver10
  Scenario: Unit Converters
    Given  I open the page "Converter"
    When I click on "Temperature"
    When I select "Fahrenheit" to "Celsius"
    Then I verify the Fereneight "54" is match Celcios "12.2"

  @webdriver11
  Scenario: Project with USPS 5
    Given  I open the page "USPS"
    When I go to Stamps
    When I select Mail Priority Mail
    Then Verify 1 item on the page


  @webdriver12
  Scenario: Project with USPS 6
    Given  I open the page "USPS"
    When I go to Stamps
    When I Unselect "Stamps" checkbox
    When Select Size "18 Months"
    When I click pink color
    Then I verify "Pink" and "18 Month"

  @webdriver13
  Scenario: Project with USPS 7
    Given I open the page "USPS"
    When I go to "Search"
    And I click "passport"
    When I go to the "Post Office Hours"
    When I select passports
    When I file zip code with "94568" within "5" miles
    When I click search
    Then I verify address contains "PLEASANTON"
    When I click on search result "PLEASANTON"
    Then I veryfy adress "4300 BLACK AVE" and "9:30am - 1:00pm" walk-in hours and "2:00pm - 3:30pm" photo hours
    When I click back to list
    Then verify you'are on correct page























