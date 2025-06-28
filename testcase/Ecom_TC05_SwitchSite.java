import PageObject.*;
import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Ecom_TC05_SwitchSite extends BaseTest {
    private String browserName;
    private WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private ProductPageObject productPage;
    private PoloBrandPageObject poloBrandPage;
    private HAndMBrandPageObject hAndMBrandPage;
    private MastAndHarbourBrandPageObject mastAndHarbourBrandPage;
    private BabyHugBrandPageObject babyHugBrandPage;
    private AllenSollyJuniorBrandPageObject allenSollyJuniorBrandPage;
    private KookieKidsBrandPageObject kookieKidsBrandPage;
    private BibaBrandPageObject bibaBrandPage;
    private BrandOfProductPageObject brandOfProductPage;
    private String ecomURLValue;
    private String backOfficeUrlValue;


    @Parameters({"Browser", "EcomSite", "BackOfficeSite"})
    @BeforeClass
    public void beforeClass(String browserName, String ecomURL, String backOfficeUrl) {
        ecomURLValue = ecomURL;
        backOfficeUrlValue = backOfficeUrl;
        driver = getBrowserDriver(browserName, ecomURLValue);

    }

    @Test
    public void TC_05_SwitchSite() {
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.inputUserNameTextBox();
        loginPage.inptuPassWordTextBox();
        homePage = loginPage.clickToLoginButton();
        Assert.assertEquals(homePage.loginSuccessTitle(), "Logged in as phat.truong@mercatus.com");


    }


    @AfterClass
    public void CloseWindow() {
        closeWindow();

    }
}
