package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;


public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAlertWindowFrameMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsMenu);
        LoggerUtility.infoLog("The user clicked on Alert Window Menu.");
    }

    public void clickOnAlertSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.alertsPage);
        LoggerUtility.infoLog("The user clicked on Alert Window SubMenu.");
    }

    public void clickOnFramesSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.framesPage);
        LoggerUtility.infoLog("The user clicked on Frame Window SubMenu.");
    }

    public void clickOnWindowsSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.browserWindowPage);
        LoggerUtility.infoLog("The user clicked on Windows SubMenu.");
    }

    public void clickOnFormsMenu() {
        elementHelper.clickJsLocator(IndexLocators.formsMenu);
        LoggerUtility.infoLog("The user clicked on Forms Window Menu.");
    }

    public void clickOnPracticeFormSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.practiceForm);
        LoggerUtility.infoLog("The user clicked on Practice Form Window SubMenu.");
    }

    public void clickOnElementsMenu() {
        elementHelper.clickJsLocator(IndexLocators.elementsMenu);
        LoggerUtility.infoLog("The user clicked on Elements Window Menu.");
    }

    public void clickOnWebTablesSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.webTables);
        LoggerUtility.infoLog("The user clicked on Web Tables Window SubMenu.");
    }
}
