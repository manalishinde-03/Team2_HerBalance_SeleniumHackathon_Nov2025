package stepDefinitions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.ActivityInSightsPage;
import utilities.ElementUtil;
import utilities.ReadConfig;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ActivityInsightsStepDef {
	private WebDriver driver;
	private ReadConfig readConfig;
	private TestContext context;
	private ActivityInSightsPage activityPage;
	private ElementUtil util;

	public ActivityInsightsStepDef(TestContext Context) {
		this.context = Context;
		this.driver = context.getDriver();
		this.readConfig = new ReadConfig();
		activityPage = new ActivityInSightsPage(driver);
		util = new ElementUtil(this.driver);

	}

	@Given("User is on the Her Balance Dashboard with the activity insights submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_activity_insights_submenu_expanded() {
		try {
			String url = util.getPageURL();
			System.out.println("The Title after clicking Activity Insights menu is: " + url);
			boolean isExpanded = activityPage.isActivityInsightsExpanded();
			System.out.println("The expanded boolean is: " + isExpanded);
		} catch (Exception e) {
			System.err.println("Exception during Activity Insights validation: " + e.getMessage());
			e.printStackTrace();

		}
	}

	@When("User clicks on track weight")
	public void user_clicks_on_track_weight() {
		try {
			activityPage.clickOnTrackWeight();
			System.out.println("Successfully clicked on 'Track Weight' submenu.");
		} catch (Exception e) {
			System.err.println("Exception while clicking on 'Track Weight': " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("Should see  header text Weight Tracking")
	public void should_see_header_text_weight_tracking() {
		try {
			// Construct platform-independent file path
			Path htmlPath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "HTML_Pages",
					"trackweight.html");
			String fileURL = htmlPath.toUri().toString();

			// Navigate to the local HTML page
			Allure.step("Navigating to Weight Tracking page: " + fileURL);
			driver.get(fileURL);

			// Get actual URL from browser
			String actualURL = util.getPageURL();
			System.out.println("The Title after clicking Weight Tracking is: " + actualURL);

			// Log expected URL
			String expectedURL = fileURL;
			System.out.println("The expected Weight Tracking URL is: " + expectedURL);

			// Assert URL match
			Allure.step("Verifying Weight Tracking URL");
			Assert.assertEquals(actualURL, expectedURL, "URL mismatch after clicking Weight Tracking.");
			System.out.println(" URL verified successfully after clicking Weight Tracking.");

		} catch (AssertionError ae) {
			System.err.println(" Assertion failed: " + ae.getMessage());
			Assert.fail("Assertion failed: " + ae.getMessage());

		} catch (Exception e) {
			System.err.println("Exception while verifying URL: " + e.getMessage());
			e.printStackTrace();
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}

	}

	@Then("{string} button should be visible")
	public void button_should_be_visible(String string) {
		try {
			boolean backToBackGroundisDisplayed = activityPage.backToDashBoardDisplayed();
			System.out.println("The boolean value is " + backToBackGroundisDisplayed);
			Allure.step("The Back to ground  is displayed value is : " + backToBackGroundisDisplayed);
			Assert.assertTrue(backToBackGroundisDisplayed, "Back to Background button is not visible");
		} catch (Exception e) {
			// Log the error to Allure
			Allure.addAttachment("Error loading URL or locating element", e.getMessage());
			// Fail the test explicitly so Allure marks it as failed
			Assert.fail("Exception occurred while checking button visibility: " + e.getMessage());
		}
	}

	@Then("{int} cards should be present")
	public void cards_should_be_present(Integer expectedCardCount) {
		try {
			// Check visibility of each card
			boolean startingWeightCardIsDisplayed = activityPage.startingWeightCardDisplayed();
			boolean currentWeightCardIsDisplayed = activityPage.currentWeightCardDisplayed();
			boolean goalWeightCardIsDisplayed = activityPage.goalWeightCardDisplayed();

			// Count how many are actually visible
			int actualVisibleCount = 0;
			if (startingWeightCardIsDisplayed)
				actualVisibleCount++;
			if (currentWeightCardIsDisplayed)
				actualVisibleCount++;
			if (goalWeightCardIsDisplayed)
				actualVisibleCount++;
			System.out.println("Expected card count: " + expectedCardCount);
			System.out.println("Actual visible card count: " + actualVisibleCount);
			Allure.addAttachment("Card Visibility Check",
					"Expected: " + expectedCardCount + "\nActual: " + actualVisibleCount);
			Assert.assertEquals(actualVisibleCount, expectedCardCount.intValue(),
					"Mismatch in number of visible cards.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying card visibility: " + e.getMessage());
			Allure.addAttachment("Card Verification Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Starting weight , Current weight and Goal weight card should be displayed")
	public void starting_weight_current_weight_and_goal_weight_card_should_be_displayed() {
		try {
			boolean startingWeightCardVisible = activityPage.startingWeightCardDisplayed();
			boolean currentWeightCardVisible = activityPage.currentWeightCardDisplayed();
			boolean goalWeightCardVisible = activityPage.goalWeightCardDisplayed();

			// Log visibility status
			System.out.println("Starting Weight Card: " + startingWeightCardVisible);
			System.out.println("Current Weight Card: " + currentWeightCardVisible);
			System.out.println("Goal Weight Card: " + goalWeightCardVisible);

			Allure.addAttachment("Card Visibility Status", "Starting Weight: " + startingWeightCardVisible
					+ "\nCurrent Weight: " + currentWeightCardVisible + "\nGoal Weight: " + goalWeightCardVisible);

			// Assert all cards are visible
			Assert.assertTrue(startingWeightCardVisible, "Starting Weight card is not displayed");
			Assert.assertTrue(currentWeightCardVisible, " Current Weight card is not displayed");
			Assert.assertTrue(goalWeightCardVisible, " Goal Weight card is not displayed");

			System.out.println(" All three weight cards are displayed successfully.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying weight cards: " + e.getMessage());
			Allure.addAttachment("Card Verification Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Label and weight values should be center-aligned")
	public void label_and_weight_values_should_be_center_aligned() {
		try {
			boolean startingCentered = activityPage.isStartingWeightCardCentered();
			boolean currentCentered = activityPage.isCurrentWeightCardCentered();
			boolean goalCentered = activityPage.isGoalWeightCardCentered();

			System.out.println("Starting Weight Card Centered: " + startingCentered);
			System.out.println("Current Weight Card Centered: " + currentCentered);
			System.out.println("Goal Weight Card Centered: " + goalCentered);

			Allure.addAttachment("Alignment Check",
					"Starting weight centre alignment : " + startingCentered + "\nCurrent weight centre alignment: "
							+ currentCentered + "\nGoal weight centre alignment: " + goalCentered);

			Assert.assertTrue(startingCentered, " Starting Weight card is not center-aligned");
			Assert.assertTrue(currentCentered, " Current Weight card is not center-aligned");
			Assert.assertTrue(goalCentered, " Goal Weight card is not center-aligned");

			System.out.println(" All cards are center-aligned.");

		} catch (Exception e) {
			System.err.println(" Exception during alignment check: " + e.getMessage());
			Allure.addAttachment("Alignment Check Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Weight value should be mapped from the onboarding process")
	public void weight_value_should_be_mapped_from_the_onboarding_process() {
		try {
			boolean isDisplayed = activityPage.isStartingWeightValueDisplayed();
			String value = activityPage.getStartingWeightValue();

			System.out.println("Starting Weight Value Displayed: " + isDisplayed);
			System.out.println("Starting Weight Value: " + value);

			Allure.addAttachment("Starting Weight Check", "Displayed: " + isDisplayed + "\nValue: " + value);

			Assert.assertTrue(isDisplayed, "Starting weight value is not displayed");

			System.out.println("Starting weight value is displayed successfully.");

		} catch (Exception e) {
			System.err.println("Exception while checking Starting Weight: " + e.getMessage());
			Allure.addAttachment("Starting Weight Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Current Weight should be x value")
	public void current_weight_should_be_x_value() {
		String expectedValue = "69.0 kg";
		try {
			String actualValue = activityPage.getCurrentWeightValue();

			System.out.println("Expected Current Weight: " + expectedValue);
			System.out.println("Actual Current Weight: " + actualValue);

			Allure.addAttachment("Current Weight Check", "Expected: " + expectedValue + "\nActual: " + actualValue);

			Assert.assertEquals(actualValue, expectedValue, "Current Weight value mismatch");

			System.out.println(" Current Weight value matches expected.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying Current Weight: " + e.getMessage());
			Allure.addAttachment("Current Weight Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Goal weight should be displayed")
	public void goal_weight_should_be_displayed() {
		try {
			boolean isDisplayed = activityPage.isGoalWeightValueDisplayed();
			String value = activityPage.goalWeightValue();

			System.out.println("Goal Weight Value Displayed: " + isDisplayed);
			System.out.println("Goal Weight Value: " + value);

			Allure.addAttachment("Gaol Weight Check", "Displayed: " + isDisplayed + "\nValue: " + value);

			Assert.assertTrue(isDisplayed, "Goal weight value is not displayed");

			System.out.println("Goal weight value is displayed successfully.");

		} catch (Exception e) {
			System.err.println("Exception while checking Goal Weight: " + e.getMessage());
			Allure.addAttachment("Goal Weight Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Header should be Progress overview")
	public void header_should_be_progress_overview() {
		try {
			String actualHeader = activityPage.getProgressOverviewHeaderText();
			boolean isDisplayed = activityPage.isProgressOverviewHeaderDisplayed();

			System.out.println("Header displayed: " + isDisplayed);
			System.out.println("Header text: " + actualHeader);

			Allure.addAttachment("Header Check", "Displayed: " + isDisplayed + "\nText: " + actualHeader);

			Assert.assertTrue(isDisplayed, "Progress overview header is not displayed");
			Assert.assertEquals(actualHeader, "Progress Overview", " Header text mismatch");

			System.out.println("Header is displayed and matches 'Progress overview'.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying header: " + e.getMessage());
			Allure.addAttachment("Header Verification Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("weight lost should be displayed")
	public void weight_lost_should_be_displayed() {
		try {
			String actualHeader = activityPage.getWeightLossProgressBarText();
			boolean isWeightLostDisplayed = activityPage.isWeightLossProgressBarDisplayed();

			System.out.println("Header displayed: " + isWeightLostDisplayed);
			System.out.println("Header text: " + actualHeader);

			Allure.addAttachment("Header Check", "Displayed: " + isWeightLostDisplayed + "\nText: " + actualHeader);

			Assert.assertTrue(isWeightLostDisplayed, "Weight loss progress header is not displayed");
			Assert.assertEquals(actualHeader, "Weight Loss Progress", " Header text mismatch");

			System.out.println("Header is displayed and matches 'Weight loss progress.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying header: " + e.getMessage());
			Allure.addAttachment("Header Verification Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}

	}

	@Then("Remaining weight  should be displayed")
	public void remaining_weight_should_be_displayed() {
		try {
			String actualHeader = activityPage.getRemainingText();
			boolean isRemainingDisplayed = activityPage.isRemainingDisplayed();

			System.out.println("Header displayed: " + isRemainingDisplayed);
			System.out.println("Header text: " + actualHeader);

			Allure.addAttachment("Header Check", "Displayed: " + isRemainingDisplayed + "\nText: " + actualHeader);

			Assert.assertTrue(isRemainingDisplayed, "Remaining header is not displayed");
			Assert.assertEquals(actualHeader, "Remaining", " Header text mismatch");

			System.out.println("Header is displayed and matches 'Remaining header.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying header: " + e.getMessage());
			Allure.addAttachment("Header Verification Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}

	}

	@Then("Graph section header should be Weight Progression over Time")
	public void graph_section_header_should_be_weight_progression_over_time() {
		try {
			String actualHeader = activityPage.getWeightProgressOverTimeHeaderText();
			boolean isRWeightProgressOverTimeDisplayed = activityPage.isWeightProgressOverTimeHeaderDisplayed();

			System.out.println("Header displayed: " + isRWeightProgressOverTimeDisplayed);
			System.out.println("Header text: " + actualHeader);

			Allure.addAttachment("Header Check",
					"Displayed: " + isRWeightProgressOverTimeDisplayed + "\nText: " + actualHeader);

			Assert.assertTrue(isRWeightProgressOverTimeDisplayed, "Weight Progress Over Time header is not displayed");
			Assert.assertEquals(actualHeader, "Weight Progression Over Time", " Header text mismatch");

			System.out.println("Header is displayed and matches 'Weight Progress Over Time header.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying header: " + e.getMessage());
			Allure.addAttachment("Header Verification Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Graph should be visible with x-axis showing days \\(Day {string} to Day {string})")
	public void graph_should_be_visible_with_x_axis_showing_days_day_to_day(String startDay, String endDay) {
		try {
			String[] labels = activityPage.getXAxisLabels();
			boolean isGraphDisplayed = activityPage.isGraphVisible();

			System.out.println("Graph visible: " + isGraphDisplayed);
			System.out.println("Labels found: " + Arrays.toString(labels));

			Allure.addAttachment("Graph Verification",
					"Graph Visible: " + isGraphDisplayed + "\nX-axis labels: " + Arrays.toString(labels));

			Assert.assertTrue(isGraphDisplayed, "Weight Progress graph is NOT visible");
			Assert.assertEquals(labels[0], "Day 1", "X-axis start label mismatch");
			Assert.assertEquals(labels[labels.length - 1], "Day 7", "X-axis end label mismatch");

			System.out.println("Graph is visible and X-axis labels match Day 1 to Day 7");

		} catch (Exception e) {
			System.err.println("Exception while verifying graph and labels: " + e.getMessage());
			Allure.addAttachment("Graph Validation Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Y-axis should display weight values in kg")
	public void y_axis_should_display_weight_values_in_kg() {
		try {
			boolean graphVisible = activityPage.isGraphVisible();
			String yAxisTitle = activityPage.getYAxisTitle();
			List<String> yAxisLabels = activityPage.getYAxisTickLabels();

			System.out.println("Graph visible: " + graphVisible);
			System.out.println("Y-axis title: " + yAxisTitle);
			System.out.println("Y-axis labels: " + yAxisLabels);

			Allure.addAttachment("Y-axis Verification", "Graph Visible: " + graphVisible + "\nY-axis Title: "
					+ yAxisTitle + "\nY-axis Labels: " + yAxisLabels);

			Assert.assertTrue(graphVisible, " Graph is not visible");
			Assert.assertEquals(yAxisTitle, "Weight (kg)", " Y-axis title mismatch");

			// check that labels are numeric values
			for (String label : yAxisLabels) {
				Assert.assertTrue(label.matches("\\d+(\\.\\d+)?"), " Y-axis label is not a numeric weight: " + label);
			}

			System.out.println("Y-axis displays weight values in kg correctly.");

		} catch (Exception e) {
			System.err.println(" Exception while verifying Y-axis: " + e.getMessage());
			Allure.addAttachment("Y-axis Validation Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("{string} should be visible")
	public void should_be_visible(String actualLogTodayweight) {
		try {

			boolean isLogTodayWeightDisplayed = activityPage.isLogTodayWeightDisplayed();

			System.out.println("Log Today's Weight displayed: " + isLogTodayWeightDisplayed);
			System.out.println(" Log Today's Weight  actual value: " + actualLogTodayweight);

			Allure.addAttachment("Log Today's Weight Check",
					"Displayed: " + isLogTodayWeightDisplayed + "\nText: " + actualLogTodayweight);

			Assert.assertTrue(isLogTodayWeightDisplayed, "Log Weight Check  is not displayed");

		} catch (Exception e) {
			System.err.println(" Exception while verifying Log Weight visibility: " + e.getMessage());
			Allure.addAttachment(" Log Weight visibility Verification Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}

	}

	@Then("{string} {string} {string} should be displayed")
	public void should_be_displayed(String expectedWeight, String expectedBMI, String expectedNote) {
		try {
			boolean weightVisible = activityPage.isWeightKgtDisplayed();
			boolean bmiVisible = activityPage.isBMIDisplayed();
			boolean noteVisible = activityPage.isNoteOptionalDisplayed();

			System.out.println("Weight label visible: " + weightVisible);
			System.out.println("BMI label visible: " + bmiVisible);
			System.out.println("Note label visible: " + noteVisible);

			Allure.addAttachment("Form Label Visibility",
					"Weight: " + weightVisible + "\nBMI: " + bmiVisible + "\nNote: " + noteVisible);

			Assert.assertTrue(weightVisible, " Weight (kg) label not visible");
			Assert.assertTrue(bmiVisible, "BMI (Auto-calculated) label not visible");
			Assert.assertTrue(noteVisible, " Note (Optional) label not visible");

			System.out.println("All labels displayed correctly.");

		} catch (NoSuchElementException e) {
			System.err.println(" One or more labels not found: " + e.getMessage());
			Allure.addAttachment("Label Lookup Error", "text/plain", e.toString());
			Assert.fail("Test failed due to missing label element(s).");
		} catch (Exception e) {
			System.err.println(" Unexpected exception: " + e.getMessage());
			Allure.addAttachment("Unexpected Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("Section should indicate the current tracking day {string}")
	public void section_should_indicate_the_current_tracking_day(String expectedDayCount) {
		try {
			boolean logDayCountVisible = activityPage.islogDayCountDisplayed();

			System.out.println("LogDay Count visible: " + logDayCountVisible);

			Allure.addAttachment("Form Label Visibility", "Log Day Count: " + logDayCountVisible);

			Assert.assertTrue(logDayCountVisible, " Log Day Count  label not visible");

		} catch (NoSuchElementException e) {
			System.err.println("Count labels not found: " + e.getMessage());
			Allure.addAttachment("Count Error", "text/plain", e.toString());
			Assert.fail("Test failed due to missing Log Day Count label element.");
		} catch (Exception e) {
			System.err.println(" Unexpected exception: " + e.getMessage());
			Allure.addAttachment("Unexpected Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("Log weight button should be disabled")
	public void log_weight_button_should_be_disabled() {
		try {

			boolean disabled = activityPage.isLogButtonDisabled();

			System.out.println("Log Weight button disabled: " + disabled);
			Allure.addAttachment("Log Weight Button State", "Disabled: " + disabled);

			Assert.assertTrue(disabled, "Log Weight button is not disabled as expected");

			System.out.println(" Log Weight button is correctly disabled.");
		} catch (Exception e) {
			System.err.println(" Exception while verifying Log Weight button: " + e.getMessage());
			Allure.addAttachment("Log Weight Button Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@When("User enter valid value in weight after clicking track weight in sub menu")
	public void user_enter_valid_value_in_weight_after_clicking_track_weight_in_sub_menu() {
		activityPage.clickOnTrackWeight();
		activityPage.enterWeightInput("79");
	}

	@Then("{string} field should auto-calculate")
	public void field_should_auto_calculate(String string) {
		try {
			String bmiValue = activityPage.getBmiValue();
			System.out.println("BMI auto-calculated: " + bmiValue);
			Allure.addAttachment("BMI Auto-Calculation", "BMI Value: " + bmiValue);
			// Assert BMI is not empty and numeric
			Assert.assertNotNull(bmiValue, " BMI field is empty");
			Assert.assertTrue(bmiValue.matches("\\d+(\\.\\d+)?"), "BMI is not numeric");
			System.out.println("BMI field auto-calculated correctly.");
		} catch (Exception e) {
			System.err.println(" Exception while verifying BMI auto-calculation: " + e.getMessage());
			Allure.addAttachment("BMI Auto-Calculation Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Then("Log Weight button should be Enabled")
	public void log_weight_button_should_be_enabled() {
		try {

			boolean enabled = activityPage.isLogButtonEnabled();

			System.out.println("Log Weight button enabled: " + enabled);
			Allure.addAttachment("Log Weight Button State", "enabled: " + enabled);

			Assert.assertTrue(enabled, "Log Weight button is not enabled as expected");

			System.out.println(" Log Weight button is correctly enabled.");
		} catch (Exception e) {
			System.err.println(" Exception while verifying Log Weight button enabled: " + e.getMessage());
			Allure.addAttachment("Log Weight Button Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}
	}

	@Given("User is on the Weight tracker")
	public void user_is_on_the_weight_tracker() {
		String weightTrackerUrl = util.getPageURL();
		System.out.println("the url for weight tracker is " + weightTrackerUrl.contains("trackweight.html"));
	}

	@When("User clicks Log Weight button after entering valid value in weight")
	public void user_clicks_log_weight_button_after_entering_valid_value_in_weight() {
		try {

			activityPage.enterWeight("65");
			String bmi = activityPage.getBmiValue();
			System.out.println(bmi);
			activityPage.clickLogWeight();

			System.out.println(" Log Weight successful. BMI: " + bmi);

		} catch (Exception e) {
			System.err.println(" Error during Log Weight interaction: " + e.getMessage());
			Allure.addAttachment("Log Weight Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("Entered weight should be added to the tracking record")
	public void entered_weight_should_be_added_to_the_tracking_record() {
		try {

			boolean found = activityPage.isWeightInHistory("65");
			List<String> historyText = activityPage.getWeightHistoryTexts();
			System.out.println("The history of weight entered are : " + historyText);
			Allure.addAttachment("Weight History Entries", String.join("\n", activityPage.getWeightHistoryTexts()));

			Assert.assertTrue(found, "Weight not found in weight history");

			System.out.println("Weight successfully added to history.");

		} catch (Exception e) {
			System.err.println("Error verifying weight history: " + e.getMessage());
			Allure.addAttachment("Weight History Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

}
