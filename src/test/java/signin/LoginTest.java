package signin;

import appmanager.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    private String email;

    @BeforeTest
    public void registerNewUser() throws InterruptedException {
        app.tempMailPage().openTempMailPage();
        email = app.tempMailPage().tempMailEmail();
        app.homePage().openHomePage();
        app.registrationPage().clickOnRegisterButton();
        app.registrationPage().acceptCookiesButtonClick();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().acceptTermsCheckbox();
        app.registrationPage().clickSignUpButton();
        assertTrue(app.registrationPage().awesomeTextIsDisplayed());
        app.tempMailPage().openTempMailPage();
        assertTrue(app.tempMailPage().tempMailHasEmail());
        app.tempMailPage().emailLinkClick();
        app.registrationPage().fillPasswordAndConfirm();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().fillPasswordField();
        app.registrationPage().submitTheForm();
        assertTrue(app.dashboardPage().questionnairePopupIsDisplayed());
        app.registrationPage().reloadPage();
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();
    }

    @Test
    public void inputInvalidUsernameValidPassword() throws InterruptedException {
        app.registrationPage().openSignInPage();
        app.registrationPage().fillEmailField(email + 1);
        app.registrationPage().fillPasswordField();
        app.registrationPage().submitTheForm();
        assertTrue(app.registrationPage().loginFormShowsErrors());
    }

    @Test
    public void inputValidUsernameInvalidPassword() throws InterruptedException {
        app.registrationPage().openSignInPage();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().fillInvalidPassword();
        app.registrationPage().clickLoginButton();
        assertTrue(app.registrationPage().loginFormShowsErrors());
    }

}