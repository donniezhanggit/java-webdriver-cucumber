package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostalStoreValidate extends UspsHeader{
    public PostalStoreValidate() {
    }
    @FindBy(xpath = "//div[@class='no-product']")
    private WebElement noProduct;

    public String returnNoProductText(){
        return noProduct.getText();
    }

    }

