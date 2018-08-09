package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostalStoreTab extends UspsHeader {
    public PostalStoreTab(){
    }

    @FindBy(xpath = "//input[@id='store-search']")
    private WebElement storeSearch;
    @FindBy(xpath = "//input[@id='store-search-btn']")
    private WebElement searchButton;

    public void SendkeysToStoreSearch(String text){
        storeSearch.sendKeys(text);
    }

    public void clickOnSearchButton(){
        click(searchButton);
    }

}
