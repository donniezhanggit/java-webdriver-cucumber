package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class MyCalculator {
    @When("^go to the \"([^\"]*)\"$")
    public void goToThe(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+tab+"')]")).click();
        }

    @When("^Go to the \"([^\"]*)\" page$")
    public void goToThePage(String tab) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        getDriver().findElement(By.xpath("//*[contains(text(),'"+tab+"')]")).click();
    }

    @When("^Clear all fields$")
    public void clearAllFields() throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();


    }

    @When("^click Calculate$")
    public void clickCalculate() throws Throwable {
        getDriver().findElement(By.xpath("//input[@type='image']")).click();

        //input[@type='image']
    }


    @Then("^I verify \"([^\"]*)\" errors$")
    public void iVerifyErrors(String expectedError) throws Throwable {
        String  actualError = getDriver().findElement(By.xpath("//*[contains(text(),'"+expectedError+"')]")).getText();
        assertThat(actualError).containsIgnoringCase(expectedError);
    }



    @When("^I enter \"([^\"]*)\" price, \"([^\"]*)\" months, \"([^\"]*)\" interest, \"([^\"]*)\" downpayment, \"([^\"]*)\" trade-in, \"([^\"]*)\" state, \"([^\"]*)\" percent tax, \"([^\"]*)\" fees$")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradeIn, String state, String percentTax, String fees) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(percentTax);
        getDriver().findElement(By.xpath("//select[@name='cstate']/option[text()='"+state+"']")).click();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);


    }

    @Then("^I verify monthly pay \"([^\"]*)\" and total cost \"([^\"]*)\"$")
    public void iVerifyMonthlyPayAndTotalCost(String monthlyPay, String totalCost) throws Throwable {

        Thread.sleep(500);

        String actualMonthlyPay =getDriver().findElement(By.xpath("//*[@class='h2result']")).getText();
        System.out.print(actualMonthlyPay);
        assertThat(actualMonthlyPay).containsIgnoringCase(monthlyPay);

        String actualTotalCost = getDriver().findElement(By.xpath("//*[@align='right'][contains(text(),'$29,421.62')]")).getText();
        assertThat(actualTotalCost).containsIgnoringCase(totalCost);


    }

    @Then("^I verify monthly pay \"([^\"]*)\"$")
    public void iVerifyMonthlyPay(String expectedValue) throws Throwable {
        Thread.sleep(3000);

        String actualValue = getDriver().findElement(By.xpath("//table[@width='620']")).getText();
        assertThat(actualValue).containsIgnoringCase(expectedValue);
    }


}
