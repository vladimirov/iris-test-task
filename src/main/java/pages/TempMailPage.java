package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.tempMailUrl;


public class TempMailPage extends HelperBase {

    public TempMailPage(WebDriver driver) {
        super(driver);
    }

//    private By emailMessageLocator = By.id("schranka");
    private By emailMessageLocator = By.xpath("//tbody[@id='schranka']/tr[1]");
    private By emailLinkLocator = By.linkText("here");
    private By resetPasswordLinkLocator = By.linkText("reset link");
    private By emailAddressLocator = By.id("email");


    public void openTempMailPage() {
        driver.get(tempMailUrl);
    }

    public String tempMailEmail() {
        return getElementText(emailAddressLocator);
    }

    public boolean tempMailHasEmail() {
        return isElementPresent(emailMessageLocator);
    }

    public void emailLinkClick() {
        waitTillElementIsVisible(emailMessageLocator);
        click(emailMessageLocator);
        driver.switchTo().frame(driver.findElement(By.id("iframeMail")));
        click(emailLinkLocator);
    }

    public void resetPasswordLinkClick() {
        waitTillElementIsVisible(emailMessageLocator);
        click(emailMessageLocator);
        driver.switchTo().frame(driver.findElement(By.id("iframeMail")));
        click(resetPasswordLinkLocator);
    }

}
