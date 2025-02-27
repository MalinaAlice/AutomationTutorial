package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData{

    @Test
    public void testMethod() {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement alertsMenu = getDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        js.executeScript("arguments[0].click();", alertsMenu);


        WebElement browserWindowPage = getDriver().findElement(By.xpath("//span[text()='Browser Windows']"));
        js.executeScript("arguments[0].click();", browserWindowPage);

        browserWindow();
    }

    public void browserWindow() {
        //NewTab
        WebElement newTabElement = getDriver().findElement(By.id("tabButton"));
        newTabElement.click();
        System.out.println("URL-ul curent este: " + getDriver().getCurrentUrl());

        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        System.out.println("URL-ul curent este: " + getDriver().getCurrentUrl());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));

        //NewWindow
        WebElement newWindowElement = getDriver().findElement(By.id("windowButton"));
        newWindowElement.click();
        System.out.println("URL-ul curent este: " + getDriver().getCurrentUrl());

        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(1));
        System.out.println("URL-ul curent este: " + getDriver().getCurrentUrl());
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));
    }
}
