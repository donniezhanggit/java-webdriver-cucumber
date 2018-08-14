package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseHouse extends BraerPark {
    public ChooseHouse(){

    }
    @FindBy(xpath = "//h1[contains(text(),'Выбор дома')]")
    private WebElement header;
    @FindBy(xpath = "//area[@title='Дом №8']")
    private WebElement houseNumber;

//    public String verifyHeader(String value){
//        return getByXpath("//h1[contains(text(),'"+value+"')]").getText();
//    }

    public String verifyHeader(){
        return header.getText();
    }

    public void iGoToHouseNumber8(){
        click(houseNumber);
    }
}
