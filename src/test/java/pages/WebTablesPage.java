package pages;

import loggerUtility.LoggerUtility;
import modelObject.WebTablesModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTablesLocators;

import java.util.List;

public class WebTablesPage extends BasePage{

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }


    public void addNewEntry(WebTablesModel testData) {
        elementHelper.clickLocator(WebTablesLocators.addElement);
        LoggerUtility.infoLog("The user adds a new data.");
        elementHelper.fillLocator(WebTablesLocators.firstNameElement, testData.getFirstnameValue());
        LoggerUtility.infoLog("The user fills First Name with value: " + testData.getFirstnameValue());
        elementHelper.fillLocator(WebTablesLocators.lastNameElement, testData.getLastNameValue());
        LoggerUtility.infoLog("The user fills Last Name with value: " + testData.getLastNameValue());
        elementHelper.fillLocator(WebTablesLocators.emailElement, testData.getEmailValue());
        LoggerUtility.infoLog("The user fills Email with value: " + testData.getEmailValue());
        elementHelper.fillLocator(WebTablesLocators.ageElement, testData.getAgeValue());
        LoggerUtility.infoLog("The user fills Age with value: " + testData.getAgeValue());
        elementHelper.fillLocator(WebTablesLocators.salaryElement, testData.getSalaryValue());
        LoggerUtility.infoLog("The user fills Salary with value: " + testData.getSalaryValue());
        elementHelper.fillLocator(WebTablesLocators.departmentElement, testData.getDepartmentValue());
        LoggerUtility.infoLog("The user fills Department with value: " + testData.getDepartmentValue());
        elementHelper.clickLocator(WebTablesLocators.submitElement);
        LoggerUtility.infoLog("The user submits the new data.");

        //Validam ca avem 4 randuri in tabel
        elementHelper.validateSizeList(WebTablesLocators.addTableElement, testData.getNewTableSize());
        LoggerUtility.infoLog("Validates the size of the table: " + testData.getNewTableSize());

        //Validam continutul tabelului
        List<WebElement> addTableElementList = driver.findElements(WebTablesLocators.addTableElement);
        String rowText = addTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(rowText.contains(testData.getFirstnameValue()));
        Assert.assertTrue(rowText.contains(testData.getLastNameValue()));
        Assert.assertTrue(rowText.contains(testData.getEmailValue()));
        Assert.assertTrue(rowText.contains(testData.getAgeValue()));
        Assert.assertTrue(rowText.contains(testData.getSalaryValue()));
        Assert.assertTrue(rowText.contains(testData.getDepartmentValue()));
    }

    public void editNewEntry(WebTablesModel testData) {
        //Edit Functionality
        elementHelper.clickLocator(WebTablesLocators.editElement);
        LoggerUtility.infoLog("The user edits the data from the table.");
        elementHelper.changeValue(WebTablesLocators.salaryChangedElement, testData.getSalaryChangedValue());
        LoggerUtility.infoLog("The user changes the Salary with value: " + testData.getSalaryChangedValue());
        elementHelper.changeValue(WebTablesLocators.departmentChangedElement, testData.getDepartmentChangedValue());
        LoggerUtility.infoLog("The user changes the Department with value: " + testData.getDepartmentChangedValue());
        elementHelper.changeValue(WebTablesLocators.emailChangedElement, testData.getEmailChangedValue());
        LoggerUtility.infoLog("The user changes the Email with value: " + testData.getEmailChangedValue());
        elementHelper.clickLocator(WebTablesLocators.submitChangedElement);
        LoggerUtility.infoLog("The user submits the changes.");

        //Validam valorile modificate
        elementHelper.validateSizeList(WebTablesLocators.editTableElement, testData.getNewTableSize());
        LoggerUtility.infoLog("Validates the size of the table: " + testData.getNewTableSize());

        //Validam continutul tabelului
        List<WebElement> editTableElementList = driver.findElements(WebTablesLocators.editTableElement);
        String editRowText = editTableElementList.get(testData.getNewTableSize()-1).getText();
        Assert.assertTrue(editRowText.contains(testData.getEmailChangedValue()));
        Assert.assertTrue(editRowText.contains(testData.getSalaryChangedValue()));
        Assert.assertTrue(editRowText.contains(testData.getDepartmentChangedValue()));
    }

    public void deleteNewEntry(WebTablesModel testData) {
        //Delete information
        elementHelper.clickLocator(WebTablesLocators.deleteElement);
        LoggerUtility.infoLog("The user deletes data from the table.");
        elementHelper.validateSizeList(WebTablesLocators.deleteTableElement, testData.getActualTableSize());
        LoggerUtility.infoLog("Validates the size of the table: " + testData.getActualTableSize());
    }

}
