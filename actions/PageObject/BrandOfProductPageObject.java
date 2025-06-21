package PageObject;

import PageUI.BrandOfProductPageUi;
import commons.BasePage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;

public class BrandOfProductPageObject extends ProductPageObject {
    public BrandOfProductPageObject(WebDriver driver) {
        super(driver);
    }

    public PoloBrandPageObject getPoloBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_POLO_LINK);
        clickToElementByJS(BrandOfProductPageUi.BRANDS_POLO_LINK);
        return PageGenerator.getPoloBrandPage(driver);

    }

    public HAndMBrandPageObject getHAndMBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_H_AND_M_LINK);
        clickToElement(BrandOfProductPageUi.BRANDS_H_AND_M_LINK);
        return PageGenerator.getHAndMBrandPage(driver);

    }

    public MadameBrandPageObject getMadameBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_MADAME_LINK);
        clickToElement(BrandOfProductPageUi.BRANDS_MADAME_LINK);
        return PageGenerator.getMadameBrandPage(driver);

    }

    public MastAndHarbourBrandPageObject getMastAndHarbourBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_MAST_AND_HARBOUR_LINK);
        clickToElement(BrandOfProductPageUi.BRANDS_MAST_AND_HARBOUR_LINK);
        return PageGenerator.getMastAndHarbourBrandPage(driver);
    }

    public BabyHugBrandPageObject getBabyHugBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_BABY_HUG_LINK);
        clickToElement(BrandOfProductPageUi.BRANDS_BABY_HUG_LINK);
        return PageGenerator.getBabyHugBrandPage(driver);
    }

    public AllenSollyJuniorBrandPageObject getAllenSollyJuniorBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_ALLEN_SOLLY_JUNIOR_LINK);
        clickToElement(BrandOfProductPageUi.BRANDS_ALLEN_SOLLY_JUNIOR_LINK);
        return PageGenerator.getAllenSollyJuniorBrandPage(driver);
    }

    public KookieKidsBrandPageObject getKookieKidsBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_KOOKIE_KID_LINK);
        clickToElement(BrandOfProductPageUi.BRANDS_KOOKIE_KID_LINK);
        return PageGenerator.getKookieKidsBrandPage(driver);
    }

    public BibaBrandPageObject getBibaBrandPage() {
        waitForElementClickable(BrandOfProductPageUi.BRANDS_BIBA_LINK);
        clickToElement(BrandOfProductPageUi.BRANDS_BIBA_LINK);
        return PageGenerator.getBibaBrandPage(driver);
    }
}
