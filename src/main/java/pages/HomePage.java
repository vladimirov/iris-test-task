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
    private By loginButtonLocator = By.xpath("//*[@registration-sref='auth.login']");
    private By menuIconLocator = By.cssSelector("i.menu-icon");
    private By mainMenuItemLocator = By.cssSelector("a.main-menu__item-link");

    public void openHomePage() {
        driver.get(baseUrl);
    }

    public void clickOnLoginButton(){
        click(loginButtonLocator);
    }

    public void openLoginPageViaSideMenu(){
        click(menuIconLocator);
        click(mainMenuItemLocator);
    }

    public boolean signInButtonIsDisplayed(){
        return isElementPresent(signInButtonLocator);
    }

}
