package pages;

import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;


public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
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

    public void clickOnFormsMenu() { elementHelper.clickJsLocator(IndexLocators.formsMenu);}

    public void clickOnPracticeFormSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.practiceForm);
    }

    public void clickOnElementsMenu() {
        elementHelper.clickJsLocator(IndexLocators.elementsMenu);
    }

    public void clickOnWebTablesSubMenu() {
        elementHelper.clickJsLocator(IndexLocators.webTables);
    }
}
