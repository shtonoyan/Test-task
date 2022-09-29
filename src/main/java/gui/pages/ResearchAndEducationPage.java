package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResearchAndEducationPage extends BasePage {
    private static final String RESEARCH_AND_EDUCATION_OPTIONS = "//a[contains(text(), '%s')]";
    @FindBy(css = ".main_nav_research")
    private WebElement researchAndEducationButton;

    @FindBy(xpath = "//*[text()='Research & Education']/parent::div[contains(@class, 'box')]/following-sibling::div[@class='wrap capitalize_text']")
    private WebElement contentBox;

    public boolean isResearchAndEducationButtonSelected() {
        return researchAndEducationButton.getAttribute("class").contains("selected");
    }

    public boolean isContentBoxDisplayed() {
        return contentBox.isDisplayed();
    }

    public void clickResearchEducationOption(String option) {
        String optionSelector = String.format(RESEARCH_AND_EDUCATION_OPTIONS, option);
        WebElement element = driver.findElement(By.xpath(optionSelector));
        element.click();
    }
}
