package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.baseUrl;

public class BasePage extends HelperBase {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private By signInButtonLocator = By.className("ai-btn");
    private By loginButtonLocator = By.xpath("//*[@ui-sref='auth.login']");

    public void openBasePage() {
        driver.get(baseUrl);
    }

    public void clickOnLoginButton(){
        click(loginButtonLocator);
    }

    public boolean signInButtonIsDisplayed(){
        return isElementPresent(signInButtonLocator);
    }

}
