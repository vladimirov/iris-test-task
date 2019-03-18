package ui;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class RequiredFieldsTest extends TestBase {

    @Test(priority = 1)
    public void firstnameInputFieldIsRequired() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().acceptCookiesButtonClick();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField(System.currentTimeMillis() + "@email.com");
        app.registrationPage().acceptTermsCheckbox();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

    @Test (priority = 2)
    public void lastnameInputFieldIsRequired() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField(System.currentTimeMillis() + "@email.com");
        app.registrationPage().acceptTermsCheckbox();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

    @Test(priority = 3)
    public void emailInputFieldIsRequired() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().acceptTermsCheckbox();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

}

