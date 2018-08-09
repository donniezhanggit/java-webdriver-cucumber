package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class MyYelp {

    @When("^I enter my location \"([^\"]*)\"$")
    public void iEnterMyLocation(String zipCode) throws Throwable {

        getDriver().findElement(By.xpath("//*[@id='dropperText_Mast']")).clear();
        getDriver().findElement(By.xpath("//*[@id='dropperText_Mast']")).sendKeys(zipCode);
    }

    @When("^I chose food \"([^\"]*)\" in a food field$")
    public void iChoseFoodInAFoodField(String food) throws Throwable {
        
        getDriver().findElement(By.xpath("//input[@id='find_desc']")).sendKeys(food);
        
    }

    @When("^I click search button$")
    public void iClickSearchButton() throws Throwable {

        getDriver().findElement(By.xpath("//button[@id='header-search-submit']")).click();

    }

    @When("^I chose first restaurant on the page$")
    public void iChoseFirstRestaurantOnThePage() throws Throwable {

        getDriver().findElement(By.xpath("//*[contains(text(),'(510) 582-8643')]/../..//*[contains(text(),'Chipotle Mexican Grill')]")).click();
    }

    @When("^I chose my favorite filters$")
    public void iChoseMyFavoriteFilters() throws Throwable {

        getDriver().findElement(By.xpath("//li[@class='suggested-filters_filter']//label[@class='feature open-now radio-check']")).click();
        getDriver().findElement(By.xpath("//span[@class='filter-label filters-toggle js-all-filters-toggle show-tooltip']")).click();
        getDriver().findElement(By.xpath("//*[@class='filter-bar suggested-filters']//li[1]/label[1]/span[1]")).click();

Thread.sleep(5000);

    }

    @Then("^I verify that header \"([^\"]*)\" is present$")
    public void iVerifyThatHeaderIsPresent(String expectedName) throws Throwable {

        String actualName = getDriver().findElement(By.xpath("//h1[contains(text(),'Chipotle')]")).getText();
        assertThat(actualName).contains(expectedName);


    }
}
