package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static appmanager.ApplicationManager.tempMailUrl;

public class TempMailPage extends HelperBase {

    public TempMailPage(WebDriver driver) {
        super(driver);
    }

    private By emailMessageLocator = By.id("schranka");
    private By emailLinkLocator = By.linkText("here");

    public void openTempMailPage() {
        driver.get(tempMailUrl);
    }

    public String tempMailEmail(){
        return getElementText(By.id("email"));
    }

    public boolean tempMailHasEmail(){
        return isElementPresent(emailMessageLocator);
    }

    public void emailLinkClick(){
        click(emailMessageLocator);
        driver.switchTo().frame(driver.findElement(By.id("iframeMail")));
        driver.findElement(By.partialLinkText("the.iris.ai")).click();
//        click(emailLinkLocator);
    }



}
