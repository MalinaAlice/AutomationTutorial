package tests;

import modelObject.WebTablesModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablesPage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {
    @Test
    public void metodaTest () {

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
