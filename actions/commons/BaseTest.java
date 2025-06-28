package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
//            case "Safari":
//                driver = new SafariDriver();
//                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        //driver.get("https://testing.qa.prod.self-point.com/?domain=eliy.sites.self-point.com");
        driver.get("https://automationexercise.com/login");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
//            case "Safari":
//                driver = new SafariDriver();
//                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    protected void sleepInSecond(int numberSeconds) {
        try {
            Thread.sleep(numberSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closeWindow() {  // Nên viết thường theo Java convention
        System.out.println("Cleaning up - Closing browser");

        // Null check để tránh NullPointerException
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("✅ Browser closed successfully");
            } catch (Exception e) {
                System.err.println(" Error closing browser: " + e.getMessage());
            }
        } else {
            System.out.println("Driver was null - no cleanup needed");
        }
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

}
