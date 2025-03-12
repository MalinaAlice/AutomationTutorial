package pages;

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

    public void populateEntireForm(String firstNameValue, String lastNameValue, String emailValue, String genderValue,
                                   String mobileNumberValue, List<String> subjectValues,
                                   List<String> hobbyValues, String chooseFilePicture, String currentAddressValue,
                                   String chooseStateValue, String chooseCityValue) {
        elementHelper.fillLocator(PracticeFormLocators.firstNameElement, firstNameValue);

        elementHelper.fillLocator(PracticeFormLocators.lastNameElement, lastNameValue);

        elementHelper.fillLocator(PracticeFormLocators.emailElement, emailValue);


        List<WebElement> genderElement = elementHelper.getListElements(PracticeFormLocators.genderLocator);
        switch (genderValue) {
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

        elementHelper.fillLocator(PracticeFormLocators.mobileNumberElement, mobileNumberValue);

        for(String subject : subjectValues) {
            elementHelper.fillPressLocator(PracticeFormLocators.subjectElement, subject, Keys.ENTER);
        }

        List<WebElement> hobbiesElement = elementHelper.getListElements(PracticeFormLocators.hobbiesLocator);
        for (WebElement hobby : hobbiesElement) {
            if (hobbyValues.contains(hobby.getText())) {
                elementHelper.clickJsLocator(hobby);
            }
        }

        File file = new File (chooseFilePicture);
        elementHelper.fillLocator(PracticeFormLocators.chooseFileElement, file.getAbsolutePath());

        elementHelper.fillLocator(PracticeFormLocators.currentAddressElement, currentAddressValue);

        elementHelper.clickJsLocator(PracticeFormLocators.stateElement);

        elementHelper.fillPressLocator(PracticeFormLocators.chooseStateElement, chooseStateValue, Keys.ENTER);

        elementHelper.clickJsLocator(PracticeFormLocators.cityElement);

        elementHelper.fillPressLocator(PracticeFormLocators.chooseCityElement, chooseCityValue, Keys.ENTER);

        elementHelper.clickJsLocator(PracticeFormLocators.submitButton);
    }

    public void validateEntireContent(String expectMessage, String firstNameValue, String lastNameValue, String emailValue, String genderValue,
                                      String mobileNumberValue, List<String> subjectValues,
                                      List<String> hobbyValues, String chooseFilePicture, String currentAddressValue,
                                      String chooseStateValue, String chooseCityValue) {

        elementHelper.validateElementText(PracticeFormLocators.thankYouElement, expectMessage, "Not the expected message.");

        List<WebElement> tableContentList = elementHelper.getListElements(PracticeFormLocators.tableContentListLocator);

        elementHelper.validateElementContainsText(tableContentList.get(0), "Student Name");
        elementHelper.validateElementContainsText(tableContentList.get(0), firstNameValue + ' ' + lastNameValue);

        elementHelper.validateElementContainsText(tableContentList.get(1), "Student Email");
        elementHelper.validateElementContainsText(tableContentList.get(1), emailValue);

        elementHelper.validateElementContainsText(tableContentList.get(2), "Gender");
        elementHelper.validateElementContainsText(tableContentList.get(2), genderValue);

        elementHelper.validateElementContainsText(tableContentList.get(3), "Mobile");
        elementHelper.validateElementContainsText(tableContentList.get(3), mobileNumberValue);

        elementHelper.validateElementContainsText(tableContentList.get(5), "Subjects");
        String subjectValue = String.join(", ", subjectValues);
        elementHelper.validateElementContainsText(tableContentList.get(5), subjectValue);

        elementHelper.validateElementContainsText(tableContentList.get(6), "Hobbies");
        String hobbyValue = String.join(", ", hobbyValues);
        elementHelper.validateElementContainsText(tableContentList.get(6), hobbyValue);

        elementHelper.validateElementContainsText(tableContentList.get(7), "Picture");
        File file = new File(chooseFilePicture);
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        String addressValue = String.join(", ", currentAddressValue);
        elementHelper.validateElementContainsText(tableContentList.get(8), addressValue);


        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), chooseStateValue + ' ' + chooseCityValue);
    }
}
