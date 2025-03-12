package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTablesLocators;

import java.util.List;

public class WebTablesPage extends BasePage{

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }


    public void addNewEntry(String firstNameValue, String lastNameValue, String emailValue, String ageValue,
                            String salaryValue, String departmentValue, int tableSize) {
        elementHelper.clickLocator(WebTablesLocators.addElement);
        elementHelper.fillLocator(WebTablesLocators.firstNameElement, firstNameValue);
        elementHelper.fillLocator(WebTablesLocators.lastNameElement, lastNameValue);
        elementHelper.fillLocator(WebTablesLocators.emailElement, emailValue);
        elementHelper.fillLocator(WebTablesLocators.ageElement, ageValue);
        elementHelper.fillLocator(WebTablesLocators.salaryElement, salaryValue);
        elementHelper.fillLocator(WebTablesLocators.departmentElement, departmentValue);
        elementHelper.clickLocator(WebTablesLocators.submitElement);

        //Validam ca avem 4 randuri in tabel
        elementHelper.validateSizeList(WebTablesLocators.addTableElement, tableSize);

        //Validam continutul tabelului
        List<WebElement> addTableElementList = driver.findElements(WebTablesLocators.addTableElement);
        String rowText = addTableElementList.get(tableSize-1).getText();
        Assert.assertTrue(rowText.contains(firstNameValue));
        Assert.assertTrue(rowText.contains(lastNameValue));
        Assert.assertTrue(rowText.contains(emailValue));
        Assert.assertTrue(rowText.contains(ageValue));
        Assert.assertTrue(rowText.contains(salaryValue));
        Assert.assertTrue(rowText.contains(departmentValue));
    }

    public void editNewEntry(String salaryChangedValue,  String departmentChangedValue, String emailChangedValue, int tableSize) {
        //Edit Functionality
        elementHelper.clickLocator(WebTablesLocators.editElement);
        elementHelper.changeValue(WebTablesLocators.salaryChangedElement, salaryChangedValue);
        elementHelper.changeValue(WebTablesLocators.departmentChangedElement, departmentChangedValue);
        elementHelper.changeValue(WebTablesLocators.emailChangedElement, emailChangedValue);
        elementHelper.clickLocator(WebTablesLocators.submitChangedElement);
        //Validam valorile modificate
        elementHelper.validateSizeList(WebTablesLocators.editTableElement, tableSize);
        //Validam continutul tabelului
        List<WebElement> editTableElementList = driver.findElements(WebTablesLocators.editTableElement);
        String editRowText = editTableElementList.get(tableSize-1).getText();
        Assert.assertTrue(editRowText.contains(emailChangedValue));
        Assert.assertTrue(editRowText.contains(salaryChangedValue));
        Assert.assertTrue(editRowText.contains(departmentChangedValue));
    }

    public void deleteNewEntry(int tableSize) {
        //Delete information
        elementHelper.clickLocator(WebTablesLocators.deleteElement);
        elementHelper.validateSizeList(WebTablesLocators.deleteTableElement, tableSize);
    }

}
