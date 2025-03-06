package pages;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.WindowLocators;

public class WindowPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private TabHelper tabHelper;

    public WindowPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        tabHelper = new TabHelper(driver);
    }

    public void interactWithTab() {
        elementHelper.clickLocator(WindowLocators.newTabElement);
        System.out.println("URL-ul curent este: " + driver.getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }

    public void interactWithNewWindow() {
        elementHelper.clickLocator(WindowLocators.newWindowElement);
        System.out.println("URL-ul curent este: " + driver.getCurrentUrl());

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
