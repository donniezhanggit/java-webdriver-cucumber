package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FullTimePortnovPage;
import pages.PortnovMain;
import pages.ScheduleOfClasses;
import support.TestContext;

import java.util.Iterator;
import java.util.Set;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Portnov {
    @Given("^Given I open the page \"([^\"]*)\"$")
    public void givenIOpenThePage(String cite) throws Throwable {
        if (cite.equalsIgnoreCase("Portnov")) {
            TestContext.getDriver().get("https://www.portnov.com/");
        }
    }

    @Then("^I verify \"([^\"]*)\" adress$")
    public void iVerifyAdress(String address) throws Throwable {
      String actualAddress = getDriver().findElement(By.xpath("//*[contains(text(),'Get in touch')]/..")).getText();
        Assertions.assertThat(actualAddress).containsIgnoringCase(address);
    }

    @When("^I go to \"([^\"]*)\" tab$")
    public void iGoToTab(String tab) throws Throwable {

        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//*[@class='separator line1'][contains(text(),'"+tab+"')]"));
        actions.moveToElement(element).perform();

        new WebDriverWait(getDriver(),5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Schedule of Classes')]")));


    }

    @When("^I move to \"([^\"]*)\"$")
    public void iMoveTo(String tab) throws Throwable {
       getDriver().findElement(By.xpath("//*[contains(text(),'"+tab+"')]")).click();
    }

    @When("^I move to \"([^\"]*)\" first tab$")
    public void iMoveToFirstTab(String tab) throws Throwable {
     getDriver().findElement(By.xpath("//*[contains(text(),'08/21/18')]/..//*[contains(text(),'"+tab+"')]")).click();
    }

    @Then("^I verify \"([^\"]*)\" price$")
    public void iVerifyPrice(String price) throws Throwable {

        String firstWindow = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();

        for (String windowHandle : handles) {
            {
                if (!windowHandle.equals(firstWindow)) {
                    getDriver().switchTo().window(windowHandle);
                    String documents = getDriver().findElement(By.xpath("//*[@itemprop='articleBody']")).getText();
                    assertThat(documents).containsIgnoringCase(price);

                    getDriver().switchTo().window(firstWindow);
                }
            }
        }

//        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
//        while (iterator.hasNext()) {
//            getDriver().switchTo().window(iterator.next());
//        }

//        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
//
//
//      String actualPrice = getDriver().findElement(By.xpath("//*[@itemprop='articleBody']")).getText();
//      assertThat(actualPrice).containsIgnoringCase(price);




    }

    @Given("^Given I open the page \"([^\"]*)\" p$")
    public void givenIOpenThePageP(String cite) throws Throwable {
        PortnovMain portnov = new PortnovMain();
        portnov.open();
    }

    @Then("^I verify \"([^\"]*)\" adress p$")
    public void iVerifyAdressP(String address) throws Throwable {
        PortnovMain portnov = new PortnovMain();
        String actualAddress = portnov.returnAddressText();
        assertThat(actualAddress).containsIgnoringCase(address);
    }

    @When("^I go to \"([^\"]*)\" tab p$")
    public void iGoToTabP(String tab) throws Throwable {
        PortnovMain portnov = new PortnovMain();
        portnov.goToTheschoolTab();
    }

    @When("^I move to \"([^\"]*)\" p$")
    public void iMoveToP(String tab) throws Throwable {
        PortnovMain portnov = new PortnovMain();
        portnov.goToScheduleOfClasses();
    }

    @When("^I move to \"([^\"]*)\" first tab p$")
    public void iMoveToFirstTabP(String classTab) throws Throwable {
        ScheduleOfClasses schedule = new ScheduleOfClasses();
        schedule.clickOnFullTimeClass();
    }

    @Then("^I verify \"([^\"]*)\" price p$")
    public void iVerifyPriceP(String price) throws Throwable {
        FullTimePortnovPage fullTime = new FullTimePortnovPage();

        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
        while (iterator.hasNext()) {
            getDriver().switchTo().window(iterator.next());
        }

        String actualPrice = fullTime.returnActicleBody();
        Assertions.assertThat(actualPrice).containsIgnoringCase(price);
    }
}
