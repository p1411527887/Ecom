package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
private WebDriver driver;
    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
            switch (browserList){
//            case FIREFOX:
//                driver = new FirefoxDriver();
//                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
//            case "Safari":
//                driver = new SafariDriver();
//                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get("https://testing.qa.prod.self-point.com/?domain=eliy.sites.self-point.com");
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
}
