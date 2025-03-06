package pages;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.FrameLocators;

public class FramePage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private FrameHelper frameHelper;

    public FramePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        frameHelper = new FrameHelper(driver);
    }

    public void interactWithFirstIFrame() {
        frameHelper.switchToIFrame("frame1");
        elementHelper.printLocatorText(FrameLocators.textElement1);
        frameHelper.switchToParentFrame();
    }

    public void interactWithSecondIFrame() {
        frameHelper.switchToIFrame("frame2");
        elementHelper.printLocatorText(FrameLocators.textElement2);
        frameHelper.switchToParentFrame();
    }
}
