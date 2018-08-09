package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class Amazon {
    @Given("^I open the page \"([^\"]*)\" page$")
    public void iOpenThePagePage(String page) throws Throwable {
        switch	(page)	{
            case	"Amazon":getDriver().get("https://www.amazon.com/");
                break;

            default:	System.out.println("Not	supported	page!");
                break;
        }
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" field$")
    public void iTypeIntoField(String item, String searchField) throws Throwable {
       new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
        getDriver().findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(item);
    }

    @When("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        getDriver().findElement(By.xpath("//input[@value='Go']")).click();
    }

    @When("^I chose protein bar$")
    public void iChoseProteinBar() throws Throwable {
       getDriver().findElement(By.xpath("//*[contains(@title,'Variety Pack 1.76-Ounce Bar (Pack of 18)')]")).click();
    }

    @Then("^I verify that bar contains \"([^\"]*)\"$")
    public void iVerifyThatBarContains(String title) throws Throwable {
        String actualTitle = getDriver().findElement(By.xpath("//*[@id='productTitle']")).getText();
        assertThat(actualTitle).containsIgnoringCase(title);
        System.out.println(actualTitle);
    }
}
