package pages;

import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver driver) {
        super(driver);
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
