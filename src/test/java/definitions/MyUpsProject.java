package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;


public class MyUpsProject {
    @When("^I open \"([^\"]*)\" menu item$")
    public void iOpenMenuItem(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//a[text()='" + tab + "'][@id='ups-menuLinks1']")).click();

    }

    @And("^I open \"([^\"]*)\" submenu item$")
    public void iOpenSubmenuItem(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + tab + "')]")).click();

    }

    @And("^I submit calculation form$")
    public void iSubmitCalculationForm() throws Throwable {
        //saveScreenshot();
//        getDriver().findElement(By.xpath("//*[@id='ctc_module1_submit']")).click();
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//h2[@id='ups-footer_thisSite']"));
        actions.moveToElement(element).perform();

        By submitSelector = By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']");


        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(submitSelector));
        getExecutor().executeScript("arguments[0].click();", getDriver().findElement(submitSelector));

//        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"))).click();

//        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/fieldset//p//strong")));


    }

    @Then("^I verify \"([^\"]*)\" form error$")
    public void iVerifyFormError(String expectedError) throws Throwable {

        String actualError = getDriver().findElement(By.xpath("//div[@id='module1edit']")).getText();
        assertThat(actualError).contains(expectedError);

    }

    @When("^I enter ship from \"([^\"]*)\" country, \"([^\"]*)\" city, \"([^\"]*)\" zip$")
    public void iEnterShipFromCountryCityZip(String country, String city, String zipCode) throws Throwable {

        getDriver().findElement(By.xpath("//select[@id='orig_Country']/option[text()='" + country + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='orig_City']")).sendKeys(city);
        getDriver().findElement(By.xpath("//*[@id='orig_PostalCode']")).sendKeys(zipCode);

    }

    @And("^I enter ship to \"([^\"]*)\" country, \"([^\"]*)\" city, \"([^\"]*)\" zip$")
    public void iEnterShipToCountryCityZip(String country, String city, String zipCode) throws Throwable {
        getDriver().findElement(By.xpath("//*[@id='dest_Country']/option[text()='" + country + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='dest_City']")).sendKeys(city);
        getDriver().findElement(By.xpath("//input[@id='dest_PostalCode']")).sendKeys(zipCode);
        Thread.sleep(3000);
    }

    @And("^I enter \"([^\"]*)\" lbs weight$")
    public void iEnterLbsWeight(String weight) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='weightValueSec']")).sendKeys(weight);

    }

    @Then("^I verify results contain \"([^\"]*)\" text$")
    public void iVerifyResultsContainText(String expectedText) throws Throwable {
        String actualText = getDriver().findElement(By.xpath("//div[@id='results']")).getText();
        assertThat(actualText).containsIgnoringCase(expectedText);
    }

    @When("^I go to \"([^\"]*)\" menu item$")
    public void iGoToMenuItem(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + tab + "')]")).click();
    }


    @When("^i click \"([^\"]*)\" button$")
    public void iClickButton(String button) throws Throwable {
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//button[@id='continueBtn']//*[contains(text(),'" + button + "')]")).click();
    }


    @Then("^I verify \"([^\"]*)\" error message$")
    public void iVerifyErrorMessage(String error) throws Throwable {
        Thread.sleep(500);
        List<WebElement> actualElements = getDriver().findElements(By.xpath("//*[contains(text(),'" + error + "')]"));
        for (WebElement element : actualElements) {
            if (element.isDisplayed()) {
                assertThat(actualElements).contains(element);
            }
        }
    }


    @When("^I fill out the form with name \"([^\"]*)\" and contact \"([^\"]*)\" and address \"([^\"]*)\" and zipCode \"([^\"]*)\" and city \"([^\"]*)\" and email \"([^\"]*)\" and telephone \"([^\"]*)\"$")
    public void iFillOutTheFormWithAndContactAndAddressAndZipCodeAndCityAndEmailAndTelephone(String name, String contact, String address, String zipCode, String city, String email, String telephone) throws Throwable {

        getDriver().findElement(By.xpath("//input[@id='Fromname']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@id='FromcontactName']")).sendKeys(contact);
        getDriver().findElement(By.xpath("//input[@id='Fromaddress1']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@id='Frompostal']")).sendKeys(zipCode);
        getDriver().findElement(By.xpath("//input[@id='Fromcity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//input[@id='Fromemail']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@id='Fromphone']")).sendKeys(telephone);

        Thread.sleep(500);

    }


    @Then("^I verify \"([^\"]*)\" message$")
    public void iVerifyMessage(String error) throws Throwable {

        getDriver().findElement(By.xpath("//input[@id='Fromemail']//..//*[contains(text(),'" + error + "')]")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@id='Fromphone']//..//*[contains(text(),'" + error + "')]")).isDisplayed();

    }

    @When("^I change email on \"([^\"]*)\" and telephone on\"([^\"]*)\"$")
    public void iChangeEmailOnAndTelephoneOn(String email, String telephone) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='Fromemail']")).sendKeys(email);
        getDriver().findElement(By.xpath("//input[@id='Fromphone']")).sendKeys(telephone);
    }


    @Then("^I verify error \"([^\"]*)\"$")
    public void iVerifyError(String text) throws Throwable {
        Thread.sleep(500);
        String actualError = getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]")).getText();
        Thread.sleep(500);
        assertThat(actualError).containsIgnoringCase(text);
    }


    @When("^I click \"([^\"]*)\" tab$")
    public void iClickTab(String tab) throws Throwable {

        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ups-language-toggle'][contains(text(),'\"+tab+\"')]")));
        getDriver().findElement(By.xpath("//a[@id='ups-language-toggle'][contains(text(),'" + tab + "')]")).click();


    }

    @Then("^I verify that country is \"([^\"]*)\"$")
    public void iVerifyThatCountryIs(String country) throws Throwable {
        String actualCountry = getDriver().findElement(By.xpath("//a[contains(text(),'" + country + "')][@id='ups-language-toggle']")).getText();
        assertThat(actualCountry).containsIgnoringCase(country);
    }


    @And("^I fill out \"([^\"]*)\" dropdown with \"([^\"]*)\"$")
    public void iFillOutDropdownWith(String fieldName, String value) throws Throwable {
//        getDriver().findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/..//select")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'" + fieldName + "')]/..//*[contains(text(),'" + value + "')]")).click();

    }

    @Then("^I verify \"([^\"]*)\" field has error \"([^\"]*)\"$")
    public void iVerifyFieldHasError(String fieldName, String expectedError) throws Throwable {
        String actualError = getDriver().findElement(By.xpath("//label[@for][contains(text(),'" + fieldName + "')]/..//*[contains(text(),'" + expectedError + "')]")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }

    @When("^I fill out \"([^\"]*)\" field with \"([^\"]*)\"$")
    public void iFillOutFieldWith(String fieldName, String text) throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/..//input[@id='originname']")).sendKeys(text);

    }

    @When("^I clear \"([^\"]*)\" field$")
    public void iClearField(String fieldName) throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/..//input")).clear();
    }

    @Then("^I verify that ship from section contains \"([^\"]*)\"$")
    public void iVerifyThatShipFromSectionContains(String expectedText) throws Throwable {

        new WebDriverWait(getDriver(), 8).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ups-section']//*[@id='originnbsAgentSummaryName']")));
        String actualText = getDriver().findElement(By.xpath("//div[@class='ups-section']")).getText();
        assertThat(actualText).containsIgnoringCase(expectedText);

    }

    @And("^I cancel shipment$")
    public void iCancelShipment() throws Throwable {


 WebElement cancel = getDriver().findElement(By.xpath("//button[@type='button'][contains(text(),'Cancel Shipment')]"));
        getExecutor().executeScript("arguments[0].click();", cancel);
        getDriver().findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

    }

    @Then("^I verify shipment is cancelled$")
    public void iVerifyShipmentIsCancelled() throws Throwable {


        WebElement fromTitle = getDriver().findElement(By.xpath("//span[@id='fromTitle']"));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(fromTitle));
        assertThat(fromTitle.isDisplayed()).isTrue();

        WebElement formName = getDriver().findElement(By.xpath("//input[@id='Fromname']"));
        String value = formName.getAttribute("value");
        assertThat(value).isEmpty();
    }

    @When("^I click \"([^\"]*)\" menu tab$")
    public void iClickMenuTab(String country) throws Throwable {

        getDriver().findElement(By.xpath("//a[contains(text(),'" + country + "')]")).click();
    }

    @And("^I go to language settings$")
    public void iGoToLanguageSettings() throws Throwable {
        getDriver().findElement(By.xpath("//a[@id='ups-language-toggle']")).click();


        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ups-language-panel']//*[contains(text(),'Select Another Country or Territory')]")));

    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String tab) throws Throwable {


        getDriver().findElement(By.xpath("//div[@id='ups-language-panel']//*[contains(text(),'" + tab + "')]")).click();
    }


    @And("^I select \"([^\"]*)\" section and \"([^\"]*)\" language$")
    public void iSelectSectionAndLanguage(String section, String language) throws Throwable {
        getDriver().findElement(By.xpath("//a[@id='ups-imagemap3'][contains(text(),'" + section + "')]")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'" + language + "')]")).click();
    }


    @Then("^I Verify total charges are \"([^\"]*)\"$")
    public void iVerifyTotalChargesAre(String expectedCharges) throws Throwable {

        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='total-charges-spinner']")));
        String actualCharges = getDriver().findElement(By.xpath("//*[@id='total-charges-spinner']")).getText();
        assertThat(actualCharges).containsIgnoringCase(expectedCharges);


    }

    @When("^I select \"([^\"]*)\" small$")
    public void iSelectSmall(String packageType) throws Throwable {

        Actions actions = new Actions(getDriver());
        WebElement lol = getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageLengthField0']"));
        actions.moveToElement(lol).perform();

//        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']"))).click();
        getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']//*[contains(text(),'" + packageType + "')]")).click();
    }

    @And("^I submit pop up window$")
    public void iSubmitPopUpWindow() throws Throwable {


        WebElement window = getDriver().findElement(By.xpath("//button[@id='nbsAddressValidationContinue']"));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(window));


        if (window.isDisplayed()) {

            getDriver().findElement(By.xpath("//button[@id='nbsAddressValidationContinue']")).click();


        }
    }

    @And("^I submit second pop up window$")
    public void iSubmitSecondPopUpWindow() throws Throwable {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nbsAddressClassificationContinue']")));
        getDriver().findElement(By.xpath("//button[@id='nbsAddressClassificationContinue']")).click();
    }

    @When("^I fill \"([^\"]*)\" pound weight$")
    public void iFillPoundWeight(String weight) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys(weight);
    }

    @When("^I submit calculation form again$")
    public void iSubmitCalculationFormAgain() throws Throwable {


        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//div[@class='ups-footer_colsCont ups-container']"));
        actions.moveToElement(element).perform();


        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='button'][contains(text(),'Continue')]"))).click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='button'][contains(text(),'Continue')]"))).click();

    }


    @Then("^I Verify new total charges are \"([^\"]*)\"$")

    public void iVerifyNewTotalChargesAre(String expectedCharges) throws Throwable {

//        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='ng-tns-c1-0']")));
//        String actualCharges = getDriver().findElement(By.xpath("//h2[@class='ng-tns-c1-0']")).getText();
//        assertThat(actualCharges).containsIgnoringCase(expectedCharges);
//        getDriver().findElement(By.xpath("//span[@class='icon ups-icon-chevronup']")).click();

        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@id='total-charges-spinner']"), expectedCharges));
    }

    @When("^I fill out \"([^\"]*)\" field with \"([^\"]*)\" info$")
    public void iFillOutFieldWithInfo(String fieldName, String text) throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/..//input[@id]")).sendKeys(text);
    }

    @When("^I fill out \"([^\"]*)\" field with \"([^\"]*)\" data$")
    public void iFillOutFieldWithData(String fieldName, String text) throws Throwable {
        getDriver().findElement(By.xpath("//label[contains(text(),'" + fieldName + "')]/..//input[@name='organization']")).sendKeys(text);
    }

    @When("^Select the option \"([^\"]*)\"$")
    public void selectTheOption(String day) throws Throwable {


        List<WebElement> options = getDriver().findElements(By.xpath("//fieldset//p//strong"));
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        double cheapestPrice = Double.MAX_VALUE;
        for (WebElement option : options) {
            if (option.isDisplayed()) {
                double currentPrice = formatter.parse(option.getText()).doubleValue();
                if (currentPrice < cheapestPrice) {
                    cheapestPrice = currentPrice;


//                    new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"))).perform();


                    WebElement cheapestPriceElement = getDriver().findElement(By.xpath("//strong[contains(text(),'" + formatter.format(cheapestPrice) + "')]"));

//                    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
                    getExecutor().executeScript("arguments[0].click();", cheapestPriceElement);


                }
            }
        }

    }

    @When("^I Choose Saturday delivery$")
    public void iChooseSaturdayDelivery() throws Throwable {

        WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'Saturday Delivery')]/../../..//*[@class='ups-lever_switch_bg']"));
        getExecutor().executeScript("arguments[0].click();", element);

    }

    @Then("^I verify I am on \"([^\"]*)\" page$")
    public void iVerifyIAmOnPage(String page) throws Throwable {

        String actualPage = getDriver().findElement(By.xpath("//*[contains(text(),'" + page + "')]")).getText();
        assertThat(actualPage).containsIgnoringCase(page);
    }

    @And("^I choose \"([^\"]*)\" payment option$")
    public void iChoosePaymentOption(String pay) throws Throwable {
        getDriver().findElement(By.xpath("//*[@id='other-ways-to-pay-tile']/..//*[contains(text(),'" + pay + "')]")).click();


    }

    @Then("^I verify PayPal appears$")
    public void iVerifyPayPalAppears() throws Throwable {
        Thread.sleep(300);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ups-radio-custom-label']")));

        WebElement paypal = getDriver().findElement(By.xpath("//label[@class='ups-radio-custom-label']"));
        getExecutor().executeScript("arguments[0].click();", paypal);

    }

    @And("^I submit shipment form and verify new page opened$")
    public void iSubmitShipmentFormAndVerifyNewPageOpened() throws Throwable {
        String currentUrl = getDriver().getCurrentUrl();
        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']")).click();
//        getDriver().findElement(By.xpath("//div[@class='page-title_cell']//h1//span[contains(text(),'Shipping')]")).isDisplayed();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));


    }

    @Then("^I verify that ship to section contains \"([^\"]*)\"$")
    public void iVerifyThatShipToSectionContains(String data) throws Throwable {

        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='destinationDrawer']/..//div")));
        String actualData = getDriver().findElement(By.xpath("//*[@id='destinationDrawer']/..//div")).getText();
        assertThat(actualData).containsIgnoringCase(data);
    }

    @Then("^I verify that shipment is cancelled$")
    public void iVerifyThatShipmentIsCancelled() throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(),'Hello. Where are you shipping from?')]")).isDisplayed();
    }


}

