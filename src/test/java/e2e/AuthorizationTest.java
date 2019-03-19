package e2e;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AuthorizationTest extends TestBase {

    private String email;

    @Test(priority = 1)
    public void successfulRegistration() {
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
        app.registrationPage().fillPasswordAndSignIn();
        assertTrue(app.dashboardPage().questionnairePopupIsDisplayed());
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();
    }

    @Test(priority = 2, dependsOnMethods = {"successfulRegistration"})
    public void successfulLoginAndLogout() {
        app.homePage().openHomePage();
        app.homePage().clickOnLoginButton();
        app.registrationPage().login(email);
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();
        assertTrue(app.homePage().signInButtonIsDisplayed());
    }

    @Test(priority = 3, dependsOnMethods = {"successfulLoginAndLogout"})
    public void resetPasswordAndLogin() {
        app.homePage().openHomePage();
        app.homePage().clickOnLoginButton();
        app.registrationPage().clickOnForgotPassword();
        app.registrationPage().typeEmailAndClickResetButton(email);
        app.tempMailPage().openTempMailPage();
        app.tempMailPage().resetPasswordLinkClick();
        app.registrationPage().fillNewPasswordAndConfirm();
        app.registrationPage().loginWithNewPassword(email);
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();
    }

    @Test(priority = 4)
    public void registerEmailThatAlreadyUsed() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().acceptTermsCheckbox();
        app.registrationPage().clickSignUpButton();

        assertEquals(app.registrationPage().userAlreadyExistMessageDisplayed(), "User already exist!");

    }


}
