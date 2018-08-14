package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FullTimePortnovPage extends PortnovMain {
    public FullTimePortnovPage(){

    }
    @FindBy(xpath = "//div[@class='ov_hidden article-Body']")
    private WebElement acrticleBody;

    public String returnActicleBody(){
        return  acrticleBody.getText();
    }

}
