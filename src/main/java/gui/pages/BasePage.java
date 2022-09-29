package gui.pages;

import gui.core.TestDataReader;
import gui.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected static final String BASE_URL = TestDataReader.getProperty("BASE_URL");
    protected WebDriver driver;
    @FindBy(xpath = "//div[@id='risk-block']/descendant::a[text()='Risk Disclosure']")
    private WebElement riscDisclosureLink;

    protected BasePage() {
        driver = Driver.getSingletonDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickRiskDisclosureLink() {
        riscDisclosureLink.click();
    }
}
