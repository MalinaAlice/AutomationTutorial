package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.util.List;

public class WebTablesTest extends SharedData {
    @Test
    public void metodaTest () {

        ElementHelper elementHelper = new ElementHelper(getDriver());

        By elementsMenu = By.xpath("//h5[text()='Elements']");
        elementHelper.clickJsLocator(elementsMenu);

        By webTables = By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJsLocator(webTables);


        //Identificam o lista de elemente
        List<WebElement> initialTableElement = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        int initialTableSize = initialTableElement.size();
        int expectedTableSize = 3;
        Assert.assertEquals(initialTableSize, expectedTableSize, "Dimensiunea initiala a tabelului nu este 3.");

        //Identificam un element
        By addElement = By.id("addNewRecordButton");
        elementHelper.clickLocator(addElement);

        By firstNameElement = By.id("firstName");
        String firstNameValue = "Alice";
        elementHelper.fillLocator(firstNameElement, firstNameValue);


        By lastNameElement = By.id("lastName");
        String lastNameValue = "Malina";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By emailElement = By.id("userEmail");
        String emailValue = "alice.email@gmail.com";
        elementHelper.fillLocator(emailElement, emailValue);

        By ageElement = By.id("age");
        String ageValue = "24";
        elementHelper.fillLocator(ageElement, ageValue);

        By salaryElement = By.id("salary");
        String salaryValue = "5500";
        elementHelper.fillLocator(salaryElement, salaryValue);

        By departmentElement = By.id("department");
        String departmentValue = "Quality Assurance";
        elementHelper.fillLocator(departmentElement, departmentValue);

        By submitElement = By.id("submit");
        elementHelper.clickLocator(submitElement);

        //Validam ca avem 4 randuri in tabel
        List<WebElement> addTableElement = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(addTableElement.size(), 4, "Dimensiunea initiala a tabelului nu este 4.");

        //Validam continutul tabelului
        String rowText = addTableElement.get(3).getText();
        Assert.assertTrue(rowText.contains(firstNameValue));
        Assert.assertTrue(rowText.contains(lastNameValue));
        Assert.assertTrue(rowText.contains(emailValue));
        Assert.assertTrue(rowText.contains(ageValue));
        Assert.assertTrue(rowText.contains(salaryValue));
        Assert.assertTrue(rowText.contains(departmentValue));
        //System.out.println(rowText);

        //Edit Functionality
        By editElement = By.id("edit-record-4");
        elementHelper.clickLocator(editElement);

        By salaryChangedElement = By.id("salary");
        String salaryChangedValue = "6000";
        elementHelper.changeValue(salaryChangedElement, salaryChangedValue);

        By departmentChangedElement = By.id("department");
        String departmentChangedValue = "QA Automation";
        elementHelper.changeValue(departmentChangedElement, departmentChangedValue);

        By emailChangedElement = By.id("userEmail");
        String emailChangedValue = "alice.email18@gmail.com";
        elementHelper.changeValue(emailChangedElement, emailChangedValue);

        By submitChangedElement = By.id("submit");
        elementHelper.clickLocator(submitChangedElement);

        //Validam valorile modificate
        List<WebElement> editTableElement = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(editTableElement.size(), 4, "Dimensiunea initiala a tabelului nu este 4.");

        //Validam continutul tabelului
        String editRowText = editTableElement.get(3).getText();
        Assert.assertTrue(editRowText.contains(firstNameValue));
        Assert.assertTrue(editRowText.contains(lastNameValue));
        Assert.assertTrue(editRowText.contains(emailChangedValue));
        Assert.assertTrue(editRowText.contains(ageValue));
        Assert.assertTrue(editRowText.contains(salaryChangedValue));
        Assert.assertTrue(editRowText.contains(departmentChangedValue));

        //Delete information
        By deleteElement = By.id("delete-record-4");
        elementHelper.clickLocator(deleteElement);

        List<WebElement> deleteTableElement = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertEquals(deleteTableElement.size(), 3, "Dimensiunea initiala a tabelului nu este 4.");
    }

}
