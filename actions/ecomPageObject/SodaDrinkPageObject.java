package ecomPageObject;

import EcomPageUIs.SodaDrinkPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SodaDrinkPageObject extends BasePage {

    private WebDriver driver;

    public SodaDrinkPageObject(WebDriver driver)  {
        super(driver);
        this.driver = driver;}
    public void clickToAddClassicCokeSodaItemButton() {
        waitForElementClickable(SodaDrinkPageUI.ADD_CLASSIC_COKE_SODA_BUTTON);
        clickToElement(SodaDrinkPageUI.ADD_CLASSIC_COKE_SODA_BUTTON);

    }

    public void clickToAddCokeZero2LtrItemButton() {

    }

    public void hoverToClassicCokeSodaItem() {
        waitForElementInvisible(SodaDrinkPageUI.CLASSIC_COKE_SODA_ITEM);
        hoverToElement(SodaDrinkPageUI.CLASSIC_COKE_SODA_ITEM);
    }

    public void scrollToClassicCokeSodaItem() {
        scrollToElement(SodaDrinkPageUI.CLASSIC_COKE_SODA_ITEM);
    }
}
