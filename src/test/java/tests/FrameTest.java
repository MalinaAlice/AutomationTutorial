package tests;

import org.testng.annotations.Test;
import pages.FramePage;
import pages.IndexPage;
import sharedData.SharedData;
import suites.TestCaseSuite;
import suites.TestSuite;

public class FrameTest extends SharedData {

    @Test (groups = {TestSuite.REGRESSION_SUITE, TestSuite.ALERT_FRAME_SUITE, TestCaseSuite.TICKET_123, TestCaseSuite.TC_457})
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowFrameMenu();
        indexPage.clickOnFramesSubMenu();

        FramePage framePage = new FramePage(getDriver());
        framePage.interactWithFirstIFrame();
        framePage.interactWithSecondIFrame();

    }

}
