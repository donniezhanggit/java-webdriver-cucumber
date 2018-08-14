package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloorNumber extends BraerPark {
    public FloorNumber() {
    }
    @FindBy(xpath = "//span[contains(@class,'tab-trigger_vertical')][contains(text(),'3')]")
    private WebElement thirdFloor;
    @FindBy(xpath = "//area[@title='Квартира №18']")
    private WebElement apartment;

    public void iGoTothirdFloor(){
        click(thirdFloor);
    }
    public void iGoToApartment(){
        waitForVisible(apartment);
        waitForClickable(apartment);
        click(apartment);
    }
}
