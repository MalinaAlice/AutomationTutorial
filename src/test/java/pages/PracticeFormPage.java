package pages;

import modelObject.PracticeFormModel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.PracticeFormLocators;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void populateEntireForm(PracticeFormModel testData) {
        elementHelper.fillLocator(PracticeFormLocators.firstNameElement, testData.getFirstNameValue());

        elementHelper.fillLocator(PracticeFormLocators.lastNameElement, testData.getLastNameValue());

        elementHelper.fillLocator(PracticeFormLocators.emailElement, testData.getEmailValue());


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

        elementHelper.fillLocator(PracticeFormLocators.mobileNumberElement, testData.getMobileNumberValue());

        for(String subject : testData.getSubjectValues()) {
            elementHelper.fillPressLocator(PracticeFormLocators.subjectElement, subject, Keys.ENTER);
        }

        List<WebElement> hobbiesElement = elementHelper.getListElements(PracticeFormLocators.hobbiesLocator);
        for (WebElement hobby : hobbiesElement) {
            if (testData.getHobbyValues().contains(hobby.getText())) {
                elementHelper.clickJsLocator(hobby);
            }
        }

        File file = new File (testData.getChooseFilePicture());
        elementHelper.fillLocator(PracticeFormLocators.chooseFileElement, file.getAbsolutePath());

        elementHelper.fillLocator(PracticeFormLocators.currentAddressElement, testData.getCurrentAddressValue());

        elementHelper.clickJsLocator(PracticeFormLocators.stateElement);

        elementHelper.fillPressLocator(PracticeFormLocators.chooseStateElement, testData.getChooseStateValue(), Keys.ENTER);

        elementHelper.clickJsLocator(PracticeFormLocators.cityElement);

        elementHelper.fillPressLocator(PracticeFormLocators.chooseCityElement, testData.getChooseCityValue(), Keys.ENTER);

        elementHelper.clickJsLocator(PracticeFormLocators.submitButton);
    }

    public void validateEntireContent(PracticeFormModel testData) {

        elementHelper.validateElementText(PracticeFormLocators.thankYouElement, testData.getExpectedMessage(), "Not the expected message.");

        List<WebElement> tableContentList = elementHelper.getListElements(PracticeFormLocators.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), testData.getFirstNameValue() + ' ' + testData.getLastNameValue());

        elementHelper.validateElementContainsText(tableContentList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), testData.getEmailValue());

        elementHelper.validateElementContainsText(tableContentList.get(2), "Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), testData.getGenderValue());

        elementHelper.validateElementContainsText(tableContentList.get(3), "Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), testData.getMobileNumberValue());

        elementHelper.validateElementContainsText(tableContentList.get(5), "Subjects");
        String subjectValue = String.join(", ", testData.getSubjectValues());
        elementHelper.validateElementContainsText(tableContentList.get(5), subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6), "Hobbies");
        String hobbyValue = String.join(", ", testData.getHobbyValues());
        elementHelper.validateElementContainsText(tableContentList.get(6), hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7), "Picture");
        File file = new File(testData.getChooseFilePicture());
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        String addressValue = String.join(", ", testData.getCurrentAddressValue());
        elementHelper.validateElementContainsText(tableContentList.get(8), addressValue);


        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), testData.getChooseStateValue() + ' ' + testData.getChooseCityValue());
    }
}
