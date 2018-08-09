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