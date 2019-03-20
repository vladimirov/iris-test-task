package e2e;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AuthorizationTest extends TestBase {

    private String email;

    @Test(priority = 1)
    public void successfulRegistration() throws InterruptedException {
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
        app.registrationPage().openSignInPage();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().fillPasswordField();
        app.registrationPage().submitTheForm();
        assertTrue(app.dashboardPage().questionnairePopupIsDisplayed());
        app.registrationPage().reloadPage();
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();
    }

    @Test(priority = 2, dependsOnMethods = {"successfulRegistration"})
    public void successfulLoginAndLogout() throws InterruptedException {
        app.registrationPage().openSignInPage();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().fillPasswordField();
        app.registrationPage().submitTheForm();
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();
        assertTrue(app.homePage().signInButtonIsDisplayed());
    }

    @Test(priority = 3, dependsOnMethods = {"successfulLoginAndLogout"})
    public void resetPassword() throws InterruptedException {
        app.homePage().openHomePage();
        app.homePage().clickOnLoginButton();
        app.registrationPage().clickOnForgotPassword();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().submitTheForm();
        app.tempMailPage().openTempMailPage();
        app.tempMailPage().resetPasswordLinkClick();
        app.registrationPage().fillNewPasswordAndConfirm();

    }

    @Test(priority = 4, dependsOnMethods = {"resetPassword"})
    public void loginWithNewPassword() throws InterruptedException {
        app.registrationPage().openSignInPage();
        app.registrationPage().clickOnEmailField();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().fillNewPasswordField();
        app.registrationPage().submitTheForm();
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();

    }

    @Test(priority = 5)
    public void registerEmailThatAlreadyUsed() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().clickOnEmailField();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().acceptTermsCheckbox();
        app.registrationPage().clickSignUpButton();
        assertTrue(app.registrationPage().userAlreadyExistMessageDisplayed());

    }


}
