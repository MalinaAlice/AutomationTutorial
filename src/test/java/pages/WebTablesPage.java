package pages;

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
        elementHelper.fillLocator(WebTablesLocators.firstNameElement, testData.getFirstnameValue());
        elementHelper.fillLocator(WebTablesLocators.lastNameElement, testData.getLastNameValue());
        elementHelper.fillLocator(WebTablesLocators.emailElement, testData.getEmailValue());
        elementHelper.fillLocator(WebTablesLocators.ageElement, testData.getAgeValue());
        elementHelper.fillLocator(WebTablesLocators.salaryElement, testData.getSalaryValue());
        elementHelper.fillLocator(WebTablesLocators.departmentElement, testData.getDepartmentValue());
        elementHelper.clickLocator(WebTablesLocators.submitElement);

        //Validam ca avem 4 randuri in tabel
        elementHelper.validateSizeList(WebTablesLocators.addTableElement, testData.getNewTableSize());

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
        elementHelper.changeValue(WebTablesLocators.salaryChangedElement, testData.getSalaryChangedValue());
        elementHelper.changeValue(WebTablesLocators.departmentChangedElement, testData.getDepartmentChangedValue());
        elementHelper.changeValue(WebTablesLocators.emailChangedElement, testData.getEmailChangedValue());
        elementHelper.clickLocator(WebTablesLocators.submitChangedElement);
        //Validam valorile modificate
        elementHelper.validateSizeList(WebTablesLocators.editTableElement, testData.getNewTableSize());
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
        elementHelper.validateSizeList(WebTablesLocators.deleteTableElement, testData.getActualTableSize());
    }

}
