package commons;

import PageObject.BasePageUi;
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
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Action with page
     */
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

    /**
     * Action with Alert
     */
    protected Alert waitAlertPresence() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert() {
        waitAlertPresence().accept();
    }

    protected void cancelToAlert() {
        waitAlertPresence().dismiss();
    }

    protected void sendkeyToAlert(String keysToSend) {
        waitAlertPresence().sendKeys(keysToSend);
    }

    /**
     * Action with window
     */
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

    /**
     * Action with element
     */
    protected By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    private WebElement getElement(String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }

    public String castRestParameter(String xpathLocator, String... restParameter) {
        return String.format(xpathLocator, (Object[]) restParameter);
    }

//    public String castRestParameter(String xpathLocator, Object... restParameter) {
//        return String.format(xpathLocator, restParameter);
//    }

    public By getByLocator(String prefixLocator) {
        By by = null;
        if (prefixLocator.startsWith("id") || prefixLocator.startsWith("Id") || prefixLocator.startsWith("ID")) {
            by = By.id(prefixLocator.substring(3));
        } else if (prefixLocator.startsWith("class") || prefixLocator.startsWith("Class") || prefixLocator.startsWith("CLASS")) {
            by = By.className(prefixLocator.substring(6));
        } else if (prefixLocator.startsWith("name") || prefixLocator.startsWith("Name") || prefixLocator.startsWith("NAME")) {
            by = By.name(prefixLocator.substring(5));
        } else if (prefixLocator.startsWith("tagname") || prefixLocator.startsWith("Tagname") || prefixLocator.startsWith("TAGNAME")) {
            by = By.tagName(prefixLocator.substring(8));
        } else if (prefixLocator.startsWith("css") || prefixLocator.startsWith("CSS") || prefixLocator.startsWith("Css")) {
            by = By.cssSelector(prefixLocator.substring(4));
        } else if (prefixLocator.startsWith("xpath") || prefixLocator.startsWith("Xpath") || prefixLocator.startsWith("XPATH")) {
            by = By.xpath(prefixLocator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not support!!!!");
        }
        return by;
    }


    protected void clickToElement(String xpathLocator, String restParameter) {
        getElement(castRestParameter(xpathLocator, restParameter)).click();
    }

    protected void clickToElement(String xpathLocator) {
        getElement(xpathLocator).click();
    }

    protected void sendkeyToElement(String xpathLocator, String keysToSend) {
        getElement(xpathLocator).clear();
        getElement(xpathLocator).sendKeys(keysToSend);
    }

    public void uploadMultipleFiles(String... fileNames) {
        // Lấy ra đường dẫn của thư mục upload file
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";

        for (String file : fileNames) {
            fullFileName += filePath + file + "\n";
        }

        fullFileName = fullFileName.trim();
        getElement(BasePageUi.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

    protected void sendkeyToElement(String xpathLocator, String keysToSend, String restParameter) {
        getElement(castRestParameter(xpathLocator, restParameter)).clear();
        getElement(castRestParameter(xpathLocator, restParameter)).sendKeys(keysToSend);
    }

    /**
     * Action with element Dropdow
     */

    protected void selectItemInDefaultDropDown(String xpathLocator, String textItem) {
        new Select(getElement(xpathLocator)).selectByVisibleText(textItem);
    }

    protected void selectItemInDefaultDropDown(String xpathLocator, String textItem, String keysToSend, String restParameter) {
        new Select(getElement(castRestParameter(xpathLocator, restParameter))).selectByVisibleText(textItem);
    }

    protected String getSelectedItemInDefaultDropDown(String xpathLocator) {
        return new Select(getElement(xpathLocator)).getFirstSelectedOption().getText();
    }


    protected boolean isDropDownMultiple(String xpathLocator) {
        return new Select(getElement(xpathLocator)).isMultiple();
    }

    protected void sleepInSecond(int numberSeconds) {
        try {
            Thread.sleep(numberSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected String getAttributeValue(String xpathLocator, String attributeName) {
        return getElement(xpathLocator).getAttribute(attributeName);
    }

    protected String getAttributeValue(String xpathLocator, String attributeName, String restParameter) {
        return getElement(castRestParameter(xpathLocator, restParameter)).getAttribute(attributeName);
    }

    protected String getTextElement(String xpathLocator, String restParameter) {
        return getElement(castRestParameter(xpathLocator, restParameter)).getText();
    }

    protected String getTextElement(String xpathLocator) {
        return getElement(xpathLocator).getText();
    }

    protected String getCssValue(String xpathLocator, String propertyName) {
        return getElement(xpathLocator).getCssValue(propertyName);
    }

    protected String getHexaColorByRGBAColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    protected List<WebElement> getListElement(WebDriver driver, String xpathLocator) {
        return driver.findElements(By.xpath(xpathLocator));
    }

    protected int getListElementNumber(String xpathLocator) {
        return getListElement(driver, xpathLocator).size();
    }

    protected void checkTheCheckBoxOrRadio(String xpathLocator) {
        if (!getElement(xpathLocator).isSelected()) {
            getElement(xpathLocator).click();
        }
    }

    protected void unCheckTheCheckBoxOrRadio(String xpathLocator) {
        if (getElement(xpathLocator).isSelected()) {
            getElement(xpathLocator).click();
        }
    }

    protected boolean isElementSelected(String xpathLocator) {
        return getElement(xpathLocator).isSelected();
    }

    protected boolean isElementSelected(String xpathLocator, String restParameter) {
        return getElement(castRestParameter(xpathLocator, restParameter)).isSelected();
    }

    protected boolean isElementDisplayed(String xpathLocator) {
        return getElement(xpathLocator).isDisplayed();
    }

    protected boolean isElementDisplayed(String xpathLocator, String restParameter) {
        return getElement(castRestParameter(xpathLocator, restParameter)).isDisplayed();
    }

    protected boolean isElementEnabled(String xpathLocator) {
        return getElement(xpathLocator).isEnabled();
    }

    protected boolean isElementEnabled(String xpathLocator, String restParameter) {
        return getElement(castRestParameter(xpathLocator, restParameter)).isEnabled();
    }

    protected void switchToIframe(String xpathLocator) {
        driver.switchTo().frame(getElement(xpathLocator));
    }

    protected void switchToDefaultPage() {
        driver.switchTo().defaultContent();
    }

    protected void hoverToElement(String xpathLocator) {
        new Actions(driver).moveToElement(getElement(xpathLocator)).perform();
    }

    protected void clickAndHoldToElement(String xpathLocator) {
        new Actions(driver).clickAndHold(getElement(xpathLocator)).perform();
    }

    protected void doubleClickToElement(String xpathLocator) {
        new Actions(driver).doubleClick(getElement(xpathLocator)).perform();
    }

    protected void rightClickToElement(String xpathLocator) {
        new Actions(driver).contextClick(getElement(xpathLocator)).perform();
    }

    protected void dragAndDropToElement(String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(sourceLocator), getElement(targetLocator)).perform();
    }

    protected void pressKeyToElement(String xpathLocator, Keys keys) {
        new Actions(driver).sendKeys(getElement(xpathLocator), keys).perform();
    }

    protected void scrollToElement(String xpathLocator) {
        new Actions(driver).scrollToElement(getElement(xpathLocator)).perform();
        sleepInSecond(3);
    }

    /**
     * Action with element by JS
     */
    protected void highlightElement(String xpathLocator) {
        WebElement element = getElement(xpathLocator);
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
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(xpathLocator));
        sleepInSecond(3);
    }

    protected void scrollToElementOnTopByJS(String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(xpathLocator));
    }

    protected void scrollToElementOnDownByJS(String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(xpathLocator));
    }

    protected void scrollToBottomPageByJS() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void setAttributeInDOM(String xpathLocator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2]);",
                getElement(xpathLocator), attributeName, attributeValue);
    }

    protected void removeAttributeInDOM(String xpathLocator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute(arguments[1]);",
                getElement(xpathLocator), attributeRemove);
    }

    protected void sendkeyToElementByJS(String xpathLocator, String value) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('value', arguments[1]);",
                getElement(xpathLocator), value);
    }

    protected String getAttributeInDOMByJS(String xpathLocator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].getAttribute(arguments[1]);",
                getElement(xpathLocator), attributeName);
    }

    protected String getElementValidationMessage(String xpathLocator) {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].validationMessage;", getElement(xpathLocator));
    }

    protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0;",
                getElement(xpathLocator));
    }

    /**
     * Action with wait for element
     *
     * @return
     */

    protected WebElement waitForElementVisible(String xpathLocator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    protected WebElement waitForElementVisible(String xpathLocator, String restParameter) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(castRestParameter(xpathLocator, restParameter))));
    }

    protected boolean waitForElementPresence(String xpathLocator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(xpathLocator)));
            return true;  // Element có mặt
        } catch (TimeoutException e) {
            return false; // Element không có mặt sau khi timeout
        }
    }

    protected boolean waitForElementPresence(String xpathLocator, String restParameter) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(castRestParameter(xpathLocator, restParameter))));
            return true;  // Element có mặt
        } catch (TimeoutException e) {
            return false; // Element không có mặt sau khi timeout
        }
    }

    protected boolean waitForElementInvisible(String xpathLocator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    protected boolean waitForElementInvisible(String xpathLocator, String restParameter) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(castRestParameter(xpathLocator, restParameter))));
    }

    protected void waitForElementClickable(String xpathLocator, String restParameter) {
        wait.until(ExpectedConditions.elementToBeClickable(getByXpath(castRestParameter(xpathLocator, restParameter))));
    }

    protected void waitForElementClickable(String xpathLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
    }

    protected void waitForElementSelected(String xpathLocator) {
        wait.until(ExpectedConditions.elementToBeSelected(getByXpath(xpathLocator)));
    }

    protected void waitForElementSelected(String xpathLocator, String restParameter) {
        wait.until(ExpectedConditions.elementToBeSelected(getByXpath(castRestParameter(xpathLocator, restParameter))));
    }

    /**
     * Action with custom Element by JS
     */
    protected void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
        getElement(parentLocator).click();
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
