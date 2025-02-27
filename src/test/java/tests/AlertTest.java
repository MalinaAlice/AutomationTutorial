package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AlertTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(getDriver());

        By alertsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(alertsMenu);


        By alertsPage = By.xpath("//span[text()='Alerts']");
        elementHelper.clickJsLocator(alertsPage);

        testAlerts();
    }

    public void testAlerts() {

        AlertHelper alertHelper = new AlertHelper(getDriver());
        ElementHelper elementHelper = new ElementHelper(getDriver());

        //Alert OK
        By alertOkElement = By.id("alertButton");
        elementHelper.clickLocator(alertOkElement);
        alertHelper.acceptAlert();

        //Time Alert
        By timeAlertElement = By.id("timerAlertButton");
        elementHelper.clickLocator(timeAlertElement);
        alertHelper.acceptAlert();

        //Cancel Alert
        By alertCancelElement = By.id("confirmButton");
        elementHelper.clickLocator(alertCancelElement);
        alertHelper.cancelAlert();

        //Name Alert
        By nameAlertElement = By.id("promtButton");
        elementHelper.clickLocator(nameAlertElement);
        alertHelper.nameAlert("Alice");
    }
}
