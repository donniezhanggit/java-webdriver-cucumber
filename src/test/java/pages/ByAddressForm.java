package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ByAddressForm extends UspsHeader{
    public ByAddressForm(){
    }
    @FindBy(xpath = "//*[contains(text(),'Find by Address')]")
    private WebElement byAddressButton;

    public void clickOnByAddressButton() {
        click(byAddressButton);
    }

}
