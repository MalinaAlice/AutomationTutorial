package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestGoogleSearch {
    public WebDriver driver;

    @Test
    public void testMethod() throws InterruptedException {
        searchGoogle();
    }

    public void searchGoogle() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        //Thread.sleep(2000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("W0wltc")));

        WebElement respingeTot = driver.findElement(By.xpath("//div[text()='Respinge tot']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", respingeTot);
        //respingeTot.click();

        //Thread.sleep(1000);
        WebElement searchElement = driver.findElement(By.id("APjFqb"));
        String searchValue = "Youtube.com";
        searchElement.sendKeys(searchValue);
        searchElement.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
