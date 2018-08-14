package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScheduleOfClasses extends PortnovMain {
    public ScheduleOfClasses() {
    }
    @FindBy(xpath = "//*[contains(text(),'08/21/18')]/..//*[contains(text(),'Full-Time')]")
    private WebElement fullTimeClass;

    public void clickOnFullTimeClass(){
        click(fullTimeClass);
    }
}
