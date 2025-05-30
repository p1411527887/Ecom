import commons.BaseTest;
import ecomPageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC_02_payFullWithEbtCardMuntilBower extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage ;
    private LoginPopUpPageObject loginPopUp;
    private ApplesCategoryPageObject applesCategory;
    private DeliveryPageObject deliveryPage;
    private LastMinuteRecommendPageObject lastMinuteRecomendPage;
    private PaymentMethodsPageObject paymentMethodsPage;
    private PersonalCareCategoryPageObject personalCareCategoryPage;
    private SodaDrinkPageObject sodaDrinkPage;

    @Parameters("Browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);

        loginPopUp = new LoginPopUpPageObject(driver);
        homePage = new HomePageObject(driver);
        applesCategory = new ApplesCategoryPageObject(driver);

        homePage.isLoadingIconInvisible();
        homePage.clickToAcceptAllCookiesButton();
        homePage.isLoadingIconInvisible();
        homePage.clickToPickUpButton();
        homePage.isLoadingIconInvisible();
        homePage.clickToElisTestSiteChooseButton();


    }
    @Test
    public void EBT_01_Pay_Full_EBT(){
        homePage.isLoadingIconInvisible();
        homePage.clickToLoginLink();
        homePage.isLoadingIconInvisible();

        loginPopUp.clickToBackToLoginWithEmailAndPasswordLink();
        loginPopUp.sendkeyToEmail();
        loginPopUp.senkeyPassword();
        loginPopUp.clickToSignInButton();

        homePage.isMyAccountLinkDisplayed();
        homePage.isLoadingIconInvisible();

        homePage.clickToAllDepartmentsMenuButton();
        homePage.clickToFruitAndVegCategoryButton();
        homePage.clickToApplesSubCategoryLink();
        sleepInSecond(2);

        applesCategory = new ApplesCategoryPageObject(driver);
        applesCategory.clickToApplesBagsEmpireItem();
        applesCategory.clickToAddApplesBagsButton();
        applesCategory.clickToBackButton();
        applesCategory.clickToApplesBagsGalaItem();
        applesCategory.clickToAddApplesBagsButton();
        applesCategory.clickToBackButton();
        applesCategory.clickToApplesBagsGoldenItem();








          homePage.clickToCheckOutButton();
        sleepInSecond(5);















    }

    @Test
    public void EBT_02_Refund_By_Amount(){

    }

    @AfterClass
    public void CloseWindow(){
        driver.quit();

    }
}
