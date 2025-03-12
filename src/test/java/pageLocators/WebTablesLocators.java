package pageLocators;

import org.openqa.selenium.By;

public class WebTablesLocators {

    public static final By initialTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");

    public static final By addElement = By.id("addNewRecordButton");

    public static final By firstNameElement = By.id("firstName");

    public static final By lastNameElement = By.id("lastName");

    public static final By emailElement = By.id("userEmail");

    public static final By ageElement = By.id("age");

    public static final By salaryElement = By.id("salary");

    public static final By departmentElement = By.id("department");

    public static final By submitElement = By.id("submit");

    public static final By addTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");

    public static final By editElement = By.id("edit-record-4");

    public static final By salaryChangedElement = By.id("salary");

    public static final By departmentChangedElement = By.id("department");

    public static final By emailChangedElement = By.id("userEmail");

    public static final By submitChangedElement = By.id("submit");

    public static final By editTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");

    public static final By deleteElement = By.id("delete-record-4");

    public static final By deleteTableElement = By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -odd' or @class='rt-tr -even']");
}
