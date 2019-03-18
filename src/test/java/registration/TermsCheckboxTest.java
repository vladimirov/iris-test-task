package registration;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class TermsCheckboxTest extends TestBase {

    @Test
    public void termsCheckboxIsRequired() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().acceptCookiesButtonClick();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField(System.currentTimeMillis() + "@email.com");
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

}