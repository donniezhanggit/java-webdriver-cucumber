@ups
Feature: Braer Park scenarios

  @ups1
  Scenario: Verify Braer Park functionality
    Given I open the page "Braer Park"
    When I go to "Планировки" section
    Then I verify that "Выбор дома" is present
    When I schose house 8
    When I go to the third floor
    When I go to the "18" apartment
    Then I verify apartment price "1 830 900"
    When I go to "Обратиться в офис продаж" section tab
    Then I verify that it contains "Бесплатная консультация"

  @ups2
  Scenario: Verify Braer Park functionality using page object pattern
    Given I open the page "Braer Park" page object
    When I go to "Планировки" section p
    Then I verify that "Выбор дома" is present p
    When I schose house 8 p
    When I go to the third floor p
    When I go to the "18" apartment p
    Then I verify apartment price "1 830 900" p
    When I go to "Обратиться в офис продаж" section tab p
    Then I verify that it contains "Бесплатная консультация" p

  @ups3
  Scenario: Verify Braer Park functionality2
    Given if else conditions