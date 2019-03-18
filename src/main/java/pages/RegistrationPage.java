package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.tempMailUrl;

public class RegistrationPage extends HelperBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private String password = "^(?=.*[a-Z])(?=.*1";
    private String newPassword = "^(?=.*[a-Z])(?=.*1-new";

    private By acceptCookieButtonLocator = By.cssSelector("div.cookies-disclaimer__btn-wrapper");
    private By registerButtonLocator = By.xpath("//div[@class='auth-btn-wrapper']/a[2]");
    private By firstNameLocator = By.name("first_name");
    private By lastNameLocator = By.name("last_name");
    private By emailLocator = By.name("email");
    private By termsAcceptLocator = By.xpath("//*[@for='i-accept']");
    private By signUpButtonLocator = By.xpath("//button[@type='submit']");
    private By remindButtonLocator = By.xpath("//button[@type='submit']");
    private By passwordLocator = By.name("password");
    private By passwordConfirmLocator = By.name("password_confirm");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");
    private By forgotPasswordLocator = By.className("forgot-password");
    private By passwordResetTextLocator = By.className("auth-page__title");


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
        driver.get("https://the.iris.ai/auth/login");
    }


    public void fillNewPasswordAndConfirm() {
        waitForPageLoaded();
        switchToNewTab();
        type(passwordLocator, newPassword);
        type(passwordConfirmLocator, newPassword);
        click(submitButtonLocator);
        driver.get("https://the.iris.ai/auth/login");
    }

    public void fillPasswordAndSignIn() {
        type(passwordLocator, password);
        click(submitButtonLocator);
    }

    public void login(String email) {
        type(emailLocator, email);
        type(passwordLocator, password);
        click(submitButtonLocator);
    }

    public void loginWithNewPassword(String email) {
        type(emailLocator, email);
        type(passwordLocator, newPassword);
        click(submitButtonLocator);
    }

    public void clickOnForgotPassword(){
        click(forgotPasswordLocator);
    }

    public void typeEmailAndClickResetButton(String email){
        type(emailLocator, email);
        click(remindButtonLocator);
    }

    public boolean passwordResetTextIsDisplayed() {
        return textIsDisplayed(passwordResetTextLocator, "Password reset");
    }

}
