package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static appmanager.ApplicationManager.tempMailUrl;


public class TempMailPage extends HelperBase {

    public TempMailPage(WebDriver driver) {
        super(driver);
    }

    private By emailMessageLocator = By.xpath("//tbody[@id='schranka']/tr[1]");
    private By emailRegistrationLinkLocator = By.linkText("here");
    private By emailResetLinkLocator = By.linkText("reset link");
    private By emailAddressLocator = By.id("email");

    public void openTempMailPage() {
        open(tempMailUrl);
    }

    public String tempMailEmail() {
        return getElementText(emailAddressLocator);
    }

    public boolean tempMailHasEmail() {
        driver.navigate().refresh();
        return isElementPresent(emailMessageLocator);
    }

    public void emailLinkClick() {
        waitTillElementIsVisible(emailMessageLocator);
        click(emailMessageLocator);
        driver.switchTo().frame(driver.findElement(By.id("iframeMail")));
        click(emailRegistrationLinkLocator);
    }

    public void resetPasswordLinkClick() {
        driver.navigate().refresh();
        driver.findElement(By.linkText("Refresh")).click();
        waitTillElementIsVisible(emailMessageLocator);
        click(emailMessageLocator);
        driver.switchTo().frame(driver.findElement(By.id("iframeMail")));
        click(emailResetLinkLocator);
    }

}
