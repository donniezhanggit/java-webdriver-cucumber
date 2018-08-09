package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Macys {
    @When("^I type \"([^\"]*)\" in a search field$")
    public void iTypeInASearchField(String goods) throws Throwable {
       getDriver().findElement(By.xpath("//*[@id='globalSearchInputField']")).sendKeys(goods);
    }

    @When("^I click on the search button$")
    public void iClickOnTheSearchButton() throws Throwable {
        getDriver().findElement(By.xpath("//button[@id='searchSubmit']")).click();

    }

    @When("^I filter the search$")
    public void iFilterTheSearch() throws Throwable {
        getDriver().findElement(By.xpath("//h2[@title='Expand Gender']")).click();
        getDriver().findElement(By.xpath("//span[@class='item'][contains(text(),'Men')]")).click();
    }

    @When("^I select one availible item$")
    public void iSelectOneAvailibleItem() throws Throwable {
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//img[@id='img_612374']")).click();
    }
}
