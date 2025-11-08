package stepDefinitions;

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

}
