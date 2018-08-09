package definitions.braerPark;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;
import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;
import static support.TestContext.saveScreenshot;

public class java {
    @When("^I go to \"([^\"]*)\" section$")
    public void iGoToSection(String tab) throws Throwable {

     getDriver().findElement(By.xpath("//div[@class='column column_2']//*[contains(text(),'"+tab+"')]")).click();
    }

    @Then("^I verify that \"([^\"]*)\" is present$")
    public void iVerifyThatIsPresent(String tab) throws Throwable {
        String actualHome = getDriver().findElement(By.xpath("//h1[contains(text(),'"+tab+"')]")).getText();
        assertThat(actualHome).containsIgnoringCase(tab);
    }

    @When("^I schose house (\\d+)$")
    public void iSchoseHouse(int arg0) throws Throwable {
      getDriver().findElement(By.xpath("//area[@title='Дом №8']")).click();
    }

    @When("^I go to the third floor$")
    public void iGoToTheThirdFloor() throws Throwable {
        getDriver().findElement(By.xpath("//span[contains(@class,'tab-trigger_vertical')][contains(text(),'3')]")).click();
    }

    @When("^I go to the \"([^\"]*)\" apartment$")
    public void iGoToTheApartment(String arg0) throws Throwable {

//        List<WebElement> WebElement = getDriver().findElements(By.xpath("//*[contains(text(),'18')]"));
//        for (WebElement newElement: WebElement) {
//            if(newElement.isDisplayed()){
//                newElement.click();
//            }
//        }

        getDriver().findElement(By.xpath("//area[@title='Квартира №18']")).click();
    }

    @Then("^I verify apartment price \"([^\"]*)\"$")
    public void iVerifyApartmentPrice(String price) throws Throwable {


        WebElement element = getDriver().findElement(By.xpath("//div[contains(text(),'Площадь квартиры')]"));
       new Actions(getDriver()).moveToElement(element).perform();

        new WebDriverWait(getDriver(),10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='column column_last']//div[@class='block_white']")));

//     String actualPrice = getDriver().findElement(By.xpath("//*[contains(text(),'"+price+"')]")).getText();
//     assertThat(actualPrice).containsIgnoringCase(price);
    }

    @When("^I go to \"([^\"]*)\" section tab$")
    public void iGoToSectionTab(String tab) throws Throwable {
       getDriver().findElement(By.xpath("//*[contains(text(),'"+tab+"')]")).click();
    }

    @Then("^I verify that it contains \"([^\"]*)\"$")
    public void iVerifyThatItContains(String tab) throws Throwable {
        System.out.println(getDriver().findElement(By.xpath("//div[@class='fancybox__body__wrapper']")).getText());
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='fancybox-title'][contains(text(),'"+tab+"')]")));
        String newTab = getDriver().findElement(By.xpath("//h2[@class='fancybox-title'][contains(text(),'"+tab+"')]")).getText();
        assertThat(newTab).containsIgnoringCase(tab);
    }
}