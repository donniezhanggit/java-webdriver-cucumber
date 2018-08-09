package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleFormNameDialog extends Page {

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    WebElement saveButton;

    public void fillFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void fillMiddleName(String name) {
        middleName.sendKeys(name);
    }

    public void fillLastName(String name) {
        lastName.sendKeys(name);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

}