package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.baseUrl;

public class RegistrationPage extends HelperBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private String password = "^(?=.*[a-Z])(?=.*1";
    private String newPassword = "^(?=.*[a-Z])(?=.*1-NEW";

    private By acceptCookieButtonLocator = By.cssSelector("div.cookies-disclaimer__btn-wrapper");
    private By registerButtonLocator = By.xpath("//div[@class='auth-btn-wrapper']/a[2]");
    private By firstNameLocator = By.name("first_name");
    private By lastNameLocator = By.name("last_name");
    private By emailLocator = By.name("email");
    private By termsAcceptLocator = By.xpath("//*[@for='i-accept']");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");
    private By passwordLocator = By.name("password");
    private By passwordConfirmLocator = By.name("password_confirm");
    private By forgotPasswordLocator = By.className("forgot-password");
    private By passwordResetTextLocator = By.className("auth-page__title");

    public void openRegistrationPage() {
        driver.get(baseUrl + "auth/registration");
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }

    public void openSignInPage() {
        driver.get(baseUrl + "auth/login");
    }

    public void clickOnRegisterButton() {
        click(registerButtonLocator);
    }

    public void acceptCookiesButtonClick() {
        click(acceptCookieButtonLocator);
    }

    public void fillFirstnameField() {
        type(firstNameLocator, "Firstname");
    }

    public void fillLastnameField() {
        type(lastNameLocator, "Lastname");
    }

    public void clickOnEmailField() {
        click(emailLocator);
    }

    public void fillEmailField(String email) {
        type(emailLocator, email);
    }

    public void acceptTermsCheckbox() {
        click(termsAcceptLocator);
    }

    public void clickSignUpButton() {
        click(submitButtonLocator);
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

    public void fillNewPasswordAndConfirm() {
        waitForPageLoaded();
        switchToNewTab();
        type(passwordLocator, newPassword);
        type(passwordConfirmLocator, newPassword);
        submit(submitButtonLocator);
        waitTillElementIsVisible(By.cssSelector("label.ai-checkbox-group__label"));
    }

    public void submitTheForm() {
        submit(submitButtonLocator);
    }

    public void fillInvalidPassword() {
        type(passwordLocator, password + 1);
    }

    public void clickLoginButton() {
        click(submitButtonLocator);
    }

    public void fillPasswordField() {
        type(passwordLocator, password);
    }

    public void fillNewPasswordField() {
        type(passwordLocator, newPassword);
    }

    public void clickOnForgotPassword() {
        click(forgotPasswordLocator);
    }

    public void scrollToSignUpButton() {
        scrollTillElementIsVisible(submitButtonLocator);
    }

    public boolean signUpButtonIsDisabled() {
        return isClickable(submitButtonLocator);
    }

    public boolean loginFormShowsErrors() {
        try {
            elementHasAttribute(submitButtonLocator, "ng-disabled", "form.$invalid");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean userAlreadyExistMessageDisplayed() {
        return elementIsPresent(By.cssSelector("div.ai-input-group.valid.error"));
    }

}
