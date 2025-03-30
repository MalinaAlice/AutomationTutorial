package tests;

import modelObject.WebTablesModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablesPage;
import sharedData.SharedData;
import suites.TestCaseSuite;
import suites.TestSuite;

public class WebTablesTest extends SharedData {
    @Test (groups = {TestSuite.REGRESSION_SUITE, TestSuite.ELEMENTS_SUITE, TestCaseSuite.TICKET_123, TestCaseSuite.TC_459})
    public void testMethod () {

        WebTablesModel testData = new WebTablesModel("src/test/resources/testData/WebTablesData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnElementsMenu();
        indexPage.clickOnWebTablesSubMenu();

        //add
        WebTablesPage webTablesPage = new WebTablesPage(getDriver());
        webTablesPage.addNewEntry(testData);

        //edit
        webTablesPage.editNewEntry(testData);

        //Delete information
        webTablesPage.deleteNewEntry(testData);
    }

}
