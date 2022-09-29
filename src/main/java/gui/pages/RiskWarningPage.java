package gui.pages;

import gui.core.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RiskWarningPage extends BasePage {
    @FindBy(css = "h2")
    private WebElement title;

    public String getPageTitle() {
        Wait.waitElementVisibility(title);
        return title.getText();
    }
}
