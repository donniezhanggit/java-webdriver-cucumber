package pages;

import org.openqa.selenium.WebElement;

public class BraerPark extends Page {
    public BraerPark(){
        setUrl("http://braerpark.ru/");
    }


    public void iGoToPlanirovki(String value){
        click(getByXpath("//div[@class='column column_2']//*[contains(text(),'"+value+"')]"));
    }


}

