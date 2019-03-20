package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.baseUrl;

public class HomePage extends HelperBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By signInButtonLocator = By.className("ai-btn");
    private By loginButtonLocator = By.xpath("//div[@class='auth-btn-wrapper']/a[1]");

    public void openHomePage() {
        open(baseUrl);
    }

    public void clickOnLoginButton() {
        click(loginButtonLocator);
    }

    public boolean signInButtonIsDisplayed() {
        return elementIsPresent(signInButtonLocator);
    }

}
