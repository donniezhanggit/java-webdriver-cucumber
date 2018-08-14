@ups
Feature: USP scenarios

  @ups1
  Scenario: Verify UPS shipping functionality
    Given I open the page "ups"
    When I open "Shipping" menu item
    And I open "Calculate Time & Cost" submenu item
    And I submit calculation form
    Then I verify ">>> Please complete the highlighted fields." form error
    And I verify ">>> City" form error
    And I verify ">>> ZIP Code" form error
    When I enter ship from "United States" country, "Los Altos" city, "94022" zip
    And I enter ship to "United States" country, "New York" city, "10165" zip
    And I submit calculation form
    And I enter "1" lbs weight
    And I submit calculation form
    Then I verify results contain "Los Altos" text
    Then I verify results contain "New York" text
    Then I verify results contain "UPS Next Day Air® Early" text
    Then I verify results contain "UPS 2nd Day Air" text
    Then I verify results contain "UPS Ground" text
    Then I verify results contain "113.81  USD" text


  @UPS2
  Scenario: Verify another UPS shipping functionality 2
    Given I open the page "ups"
    When I open "Shipping" menu item
    And I open "Create a Shipment" submenu item

    And I fill out "Country or Territory" dropdown with "United States"
    And I submit calculation form

    Then I verify "Company or Name" field has error "This field is required"
    Then I verify "Address" field has error "This field is required"
    Then I verify "State" field has error "This field is required"
    Then I verify "Telephone" field has error "This field is required"
    Then I verify "E-mail" field has error "This field is required"
    Then I verify "ZIP Code" field has error "This field is required"
    Then I verify "City" field has error "This field is required"

    When I fill out "E-mail" field with "aaa"
    Then I verify "E-mail" field has error "Field format invalid"
    When I clear "E-mail" field

    When I fill out "Telephone" field with "aaa"
    Then I verify "Telephone" field has error "Field format invalid"
    And I clear "Telephone" field

    When I fill out "Telephone" field with "123"
    Then I verify "Telephone" field has error "Field min length not met"
    And I clear "Telephone" field

    When I fill out "Company or Name" field with "Los Altos Software Testing House"
    When I fill out "Contact" field with "Andrei Travkin"
    And I fill out "Address" field with "4970 El Camino Real"
    And I fill out "ZIP Code" field with "94022"
    And I fill out "City" field with "Los Altos"
    And I fill out "State" dropdown with "California"
    And I fill out "E-mail" field with "andreytravkin5@gmail.com"
    And I fill out "Telephone" field with "3477943437"

    And I submit calculation form
    Then I verify that ship from section contains "Los Altos Software Testing House"
    Then I verify that ship from section contains "Andrei Travkin"
    Then I verify that ship from section contains "4970 El Camino Real"
    Then I verify that ship from section contains "Los Altos, CA 94022"

    And I cancel shipment
    Then I verify shipment is cancelled


  @ups3
  Scenario: Verify ship and cost in different locale
    Given I open the page "ups"
    And I go to language settings
    And I select "Select Another Country or Territory"
    And I select "Europe" section and "Germany - English" language

    When I open "Shipping" menu item
    And I open "Create a Shipment" submenu item
    And I fill out "Country or Territory" dropdown with "United States"
    And I submit calculation form

    Then I verify "Company or Name" field has error "This field is required"
    Then I verify "Address" field has error "This field is required"
    Then I verify "State" field has error "This field is required"
    Then I verify "Telephone" field has error "This field is required"
    Then I verify "E-mail" field has error "This field is required"
    Then I verify "ZIP Code" field has error "This field is required"
    Then I verify "City" field has error "This field is required"

    When I fill out "E-mail" field with "aaa"
    Then I verify "E-mail" field has error "Field format invalid"
    When I clear "E-mail" field

    When I fill out "Telephone" field with "aaa"
    Then I verify "Telephone" field has error "Field format invalid"
    And I clear "Telephone" field

    When I fill out "Telephone" field with "123"
    Then I verify "Telephone" field has error "Field min length not met"
    And I clear "Telephone" field

    When I fill out "Company or Name" field with "Los Altos Software Testing House"
    When I fill out "Contact" field with "Andrei Travkin"
    And I fill out "Address" field with "4970 El Camino Real"
    And I fill out "City" field with "Los Altos"
    And I fill out "ZIP Code" field with "94022"
    And I fill out "State" dropdown with "California"
    And I fill out "E-mail" field with "andreytravkin5@gmail.com"
    And I fill out "Telephone" field with "3477943437"

    And I submit calculation form
    Then I verify that ship from section contains "Los Altos Software Testing House"
    Then I verify that ship from section contains "Andrei Travkin"
    Then I verify that ship from section contains "4970 El Camino Real"
    Then I verify that ship from section contains "Los Altos, CA 94022"

    And I cancel shipment
    Then I verify shipment is cancelled



  @ups4
  Scenario: Verify another UPS shipping functionality 3
    Given I open the page "ups"
    When I open "Shipping" menu item
    And I open "Create a Shipment" submenu item

    And I fill out "Country or Territory" dropdown with "United States"
    When I fill out "Name" field with "Los Altos Software Testing House"
    When I fill out "Contact Name" field with "Andrei Travkin" info
    And I fill out "Address" field with "4970 El Camino Real" info
    And  I fill out "City" field with "Los Altos" info
    And I fill out "ZIP Code" field with "94022" info

    And I fill out "State" dropdown with "California"
    And I fill out "Email" field with "andreytravkin5@gmail.com" info
    And I fill out "Phone" field with "3477943437" info
    And I submit calculation form

    Then I verify that ship from section contains "Los Altos Software Testing House"
    Then I verify that ship from section contains "Andrei Travkin"
    Then I verify that ship from section contains "4970 El Camino Real"
    Then I verify that ship from section contains "Los Altos, California 94022"

    When I fill out "Country or Territory" dropdown with "United States"
    When I fill out "Name" field with "Dusik inc" data
    When I fill out "Contact" field with "Dusic" info
    And I fill out "Address" field with "Brighton 11th st" info
    And  I fill out "City" field with "Brooklyn" info
    And I fill out "ZIP Code" field with "11235" info
    And I fill out "Email" field with "andreytravkin5@gmail.com" info
    And I fill out "Phone" field with "3477943437" info

    Then I Verify total charges are "11.04"

    And I submit calculation form
    And I submit pop up window
    And I submit second pop up window

    When I select "UPS Express Box - Small" small
    When I fill "1" pound weight
    Then I Verify new total charges are "42.57"

    And I submit calculation form
