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
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.inputUserNameTextBox();

        loginPage.inptuPassWordTextBox();

        homePage = loginPage.clickToLoginButton();

        verifyEquals(homePage.loginSuccessTitle(), "Logged in as phat.truong@merca1111tus.com!!!");

        homePage.clickToContactUsLink();

        contactUsPage = homePage.clickToContactUsLink();

        contactUsPage.inputNameTextBox();

        contactUsPage.inputEmailTextBox();

        contactUsPage.inputSubjectTextBox();

        contactUsPage.inputYourMessageHereTextBox();

        contactUsPage.uploadMultipleFiles("hinh3.jpg");
        sleepInSecond(1);

        contactUsPage.clickToSubmitButton();

        contactUsPage.clickOkToAlert();

        verifyEquals(contactUsPage.submitSuccessfullyMessage(), "Success! Your details have been submitted successfully.1111");

        contactUsPage.clickToBackToHomeButton();


    }


    @AfterClass
    public void CloseWindow() {
        driver.quit();

    }
}
