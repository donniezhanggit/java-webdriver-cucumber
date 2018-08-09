package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class SampleVerify extends Page {

    public SampleVerify() {
    }

    @FindBy(xpath ="//div[@id='samplePageResult']")
    private WebElement result;
    @FindBy(xpath ="//b[@name='password']")
    private WebElement passwordResult;
    @FindBy(xpath ="//b[@name='allowedToContact']")
    private WebElement allowedToContact;
    @FindBy(xpath ="//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    public String getAllowedToContact() {
        return allowedToContact.getText();
    }
    public String getAgreedToPrivacyPolicy() {
        return agreedToPrivacyPolicy.getText();
    }
    public String getResult() {
        waitForVisible(result);
        return result.getText();
    }
    public String getPasswordResult() {
        return passwordResult.getText();
    }

}
