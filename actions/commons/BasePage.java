package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void openPageURL(String urlPage) {
        driver.get(urlPage);
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getPageSource() {
        return driver.getPageSource();
    }

    protected void backPage() {
        driver.navigate().back();
    }

    protected void forwardPage() {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    protected Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptToAlert() {
        waitAlertPresence(driver).accept();
    }

    protected void cancelToAlert() {
        waitAlertPresence(driver).dismiss();
    }

    protected void sendkeyToAlert(String keysToSend) {
        waitAlertPresence(driver).sendKeys(keysToSend);
    }

    protected void switchToWindowByID(String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    protected void switchToWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            driver.switchTo().window(runWindow);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    protected void closeAllWindowsWithoutParent(String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    protected By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    protected WebElement getElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }

    protected void clickToElement(String xpathLocator) {
        getElement(driver, xpathLocator).click();
    }

    protected void sendkeyToElement(String xpathLocator, String keysToSend) {
        getElement(driver, xpathLocator).sendKeys(keysToSend);
    }

    protected void selectItemInDefaultDropDown(String xpathLocator, String textItem) {
        new Select(getElement(driver, xpathLocator)).selectByVisibleText(textItem);
    }

    protected String getSelectedItemInDefaultDropDown(String xpathLocator) {
        return new Select(getElement(driver, xpathLocator)).getFirstSelectedOption().getText();
    }



    protected boolean isDropDownMultiple(String xpathLocator) {
        return new Select(getElement(driver, xpathLocator)).isMultiple();
    }

    protected void sleepInSecond(int numberSeconds) {
        try {
            Thread.sleep(numberSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String getAttributeValue(String xpathLocator, String attributeName) {
        return getElement(driver, xpathLocator).getAttribute(attributeName);
    }

    protected String getTextElement(String xpathLocator) {
        return getElement(driver, xpathLocator).getText();
    }

    protected String getCssValue(String xpathLocator, String propertyName) {
        return getElement(driver, xpathLocator).getCssValue(propertyName);
    }

    protected String getHexaColorByRGBAColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    protected List<WebElement> getListElement(WebDriver driver, String xpathLocator) {
        return driver.findElements(By.xpath(xpathLocator));
    }

    protected int getListElementNumber( String xpathLocator) {
        return getListElement(driver, xpathLocator).size();
    }

    protected void checkTheCheckBoxOrRadio(String xpathLocator) {
        if (!getElement(driver, xpathLocator).isSelected()) {
            getElement(driver, xpathLocator).click();
        }
    }

    protected void unCheckTheCheckBoxOrRadio(String xpathLocator) {
        if (getElement(driver, xpathLocator).isSelected()) {
            getElement(driver, xpathLocator).click();
        }
    }

    protected boolean isElementSelected(String xpathLocator) {
        return getElement(driver, xpathLocator).isSelected();
    }

    protected boolean isElementDisplayed(String xpathLocator) {
        return getElement(driver, xpathLocator).isDisplayed();
    }

    protected boolean isElementEnabled(String xpathLocator) {
        return getElement(driver, xpathLocator).isEnabled();
    }

    protected void switchToIframe(String xpathLocator) {
        driver.switchTo().frame(getElement(driver, xpathLocator));
    }

    protected void switchToDefaultPage() {
        driver.switchTo().defaultContent();
    }

    protected void hoverToElement(String xpathLocator) {
        new Actions(driver).moveToElement(getElement(driver, xpathLocator)).perform();
    }

    protected void clickAndHoldToElement(String xpathLocator) {
        new Actions(driver).clickAndHold(getElement(driver, xpathLocator)).perform();
    }

    protected void doubleClickToElement(String xpathLocator) {
        new Actions(driver).doubleClick(getElement(driver, xpathLocator)).perform();
    }

    protected void rightClickToElement( String xpathLocator) {
        new Actions(driver).contextClick(getElement(driver, xpathLocator)).perform();
    }

    protected void dragAndDropToElement( String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    protected void pressKeyToElement(String xpathLocator, Keys keys) {
        new Actions(driver).sendKeys(getElement(driver, xpathLocator), keys).perform();
    }

    protected void scrollToElement(String xpathLocator) {
        new Actions(driver).scrollToElement(getElement(driver, xpathLocator)).perform();
        sleepInSecond(2);
    }

    protected void highlightElement(String xpathLocator) {
        WebElement element = getElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', arguments[1])",
                element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', arguments[1])",
                element, originalStyle);
    }

    protected void clickToElementByJS(String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, xpathLocator));
        sleepInSecond(3);
    }

    protected void scrollToElementOnTopByJS( String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathLocator));
    }

    protected void scrollToElementOnDownByJS( String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, xpathLocator));
    }

    protected void scrollToBottomPageByJS() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void setAttributeInDOM(String xpathLocator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2]);",
                getElement(driver, xpathLocator), attributeName, attributeValue);
    }

    protected void removeAttributeInDOM( String xpathLocator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute(arguments[1]);",
                getElement(driver, xpathLocator), attributeRemove);
    }

    protected void sendkeyToElementByJS( String xpathLocator, String value) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('value', arguments[1]);",
                getElement(driver, xpathLocator), value);
    }

    protected String getAttributeInDOMByJS(String xpathLocator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].getAttribute(arguments[1]);",
                getElement(driver, xpathLocator), attributeName);
    }

    protected String getElementValidationMessage( String xpathLocator) {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].validationMessage;", getElement(driver, xpathLocator));
    }

    protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;",
                getElement(driver, xpathLocator));
    }

    protected void waitForElementVisible(String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    protected void waitForElementPresence(String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(xpathLocator)));
    }

    protected boolean waitForElementInvisible(String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
        return false;
    }

    protected void waitForElementClickable(String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
    }

    protected void waitForElementSelected(String xpathLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeSelected(getByXpath(xpathLocator)));
    }


    protected void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        List<WebElement> allItems = explicitWait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator))
        );

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

}
