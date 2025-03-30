package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.WindowLocators;

public class WindowPage extends BasePage{

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithTab() {
        elementHelper.clickLocator(WindowLocators.newTabElement);
        System.out.println("URL-ul curent este: " + driver.getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switched to another Tab.");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closed the new Tab.");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switched to the first Tab.");
    }

    public void interactWithNewWindow() {
        elementHelper.clickLocator(WindowLocators.newWindowElement);
        System.out.println("URL-ul curent este: " + driver.getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        LoggerUtility.infoLog("The user switched to another Tab in a new Window.");
        tabHelper.closeCurrentTab();
        LoggerUtility.infoLog("The user closed the new Window Tab.");
        tabHelper.switchToSpecificTab(0);
        LoggerUtility.infoLog("The user switched to the first Window Tab.");
    }
}
