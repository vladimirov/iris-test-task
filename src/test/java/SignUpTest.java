import appmanager.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest extends TestBase {

    private String email;

    @BeforeTest
    public void generateTempEmail(){
        app.tempMailPage().openTempMailPage();
        email = app.tempMailPage().tempMailEmail();
    }

    @Test
    public void successfulRegistration(){
        app.signUpPage().openBasePage();
        app.signUpPage().clickOnRegisterButton();
        app.signUpPage().fillNameFields();
        app.signUpPage().fillEmailField(email);
        app.signUpPage().acceptTermsAndClickSignUp();
        assertTrue(app.signUpPage().awesomeTextIsDisplayed());
        app.tempMailPage().openTempMailPage();
        assertTrue(app.tempMailPage().tempMailHasEmail());
        app.tempMailPage().emailLinkClick();

        app.signUpPage().fillPasswordAndConfirm();

        app.signUpPage().fillEmailField(email);
        app.signUpPage().fillPasswordAndSignIn();

    }

}
