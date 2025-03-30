package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;

public class FramePage extends BasePage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void interactWithFirstIFrame() {
        frameHelper.switchToIFrame("frame1");
        LoggerUtility.infoLog("The user switched to another IFrame1.");
        elementHelper.printLocatorText(FrameLocators.textElement1);
        frameHelper.switchToParentFrame();
        LoggerUtility.infoLog("The user switched back to parent IFrame.");
    }

    public void interactWithSecondIFrame() {
        frameHelper.switchToIFrame("frame2");
        LoggerUtility.infoLog("The user switched to another IFrame2.");
        elementHelper.printLocatorText(FrameLocators.textElement2);
        frameHelper.switchToParentFrame();
        LoggerUtility.infoLog("The user switched back to parent IFrame.");
    }
}
