package ecomPageObject;

import EcomPageUIs.HomePageUI;
import EcomPageUIs.LoginPopUpPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPopUpPageObject extends BasePage {
    private WebDriver driver;

    public LoginPopUpPageObject(WebDriver driver) {
        super(driver);
    }


    public void clickToBackToLoginWithEmailAndPasswordLink() {
        waitForElementClickable(LoginPopUpPageUI.BACK_TO_LOGIN_WITH_EMAIL_AND_PASSWORD);
        clickToElement(LoginPopUpPageUI.BACK_TO_LOGIN_WITH_EMAIL_AND_PASSWORD);
    }

    public void sendkeyToEmail() {
        waitForElementVisible(LoginPopUpPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(LoginPopUpPageUI.EMAIL_TEXTBOX,"qa-vn-ecom-01@stor.ai");
    }

    public void senkeyPassword() {
        waitForElementVisible(LoginPopUpPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(LoginPopUpPageUI.PASSWORD_TEXTBOX,"Abcd1234");
    }

    public void clickToSignInButton() {
        waitForElementClickable(LoginPopUpPageUI.SIGN_IN_BUTTON);
        clickToElement(LoginPopUpPageUI.SIGN_IN_BUTTON);

    }
}
