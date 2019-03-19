package registration;

import appmanager.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InvalidEmailTest extends TestBase {

    @Test
    public void inputInvalidEmail() {
        app.registrationPage().openRegistrationPage();
//        app.registrationPage().acceptCookiesButtonClick();
        app.registrationPage().fillFirstnameField();
        app.registrationPage().fillLastnameField();
        app.registrationPage().fillEmailField("email@email");
        app.registrationPage().acceptTermsCheckbox();
        assertFalse(app.registrationPage().signUpButtonIsDisabled());
    }

}
