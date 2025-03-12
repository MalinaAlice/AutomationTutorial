package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablesPage;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {
    @Test
    public void metodaTest () {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnElementsMenu();
        indexPage.clickOnWebTablesSubMenu();

        String firstNameValue = "Alice";
        String lastNameValue = "Malina";
        String emailValue = "alice.email@gmail.com";
        String ageValue = "24";
        String salaryValue = "5500";
        String departmentValue = "Quality Assurance";

        WebTablesPage webTablesPage = new WebTablesPage(getDriver());
        webTablesPage.addNewEntry(firstNameValue, lastNameValue, emailValue, ageValue, salaryValue, departmentValue, 4);

        //Edit Functionality
        String salaryChangedValue = "6000";
        String departmentChangedValue = "QA Automation";
        String emailChangedValue = "alice.email18@gmail.com";
        webTablesPage.editNewEntry(salaryChangedValue, departmentChangedValue, emailChangedValue, 4);

        //Delete information
        webTablesPage.deleteNewEntry(3);
    }

}
