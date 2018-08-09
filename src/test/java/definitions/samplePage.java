package definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SampleForm;
import pages.SampleVerify;

import java.util.*;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class samplePage {
    @When("^I fill out the form$")
    public void iFillOutTheForm() throws Throwable {

        getDriver().manage().window().maximize();

        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Username");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();

        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Andrei");
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys("Aleksandrovich");
        getDriver().findElement(By.xpath(" //input[@id='lastName']")).sendKeys("Travkin");

        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();

        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("andreytravkin5@gmail.com");

        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("Ololo8008");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("Ololo8008");

        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("88005553535");

        getDriver().findElement(By.xpath("//span[contains(text(),'Male')]")).click();

        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("25928 Westview Way");

        WebElement toyota = getDriver().findElement(By.xpath("//option[@value='Toyota']"));
        WebElement bmv = getDriver().findElement(By.xpath("//option[@value='BMW']"));
        new Actions(getDriver()).keyDown(Keys.COMMAND).click(toyota).click(bmv).keyUp(Keys.COMMAND).perform();


        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();

        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys("08/31/1992");

        getDriver().findElement(By.xpath("//button[contains(text(),'Related documents (click)')]")).click();

        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();

        getDriver().findElement(By.xpath("/input[@id='attachment']")).sendKeys(System.getProperty("user.dir")+"/scr/test/resources/downloads/Text.txt");

        WebElement iframe = getDriver().findElement(By.xpath("//iframe[@name='additionalInfo']"));
        new Actions(getDriver()).moveToElement(iframe).perform();
        getDriver().switchTo().frame(iframe);
        getDriver().findElement(By.xpath("//*[@id='contactPersonName']")).sendKeys("John");
        getDriver().findElement(By.xpath("//*[@id='contactPersonPhone']")).sendKeys("3477943437");
        getDriver().switchTo().defaultContent();




// IMPORTANT!! READ THIS AGAIN LATER!

        String firstWindow = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();

        for (String windowHandle : handles) {
            {
                if (!windowHandle.equals(firstWindow)) {
                    getDriver().switchTo().window(windowHandle); // switch window here

                    String documents = getDriver().findElement(By.xpath("//h4[contains(text(),'Documents List:')]")).getText();
                    assertThat(documents).containsIgnoringCase("Documents List");

                    getDriver().switchTo().window(firstWindow);
                }
            }
        }

        //---------------

//
//        for (String h : getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(h);
//        }
//
//        //.......
//
//        getDriver().switchTo().window(firstWindow);
//
//        //---------------
//
//        String[] windows = (String[]) getDriver().getWindowHandles().toArray();
//
//        getDriver().switchTo().window(windows[1]);
//
//        //.......
//
//        getDriver().switchTo().window(windows[0]);  // doesn't work

        //---------------

//        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
//        while (iterator.hasNext()) {
//            getDriver().switchTo().window(iterator.next());
//        }
//
//        //.....
//
//        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next()); // doesn't work
//

    }

    @When("^I submit the sample page$")
    public void iSubmitTheSamplePage() throws Throwable {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("^I verify filled out fields$")
    public void iVerifyFilledOutFields() throws Throwable {
        WebElement container = getDriver().findElement(By.xpath("//legend[@class='applicationResult']/../section"));
        assertThat(container.getText()).contains("Username");
        assertThat(container.getText()).contains("andreytravkin5@gmail.com");
        assertThat(container.getText()).contains("Andrei");
        assertThat(container.getText()).contains("88005553535");
        assertThat(container.getText()).contains("08/31/1992");
        assertThat(container.getText()).contains("male");
        assertThat(container.getText()).contains("25928 Westview Way");
        assertThat(container.getText()).contains("Toyota, BMW");

        String passwordText = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(passwordText).isEqualTo("[entered]");

        String allowedToContact = getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText();
        assertThat(allowedToContact).isEqualTo("true");

        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).isEqualTo("true");
    }



    @Given("^I open sample page$")
    public void iOpenSamplePage() throws Throwable {
        new SampleForm().open();
    }

    @When("^I fill out all page object fields$")
    public void iFillOutAllPageObjectFields() throws Throwable {
        SampleForm form = new SampleForm();
        form.fillUsername(getData("username"));
        form.fillEmail(getData("email"));
        form.fillPassword(getData("password"));
        form.fillConfirmPassword(getData("confirmPassword"));
        form.fillName(getData("firstName"), "", getData("lastName"));
        form.clickPrivacyPolicy();
        form.selectCountryOfOrigin(getData("countryOfOrigin"));
        form.fillPhone(getData("phone"));

    }

    @When("^I submit page object form$")
    public void iSubmitPageObjectForm() throws Throwable {
        new SampleForm().clickSubmit();
    }

    @Then("^I verify all page object fields$")
    public void iVerifyAllPageObjectFields() throws Throwable {
        SampleVerify verifyPage = new SampleVerify();
        String result = verifyPage.getResult();
        assertThat(result).contains(getData("username"));
        assertThat(result).contains(getData("email"));
        assertThat(result).contains(getData("firstName"));
        assertThat(result).contains(getData("lastName"));
        assertThat(verifyPage.getPasswordResult()).contains(getData("savedPasswordPlaceholder"));
    }
}




