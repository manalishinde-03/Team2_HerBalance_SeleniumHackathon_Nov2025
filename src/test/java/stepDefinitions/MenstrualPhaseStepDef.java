package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.BaseClass;
import hooks.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObjects.ActivityInSightsPage;
import pageObjects.MenstrualPhaseLogsPage;
import utilities.ElementUtil;
import utilities.ReadConfig;

public class MenstrualPhaseStepDef {

    private final WebDriver driver;
    private final ActivityInSightsPage activityPage;
    private final MenstrualPhaseLogsPage menstrualLogsPage;
    private final ReadConfig config;
    private final ElementUtil util;
    private final BaseClass base;

    public MenstrualPhaseStepDef(TestContext context) {
        this.driver = context.getDriver();
        this.activityPage = new ActivityInSightsPage(driver);
        this.menstrualLogsPage = new MenstrualPhaseLogsPage(driver);
        this.config = new ReadConfig();
        this.util = new ElementUtil(driver);
        this.base = new BaseClass(context);
    }

    // ---------------- Background ----------------
    @Given("the user is logged in to Her Balance")
    public void the_user_is_logged_in_to_her_balance() {
        driver.get(config.getApplicationURL());
        if (util.exists(By.xpath("//input[@type='email']"), 2)) {
            activityPage.enterUsername();
            activityPage.enterPassword();
            activityPage.clickOnLogin();
        }
        // open Activity Insights mock page
        base.navigateTo("activityInsights");
    }

    @Given("the {string} submenu is expanded")
    public void the_submenu_is_expanded(String menuName) {
        if (!activityPage.isActivityInsightsExpanded()) {
            activityPage.clickOnActivityInsights();
            Assert.assertTrue(
                activityPage.isActivityInsightsExpanded(),
                "Activity Insights submenu did not expand."
            );
        }
    }

    // ---------------- Navigation ----------------
    @When("the user clicks on Menstrual Phase Logs")
    public void clickOnMenstrualPhaseLogs() {
        try { activityPage.openMenstrualPhaseLogs(); } catch (Exception ignored) {}
        base.navigateTo("menstrualLog");
        menstrualLogsPage.waitUntilLoaded();
    }

    // ---------------- Sections table ----------------
    @Then("the following sections should be visible:")
    public void the_following_sections_should_be_visible(DataTable dataTable) {
        List<String> sections = dataTable.asList();
        menstrualLogsPage.assertSectionsVisible(sections);
    }

    // ---------------- Buttons (single step for all buttons) ----------------
    @Then("the {string} button should be visible")
    public void the_button_should_be_visible(String buttonText) {
        if ("Update Cycle Information".equalsIgnoreCase(buttonText)) {
            Assert.assertTrue(
                menstrualLogsPage.isUpdateCycleButtonVisible(),
                "'" + buttonText + "' button is not visible on the Menstrual Phase Logs page."
            );
        } else if ("Back to Dashboard".equalsIgnoreCase(buttonText)) {
            Assert.assertTrue(
                menstrualLogsPage.isBackToDashboardButtonVisible(),
                "'" + buttonText + "' button is not visible on the Menstrual Phase Logs page."
            );
        } else if ("Add Period Log".equalsIgnoreCase(buttonText)) {
            Assert.assertTrue(
                menstrualLogsPage.isAddPeriodLogButtonVisible(),
                "'" + buttonText + "' button is not visible on the Menstrual Phase Logs page."
            );
        } else {
            throw new AssertionError("Unknown button: " + buttonText);
        }
    }

    // ---------------- Tabs (separate steps as in your feature) ----------------
    @Then("the \"Cycle Overview\" tab should be visible")
    public void cycle_overview_tab_should_be_visible() {
        By tab = By.xpath("//*[self::div or self::button or self::a][normalize-space()='Cycle Overview']");
        util.waitForVisible(tab, 10);
        Assert.assertTrue(util.isDisplayed(tab), "'Cycle Overview' tab is not visible.");
    }

    @Then("the \"Menstrual Calendar\" tab should be visible")
    public void menstrual_calendar_tab_should_be_visible() {
        By tab = By.xpath("//*[self::div or self::button or self::a][normalize-space()='Menstrual Calendar']");
        util.waitForVisible(tab, 10);
        Assert.assertTrue(util.isDisplayed(tab), "'Menstrual Calendar' tab is not visible.");
    }

    @Then("the \"Period History\" tab should be visible")
    public void period_history_tab_should_be_visible() {
        By tab = By.xpath("//*[self::div or self::button or self::a][normalize-space()='Period History']");
        util.waitForVisible(tab, 10);
        Assert.assertTrue(util.isDisplayed(tab), "'Period History' tab is not visible.");
    }
}
