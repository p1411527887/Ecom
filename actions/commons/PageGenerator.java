package commons;

import PageObject.*;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static ContactUsPageObject contactUsPage(WebDriver driver) {
        return new ContactUsPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static ProductPageObject getProductPage(WebDriver driver) {
        return new ProductPageObject(driver);
    }

    public static HAndMBrandPageObject getHAndMBrandPage(WebDriver driver) {
        return new HAndMBrandPageObject(driver);
    }

    public static MadameBrandPageObject getMadameBrandPage(WebDriver driver) {
        return new MadameBrandPageObject(driver);
    }

    public static MastAndHarbourBrandPageObject getMastAndHarbourBrandPage(WebDriver driver) {
        return new MastAndHarbourBrandPageObject(driver);
    }

    public static BabyHugBrandPageObject getBabyHugBrandPage(WebDriver driver) {
        return new BabyHugBrandPageObject(driver);
    }

    public static AllenSollyJuniorBrandPageObject getAllenSollyJuniorBrandPage(WebDriver driver) {
        return new AllenSollyJuniorBrandPageObject(driver);
    }

    public static KookieKidsBrandPageObject getKookieKidsBrandPage(WebDriver driver) {
        return new KookieKidsBrandPageObject(driver);
    }

    public static PoloBrandPageObject getPoloBrandPage(WebDriver driver) {
        return new PoloBrandPageObject(driver);
    }

    public static BibaBrandPageObject getBibaBrandPage(WebDriver driver) {
        return new BibaBrandPageObject(driver);
    }

    public static BrandOfProductPageObject getBrandOfProductPage(WebDriver driver) {
        return new BrandOfProductPageObject(driver);
    }


}
