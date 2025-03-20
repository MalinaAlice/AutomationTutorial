package tests;

import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest () {

        PracticeFormModel testData = new PracticeFormModel("src/test/resources/testData/PracticeFormData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnPracticeFormSubMenu();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(testData);

        practiceFormPage.validateEntireContent(testData);
    }
}
