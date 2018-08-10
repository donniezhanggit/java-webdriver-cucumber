package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DatePicker extends Page {

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement monthElement;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    private WebElement yearElement;

    public void selectDate(String day, String month, String year) {
        new Select(monthElement).selectByValue(month);
        new Select(yearElement).selectByValue(year);
        click(getByXpath("//td[@data-handler='selectDay']/a[text()='"+ day + "']"));
    }

}

