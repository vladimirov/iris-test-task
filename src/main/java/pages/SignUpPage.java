package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.baseUrl;

public class SignUpPage extends HelperBase {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private String password = "^(?=.*[a-Z])(?=.*1";

    private By acceptCookieButtonLocator = By.cssSelector("div.cookies-disclaimer__btn-wrapper");
    private By registerButtonLocator = By.xpath("//div[@class='auth-btn-wrapper']/a[2]");
    private By firstNameLocator = By.name("first_name");
    private By lastNameLocator = By.name("last_name");
    private By emailLocator = By.name("email");
    private By termsAcceptLocator = By.xpath("//*[@for='i-accept']");
    private By signUpButtonLocator = By.xpath("//button[@type='submit']");
    private By passwordLocator = By.name("password");
    private By passwordConfirmLocator = By.name("password_confirm");
//    private By submitButtonLocator = By.className("auth-page__submit-btn ai-btn-submit");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");
    private By questionnairePopupLocator = By.className("questionnaire-popup__container");

    public void openBasePage() {
        driver.get(baseUrl);
    }

    public void clickOnRegisterButton() {
        click(registerButtonLocator);
    }

    public void fillNameFields() {
        click(acceptCookieButtonLocator);
        type(firstNameLocator, "Firstname");
        type(lastNameLocator, "Lastname");
    }

    public void fillEmailField(String email) {
        type(emailLocator, email);
    }

    public void acceptTermsAndClickSignUp() {
        click(termsAcceptLocator);
        click(signUpButtonLocator);
    }

    public boolean awesomeTextIsDisplayed() {
        return textIsDisplayed(By.className("title"), "Awesome, way to go!");
    }

    public void fillPasswordAndConfirm() {
        waitForPageLoaded();
        switchToNewTab();
        type(passwordLocator, password);
        type(passwordConfirmLocator, password);
        click(submitButtonLocator);
    }

    public void fillPasswordAndSignIn() {
        type(passwordLocator, password);
        click(submitButtonLocator);
    }

    public boolean questionnairePopupIsDisplayed(){
        return isElementPresent(questionnairePopupLocator);
    }

}
