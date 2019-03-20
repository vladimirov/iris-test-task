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
    private By logoutButtonLocator = By.xpath("//ul[@class='personal-information__list']/li[2]/span");
    private By questionnairePopupLocator = By.className("questionnaire-popup__container");

    public boolean questionnairePopupIsDisplayed() {
        return elementIsPresent(questionnairePopupLocator);
    }

//    public void refreshPage(){
//        driver.navigate().refresh();
//    }

    public void clickOnUserInfoButton() {
        click(userInfoLocator);
        waitToBePresent(personalInfoLocator);
    }

    public boolean personalInfoIsDisplayed() {
        return elementIsPresent(personalInfoLocator);
    }

    public void clickOnLogoutButton() {
        click(logoutButtonLocator);
    }


}
