package appmanager;

import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private WebDriver driver;
    private final Properties localProperties;
    public static String baseUrl;
    public static String tempMailUrl;
    private RegistrationPage registrationPage;
    private TempMailPage tempMailPage;
    private DashboardPage dashboardPage;
    private HomePage homePage;


    public ApplicationManager() {
        localProperties = new Properties();
    }

    public void init(String browser) throws IOException {
        driver = DriverFactory.initDriver(browser);
        driver.manage().window().maximize();
        localProperties.load(new FileReader(new File("src/main/resources/local.properties")));
        baseUrl = localProperties.getProperty("web.baseUrl");
        tempMailUrl = localProperties.getProperty("web.tempMailUrl");
        registrationPage = new RegistrationPage(driver);
        tempMailPage = new TempMailPage(driver);
        dashboardPage = new DashboardPage(driver);
        homePage = new HomePage(driver);
    }

    public void stop() {
        driver.quit();
    }

    public RegistrationPage registrationPage() {
        return registrationPage;
    }

    public TempMailPage tempMailPage() {
        return tempMailPage;
    }

    public DashboardPage dashboardPage() {
        return dashboardPage;
    }

    public HomePage homePage() {
        return homePage;
    }

}
