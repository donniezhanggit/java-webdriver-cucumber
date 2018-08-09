package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LookupByZip extends UspsHeader {

    @FindBy(xpath = "//a[contains(@href,'byaddress')][contains(@class,'code-address')]")
    private WebElement findByAddress;

    public void clickFindByAddress() {
        click(findByAddress);
    }
}

