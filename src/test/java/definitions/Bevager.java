package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;
import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;
import static support.TestContext.saveScreenshot;

public class Bevager {
    @When("^I fill out log in \"([^\"]*)\" and password \"([^\"]*)\" fields$")
    public void iFillOutLogInAndPasswordFields(String login, String password) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='ember324']")).sendKeys(login);
        getDriver().findElement(By.xpath("//input[@id='ember328']")).sendKeys(password);

    }

    @When("^I click log in bar$")
    public void iClickLogInBar() throws Throwable {
        getDriver().findElement(By.xpath("//a[contains(text(),'Login')]")).click();
    }

    @Then("^I verify that Im on the main page$")
    public void iVerifyThatImOnTheMainPage() throws Throwable {

      String currentUrl = getDriver().getCurrentUrl();
      assertThat(currentUrl).containsIgnoringCase("https://bevager.com/buyer/1/200");

    }

    @When("^I click \"([^\"]*)\" button and log in$")
    public void iClickButtonAndLogIn(String signIn) throws Throwable {
       getDriver().findElement(By.xpath("//*[@type='submit']")).click();
    }

    @When("^I click on recipes(\\d+)$")
    public void iClickOnRecipes(int arg0) throws Throwable {
       getDriver().findElement(By.xpath("//*[@class='svg-icon recipe']")).click();
    }

    @When("^I click on recipes two$")
    public void iClickOnRecipesTwo() throws Throwable {
//        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ember-view'][@id='ember1870']")));
    getDriver().findElement(By.xpath("//a[@id='ember845']")).click();

    }

    @When("^I click on \"([^\"]*)\" button$")
    public void iClickOnButton(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//a[@class='btn btn-primary']")).click();
Thread.sleep(500);
    }

    @When("^I chose menu list type$")
    public void iChoseMenuListType() throws Throwable {
        getDriver().findElement(By.xpath("//select[@class='form-control']")).click();
        getDriver().findElement(By.xpath("//option[@value='2']")).click();
    }

    @When("^I name my recipe as \"([^\"]*)\"$")
    public void iNameMyRecipeAs(String arg0) throws Throwable {
       String arg = arg0 + new Random().nextInt(1000000);

        getDriver().findElement(By.xpath("//*[@type='text'][@class='form-control  ember-text-field ember-view']")).sendKeys(arg);
    }

    @When("^I click on create new recipe$")
    public void iClickOnCreateNewRecipe() throws Throwable {
        getDriver().findElement(By.xpath("//button[@type='button']//span[@class='fa fa-plus']")).click();
        Thread.sleep(5000);
    }
}

