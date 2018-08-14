package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Kvartira extends  BraerPark {
    public Kvartira() {
    }

    @FindBy(xpath = "//a[@class='button button_big fancybox ajax']")
    private WebElement salesOffice;

    public String returnapartmenttex() {
        return getByXpath("//span[@class='catalog_detail__price__value']").getText();
    }

    public void goToSalesOffice() {
        click(salesOffice);
    }

}