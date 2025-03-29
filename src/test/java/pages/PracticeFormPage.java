package pages;

import loggerUtility.LoggerUtility;
import modelObject.PracticeFormModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.PracticeFormLocators;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void populateEntireForm(PracticeFormModel testData) {
        elementHelper.fillLocator(PracticeFormLocators.firstNameElement, testData.getFirstNameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstNameValue());

        elementHelper.fillLocator(PracticeFormLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());

        elementHelper.fillLocator(PracticeFormLocators.emailElement, testData.getEmailValue());
        LoggerUtility.infoLog("The user fills Email with value: " + testData.getEmailValue());


        List<WebElement> genderElement = elementHelper.getListElements(PracticeFormLocators.genderLocator);
        switch (testData.getGenderValue()) {
            case "Male":
                elementHelper.clickJsLocator(genderElement.get(0));
                break;
            case "Female":
                elementHelper.clickJsLocator(genderElement.get(1));
                break;
            case "Other":
                elementHelper.clickJsLocator(genderElement.get(2));
                break;
        }
        LoggerUtility.infoLog("The user fills Gender with value: " + testData.getGenderValue());

        elementHelper.fillLocator(PracticeFormLocators.mobileNumberElement, testData.getMobileNumberValue());

        for (String subject : testData.getSubjectValues()) {
            elementHelper.fillPressLocator(PracticeFormLocators.subjectElement, subject, Keys.ENTER);
        }
        LoggerUtility.infoLog("The user choose these Subjects: " + testData.getSubjectValues());

        List<WebElement> hobbiesElement = elementHelper.getListElements(PracticeFormLocators.hobbiesLocator);
        for (WebElement hobby : hobbiesElement) {
            if (testData.getHobbyValues().contains(hobby.getText())) {
                elementHelper.clickJsLocator(hobby);
            }
        }
        LoggerUtility.infoLog("The user choose these Hobbies: " + testData.getHobbyValues());

        File file = new File(testData.getChooseFilePicture());
        elementHelper.fillLocator(PracticeFormLocators.chooseFileElement, file.getAbsolutePath());
        LoggerUtility.infoLog("The user uploads the file: " + testData.getChooseFilePicture());

        elementHelper.fillLocator(PracticeFormLocators.currentAddressElement, testData.getCurrentAddressValue());
        LoggerUtility.infoLog("The user's Address is: " + testData.getCurrentAddressValue());

        elementHelper.clickJsLocator(PracticeFormLocators.stateElement);

        elementHelper.fillPressLocator(PracticeFormLocators.chooseStateElement, testData.getChooseStateValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user's State is: " + testData.getChooseStateValue());

        elementHelper.clickJsLocator(PracticeFormLocators.cityElement);

        elementHelper.fillPressLocator(PracticeFormLocators.chooseCityElement, testData.getChooseCityValue(), Keys.ENTER);
        LoggerUtility.infoLog("The user's City is: " + testData.getChooseCityValue());

        elementHelper.clickJsLocator(PracticeFormLocators.submitButton);
    }

    public void validateEntireContent(PracticeFormModel testData) {

        elementHelper.validateElementText(PracticeFormLocators.thankYouElement, testData.getExpectedMessage(), "Not the expected message.");

        List<WebElement> tableContentList = elementHelper.getListElements(PracticeFormLocators.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), testData.getFirstNameValue() + ' ' + testData.getLastNameValue());
        LoggerUtility.infoLog("Validate the First and Last Name: " + testData.getFirstNameValue() + " " + testData.getLastNameValue());

        elementHelper.validateElementContainsText(tableContentList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), testData.getEmailValue());
        LoggerUtility.infoLog("Validate the Email: " + testData.getEmailValue());

        elementHelper.validateElementContainsText(tableContentList.get(2), "Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), testData.getGenderValue());
        LoggerUtility.infoLog("Validate the Gender: " + testData.getGenderValue());

        elementHelper.validateElementContainsText(tableContentList.get(3), "Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), testData.getMobileNumberValue());
        LoggerUtility.infoLog("Validate the Mobile: " + testData.getMobileNumberValue());

        elementHelper.validateElementContainsText(tableContentList.get(5), "Subjects");
        String subjectValue = String.join(", ", testData.getSubjectValues());
        elementHelper.validateElementContainsText(tableContentList.get(5), subjectValue);
        LoggerUtility.infoLog("Validate the Subjects: " + testData.getSubjectValues());

        elementHelper.validateElementContainsText(tableContentList.get(6), "Hobbies");
        String hobbyValue = String.join(", ", testData.getHobbyValues());
        elementHelper.validateElementContainsText(tableContentList.get(6), hobbyValue);
        LoggerUtility.infoLog("Validate the Hobbies: " + testData.getHobbyValues());

        elementHelper.validateElementContainsText(tableContentList.get(7), "Picture");
        File file = new File(testData.getChooseFilePicture());
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);
        LoggerUtility.infoLog("Validate the File: " + testData.getChooseFilePicture());

        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        String addressValue = String.join(", ", testData.getCurrentAddressValue());
        elementHelper.validateElementContainsText(tableContentList.get(8), addressValue);
        LoggerUtility.infoLog("Validate the Address: " + testData.getCurrentAddressValue());


        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), testData.getChooseStateValue() + ' ' + testData.getChooseCityValue());
        LoggerUtility.infoLog("Validate the State and City: " + testData.getChooseStateValue() + " " + testData.getChooseCityValue());
    }
}
