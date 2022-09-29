package gui.pages;

import gui.core.Actions;
import gui.core.Utils;
import gui.core.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class EconomicCalendarPage extends BasePage {
    @FindBy(id = "timeFrame_yesterday")
    private WebElement yesterdayButton;

    @FindBy(id = "timeFrame_tomorrow")
    private WebElement tomorrowButton;

    @FindBy(id = "timeFrame_thisWeek")
    private WebElement thisWeekButton;

    @FindBy(css = ".economic-calendar")
    private WebElement economyCalendar;

    @FindBy(css = ".theDay")
    private WebElement theDay;

    @FindBy(xpath = "//*[text() = 'Disclaimer:']/ancestor::p")
    private WebElement disclaimerSection;

    @FindBy(xpath = "//a[text()='here']")
    private WebElement disclaimerHereLink;

    public boolean isEconomyCalendarDisplayed() {
        return economyCalendar.isDisplayed();
    }

    private void switchIframe() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='economicCalendar']")));
    }

    public void clickYesterdayButton() {
        switchIframe();
        yesterdayButton.click();
    }

    public void clickTomorrowButton() {
        tomorrowButton.click();
    }

    public void clickThisWeek() {
        thisWeekButton.click();
    }

    public LocalDate getDay() {
        Wait.waitElementVisibility(theDay);
        return LocalDate.parse(theDay.getText(), Utils.formatter());
    }

    public RiskWarningPage clickHereLink() {
        driver.switchTo().defaultContent();
        Actions.scrollToWebElement(disclaimerSection);
        disclaimerHereLink.click();
        return new RiskWarningPage();
    }
}
