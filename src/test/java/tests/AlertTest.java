package tests;

import modelObject.AlertModel;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void testMethod() {

        AlertModel testData = new AlertModel("src/test/resources/testData/AlertData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnAlertWindowFrameMenu();
        indexPage.clickOnAlertSubMenu();

        AlertPage alertPage = new AlertPage(getDriver());
        //Alert OK
        alertPage.interactWithAcceptAlert();

        //Time Alert
        alertPage.interactWithTimerAlert();

        //Cancel Alert
        alertPage.interactWithCancelAlert();

        //Name Alert
        alertPage.interactWithValueAlert(testData);
    }
}
