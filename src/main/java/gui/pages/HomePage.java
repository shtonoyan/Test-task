package gui.pages;

import gui.core.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//button[text()='ACCEPT ALL']")
    private WebElement acceptCookies;

    @FindBy(css = ".navbar-header .navbar-brand.logo")
    private WebElement logo;

    @FindBy(xpath = "//a[text()[normalize-space() = 'Research & Education']]")
    private WebElement researchAndEducation;

    public void openPage() {
        driver.get(BASE_URL);
        acceptAllCookies();
    }

    public void acceptAllCookies() {
        Wait.waitElementToBeClickable(acceptCookies);
        acceptCookies.click();
        Wait.waitElementInvisibility(acceptCookies);
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public ResearchAndEducationPage clickResearchAndEducationLink() {
        researchAndEducation.click();
        return new ResearchAndEducationPage();
    }
}
