package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {

    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitForVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    private void waitForVisibleLists(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    private void waitForPresenceList(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void clickJsLocator(By locator) {
        waitForVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void clickJsLocator(WebElement locator) {
        waitForVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", locator);
    }

    public void clickLocator(By locator) {
        waitForVisible(locator);
        driver.findElement(locator).click();
    }

    public void printLocatorText(By locator) {
        waitForVisible(locator);
        System.out.println(driver.findElement(locator).getText());
    }

    public void fillLocator(By locator, String value) {
        waitForVisible(locator);
        driver.findElement(locator).sendKeys(value);
    }

    public List<WebElement> getListElements(By locator) {
        waitForPresenceList(locator);
        return driver.findElements(locator);
    }

    public void fillPressLocator(By locator, String value, Keys key) {
        waitForVisible(locator);
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(key);
    }


    public void changeValue(By locator, String value) {
        waitForVisible(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void validateElementText(By locator, String expectedText, String message) {
        waitForVisible(locator);
        Assert.assertEquals(driver.findElement(locator).getText(), expectedText, message);
    }

    public void validateElementContainsText(WebElement element, String value) {
        waitForVisible(element);
        Assert.assertTrue(element.getText().contains(value));
    }
}
