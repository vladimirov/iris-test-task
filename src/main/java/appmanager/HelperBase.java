package appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HelperBase {

    private Logger logger = LoggerFactory.getLogger(HelperBase.class);
    protected WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;


    public HelperBase(WebDriver driver) {
        this.driver = driver;
        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    protected void click(By locator) {
        logger.info("CLICK ON ELEMENT: " + locator);
        try {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
        }
    }

    protected void type(By locator, String text) {
        logger.info("SEND TO " + locator + " KEYS " + text);
        try {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
            element.sendKeys(text);
        } catch (StaleElementReferenceException ignored) {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
            element.sendKeys(text);
        }
    }

    protected void waitToBePresent(By locator) {
        try {
            logger.info("ELEMENT HAS BEEN FOUND: " + locator);
            element = wait.until(visibilityOfElementLocated(locator));
        } catch (NullPointerException ignored) {
            logger.info("ELEMENT HAS BEEN FOUND: " + locator);
            element = wait.until(presenceOfElementLocated(locator));
        }
    }

    public void waitTillElementIsClickable(By locator) {
        logger.info("WAITING TILL ELEMENT IS CLICKABLE: " + locator);
        try {
            element = wait.until(elementToBeClickable(locator));
        } catch (TimeoutException e) {
            logger.info("ELEMENT IS CLICKABLE: " + locator);
            element = wait.until(elementToBeClickable(locator));
        }
    }

    protected void waitTillElementIsVisible(By locator) {
        logger.info("WAITING TILL ELEMENT IS VISIBLE: " + locator);
        try {
            logger.info("ELEMENT IS VISIBLE: " + locator);
            element = wait.until(visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            logger.info("ELEMENT IS VISIBLE: " + locator);
            element = wait.until(visibilityOfElementLocated(locator));
        }
    }

    protected void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    protected boolean isElementPresent(By locator) {
        logger.info("TRYING TO FOUND ELEMENT: " + locator);
        element = wait.until(presenceOfElementLocated(locator));
        logger.info("ELEMENT HAS BEEN FOUND: " + locator);
        return true;
    }

    protected boolean textIsDisplayed(By locator, String text) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(presenceOfElementLocated(locator));
        logger.info("ACTUAL TEXT:   " + element.getText());
        logger.info("EXPECTED TEXT: " + text);
        return element.getText().equals(text);
    }

    protected boolean elementHasAttribute(By locator, String attribute, String value) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        logger.info("ACTUAL VALUE:   " + element.getAttribute(attribute));
        logger.info("EXPECTED VALUE: " + value);
        return element.getAttribute(attribute).equals(value);
    }

    protected String getElementText(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getText();
    }

    protected void scrollTillElementIsVisible(By locator) {
        logger.info("SCROLL TILL ELEMENT IS VISIBLE: " + locator);
        element = wait.until(presenceOfElementLocated(locator));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void switchToNewTab() {
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
    }

    protected boolean isClickable(By locator) {
        logger.info("CHECK IF ELEMENT IS CLICKABLE " + locator);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            element = wait.until(elementToBeClickable(locator));
            logger.info("ELEMENT IS CLICKABLE: " + locator);
            return true;
        } catch (Exception e) {
            logger.info("ELEMENT IS NOT CLICKABLE: " + locator);
            return false;
        }
    }

    protected void open(String url) {
        logger.info("OPEN URL: " + url);
        driver.get(url);
    }

}

