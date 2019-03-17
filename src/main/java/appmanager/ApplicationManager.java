package appmanager;

import org.openqa.selenium.WebDriver;
import pages.SignUpPage;
import pages.TempMailPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private WebDriver driver;
    private final Properties localProperties;
    private SignUpPage signUpPage;
    private TempMailPage tempMailPage;
    public static String baseUrl;
    public static String tempMailUrl;


    public ApplicationManager() {
        localProperties = new Properties();
    }

    public void init(String browser) throws IOException {
        driver = DriverFactory.initDriver(browser);
        driver.manage().window().maximize();
        localProperties.load(new FileReader(new File("src/main/resources/local.properties")));
        baseUrl = localProperties.getProperty("web.baseUrl");
        tempMailUrl = localProperties.getProperty("web.tempMailUrl");
        signUpPage = new SignUpPage(driver);
        tempMailPage = new TempMailPage(driver);
    }

    public void stop() {
        driver.quit();
    }

    public SignUpPage signUpPage() {
        return signUpPage;
    }

    public TempMailPage tempMailPage() {
        return tempMailPage;
    }

}
