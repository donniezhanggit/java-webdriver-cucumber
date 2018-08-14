package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChipotleFinalPage extends Yelp {
    public ChipotleFinalPage() {
    }

    @FindBy(xpath = "//h1[@class='biz-page-title embossed-text-white']")
    private WebElement headerText;

    public String returnHeaderText(){
        return  headerText.getText();
    }
}
