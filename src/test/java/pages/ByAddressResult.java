package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ByAddressResult extends UspsHeader {
    public ByAddressResult() {
    }

    @FindBy(xpath = "//div[@id='zipByAddressDiv']")
    WebElement searchResult;

    public String getSearchResultText() {
        waitForVisible(searchResult);
        return searchResult.getText();
    }
}
