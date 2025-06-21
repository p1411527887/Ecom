import PageObject.ContactUsPageObject;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.ProductPageObject;
import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Ecom_TC03_VerifyProductPage extends BaseTest {

    private WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private ProductPageObject productPage;


    @Parameters("Browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void TC_03_VerifyProductPage() {
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.inputUserNameTextBox();
        loginPage.inptuPassWordTextBox();

        homePage = loginPage.clickToLoginButton();
        Assert.assertEquals(homePage.loginSuccessTitle(), "Logged in as phat.truong@mercatus.com");
        productPage = homePage.clickToProductLink();
        productPage.scrollDownToBrand();
        Assert.assertEquals(productPage.getTextPoloBrands(), "POLO");
        Assert.assertEquals(productPage.getTextHAndMBrands(), "H&M");
        Assert.assertEquals(productPage.getTextMadameBrands(), "MADAME");
        Assert.assertEquals(productPage.getTextMastAndHabourBrands(), "MAST & HARBOUR");
        Assert.assertEquals(productPage.getTextBabyHubBrands(), "BABYHUG");
        Assert.assertEquals(productPage.getTextAllenSollyJuniorBrands(), "ALLEN SOLLY JUNIOR");
        Assert.assertEquals(productPage.getTextKooKieBrands(), "KOOKIE KIDS");
        Assert.assertEquals(productPage.getTextBiBaBrands(), "BIBA");

        productPage.clickOnViewProductOfBlueTopItem();


    }


    @AfterClass
    public void CloseWindow() {
        driver.quit();

    }
}
