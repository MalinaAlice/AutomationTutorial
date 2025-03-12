package pages;

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
