package gui;

import gui.core.Actions;
import gui.core.Utils;
import gui.pages.EconomicCalendarPage;
import gui.pages.HomePage;
import gui.pages.ResearchAndEducationPage;
import gui.pages.RiskWarningPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class GuiTestCase extends BaseTest {
    @Test
    public void useCaseTest() {
        SoftAssert softly = new SoftAssert();
        HomePage homePage = new HomePage();
        homePage.openPage();

        Assert.assertTrue(homePage.isLogoDisplayed(), "The home page is not opened...");

        ResearchAndEducationPage researchAndEducationPage = homePage.clickResearchAndEducationLink();

        Assert.assertTrue(researchAndEducationPage.isResearchAndEducationButtonSelected(), "The Research and Education section is not selected...");
        Assert.assertTrue(researchAndEducationPage.isContentBoxDisplayed(), "The section content box is not displayed...");

        researchAndEducationPage.clickResearchEducationOption("Economic Calendar");
        EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage();

        Assert.assertTrue(economicCalendarPage.isEconomyCalendarDisplayed(), "Economy calendar is not displayed...");

        LocalDate today = Utils.getCurrentDate();

        economicCalendarPage.clickYesterdayButton();
        LocalDate yesterday = economicCalendarPage.getDay();

        softly.assertEquals(yesterday, today.minusDays(1), "Yesterday date is incorrect...");

        economicCalendarPage.clickTomorrowButton();
        LocalDate tomorrow = economicCalendarPage.getDay();

        softly.assertEquals(tomorrow, today.plusDays(1), "Tomorrow date is incorrect...");

        economicCalendarPage.clickThisWeek();
        softly.assertEquals(economicCalendarPage.getDay(), today.with(DayOfWeek.MONDAY).minusDays(1), "This week date is incorrect...");

        RiskWarningPage riskWarningPage = economicCalendarPage.clickHereLink();

        String expectedPageTitle = "Notification on Non-Independent Investment Research and Risk Warning";

        softly.assertEquals(riskWarningPage.getPageTitle(), expectedPageTitle, "The Risk Warning page is not opened...");

        riskWarningPage.clickRiskDisclosureLink();
        Actions.switchTab();

        String url = Actions.getCurrentUrl();
        Assert.assertTrue(url.contains("XMGlobal-Risk-Disclosures-for-Financial-Instruments.pdf"));
        softly.assertAll();
    }
}
