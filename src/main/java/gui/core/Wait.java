package gui.core;

import gui.driver.Driver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@UtilityClass
public class Wait {
    private static final int DEFAULT_TIMEOUT = 30;

    public void waitElementVisibility(WebElement element) {
        Logger.log("Waiting element visibility...");
        new WebDriverWait(Driver.getSingletonDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element) {
        Logger.log("Waiting element to be clickable...");
        new WebDriverWait(Driver.getSingletonDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementInvisibility(WebElement element) {
        Logger.log("Waiting element to disappear...");
        new WebDriverWait(Driver.getSingletonDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOf(element));
    }
}
