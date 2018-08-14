package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChipotleMexicanGrillYelp extends Yelp {
    public ChipotleMexicanGrillYelp() {
    }

    @FindBy(xpath = "//span[@class='filter-label filters-toggle js-all-filters-toggle show-tooltip']")
    private WebElement allFiltersButton;
    @FindBy(xpath = "//ul[@class='main']//input[@value='RestaurantsPriceRange2.1']")
    private  WebElement chepiestPrice;
    @FindBy(xpath = "//ul[@class='main']//input[@value='open_now']")
    private  WebElement openNowButton;
    @FindBy(xpath = "//ul[@class='ylist ylist-bordered search-results js-search-results yloca-pills-blue yloca-wrapper-grey']//li[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//h3[1]//span[1]//a[1]//span[1]")
    private  WebElement firstItemOnThePage;

    public void openAllFiltersButton() {
        click(allFiltersButton);
    }
    public void iClickOnTheChepiestPrice(){
        click(chepiestPrice);
    }
    public void clicOnOpenNowButton(){
        click(openNowButton);
    }

    public void IselectFirstItemOnThePage(){
        click(firstItemOnThePage);
    }

}
