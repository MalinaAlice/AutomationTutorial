package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PracticeFormModel {

    private String firstNameValue;
    private String lastNameValue;
    private String emailValue;
    private String genderValue;
    private String mobileNumberValue;
    private List<String> subjectValues;
    private List<String> hobbyValues;
    private String chooseFilePicture;
    private String currentAddressValue;
    private String chooseStateValue;
    private String chooseCityValue;
    private String expectedMessage;

    public PracticeFormModel(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
    }

    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastNameValue() {
        return lastNameValue;
    }

    public void setLastNameValue(String lastNameValue) {
        this.lastNameValue = lastNameValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public void setGenderValue(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getMobileNumberValue() {
        return mobileNumberValue;
    }

    public void setMobileNumberValue(String mobileNumberValue) {
        this.mobileNumberValue = mobileNumberValue;
    }

    public List<String> getSubjectValues() {
        return subjectValues;
    }

    public void setSubjectValues(List<String> subjectValues) {
        this.subjectValues = subjectValues;
    }

    public List<String> getHobbyValues() {
        return hobbyValues;
    }

    public void setHobbyValues(List<String> hobbyValues) {
        this.hobbyValues = hobbyValues;
    }

    public String getChooseFilePicture() {
        return chooseFilePicture;
    }

    public void setChooseFilePicture(String chooseFilePicture) {
        this.chooseFilePicture = chooseFilePicture;
    }

    public String getCurrentAddressValue() {
        return currentAddressValue;
    }

    public void setCurrentAddressValue(String currentAddressValue) {
        this.currentAddressValue = currentAddressValue;
    }

    public String getChooseStateValue() {
        return chooseStateValue;
    }

    public void setChooseStateValue(String chooseStateValue) {
        this.chooseStateValue = chooseStateValue;
    }

    public String getChooseCityValue() {
        return chooseCityValue;
    }

    public void setChooseCityValue(String chooseCityValue) {
        this.chooseCityValue = chooseCityValue;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    public void setExpectedMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }
}
