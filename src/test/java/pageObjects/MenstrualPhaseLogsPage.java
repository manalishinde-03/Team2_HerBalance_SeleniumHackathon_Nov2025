package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.ElementUtil;

public class MenstrualPhaseLogsPage {

    private WebDriver driver;
    private ElementUtil util;

    // ✅ Locators using XPath (these must match your HTML)
    private By currentCycleStatus    = By.xpath("//*[normalize-space()='Current Cycle Status']");
    private By upcomingPhases        = By.xpath("//*[normalize-space()='Upcoming Phases']");
    private By recommendedActivities = By.xpath("//*[normalize-space()='Recommended Activities']");
    private By nutritionTips         = By.xpath("//*[normalize-space()='Nutrition Tips' or normalize-space()='Nutrtion Tips']");
    private By nextPeriod            = By.xpath("//*[contains(normalize-space(.), 'Next Period')]");
    private By updateCycleButton     = By.xpath("//div//button[@data-testid='btn-update-cycle']");
    private By backToDashboardBtn    = By.xpath("//div//span[@data-testid='crumb-back']");
    private By addPeriodLogBtn   	 = By.xpath("//div//button[@id='btn-add-log']");
    private By cycleOverviewTab      = By.xpath("//div[@data-testid='tab-overview']");
    private By menstrualCalendarTab  = By.xpath("//div[@data-testid='tab-calendar']");
    private By periodHistoryTab      = By.xpath("//div[@data-testid='tab-history']");

    
    public MenstrualPhaseLogsPage(WebDriver driver) {
        this.driver = driver;
        this.util = new ElementUtil(driver);
    }

    // 1️⃣ Wait for any main section (the page is considered loaded when first heading is visible)
    public void waitUntilLoaded() {
        util.waitForVisible(currentCycleStatus, 10);
    }

    // 2️⃣ Verify that all expected sections from feature file are visible
    public void assertSectionsVisible(List<String> expectedSections) {
        List<String> missing = new ArrayList<>();

        for (String section : expectedSections) {
            By locator = mapSection(section);
            try {
                util.waitForVisible(locator, 5);
            } catch (TimeoutException e) {
                missing.add(section);
            }
        }

        // 3️⃣ Fail the test if any expected section wasn't found
        Assert.assertTrue(
            missing.isEmpty(),
            "Missing or hidden sections: " + String.join(", ", missing)
        );
    }

    // 4️⃣ Map the feature-file section names to their locators
    private By mapSection(String name) {
        if (name == null) throw new AssertionError("Section name is null");
        String key = name.trim().toLowerCase();

        switch (key) {
            case "current cycle status":
                return currentCycleStatus;
            case "upcoming phases":
                return upcomingPhases;
            case "recommended activities":
                return recommendedActivities;
            case "nutrition tips":
            case "nutrtion tips": // just in case spelling mismatch
                return nutritionTips;
            case "next period":
                return nextPeriod;
            default:
                throw new AssertionError("Unknown section name: " + name);
        }
    }
    
//    public void waitUntilLoaded() {
//        util.waitForVisible(rootMarker, 10);
//    }

    // ---------- Buttons ----------
    public boolean isUpdateCycleButtonVisible() {
        util.waitForVisible(updateCycleButton, 10);
        return util.isDisplayed(updateCycleButton);
    }

    public boolean isBackToDashboardButtonVisible() {
        util.waitForVisible(backToDashboardBtn, 10);
        return util.isDisplayed(backToDashboardBtn);
    }

    public boolean isAddPeriodLogButtonVisible() {
        util.waitForVisible(addPeriodLogBtn, 10);
        return util.isDisplayed(addPeriodLogBtn);
    }

    // ---------- Tabs ----------
    public boolean isCycleOverviewTabVisible() {
        util.waitForVisible(cycleOverviewTab, 10);
        return util.isDisplayed(cycleOverviewTab);
    }

    public boolean isMenstrualCalendarTabVisible() {
        util.waitForVisible(menstrualCalendarTab, 10);
        return util.isDisplayed(menstrualCalendarTab);
    }

    public boolean isPeriodHistoryTabVisible() {
        util.waitForVisible(periodHistoryTab, 10);
        return util.isDisplayed(periodHistoryTab);
    }

    // ---------- Optional hard assertion helpers (if you prefer assert here) ----------
    public void assertLoaded() {
        waitUntilLoaded();
    }

    public void assertBackToDashboardVisible() {
        Assert.assertTrue(isBackToDashboardButtonVisible(), "'Back to Dashboard' button is not visible.");
    }
}

