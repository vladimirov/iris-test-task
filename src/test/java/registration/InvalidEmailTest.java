package registration;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InvalidEmailTest extends TestBase {

    @Test
    public void successfulRegistration() {
        app.registrationPage().openRegistrationPage();
        app.registrationPage().acceptCookiesButtonClick();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        String invalidEmail = "email@email";
        app.registrationPage().fillEmailField(invalidEmail);
        app.registrationPage().acceptTermsCheckbox();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

}
