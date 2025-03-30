package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WindowPage;
import sharedData.SharedData;
import suites.TestCaseSuite;
import suites.TestSuite;

public class WindowTest extends SharedData{

    @Test (groups = {TestSuite.REGRESSION_SUITE, TestSuite.FORM_SUITE, TestCaseSuite.TICKET_321, TestCaseSuite.TC_466})
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
