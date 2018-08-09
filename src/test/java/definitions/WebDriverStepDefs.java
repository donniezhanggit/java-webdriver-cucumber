package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import javax.swing.*;
import java.security.Key;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class WebDriverStepDefs {
    private org.openqa.selenium.WebElement WebElement;

    @Given("^I go to \"([^\"]*)\" page and print details$")
    public void iGoToPageAndPrintDetails(String page) throws Throwable {

        if (page.equalsIgnoreCase("Google")) {

            TestContext.getDriver().get("https://www.google.com/");
        } else if (page.equalsIgnoreCase("Sample")) {
            TestContext.getDriver().get("http://skryabin.com/webdriver/html/sample.html");
        }

        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getWindowHandle());


//        getDriver().navigate().to("https://www.google.com/");
//        getDriver().navigate().forward();
//        getDriver().navigate().back();
//        getDriver().navigate().refresh();


//        TestContext.getDriver().quit();
//        TestContext.setDriver("safari");
    }

    @And("^I go back and forward, then refresh the page$")
    public void iGoBackAndForwardThenRefreshThePage() throws Throwable {

        getDriver().navigate().forward();
        getDriver().navigate().back();
        getDriver().navigate().refresh();


    }

    @And("^I print logs to the console$")
    public void iPrintLogsToTheConsole() throws Throwable {


        LogEntries logEntries = getDriver().manage().logs().get("browser");


        for (LogEntry element : logEntries) {
            System.out.println(element);
        }

    }

    @Given("^I open \"([^\"]*)\" then \"([^\"]*)\" then \"([^\"]*)\"$")
    public void iOpenThenThen(String url1, String url2, String url3) throws Throwable {

        String[] urls = {url1, url2, url3};

        for (String item : urls) {


            System.out.println(item);
            System.out.println();

            getDriver().get(item);
            Thread.sleep(500);
        }

        for (int j = 0; j < urls.length; j++) {

            System.out.println(urls[j]);
            System.out.println();

            getDriver().get(urls[j]);
            Thread.sleep(500);
        }


    }

    @And("^I change resolution to \"([^\"]*)\"$")
    public void iChangeResolutionTo(String arg0) throws Throwable {


        if (arg0.equalsIgnoreCase("phohe")) {
            getDriver().manage().window().setSize(new Dimension(400, 768));

        } else if (arg0.equalsIgnoreCase("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));

        }
        Thread.sleep(1000);


    }

    @When("^I fill out first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
    public void iFillOutFirstNameAndLastName(String firstName, String lastName) throws Throwable {

        getDriver().findElement(By.xpath("//*[@id='name']")).click();
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();


    }

    @And("^I fill out required fields$")
    public void iFillOutRequiredFields() throws Throwable {


        getDriver().findElement(By.xpath("//*[@name='username']")).sendKeys("Username1");
        getDriver().findElement(By.xpath("//*[@name='email']")).sendKeys("andreytravkin5@gmail.com");
        getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("Password0$");
        getDriver().findElement(By.xpath("//*[@id='confirmPassword']")).sendKeys("Password0$");
        getDriver().findElement(By.xpath("//*[@type='checkbox'][@name='agreedToPrivacyPolicy']")).click();


    }


    @And("^I submit the page$")
    public void iSubmitThePage() throws Throwable {
        Thread.sleep(3000);

        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        Thread.sleep(3000);

    }

    @And("^I fill out all non required fields$")
    public void iFillOutAllNonRequiredFields() throws Throwable {


        getDriver().findElement(By.xpath("//*[@name='phone']")).sendKeys("5106762515");
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys("25928 Westview Way");
        getDriver().findElement(By.xpath("//*[@name='countryOfOrigin']")).click();
        getDriver().findElement(By.xpath("//option[@value='USA']")).click();
        getDriver().findElement(By.xpath("//*[@name='gender'][@value='male']")).click();
        getDriver().findElement(By.xpath("//*[@type='checkbox'][@name='allowedToContact']")).click();

        getDriver().findElement(By.xpath("//*[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//*[@data-handler='selectYear']")).click();
        getDriver().findElement(By.xpath("//*//*[@value='1984']")).click();
        getDriver().findElement(By.xpath("//*[@data-handler='selectMonth']")).click();
        getDriver().findElement(By.xpath("//*[@value='7']")).click();
        getDriver().findElement(By.xpath("//*[@class='ui-state-default'][contains(text(),'31')]")).click();
        getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();


    }

    @When("^I verify email field behavior$")
    public void iVerifyEmailFieldBehavior() throws Throwable {


        WebElement email = getDriver().findElement(By.xpath("//input[@name='email']"));

        email.clear();
        email.sendKeys("wrong_format");
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();

        Assertions.assertThat(getDriver().findElement(By.xpath("//label[@id='email-error']")).getText()).contains("Please enter a valid email address");

        String emailError = getDriver().findElement(By.xpath("//label[@id='email-error']")).getText();

        assertThat(emailError).contains("Please enter a valid email address");

        email.sendKeys(Keys.BACK_SPACE);
        email.clear();
        email.sendKeys("andreytravkin5@gmail.com");


        boolean errorDisplayed = getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed();

        assertThat(errorDisplayed).isFalse();
    }


    @Then("^I verify that fields values recorded correctly$")
    public void iVerifyThatFieldsValuesRecordedCorrectly() throws Throwable {

        assertThat(getDriver().findElement(By.xpath("//*[@name='phone'][contains(text(), '5106762515' )]")).isDisplayed());

        boolean privacyPocicy = getDriver().findElement(By.xpath("//*[contains(text(),'Agreed To Privacy Policy')]")).isDisplayed();
        assertThat(privacyPocicy).isTrue();


        getDriver().findElement(By.xpath("//*[@name='password'][contains(text(), '[entered]')]")).isDisplayed();


        String passwordText = getDriver().findElement(By.xpath("//*[@name='password'][contains(text(), '[entered]')]")).getText();
        assertThat(passwordText).doesNotContain("passowrd");
        assertThat(passwordText).contains("entered");

        String resultText = getDriver().findElement(By.xpath("//div[@id='samplePageResult']//section")).getText();
        assertThat(resultText).contains("Username1");
        assertThat(resultText).contains("andreytravkin5@gmail.com");
        assertThat(resultText).doesNotContain("Password0$");


        boolean resultDisplayed = getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).isDisplayed();
        assertThat(resultDisplayed).isTrue();


    }

    @Then("^I verify that first name is \"([^\"]*)\" and last name is \"([^\"]*)\"$")
    public void iVerifyThatFirstNameIsAndLastNameIs(String fname, String lname) throws Throwable {

        String[] names = {fname, lname};

        for (String name : names) {
            assertThat(getDriver().findElement(By.xpath("//b[@name = 'name']")).getText()).contains(name);
        }
    }


    @When("^I open the page \"([^\"]*)\"$")
    public void iOpenThePage(String cite) throws Throwable {

        if (cite.equalsIgnoreCase("USPS")) {
            TestContext.getDriver().get("https://www.definitions.Portnov.usps.com/");

        } else if (cite.equalsIgnoreCase("Sample")) {
            TestContext.getDriver().get("http://skryabin.com/webdriver/html/sample.html");
        } else if (cite.equalsIgnoreCase("Cinemark")) {
            TestContext.getDriver().get("https://www.cinemark.com/");
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='Headline']")));
            getDriver().findElement(By.xpath("//div[contains(@class,'navbarRow2')]//a[contains(@href,'movies')]")).click();
        } else if (cite.equalsIgnoreCase("Yelp")) {
            TestContext.getDriver().get("https://www.yelp.com/");
        } else if (cite.equalsIgnoreCase("Braer Park")) {
                TestContext.getDriver().get("http://braerpark.ru");
        } else if (cite.equalsIgnoreCase("Converter")) {
            try {
                TestContext.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
                TestContext.getDriver().get("https://www.unitconverters.net/");
            } catch (TimeoutException exception) {

            } finally {
                TestContext.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            }
        } else if (cite.equalsIgnoreCase("Calculator")) {
            TestContext.getDriver().get("http://www.calculator.net");
        } else if (cite.equalsIgnoreCase("ups")) {
            TestContext.getDriver().get("https://www.ups.com/us/en/Home.page");
        } else if (cite.equalsIgnoreCase("Macys")) {
                TestContext.getDriver().get("https://www.macys.com/");
            } else if (cite.equalsIgnoreCase("Bevager")) {
            TestContext.getDriver().get("https://bevager.com/");
        } else {
            System.out.print("Wrong Address, Please try another one!");
        }
    }


    @When("^I go to the page by adress$")
    public void iGoToThePageByAdress() throws Throwable {


        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[@aria-expanded='false'][contains(text(),'Quick Tools')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//html//li[7]/a[1]/p[1]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("(//a[text() = 'Find by Address'])[1]")).click();
        Thread.sleep(1000);


    }

//    @When("^I put the data$")
//    public void iPutTheData() throws Throwable {
//
////        getDriver().findElement(By.xpath("//*[@id='tAddress']")).sendKeys("25928 Westview Way");
////        getDriver().findElement(By.xpath("//*[@id='tCity']")).sendKeys("Hayward");
////        getDriver().findElement(By.xpath("//*[@id='tZip-byaddress']")).sendKeys("94542");
//
//
//
//
//    }

    @When("^I search for result$")
    public void iSearchForResult() throws Throwable {

        getDriver().findElement(By.xpath("//*[@id='zip-by-address']")).click();

    }

    @Then("^I verify the data$")
    public void iVerifyTheData() throws Throwable {

        Thread.sleep(1000);
        boolean streetAdress = getDriver().findElement(By.xpath("//*[@id='street-address']")).isDisplayed();
        System.out.println(streetAdress);
        assertThat(streetAdress).isTrue();

//     String result = getDriver().findElement(By.xpath("")).getText();
//     assertThat(result).contains("");

    }

    @When("^I put the data \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPutTheDataAnd(String adress, String city) throws Throwable {

        getDriver().findElement(By.xpath("//*[@id='tAddress']")).sendKeys(adress);
        getDriver().findElement(By.xpath("//*[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//*[@id='tState']//option[@value='CA']")).click();

    }


    @Then("^I verify the data by \"([^\"]*)\"$")
    public void iVerifyTheDataBy(String zipCode) throws Throwable {

        Thread.sleep(1000);
        // getDriver().findElement(By.xpath("//strong[contains(text(),'94542-1942')]")).getText().contains(zipCode);

        assertThat(getDriver().findElement(By.xpath("//strong[contains(text(),'94542-1942')]")).getText()).contains(zipCode);


    }

    @When("^I go	to Calculate Price Page$")
    public void iGoToCalculatePricePage() throws Throwable {


        getDriver().findElement(By.xpath("//a[@aria-expanded='false'][contains(text(),'Quick Tools')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[@alt='Calculate a Price Icon']")).click();
        Thread.sleep(1000);


    }

    @And("^I select \"([^\"]*)\" with \"([^\"]*)\" shape$")
    public void iSelectWithShape(String country, String option) throws Throwable {

        getDriver().findElement(By.xpath("//*[@id='CountryID']")).click();
        getDriver().findElement(By.xpath("//option[@value='10143']")).click();
        getDriver().findElement(By.xpath("//*[@id='option_1']")).click();


    }

    @When("^I define (\\d+) quantity$")
    public void iDefineQuantity(int num) throws Throwable {


        WebElement quantity = getDriver().findElement(By.xpath("//*[@id='quantity-0']"));
        quantity.click();
        quantity.sendKeys(Keys.NUMPAD2);
        Thread.sleep(5000);


    }


    @When("^I submit a new page using \"([^\"]*)\"$")
    public void iSubmitANewPageUsing(String xpath) throws Throwable {

        getDriver().findElement(By.xpath(xpath)).click();
    }


    @Then("^I verify the price$")
    public void iVerifyThePrice() throws Throwable {

        getDriver().findElement(By.xpath("//div[@id='total'][contains(text(),'$2.30')]")).isDisplayed();


    }


    @When("^I go to the movies$")
    public void iGoToTheMovies() throws Throwable {

        Thread.sleep(3000);

        if (getDriver().findElement(By.xpath("//span[@class='walkme-action-destroy-1 wm-close-link']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//span[@class='walkme-action-destroy-1 wm-close-link']")).click();
            Thread.sleep(3000);
            getDriver().findElement(By.xpath("//div[@class='navbarRow2 hidden-xs']//*[@class='nav-movies']")).click();
            Thread.sleep(3000);
        } else {
            getDriver().findElement(By.xpath("//div[@class='navbarRow2 hidden-xs']//*[@class='nav-movies']")).click();
        }


        getDriver().findElement(By.xpath("//a[@href='/deadpool-2'][contains(text(),'Deadpool 2')]")).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//html//div[1]/div[2]/div[2]/div[1]/div[3]")).click();

    }

    @When("^I select tickets$")
    public void iSelectTickets() throws Throwable {

        getDriver().findElement(By.xpath("//html//div[1]/div[1]/select[1]/option[@value='1']")).click();
        getDriver().findElement(By.xpath("//html//div[2]/div[1]/select[1]/option[@value='2']")).click();

        Thread.sleep(3000);

    }


    @Then("^I verify the prices \"([^\"]*)\"$")
    public void iVerifyThePrices(String price) throws Throwable {

        getDriver().findElement(By.xpath("//span[@id='SummaryTotal'][contains(text()), '34.00]")).isDisplayed();

    }


    @When("^I go to postal store$")
    public void iGoToPostalStore() throws Throwable {

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@aria-expanded='false'][contains(text(),'Postal Store')]")).click();

    }

    @Then("^I fill out the form with \"([^\"]*)\"$")
    public void iFillOutTheFormWith(String zipCode) throws Throwable {


        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(zipCode);
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();
    }

    @Then("^I Verify that search does not match any products$")
    public void iVerifyThatSearchDoesNotMatchAnyProducts() throws Throwable {

        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//*[text()=' - did not match any products.']")).isDisplayed();

    }

    @When("^I click on element with xpath \"([^\"]*)\"Temperature\"([^\"]*)\"$")
    public void iClickOnElementWithXpathTemperature(String xPath, String arg1) throws Throwable {

        getDriver().findElement(By.xpath(xPath)).click();
    }


    @When("^I select Fereneight \"([^\"]*)\" to Celcios \"([^\"]*)\"$")
    public void iSelectFereneightToCelcios(String fereneight, String celcios) throws Throwable {

        getDriver().findElement(By.xpath(fereneight)).click();
        getDriver().findElement(By.xpath(celcios)).click();

    }


    @Then("^I verify the Fereneight \"([^\"]*)\" is match Celcios \"([^\"]*)\"$")
    public void iVerifyTheFereneightIsMatchCelcios(String fereneight, String celcios) throws Throwable {


        getDriver().findElement(By.xpath("//*[@name='fromVal']")).sendKeys(fereneight);

        String result = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        System.out.println(result);
        assertThat(result).contains(celcios);


    }

    @When("^I go to Stamps$")
    public void iGoToStamps() throws Throwable {
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//a[@aria-expanded='false'][contains(text(),'Quick Tools')]"));
        actions.moveToElement(element).perform();

        getDriver().findElement(By.xpath("//p[contains(text(),'Buy Stamps')]")).click();

    }

    @When("^I select Mail Priority Mail$")
    public void iSelectMailPriorityMail() throws Throwable {

        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Mail Service-Priority Mail-1']")).click();


    }

    @Then("^Verify (\\d+) item on the page$")
    public void verifyItemOnThePage(int arg0) throws Throwable {


        getDriver().findElement(By.xpath("//img[@src='https://www.definitions.Portnov.usps.com/ecp/asset/images/114104-T0.jpg']")).isDisplayed();
        Thread.sleep(5000);

    }

    @When("^Go to \"([^\"]*)\"$")
    public void goTo(String tab) throws Throwable {

        Thread.sleep(5000);
        Actions actions = new Actions(getDriver());
        WebElement elementNew = getDriver().findElement(By.xpath("//a[@id='mail-ship-width'][contains(text(),  " + tab + " "));
        actions.moveToElement(elementNew).perform();
        Thread.sleep(5000);

        getDriver().findElement(By.xpath("//a[@role='menuitem'][contains(text(),'Stamps & Supplies')]")).click();


    }

    @When("^Go to \"([^\"]*)\" after$")
    public void goToAfter(String arg0) throws Throwable {

        getDriver().findElement(By.xpath("//img[@id='icon-stamp']")).click();


    }

    @When("^I Unselect \"([^\"]*)\" checkbox$")
    public void iUnselectCheckbox(String stamps) throws Throwable {

        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Category-Stamps'][contains(text()," + stamps + ")]")).click();

    }

    @When("^Select Size \"([^\"]*)\"$")
    public void selectSize(String arg0) throws Throwable {

        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Size-18 Months-2']")).click();

    }

    @When("^I click pink color$")
    public void iClickPinkColor() throws Throwable {

        Thread.sleep(5000);

        getDriver().findElement(By.xpath("//html//div[@class='result-checkbox-filter-by-holder']//div[3]")).click();

    }

    @Then("^I verify \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyAnd(String expectedColor, String expectedMonth) throws Throwable {

        String actualColor = getDriver().findElement(By.xpath("//div[@class = 'results-product-desc']")).getText();
        assertThat(actualColor).containsIgnoringCase(expectedColor);
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(), '" + expectedColor + "')][contains(@onclick, '18-months')]")).isDisplayed());


    }

    @When("^I looking for my location \"([^\"]*)\"$")
    public void iLookingForMyLocation(String zipCode) throws Throwable {

        Thread.sleep(5000);


        getDriver().findElement(By.xpath("//span[@class='walkme-action-destroy-1 wm-close-link']")).click();


        getDriver().findElement(By.xpath("//*[@class='navbarRow2 hidden-xs']//*[contains(text(),'Theatres')]")).click();


        getDriver().findElement(By.xpath("//form[@class='navbar-form topNavSearch']//input[@type='text']")).sendKeys(zipCode);
        getDriver().findElement(By.xpath("//form[@class='navbar-form topNavSearch']//button[@type='submit']")).click();


    }

    @When("^I click on \"([^\"]*)\"$")
    public void iClickOn(String tab) throws Throwable {

        getDriver().findElement(By.xpath("//div[@id='menu']//*[contains(text(),'" + tab + "')]")).click();

    }

    @When("^I select \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iSelectTo(String from, String to) throws Throwable {


        getDriver().findElement(By.xpath("//*[@id='calFrom']//*[contains(text(),'" + from + "')]")).click();
        getDriver().findElement(By.xpath("//*[@id='calTo']//*[contains(text(),'" + to + "')]")).click();

    }


    @When("^I go to \"([^\"]*)\"$")
    public void iGoTo(String search) throws Throwable {

        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//a[contains(text(),'" + search + " USPS.com')]"));
        ((Actions) actions).moveToElement(element).perform();

    }


    @And("^I click \"([^\"]*)\"$")
    public void iClick(String tabs) throws Throwable {


        String newTabs = tabs.toUpperCase();


        getDriver().findElement(By.xpath("//div[@class='repos']//*[contains(text(),'" + newTabs + "')]")).click();


    }

    @When("^I go to the \"([^\"]*)\"$")
    public void iGoToThe(String hours) throws Throwable {

        getDriver().findElement(By.xpath("//*[contains(text(),'" + hours + "')]")).click();

    }

    @When("^I select passports$")
    public void iSelectPassports() throws Throwable {

        Thread.sleep(5000);

        getDriver().findElement(By.xpath("//span[contains(text(),'Post Offices™ and Approved Postal Providers™')]")).click();
//     getDriver().findElement(By.xpath("//*[text()='Passports'][@xpath='4']")).click();
        getDriver().findElement(By.xpath("//div[@id='locationTypeWrapper']//ul//li//a[@rel='passport']")).click();

    }

    @When("^I file zip code with \"([^\"]*)\" within \"([^\"]*)\" miles$")
    public void iFileZipCodeWithWithinMiles(String zipCode, String miles) throws Throwable {


        getDriver().findElement(By.xpath("//input[@id='tCityStateZip']")).sendKeys(zipCode);
        getDriver().findElement(By.xpath("//span[@class='select-current-text'][contains(text(),'20 miles')]")).click();
        getDriver().findElement(By.xpath("//*[@id='sWithin-wrap']//li//*[text()='"+miles+" miles']")).click();

    }

    @When("^I click search$")
    public void iClickSearch() throws Throwable {
       getDriver().findElement(By.xpath("//input[@id='bSearch']")).click();
       Thread.sleep(1000);
    }

    @Then("^I verify address contains \"([^\"]*)\"$")
    public void iVerifyAddressContains(String expectedCity) throws Throwable {

        Thread.sleep(1000);
        String actualCity = getDriver().findElement(By.xpath("//tbody[@class='resultRows']")).getText();
        assertThat(actualCity).contains(expectedCity);
    }



    @Then("^I veryfy walk in hours contains \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVeryfyWalkInHoursContainsAnd(String city, String hours2) throws Throwable {

     String actualCity = getDriver().findElement(By.xpath("//span[@id='city']")).getText();
     assertThat(actualCity).contains(city);

    }

    @When("^I click on search result \"([^\"]*)\"$")
    public void iClickOnSearchResult(String expectedResult) throws Throwable {

        getDriver().findElement(By.xpath("//span[text()='"+expectedResult+"'][not(@id='city')]")).click();

    }

    @Then("^I veryfy adress \"([^\"]*)\" and \"([^\"]*)\" walk-in hours and \"([^\"]*)\" photo hours$")
    public void iVeryfyAdressAndWalkInHoursAndPhotoHours(String expectedAddress, String walkInHors, String photoHours) throws Throwable {

        String actualAddress = getDriver().findElement(By.xpath("//span[@id='addressDisp']")).getText();
        Assertions.assertThat(actualAddress).contains(expectedAddress);

        String actualWalkInHours = getDriver().findElement(By.xpath("//div[@id='passportWlkHours']")).getText();
        Assertions.assertThat(actualWalkInHours).contains(walkInHors);

        String actualPhotoHours = getDriver().findElement(By.xpath("//div[@id='passportPhotoHours']")).getText();
        Assertions.assertThat(actualPhotoHours).contains(photoHours);






    }

    @When("^I click back to list$")
    public void iClickBackToList() throws Throwable {
       getDriver().findElement(By.xpath("//a[@id='back-to-list']")).click();
    }

    @Then("^verify you'are on correct page$")
    public void verifyYouAreOnCorrectPage() throws Throwable {

        WebElement ZipSearch = getDriver().findElement(By.xpath("//input[@id='tCityStateZip']"));
        assertThat(ZipSearch.isDisplayed()).isTrue();

        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle).contains("Find Locations");

    }


}



