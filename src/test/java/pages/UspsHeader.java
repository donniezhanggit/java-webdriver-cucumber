package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsHeader extends Page {
    public UspsHeader() {
        setUrl("https://www.usps.com/");
    }

    @FindBy(xpath = "//*[@id='mail-ship-width']")
    private WebElement mailAndShip;
    @FindBy(xpath = "//li[@class='tool-zip']//a")
    private WebElement lookupByZip;
    @FindBy(xpath = "//a[contains(text(),'Calculate a Price')]")
    private WebElement calculateAPrice;
    @FindBy(xpath = "//a[@class='menuitem'][contains(text(),'Postal Store')]")
    private WebElement postalStore;


    public void mouseOvermailAndShip() {
        moveToElement(mailAndShip);
    }

    public void goToLookupByZip() {
        click(lookupByZip);
    }

    public void goToCalculateAPrice() {
        click(calculateAPrice);
    }

    public void goToPostalStoreTab() {
        click(postalStore);
    }
}
