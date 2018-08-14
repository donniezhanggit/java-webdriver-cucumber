@sample
Feature: Predefined steps for Sample page

#    @sample1
#    Scenario: Validate responsive UI behavior
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#      When I resize window to 1280 and 1024
#      Then element with xpath "//*[@id='location']" should be displayed
#      When I resize window to 400 and 1024
#      Then element with xpath "//*[@id='location']" should not be displayed


#
#    @sample2
#    Scenario: Fill out and validate "Username" field for at least 2 char
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#      When I type "H" into element with xpath "//*[@name='username']"
#      When I click on element using JavaScript with xpath "//*[@type='submit']"
#      Then I wait for element with xpath "//*[contains(text(), 'Please enter at least 2')]" to be present


#    @sample3
#    Scenario: validate email field
#  Given I open url "http://skryabin.com/webdriver/html/sample.html"
#  When I type "walkot@@gmail.com" into element with xpath "//*[@name='email']"
#  Then I click on element using JavaScript with xpath "//*[@id='formSubmit']"
#  Then I wait for element with xpath "//*[@id='email-error']" to be present


#    @sample3
#    Scenario: validate password fields
#  Given I open url "http://skryabin.com/webdriver/html/sample.html"
#  When I click on element using JavaScript with xpath "//*[@id='password'][contains(text() , '' )]"
#  Then element with xpath "//*[@id='confirmPassword']" should be disabled


#    @sample5
#    Scenario: validate password fields 2
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#      When I click on element using JavaScript with xpath "//*[@id='formSubmit']"
#      Then I wait for element with xpath "//*[@id='password-error']" to be present


#    @sample6
#    Scenario: validate password fields 3
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#      When I type "H" into element with xpath "//*[@name='password']"
#      Then I click on element using JavaScript with xpath "//*[@id='formSubmit']"
#      Then I wait for element with xpath "//*[@id='password-error'][contains(text(), '5 characters')]" to be present


#    @sample7
#    Scenario: validate password fields 4
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#      When I type "00000" into element with xpath "//*[@name='password']"
#      When I type "11111" into element with xpath "//*[@id='confirmPassword']"
#      Then I click on element using JavaScript with xpath "//*[@id='formSubmit']"
#      Then I wait for element with xpath "//*[@id='confirmPassword-error'][contains(text(), 'do not match!')]" to be present

#
#    @sample8
#    Scenario: validate name field
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#  When I click on element using JavaScript with xpath "//*[@id='name']"
#  Then I wait for element with xpath "//*[@id='nameDialog']" to be present
#  When I type "Walter" into element with xpath "//*[@id='firstName']"
#  And I type "Hartwell" into element with xpath "//*[@id='middleName']"
#      And I type "White" into element with xpath "//*[@id='lastName']"
#  When I click on element using JavaScript with xpath "//*[@class='ui-button-text'][contains(text(),'Save')]"
#      Then I wait for 1 sec
#      Then element with xpath "//*[@id='name']" should have attribute "value" as "Walter Hartwell White"



#    @sample9
#    Scenario: validate name field
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#When I click on element with xpath "//*[@id='formSubmit']"
#Then element with xpath "//*[@id='agreedToPrivacyPolicy-error']" should be displayed
#      And I wait for 3 sec
#  When I click on element with xpath "//*[@type='checkbox'][@name='agreedToPrivacyPolicy']"
#      And I click on element with xpath "//*[@id='formSubmit']"

#  @sample10
#  Scenario: Fill uot the form
#    Given I open url "http://skryabin.com/webdriver/html/sample.html"
#    When I type "5106762515" into element with xpath "//*[@name='phone']"
#    When I click on element with xpath "//*[@name='countryOfOrigin']/option[@value='Russia']"
#    When I click on element with xpath "//*[@name='gender'][@value='male']"
#    When I click on element with xpath "//*[@name='allowedToContact']"
#    When I type "hayward, CA, 94542" into element with xpath "//*[@id='address']"
#    When I click on element with xpath "//*[@value='Toyota']"
#    When I click on element with xpath "//*[@id='thirdPartyButton']"
#    When I accept alert
#
#    When I click on element with xpath "//*[@id='dateOfBirth']"
#    When I click on element with xpath "//a[@data-handler='prev']"
#    Then element with xpath "//select[@data-handler='selectMonth']/option[@value='2']" should be selected
#    When I click on element with xpath "//a[@data-handler='next']"
#    Then element with xpath "//select[@data-handler='selectMonth']/option[@value='3']" should be selected
#    When I click on element with xpath "//select[@data-handler='selectMonth']/option[@value='7']"
#    When I click on element with xpath "//select[@data-handler='selectYear']/option[@value='1992']"
#    When I click on element with xpath "//a[contains(text(),'31')]"
#    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "08/31/1992"
  

  


#    When I type "08/31/1992" into element with xpath "//*[@id='dateOfBirth']"



#    @sample11
#    Scenario: Just Fill out whole page
#      Given I open url "http://skryabin.com/webdriver/html/sample.html"
#      When I click on element using JavaScript with xpath "//*[@id='name']"
#      Then I wait for element with xpath "//*[@id='ui-id-1']" to be present
#      When I type "Andrei" into element with xpath "//input[@id='firstName']"
#      And I type "Travkin" into element with xpath "//input[@id='lastName']"
#      Then I click on element using JavaScript with xpath "//span[contains(text(),'Save')]"



#  @sample12
#  Scenario: Iframes
#    Given I open url "http://skryabin.com/webdriver/html/sample.html"
#    When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
#    When I type "5106762515" into element with xpath "//*[@id='contactPersonPhone']"
#    When I type "Andrei" into element with xpath "//*[@id='contactPersonName']"
#    And I switch to default content
#    When I click on element using JavaScript with xpath "//*[contains(text(),'Privacy Policy')]"


  @sample13
  Scenario: New windows
    Given I open url "http://skryabin.com/webdriver/html/sample.html"
    When I click on element with xpath "//*[contains(@onclick,'new_window')]"
    When I switch to new window
    Then element with xpath "/html" should contain text "Document 2"
    When I switch to first window


  @sample14
  Scenario: Full sample page functionality
    When I open the page "sample"
    When I fill out the form
    When I submit the sample page
    Then I verify filled out fields


  @sample15
  Scenario: Subnit and verify page object form
    Given I open sample page
    When I fill out all page object fields
    When I submit page object form
    Then I verify all page object fields

    @sample16
    Scenario: Map use
      Given when i create hash map

  @form17
  Scenario: Submit and verify page object form
    Given I open sample page
    When I fill out all page object fields
    And I submit page object form
    Then I verify all page object fields




    


