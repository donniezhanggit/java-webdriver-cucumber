$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/ups.feature");
formatter.feature({
  "name": "USP scenarios",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ups"
    }
  ]
});
formatter.scenario({
  "name": "Verify another UPS shipping functionality 2",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ups"
    },
    {
      "name": "@ups2"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open the page \"ups\"",
  "keyword": "Given "
});
formatter.match({
  "location": "WebDriverStepDefs.iOpenThePage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I open \"Shipping\" menu item",
  "keyword": "When "
});
formatter.match({
  "location": "MyUpsProject.iOpenMenuItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I open \"Create a Shipment:\" submenu item",
  "keyword": "And "
});
formatter.match({
  "location": "MyUpsProject.iOpenSubmenuItem(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill out \"Country or Territory\" dropdown with \"United States\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyUpsProject.iFillOutDropdownWith(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I submit calculation form",
  "keyword": "And "
});
formatter.match({
  "location": "MyUpsProject.iSubmitCalculationForm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"Company or Name\" field has error \"This field is required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"Address\" field has error \"This field is required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"State\" field has error \"This field is required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"Telephone\" field has error \"This field is required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"E-mail\" field has error \"This field is required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"ZIP Code\" field has error \"This field is required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"City\" field has error \"This field is required\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill out \"E-mail\" field with \"aaa\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify \"E-mail\" field has error \"Field format invalid\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I clear \"E-mail\" field",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"Telephone\" field with \"aaa\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify \"Telephone\" field has error \"Field format invalid\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I clear \"Telephone\" field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"Telephone\" field with \"123\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify \"Telephone\" field has error \"Field min length not met\"",
  "keyword": "Then "
});
formatter.match({
  "location": "MyUpsProject.iVerifyFieldHasError(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I clear \"Telephone\" field",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"Company or Name\" field with \"Los Altos Software Testing House\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"Contact\" field with \"Slava Skryabin\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"Address\" field with \"4970 El Camino Real\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"ZIP Code\" field with \"94022\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"City\" field with \"Los Altos\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"State\" dropdown with \"California\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyUpsProject.iFillOutDropdownWith(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I fill out \"E-mail\" field with \"slava@skryabin.com\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I fill out \"Telephone\" field with \"1234567890\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I submit shipment form",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify that ship from section contains \"Los Altos Software Testing House\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify that ship from section contains \"Slava Skryabin\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify that ship from section contains \"4970 El Camino Real\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify that ship from section contains \"Los Altos, CA 94022\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I cancel shipment",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I verify shipment is cancelled",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "passed"
});
});