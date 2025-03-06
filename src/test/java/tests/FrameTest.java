package tests;

import org.testng.annotations.Test;
import pages.FramePage;
import pages.IndexPage;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowFrameMenu();
        indexPage.clickOnFramesSubMenu();

        FramePage framePage = new FramePage(getDriver());
        framePage.interactWithFirstIFrame();
        framePage.interactWithSecondIFrame();

    }

}
