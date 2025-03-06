package pages;

import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;


public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void clickOnAlertWindowFrameMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsMenu);
    }

    public void clickOnAlertSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsPage);
    }

    public void clickOnFramesSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.framesPage);
    }

    public void clickOnWindowsSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.browserWindowPage);
    }
}
