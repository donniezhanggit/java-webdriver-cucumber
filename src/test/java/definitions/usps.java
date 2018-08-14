package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import support.TestContext;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class usps {
    @Given("^I go to usps page object$")
    public void iGoToUspsPageObject() throws Throwable {
        new UspsHeader().open();
    }

    @When("^I go to Lookup ZIP page object by address$")
    public void iGoToLookupZIPPageObjectByAddress() throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.mouseOvermailAndShip();
        usps.goToLookupByZip();
    }


    @And("^I fill out \"([^\"]*)\" street, \"([^\"]*)\" city, \"([^\"]*)\" state page object$")
    public void iFillOutStreetCityStatePageObject(String street, String city, String state) throws Throwable {
        ByAddressForm form = new ByAddressForm();
        form.clickOnByAddressButton();

        LookUpaZIPCode zipCodePage = new LookUpaZIPCode();
        zipCodePage.fillOutCity(city);
        zipCodePage.fillStreetAddress(street);
        zipCodePage.selectState(state);
        zipCodePage.clickFindButton();


    }

    @Then("^I validate \"([^\"]*)\" zip code exists in the result page object$")
    public void iValidateZipCodeExistsInTheResultPageObject(String zipCode) throws Throwable {

        ByAddressResult result = new ByAddressResult();
        String newResult = result.getSearchResultText();
        assertThat(newResult).containsIgnoringCase(zipCode);

    }

    @When("^I go to Calculate Price page object$")
    public void iGoToCalculatePricePageObject() throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.mouseOvermailAndShip();
        usps.goToCalculateAPrice();
    }

    @And("^I select \"([^\"]*)\" with \"([^\"]*)\" shape and I define \"([^\"]*)\" quantity page object$")
    public void iSelectWithShapeAndIDefineQuantityPageObject(String country, String postcard, String quantity) throws Throwable {
      PostagePriceCalculator priceCalculator = new PostagePriceCalculator();
      priceCalculator.selectCountryId(getData(country));
      priceCalculator.clickOnPostcard();

      PostcardUsps postcardUsps = new PostcardUsps();
      postcardUsps.sendKeysToQuantity(quantity);
      postcardUsps.clickOnCalculateButton();
      Thread.sleep(1000);

    }

    @Then("^I calculate the price and validate cost is \"([^\"]*)\" page object$")
    public void iCalculateThePriceAndValidateCostIsPageObject(String totalPrice) throws Throwable {
        PostcardUsps postcardUsps = new PostcardUsps();
        String actualTotalPrice = postcardUsps.getTotal();
        assertThat(actualTotalPrice).containsIgnoringCase(totalPrice);
    }

    @When("^I go to Postal Store tab$")
    public void iGoToPostalStoreTab() throws Throwable {
        UspsHeader usps = new UspsHeader();
        usps.goToPostalStoreTab();
    }

    @And("^I enter \"([^\"]*)\" into store search page object$")
    public void iEnterIntoStoreSearchPageObject(String searchFieldText) throws Throwable {
        PostalStoreTab postalStore = new PostalStoreTab();
        postalStore.SendkeysToStoreSearch(searchFieldText);
        postalStore.clickOnSearchButton();
    }

    @Then("^I search and validate no products found page object$")
    public void iSearchAndValidateNoProductsFoundPageObject() throws Throwable {
    PostalStoreValidate postalValidate = new PostalStoreValidate();
    String text = postalValidate.returnNoProductText();
    assertThat(text).containsIgnoringCase(" did not match any products");

    }

    @When("^I chose food \"([^\"]*)\" in a food field p$")
    public void iChoseFoodInAFoodFieldP(String foodName) throws Throwable {
    Yelp yelp = new Yelp();
    yelp.sendKeysToSearchField(foodName);
    }
}

