package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends HelperBase {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private By userInfoLocator = By.xpath("//div[@class='header-part__user-info']/button");
    private By personalInfoLocator = By.className("personal-information__title");
    private By logoutButtonLocator = By.xpath("//ul[@class='personal-information__list']/li[2]");
    private By questionnairePopupLocator = By.className("questionnaire-popup__container");

    public boolean questionnairePopupIsDisplayed() {
        return isElementPresent(questionnairePopupLocator);
    }

    public void clickOnUserInfoButton() {
        try {
            waitToBePresent(questionnairePopupLocator);
            driver.navigate().refresh();
            click(userInfoLocator);
            waitToBePresent(personalInfoLocator);
        } catch (Exception e) {
            driver.navigate().refresh();
            click(userInfoLocator);
            waitToBePresent(personalInfoLocator);
        }
    }

    public boolean personalInfoIsDisplayed() {
        return isElementPresent(personalInfoLocator);
    }

    public void clickOnLogoutButton() {
        click(logoutButtonLocator);
    }

}
