import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AuthorizationTest extends TestBase {

    private String email;

    @Test(priority = 1)
    public void successfulRegistration() {
        app.tempMailPage().openTempMailPage();
        email = app.tempMailPage().tempMailEmail();
        app.basePage().openBasePage();
        app.registrationPage().clickOnRegisterButton();
        app.registrationPage().fillNameFields();
        app.registrationPage().fillEmailField(email);
        app.registrationPage().acceptTermsAndClickSignUp();
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
        app.basePage().openBasePage();
        app.basePage().clickOnLoginButton();
        app.registrationPage().login(email);
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
        app.dashboardPage().clickOnLogoutButton();
        assertTrue(app.basePage().signInButtonIsDisplayed());
    }

    @Test(priority = 3, dependsOnMethods = {"successfulLoginAndLogout"})
    public void resetPasswordAndLogin(){
        app.basePage().openBasePage();
        app.basePage().clickOnLoginButton();
        app.registrationPage().clickOnForgotPassword();
        app.registrationPage().typeEmailAndClickResetButton(email);
        app.tempMailPage().openTempMailPage();
        app.tempMailPage().resetPasswordLinkClick();
        app.registrationPage().fillNewPasswordAndConfirm();
        app.registrationPage().loginWithNewPassword(email);
        app.dashboardPage().clickOnUserInfoButton();
        assertTrue(app.dashboardPage().personalInfoIsDisplayed());
    }

}
