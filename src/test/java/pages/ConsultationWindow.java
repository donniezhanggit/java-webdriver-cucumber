package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultationWindow extends Kvartira {
    public ConsultationWindow() {
    }
    @FindBy (xpath = "//h2[@class='fancybox-title']")
    private WebElement freeConsultationText;

    public String returnFreeConsultationText(){
        waitForVisible(freeConsultationText);
        return freeConsultationText.getText();
    }
}
