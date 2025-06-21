package PageObject;

import PageUI.ContactUsPageUi;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ContactUsPageObject extends BasePage {
    private String Name = "Phat";
    private String Email = "Phat.truong@mercatus.com";
    private String Subject = "QA automation";
    private String YourMassageHere = " become QA automation as soon as possible";
    private String upLoadFolderPath = System.getProperty("user.dir") + File.separator + "uploadFile" + File.separator;
    private String Hinh1 = "hinh1.jpg";
    private String Hinh1Path = upLoadFolderPath + Hinh1;

    public ContactUsPageObject(WebDriver driver) {
        super(driver);
    }

    public void inputNameTextBox() {
        waitForElementVisible(ContactUsPageUi.NAME_TEXTBOX);
        sendkeyToElement(ContactUsPageUi.NAME_TEXTBOX, Name);
    }

    public void inputEmailTextBox() {
        waitForElementVisible(ContactUsPageUi.EMAIL_TEXTBOX);
        sendkeyToElement(ContactUsPageUi.EMAIL_TEXTBOX, Email);
    }

    public void inputSubjectTextBox() {
        waitForElementVisible(ContactUsPageUi.SUBJECT_TEXTBOX);
        sendkeyToElement(ContactUsPageUi.SUBJECT_TEXTBOX, Subject);
    }

    public void uploadFile() {
        waitForElementVisible(ContactUsPageUi.UPLOAD_FILE_BUTTON);
        sendkeyToElement(ContactUsPageUi.UPLOAD_FILE_BUTTON, Hinh1Path);

    }

    public void clickToSubmitButton() {
        waitForElementVisible(ContactUsPageUi.SUBMIT_BUTTON);
        waitForElementClickable(ContactUsPageUi.SUBMIT_BUTTON);
        clickToElement(ContactUsPageUi.SUBMIT_BUTTON);


    }

    public void clickOkToAlert() {
        waitAlertPresence();
        acceptToAlert();
    }

    public String submitSuccessfullyMessage() {
        waitForElementVisible(ContactUsPageUi.SUBMIT_SUCCESSFULLY_MESSAGE);
        return getTextElement(ContactUsPageUi.SUBMIT_SUCCESSFULLY_MESSAGE);
    }

    public HomePageObject clickToBackToHomeButton() {
        waitForElementClickable(ContactUsPageUi.BACK_TO_HOME_BUTTON);
        clickToElement(ContactUsPageUi.BACK_TO_HOME_BUTTON);
        return PageGenerator.getHomePage(driver);
    }

    public void inputYourMessageHereTextBox() {
        waitForElementVisible(ContactUsPageUi.YOUR_MESSAGE_HERE_TEXTBOX);
        sendkeyToElement(ContactUsPageUi.YOUR_MESSAGE_HERE_TEXTBOX, YourMassageHere);
    }
}
