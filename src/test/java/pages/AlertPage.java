package pages;

import loggerUtility.LoggerUtility;
import modelObject.AlertModel;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void interactWithAcceptAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        LoggerUtility.infoLog("The user clicked on the Alert.");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user accepted the Alert.");
    }

    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.timeAlertElement);
        LoggerUtility.infoLog("The user clicked on the Time Alert.");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user accepted the Alert.");
    }

    public void interactWithCancelAlert() {
        elementHelper.clickLocator(AlertLocators.alertCancelElement);
        LoggerUtility.infoLog("The user clicked on the Cancel Alert.");
        alertHelper.cancelAlert();
        LoggerUtility.infoLog("The user canceled the Alert.");
    }

    public void interactWithValueAlert(AlertModel testData) {
        elementHelper.clickLocator(AlertLocators.nameAlertElement);
        LoggerUtility.infoLog("The user clicked on the Fill Name Alert.");
        alertHelper.nameAlert(testData.getPromptData());
        LoggerUtility.infoLog("The user filled the name in the Window Alert.");
    }
}
