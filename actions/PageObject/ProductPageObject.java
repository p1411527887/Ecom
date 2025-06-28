package PageObject;

import PageUI.AllProductPageUi;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ProductPageObject extends BasePage {

    public ProductPageObject(WebDriver driver) {
        super(driver);
    }

    public String getTextPoloBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_POLO_LINK);
        return getTextElement(AllProductPageUi.BRANDS_POLO_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();


    }

    public String getTextHAndMBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_H_AND_M_LINK);
        return getTextElement(AllProductPageUi.BRANDS_H_AND_M_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();
    }

    public String getTextMadameBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_MADAME_LINK);
        return getTextElement(AllProductPageUi.BRANDS_MADAME_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();
    }

    public String getTextMastAndHabourBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_MAST_AND_HARBOUR_LINK);
        return getTextElement(AllProductPageUi.BRANDS_MAST_AND_HARBOUR_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();
    }

    public String getTextBabyHubBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_BABY_HUG_LINK);
        return getTextElement(AllProductPageUi.BRANDS_BABY_HUG_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();
    }

    public String getTextAllenSollyJuniorBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_ALLEN_SOLLY_JUNIOR_LINK);
        return getTextElement(AllProductPageUi.BRANDS_ALLEN_SOLLY_JUNIOR_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();
    }

    public String getTextKooKieBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_KOOKIE_KID_LINK);
        return getTextElement(AllProductPageUi.BRANDS_KOOKIE_KID_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();
    }

    public String getTextBiBaBrands() {
        waitForElementVisible(AllProductPageUi.BRANDS_BIBA_LINK);
        return getTextElement(AllProductPageUi.BRANDS_BIBA_LINK).replaceAll("\\(\\d+\\)\\s*", "").trim();
    }

    public void scrollDownToBrand() {
        waitForElementVisible(AllProductPageUi.BRANDS_MAST_AND_HARBOUR_LINK);
        scrollToElementOnDownByJS(AllProductPageUi.BRANDS_MAST_AND_HARBOUR_LINK);
    }

    public void clickOnViewProductOfBlueTopItem() {
        waitForElementClickable(AllProductPageUi.VIEW_PRODUCT_BLUE_TOP_LINK);
        clickToElementByJS(AllProductPageUi.VIEW_PRODUCT_BLUE_TOP_LINK);
    }

}
