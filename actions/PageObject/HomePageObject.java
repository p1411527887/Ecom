package PageObject;

import PageUI.HomePageUi;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public String loginSuccessTitle() {
        waitForElementVisible(HomePageUi.LOGIN_SUCCESS_TITLE);
        return getTextElement(HomePageUi.LOGIN_SUCCESS_TITLE);
    }

    public ContactUsPageObject clickToContactUsLink() {
        waitForElementClickable(HomePageUi.CONTACT_US_LINK);
        clickToElement(HomePageUi.CONTACT_US_LINK);
        return PageGenerator.contactUsPage(driver);
    }


    public ProductPageObject clickToProductLink() {
        waitForElementClickable(HomePageUi.PRODUCT_LINK);
        clickToElement(HomePageUi.PRODUCT_LINK);
        return PageGenerator.getProductPage(driver);
    }
}
