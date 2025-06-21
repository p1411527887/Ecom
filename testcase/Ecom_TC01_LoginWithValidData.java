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


public class Ecom_TC01_LoginWithValidData extends BaseTest {

    private WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;


    @Parameters("Browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void TC_01_LoginWithValidData() {
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.inputUserNameTextBox();
        loginPage.inptuPassWordTextBox();
        homePage = loginPage.clickToLoginButton();
        Assert.assertEquals(homePage.loginSuccessTitle(), "Logged in as phat.truong@mercatus.com");
    }

    @AfterClass
    public void CloseWindow() {
        driver.quit();

    }
}
