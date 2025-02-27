package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest () {

        ElementHelper elementHelper = new ElementHelper(getDriver());

        By formsMenu = By.xpath("//h5[text()='Forms']");
        elementHelper.clickJsLocator(formsMenu);

        By practiceForm = By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJsLocator(practiceForm);

        By firstNameElement = By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = "Alice";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue = "Malina";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By emailElement = By.xpath("//input[@placeholder='name@example.com']");
        String emailValue = "alice@email.com";
        elementHelper.fillLocator(emailElement, emailValue);

        By genderLocator = By.xpath("//label[contains(@for, 'gender-radio')]");
        List<WebElement> genderElement = elementHelper.getListElements(genderLocator);
        String genderValue = "Female";
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

        By mobileNumberElement = By.xpath("//input[@placeholder = 'Mobile Number']");
        String mobileNumberValue = "0762569871";
        elementHelper.fillLocator(mobileNumberElement, mobileNumberValue);

        By subjectElement = By.xpath("//input[@id = 'subjectsInput']");
        List<String> subjectValues = Arrays.asList("Maths", "Arts", "Computer Science");
        for(String subject : subjectValues) {
            elementHelper.fillPressLocator(subjectElement, subject, Keys.ENTER);
        }


        //Folosim metoda de a pune testul 2s pe pauza
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        By hobbiesLocator = By.xpath("//div[@id= 'hobbiesWrapper']//label[@class='custom-control-label']");
        List<WebElement> hobbiesElement = elementHelper.getListElements(hobbiesLocator);
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        for (WebElement hobby : hobbiesElement) {
            if (hobbyValues.contains(hobby.getText())) {
                elementHelper.clickJsLocator(hobby);
            }
        }

        By chooseFileElement = By.cssSelector("input[type='file']");
        String chooseFilePicture = "src/test/resources/poza-cv1.jpeg";
        File file = new File (chooseFilePicture);
        elementHelper.fillLocator(chooseFileElement, file.getAbsolutePath());

        By currentAddressElement = By.cssSelector("#currentAddress");
        String currentAddressValue = "Str. X, Buc., Sect.4";
        elementHelper.fillLocator(currentAddressElement, currentAddressValue);

        By stateElement = By.xpath("//div[text()='Select State']");
        elementHelper.clickJsLocator(stateElement);

        By chooseStateElement = By.cssSelector("#react-select-3-input");
        String chooseStateValue = "Haryana";
        elementHelper.fillPressLocator(chooseStateElement, chooseStateValue, Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJsLocator(cityElement);

        By chooseCityElement = By.cssSelector("#react-select-4-input");
        String chooseCityValue = "Panipat";
        elementHelper.fillPressLocator(chooseCityElement, chooseCityValue, Keys.ENTER);

        By submitButton = By.id("submit");
        elementHelper.clickJsLocator(submitButton);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#example-modal-sizes-title-lg")));


        //Verificam Submitul
        By thankYouElement = By.cssSelector("#example-modal-sizes-title-lg");
        String expectMessage = "Thanks for submitting the form";
        elementHelper.validateElementText(thankYouElement, expectMessage, "Not the expected message.");

        By tableContentListLocator = By.cssSelector(".table>tbody>tr");
        List<WebElement> tableContentList = elementHelper.getListElements(tableContentListLocator);

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
        String fileName = file.getName();
        elementHelper.validateElementContainsText(tableContentList.get(7), fileName);

        elementHelper.validateElementContainsText(tableContentList.get(8), "Address");
        String addressValue = String.join(", ", currentAddressValue);
        elementHelper.validateElementContainsText(tableContentList.get(8), addressValue);


        elementHelper.validateElementContainsText(tableContentList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableContentList.get(9), chooseStateValue + ' ' + chooseCityValue);
    }
}
