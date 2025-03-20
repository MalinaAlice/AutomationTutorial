package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WebTablesModel {

    private String firstnameValue;
    private String lastNameValue;
    private String emailValue;
    private String ageValue;
    private String salaryValue;
    private String departmentValue;
    private String salaryChangedValue;
    private String departmentChangedValue;
    private String emailChangedValue;
    private int newTableSize;
    private int actualTableSize;

    // Constructor care încarcă JSON fără mapare manuală
    public WebTablesModel(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
    }

    // Getteri (fără modificări)
    public String getFirstnameValue() { return firstnameValue; }
    public String getLastNameValue() { return lastNameValue; }
    public String getEmailValue() { return emailValue; }
    public String getAgeValue() { return ageValue; }
    public String getSalaryValue() { return salaryValue; }
    public String getDepartmentValue() { return departmentValue; }
    public String getSalaryChangedValue() { return salaryChangedValue; }
    public String getDepartmentChangedValue() { return departmentChangedValue; }
    public String getEmailChangedValue() { return emailChangedValue; }
    public int getNewTableSize() { return newTableSize; }
    public int getActualTableSize() { return actualTableSize; }
}