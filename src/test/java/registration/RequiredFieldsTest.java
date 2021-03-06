package registration;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class RequiredFieldsTest extends TestBase {

    @Test(priority = 1)
    public void firstnameInputFieldIsRequired() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField(System.currentTimeMillis() + "@email.com");
        app.registrationPage().acceptTermsCheckbox();
        app.registrationPage().scrollToSignUpButton();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

    @Test (priority = 2)
    public void lastnameInputFieldIsRequired() {
        app.registrationPage().reloadPage();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillEmailField(System.currentTimeMillis() + "@email.com");
        app.registrationPage().acceptTermsCheckbox();
        app.registrationPage().scrollToSignUpButton();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

    @Test(priority = 3)
    public void emailInputFieldIsRequired() {
        app.registrationPage().reloadPage();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().acceptTermsCheckbox();
        app.registrationPage().scrollToSignUpButton();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

}

