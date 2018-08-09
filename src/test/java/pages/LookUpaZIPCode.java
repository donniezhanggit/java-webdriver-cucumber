package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LookUpaZIPCode extends UspsHeader{
    public LookUpaZIPCode() {
    }

    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement streetAddress;
    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement city;
    @FindBy(xpath = "//select[@id='tState']")
    private WebElement state;
    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement findButton;

    public void fillStreetAddress(String text) {
        sendKeys(streetAddress, text);
    }

    public void fillOutCity(String text) {
        sendKeys(city, text);
    }

    public void selectState(String value) {
        new Select(state).selectByValue(value);
    }

        public void clickFindButton() {
            click(findButton);
        }

}
