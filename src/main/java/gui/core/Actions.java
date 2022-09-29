package gui.core;

import gui.driver.Driver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

@UtilityClass
public class Actions {
    public void scrollToWebElement(WebElement element) {
        Logger.log("Scrolling to the element");
        ((JavascriptExecutor) Driver.getSingletonDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchTab() {
        Logger.log("Switching to the next tab");
        ArrayList<String> windowHandles = new ArrayList<>(Driver.getSingletonDriver().getWindowHandles());
        Driver.getSingletonDriver().switchTo().window(windowHandles.get(1));
    }

    public String getCurrentUrl() {
        return Driver.getSingletonDriver().getCurrentUrl();
    }
}
