package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestGoogleSearch {
    public WebDriver driver;

    @Test
    public void testMethod() throws InterruptedException {
        searchGoogle();
    }

    public void searchGoogle() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        //Thread.sleep(2000);
        WebElement respingeTot = driver.findElement(By.id("W0wltc"));
        respingeTot.click();

        //Thread.sleep(1000);
        WebElement searchElement = driver.findElement(By.id("APjFqb"));
        String searchValue = "Youtube.com";
        searchElement.sendKeys(searchValue);
        searchElement.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
