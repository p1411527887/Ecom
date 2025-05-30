package ecomPageObject;

import EcomPageUIs.HomePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageObject extends BasePage {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver); // Gọi constructor của BasePage để gán this.driver
        this.driver = driver;
    }


    public void clickToAcceptAllCookiesButton() {
        waitForElementClickable(HomePageUI.ACCEPT_ALL_COOKIES_BUTTON);
        clickToElement(HomePageUI.ACCEPT_ALL_COOKIES_BUTTON);
    }



    public void clickToElisTestSiteChooseButton() {
        waitForElementClickable(HomePageUI.ELIS_TEST_SITE_PICKUP_TEST_CHOOSE_BUTTON);
        clickToElement(HomePageUI.ELIS_TEST_SITE_PICKUP_TEST_CHOOSE_BUTTON);
    }

    public LoginPopUpPageObject clickToLoginLink() {
        waitForElementClickable(HomePageUI.LOGIN_LINK);
        clickToElementByJS(HomePageUI.LOGIN_LINK);
        return new LoginPopUpPageObject(driver);
    }

    public void clickToAllDepartmentsMenuButton() {
        waitForElementClickable(HomePageUI.ALL_DEPARTMENTS_MENU_BUTTON);
        clickToElement(HomePageUI.ALL_DEPARTMENTS_MENU_BUTTON);
    }

    public void clickToFruitAndVegCategoryButton() {
        waitForElementClickable(HomePageUI.FRUIT_AND_VEG_CATEGORY_LINK);
        clickToElement(HomePageUI.FRUIT_AND_VEG_CATEGORY_LINK);
    }

    public void clickToApplesSubCategoryLink() {
        waitForElementClickable(HomePageUI.APPLES_SUB_CATEGORY_LINK);
        clickToElement(HomePageUI.APPLES_SUB_CATEGORY_LINK);
    }

    public void clickToBeveragesCategoryLink() {
        waitForElementClickable(HomePageUI.BEVERAGES_CATEGORY_LINK);
        clickToElement(HomePageUI.BEVERAGES_CATEGORY_LINK);
    }

    public void clickToSodaDrinkSubCategoryLink() {
        waitForElementClickable(HomePageUI.SODA_DRINK_SUB_CATEGORY_LINK);
        clickToElement(HomePageUI.SODA_DRINK_SUB_CATEGORY_LINK);
    }

    public void clickToPersonalCareAndBabyCategoryLink() {
        waitForElementClickable(HomePageUI.PERSONAL_CARE_AND_BABY_CATEGORY_LINK);
        clickToElement(HomePageUI.PERSONAL_CARE_AND_BABY_CATEGORY_LINK);
    }

    public void clickToPersonalCareSubCategoryLink() {
        waitForElementClickable(HomePageUI.PERSONAL_CARE_SUB_CATEGORY_LINK);
        clickToElement(HomePageUI.PERSONAL_CARE_SUB_CATEGORY_LINK);
    }

    public LastMinuteRecommendPageObject clickToCheckOutButton() {
        waitForElementClickable(HomePageUI.CHECK_OUT_BUTTON);
        clickToElement(HomePageUI.CHECK_OUT_BUTTON);
        return new LastMinuteRecommendPageObject(driver);

    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(HomePageUI.MY_ACCOUNT_LINK);
    }

    public boolean isLoadingIconInvisible() {
         return waitForElementInvisible(HomePageUI.LOADING_ICON);
    }

    public void verifyLoadingIconInvisible() {
        Assert.assertTrue(waitForElementInvisible(HomePageUI.LOADING_ICON));
    }


    public void clickToPickUpButton() {
        waitForElementClickable(HomePageUI.PICK_UP_BUTTON);
        clickToElement(HomePageUI.PICK_UP_BUTTON);
    }
}

