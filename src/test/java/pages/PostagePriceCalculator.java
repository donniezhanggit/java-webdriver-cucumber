package pages;

import cucumber.api.java8.Pa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PostagePriceCalculator extends Page {
    public PostagePriceCalculator() {
    }

    @FindBy(xpath = "//select[@id='CountryID']")
    private WebElement countryId;
    @FindBy(xpath = "//input[@id='option_1']")
    private WebElement postcard;


    public void selectCountryId(String value) {
        new Select(countryId).selectByValue(value);
    }

    public void clickOnPostcard() {
        click(postcard);
    }


}
