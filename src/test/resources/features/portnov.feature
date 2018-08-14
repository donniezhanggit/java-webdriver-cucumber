@ups
Feature: Portnov scenarios

  @ups1
  Scenario: play with basic functions
    Given  Given I open the page "Portnov"
    Then I verify "4970 El Camino Real, Suite 110, Los Altos, CA 94022" adress
    When I go to "School" tab
    When I move to "Schedule of Classes"
    When I move to "Full-Time" first tab
    Then I verify "$4,500.00" price


  @ups2
  Scenario: play with basic functions using page object model
    Given  Given I open the page "Portnov" p
    Then I verify "4970 El Camino Real, Suite 110, Los Altos, CA 94022" adress p
    When I go to "School" tab p
    When I move to "Schedule of Classes" p
    When I move to "Full-Time" first tab p
    Then I verify "$4,500.00" price p