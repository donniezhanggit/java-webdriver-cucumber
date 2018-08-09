package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostcardUsps extends Page {
    public PostcardUsps() {
    }

    @FindBy(xpath = "//input[@id='quantity-0']")
    private WebElement quantity;
    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;
    @FindBy(xpath = "//div[@id='total']")
    private WebElement totalPrice;

    public void sendKeysToQuantity(String text) {
        quantity.sendKeys(text);
    }

    public void clickOnCalculateButton() {
        click(calculateButton);
    }

    public String getTotal() {
        waitForVisible(totalPrice);
        return totalPrice.getText();
    }
}

