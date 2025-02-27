package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest  extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(getDriver());
        By alertsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJsLocator(alertsMenu);

        By framesPage = By.xpath("//span[text()='Frames']");
        elementHelper.clickJsLocator(framesPage);

        frames();
    }

    public void frames() {

        FrameHelper frameHelper = new FrameHelper(getDriver());
        ElementHelper elementHelper = new ElementHelper(getDriver());

        frameHelper.switchToIFrame("frame1");
        By textElement1 = By.id("sampleHeading");
        elementHelper.printLocatorText(textElement1);
        frameHelper.switchToParentFrame();

        frameHelper.switchToIFrame("frame2");
        By textElement2 = By.id("sampleHeading");
        elementHelper.printLocatorText(textElement2);
    }

}
