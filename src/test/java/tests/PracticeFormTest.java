package tests;

import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import sharedData.SharedData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest () {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickOnFormsMenu();
        indexPage.clickOnPracticeFormSubMenu();



        String firstNameValue = "Alice";
        String lastNameValue = "Malina";
        String emailValue = "alice@email.com";
        String genderValue = "Female";
        String mobileNumberValue = "0762569871";
        List<String> subjectValues = Arrays.asList("Maths", "Arts", "Computer Science");
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        String chooseFilePicture = "src/test/resources/poza-cv1.jpeg";
        File file = new File (chooseFilePicture);
        String currentAddressValue = "Str. X, Buc., Sect.4";
        String chooseStateValue = "Haryana";
        String chooseCityValue = "Panipat";
        String expectedMessage = "Thanks for submitting the form";


        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.populateEntireForm(firstNameValue, lastNameValue, emailValue, genderValue,
                mobileNumberValue, subjectValues,hobbyValues, chooseFilePicture, currentAddressValue,
                chooseStateValue, chooseCityValue);

        practiceFormPage.validateEntireContent(expectedMessage, firstNameValue, lastNameValue, emailValue, genderValue,  mobileNumberValue, subjectValues,
                hobbyValues, chooseFilePicture, currentAddressValue, chooseStateValue, chooseCityValue);
    }
}
