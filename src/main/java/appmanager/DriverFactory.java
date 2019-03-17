package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initDriver(String browser) {
        switch (browser) {
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--enable-precise-memory-info");
                chromeOptions.setCapability("webdriver.chrome.driver", true);
                return new ChromeDriver(chromeOptions);

        }
    }
}