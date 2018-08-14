package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PortnovMain extends Page {
    public PortnovMain(){
        setUrl("https://www.portnov.com/");
    }

    @FindBy(xpath = "//*[contains(text(),'Get in touch')]/..")
    private WebElement address;
    @FindBy(xpath = "//span[@class='separator line1'][contains(text(),'School')]")
    private WebElement schoolTab;
    @FindBy(xpath = "//a[contains(text(),'Schedule of Classes')]")
    private WebElement scheduleOfClasses;


    public String returnAddressText(){
        return address.getText();
    }

    public void goToTheschoolTab(){
        moveToElement(schoolTab);
    }

    public void goToScheduleOfClasses(){
        click(scheduleOfClasses);
    }


}
