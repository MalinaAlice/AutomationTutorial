package pages;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        alertHelper = new AlertHelper(driver);
        elementHelper = new ElementHelper(driver);
    }

    public void interactWithAcceptAlert() {
        elementHelper.clickLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
    }

    public void interactWithTimerAlert() {
        elementHelper.clickLocator(AlertLocators.timeAlertElement);
        alertHelper.acceptAlert();
    }

    public void interactWithCancelAlert() {
        elementHelper.clickLocator(AlertLocators.alertCancelElement);
        alertHelper.cancelAlert();
    }

    public void interactWithValueAlert(String value) {
        elementHelper.clickLocator(AlertLocators.nameAlertElement);
        alertHelper.nameAlert(value);
    }
}
