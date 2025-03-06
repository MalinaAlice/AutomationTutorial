package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WindowPage;
import sharedData.SharedData;

public class WindowTest extends SharedData{

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowFrameMenu();
        indexPage.clickOnWindowsSubMenu();

        WindowPage windowPage = new WindowPage(getDriver());
        //NewTab
        windowPage.interactWithTab();

        //NewWindow
        windowPage.interactWithNewWindow();
    }
}
