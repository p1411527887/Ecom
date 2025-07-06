import PageObject.ContactUsPageObject;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Ecom_TC07_UploadFileByDynamiclocator extends BaseTest {

    private WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private ContactUsPageObject contactUsPage;


    @Parameters("Browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void TC_02_VerifyContactUsPage() {
        log.info("1");
        loginPage = PageGenerator.getLoginPage(driver);
        log.info("2");
        loginPage.inputUserNameTextBox();
        log.info("3");
        loginPage.inptuPassWordTextBox();
        log.info("4");
        homePage = loginPage.clickToLoginButton();
        log.info("5");
        verifyEquals(homePage.loginSuccessTitle(), "Logged in as phat.truong@mercatus.co111m");
        log.info("5");
        homePage.clickToContactUsLink();
        log.info("5");
        contactUsPage = homePage.clickToContactUsLink();
        log.info("5");
        contactUsPage.inputNameTextBox();
        log.info("5");
        contactUsPage.inputEmailTextBox();
        log.info("5");
        contactUsPage.inputSubjectTextBox();
        log.info("5");
        contactUsPage.inputYourMessageHereTextBox();
        log.info("5");
        contactUsPage.uploadMultipleFiles("hinh3.jpg");
        sleepInSecond(1);
        log.info("5");
        contactUsPage.clickToSubmitButton();
        log.info("5");
        contactUsPage.clickOkToAlert();
        log.info("5");
        verifyEquals(contactUsPage.submitSuccessfullyMessage(), "Success! Your details have been submitted successfully.");
        log.info("5");
        contactUsPage.clickToBackToHomeButton();
        log.info("5");


    }


    @AfterClass
    public void CloseWindow() {
        driver.quit();

    }
}