#    When I submit calculation form again

    When   Select the option "by End of Day"
#    When I submit calculation form again
    And I submit calculation form

#    When I Choose Saturday delivery
    Then I Verify new total charges are "59.85"
    And I submit calculation form


    Then I verify I am on "How would you like to pay?" page
    And I choose "Other Ways to Pay" payment option
    Then I verify PayPal appears

    And I submit shipment form and verify new page opened
    Then I verify that ship to section contains "Dusic"
    Then I verify that ship to section contains "Brighton"
    Then I verify that ship to section contains "Brooklyn"
    Then I verify that ship to section contains "andreytravkin5@gmail.com"

    And I cancel shipment
    Then I verify that shipment is cancelled

  @ups5
  Scenario:	UPS	end	to	end
    Given I open the page "ups"
    When I open "Shipping" menu item
    And I open "Create a Shipment" submenu item

    And I fill out "Country or Territory" dropdown with "United States"
    When I fill out "Name" field with "Los Altos Software Testing House"
    When I fill out "Contact Name" field with "Andrei Travkin" info
    And I fill out "Address" field with "4970 El Camino Real" info
    And  I fill out "City" field with "Los Altos" info
    And I fill out "ZIP Code" field with "94022" info

    And I fill out "State" dropdown with "California"
    And I fill out "Email" field with "andreytravkin5@gmail.com" info
    And I fill out "Phone" field with "3477943437" info
    And I submit calculation form

    Then I verify that ship from section contains "Los Altos Software Testing House"
    Then I verify that ship from section contains "Andrei Travkin"
    Then I verify that ship from section contains "4970 El Camino Real"
    Then I verify that ship from section contains "Los Altos, California 94022"
    And I cancel shipment
    Then I verify that shipment is cancelled


