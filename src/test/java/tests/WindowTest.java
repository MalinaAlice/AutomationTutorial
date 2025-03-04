package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
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

        ElementHelper elementHelper = new ElementHelper(getDriver());
        TabHelper tabHelper = new TabHelper(getDriver());

        By alertsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickLocator(alertsMenu);

        By browserWindowPage = By.xpath("//span[text()='Browser Windows']");
        elementHelper.clickJsLocator(browserWindowPage);

        //NewTab
        By newTabElement = By.id("tabButton");
        elementHelper.clickLocator(newTabElement);
        System.out.println("URL-ul curent este: " + getDriver().getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        //NewWindow
        By newWindowElement = By.id("windowButton");
        elementHelper.clickLocator(newWindowElement);
        System.out.println("URL-ul curent este: " + getDriver().getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
