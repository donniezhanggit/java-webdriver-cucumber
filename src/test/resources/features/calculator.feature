@calculator
Feature: calculator functions

  @calculator1
  Scenario: Verification of Loan Calculator
    When I open the page "Calculator"
    When  go to the "Financial Calculators"
    When Go to the "Auto Loan Calculator" page
    When Clear all fields
    When click Calculate
    Then I verify "Please provide a positive" errors
    When I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
    When click Calculate
    Then I verify monthly pay "372.86"






    


 