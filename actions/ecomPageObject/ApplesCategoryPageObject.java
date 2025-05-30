package ecomPageObject;

import EcomPageUIs.ApplesCategoryPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ApplesCategoryPageObject extends BasePage {

    private WebDriver driver;

    public ApplesCategoryPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickToApplesBagsEmpireItem() {
        waitForElementVisible(ApplesCategoryPageUI.APPLES_BAG_EMPIRE_ITEM);
        waitForElementClickable(ApplesCategoryPageUI.APPLES_BAG_EMPIRE_ITEM);
        clickToElementByJS(ApplesCategoryPageUI.APPLES_BAG_EMPIRE_ITEM);

    }

//    public void scrollToExtraFancyGalaApplesItem() {
//        scrollToElement(ApplesCategoryPageUI.EXTRA_FANCY_GALA_APPLES_ITEM);
//
//    }

    public void clickToAddApplesBagsButton() {
        waitForElementVisible(ApplesCategoryPageUI.ADD_APPLES_BAG_EMPIRE_BUTTON);
        waitForElementClickable(ApplesCategoryPageUI.ADD_APPLES_BAG_EMPIRE_BUTTON);
        clickToElement(ApplesCategoryPageUI.ADD_APPLES_BAG_EMPIRE_BUTTON);


    }

    public void clickToBackButton() {
        waitForElementVisible(ApplesCategoryPageUI.BACK_BUTTON);
        waitForElementClickable(ApplesCategoryPageUI.BACK_BUTTON);
        clickToElement(ApplesCategoryPageUI.BACK_BUTTON);


    }

    public void clickToApplesBagsGalaItem() {
    }

    public void clickToApplesBagsGoldenItem() {
    }
}
