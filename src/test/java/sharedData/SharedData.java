package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;
    private String testName;

    @BeforeMethod (alwaysRun = true)
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTest(testName);

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod (alwaysRun = true)
    public void clearEnvironment() {
        driver.quit();
        LoggerUtility.finishTest(testName);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
