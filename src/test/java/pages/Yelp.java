package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class Yelp extends Page{
    public Yelp() {

            setUrl("https://www.yelp.com/");
    }
    @FindBy(xpath = "//input[@id='dropperText_Mast']")
    private WebElement zipCodeField;
    @FindBy(xpath = "//input[@id='find_desc']")
    private WebElement searchField;
    @FindBy(xpath = "//button[@id='header-search-submit']")
    private WebElement searchClickButton;

    public void sendKeysToZipCodeField(String text){
        zipCodeField.clear();
        sendKeys(zipCodeField, text );
    }
    public void sendKeysToSearchField(String text){
        sendKeys(searchField, text);
    }
    public void iClickOnSearchClickButton() {
        click(searchClickButton);
    }
}
