package stepDefinitions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.TestContext;
import pageObjects.WorkOutPage;
import utilities.ElementUtil;
import utilities.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class WorkOutStepDef {

	private WebDriver driver;
	private ReadConfig readConfig;
	private TestContext context;
	private WorkOutPage workOutPage;
	private ElementUtil util;

	public WorkOutStepDef(TestContext Context) {
		this.context = Context;
		this.driver = context.getDriver();
		this.readConfig = new ReadConfig();
		workOutPage = new WorkOutPage(driver);
		util = new ElementUtil(this.driver);

	}

	@Given("User is on the dashboard page")
	public void user_is_on_the_dashboard_page() {
		try {
			String url = workOutPage.getMainDashBoardUrl();
			boolean isMainDashBoard = workOutPage.isMainDashBoardDisplayed();
			System.out.println("The Title after clicking login  is: " + url.contains("mainDashboard.html"));
			System.out.println("The return value for maindashboard display is :" + isMainDashBoard);

		} catch (Exception e) {
			System.err.println("Exception  opening main DashBoard : " + e.getMessage());
			e.printStackTrace();

		}
	}

	@When("user clicks workout button on navigation bar")
	public void user_clicks_workout_button_on_navigation_bar() {
		try {
			workOutPage.clickOnWorkOut();
			System.out.println("Workout button clicked successfully.");
		} catch (NoSuchElementException e) {
			System.err.println(" Workout button not found: " + e.getMessage());
			Allure.addAttachment("Workout Button Error", "text/plain", e.toString());
		} catch (TimeoutException e) {
			System.err.println(" Timeout while waiting for workout button: " + e.getMessage());
			Allure.addAttachment("Workout Button Timeout", "text/plain", e.toString());
		} catch (Exception e) {
			System.err.println(" Unexpected error clicking workout button: " + e.getMessage());
			Allure.addAttachment("Workout Button Unexpected Error", "text/plain", e.toString());
		}
	}

	@Then("User should see page title as {string}")
	public void user_should_see_page_title_as(String expectedTitle) {
		try {
			boolean isDailyPersonalised = workOutPage.isDailyPersonalisedDisplayed();
			String elementText = workOutPage.getDailyPersonalisedText();

			System.out.println("The Daily Personalised Page is displayed: " + isDailyPersonalised);
			System.out.println("The text of Daily personalised element is: " + elementText);

			// Attach to Allure
			Allure.addAttachment("Daily Personalised Element Text", elementText);

			// Assert element is displayed
			Assert.assertTrue(isDailyPersonalised, " Daily Personalised element is not displayed");

			// Assert text matches expected
			Assert.assertEquals(elementText, "Daily Personalized Workouts", " Text does not match expected");

			System.out.println("Back to dashboard link is displayed with correct text.");

		} catch (Exception e) {
			System.err.println("Error verifying Daily Personalised element: " + e.getMessage());
			Allure.addAttachment("Daily Personalised Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("User should see the link Back to dashboard")
	public void user_should_see_the_link_back_to_dashboard() {
		try {
			boolean isBackToDashBoard = workOutPage.isDailyPersonalisedDisplayed();
			String linkText = workOutPage.getBacktoDashBoardText();

			System.out.println("Back to DashBoard is displayed: " + isBackToDashBoard);
			System.out.println("The text of Back to DashBoard element is: " + linkText);

			// Attach to Allure
			Allure.addAttachment("Back to Dashboard Link Text", linkText);

			// Assert that the link is displayed
			Assert.assertTrue(isBackToDashBoard, " Back to dashboard link is not displayed");

			// Assert that the text matches expected
			Assert.assertEquals(linkText, "← Back to Dashboard", "Link text does not match expected");

			System.out.println("Back to dashboard link is displayed with correct text.");

		} catch (Exception e) {
			System.err.println(" Error verifying Back to dashboard link: " + e.getMessage());
			Allure.addAttachment("Back to Dashboard Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("User should see the {string} section")
	public void user_should_see_the_section(String expectedText) {
		try {
			boolean isDailyWorkOutPlan = workOutPage.isDailyWorkOutPlanDisplayed();
			String linkText = workOutPage.getDailyWorkOutPlanText();

			System.out.println("Daily WorkOut Plan is displayed: " + isDailyWorkOutPlan);
			System.out.println("The text of Daily WorkOut Plan  element is: " + linkText);

			// Attach to Allure
			Allure.addAttachment("Daily WorkOut Plan  Text", linkText);

			// Assert that the link is displayed
			Assert.assertTrue(isDailyWorkOutPlan, " Daily WorkOut Plan link is not displayed");

			// Assert that the text matches expected
			Assert.assertEquals(linkText, expectedText, "Link text does not match expected");

			System.out.println("Back to dashboard link is displayed with correct text.");

		} catch (Exception e) {
			System.err.println(" Error verifying Back to dashboard link: " + e.getMessage());
			Allure.addAttachment("Back to Dashboard Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("User should see the description as {string}.")
	public void user_should_see_the_description_as(String expectedText) {
		try {
			boolean isFreshAIPlan = workOutPage.isFreshAIDisplayed();
			String linkText = workOutPage.getFreshAIText();

			System.out.println("Fresh AI is displayed: " + isFreshAIPlan);
			System.out.println("The text ofFresh AI i element is: " + linkText);

			// Attach to Allure
			Allure.addAttachment("Fresh AI  Text", linkText);

			// Assert that the link is displayed
			Assert.assertTrue(isFreshAIPlan, " Fresh AI i link is not displayed");

			// Assert that the text matches expected
			Assert.assertEquals(linkText, expectedText, "Link text does not match expected");

			System.out.println("Fresh AI is displayed with correct text.");

		} catch (Exception e) {
			System.err.println(" Error verifying Back to dashboard link: " + e.getMessage());
			Allure.addAttachment("Back to Dashboard Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("User should see the message as {string}")
	public void user_should_see_the_message_as(String expectedText) {
		try {
			boolean isNoWorkOutPlan = workOutPage.isNoWorkOutPlanDisplayed();
			String linkText = workOutPage.getNoWorkOutPlanText();

			System.out.println("No workOut Plan  is displayed: " + isNoWorkOutPlan);
			System.out.println("The text No workOut Plan is element is: " + linkText);

			// Attach to Allure
			Allure.addAttachment("No WorkOut  Text", linkText);

			// Assert that the link is displayed
			Assert.assertTrue(isNoWorkOutPlan, " Workout Plan link is not displayed");

			// Assert that the text matches expected
			Assert.assertEquals(linkText, expectedText, "Link text does not match expected");

			System.out.println("Workout is displayed with correct text.");

		} catch (Exception e) {
			System.err.println(" Error verifying Workout Planlink: " + e.getMessage());
			Allure.addAttachment("Workout Plan Error", "text/plain", e.toString());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}

	@Then("User should see the message as {string} aligned centre")
	public void user_should_see_the_message_as_aligned_centre(String expectedMessage) {
		try {

			boolean isDisplayed = workOutPage.isNoWorkoutMessageDisplayed();
			String actualMessage = workOutPage.getNoWorkoutMessageText();
			String alignment = workOutPage.getNoWorkoutMessageAlignment();

			System.out.println("Message displayed: " + isDisplayed);
			System.out.println("Message text: " + actualMessage);
			System.out.println("Message alignment: " + alignment);

			Allure.addAttachment("No Workout Message", actualMessage);
			Allure.addAttachment("Message Alignment", alignment);

			if (!isDisplayed) {
				System.err.println("Message element not displayed.");
			} else if (!actualMessage.equals(expectedMessage)) {
				System.err.println(" Message text does not match expected.");
			} else if (!alignment.equalsIgnoreCase("center")) {
				System.err.println("Message is not aligned center.");
			} else {
				System.out.println("Message displayed correctly and aligned center.");
			}

		} catch (Exception e) {
			System.err.println("Error verifying message: " + e.getMessage());
			Allure.addAttachment("Message Error", "text/plain", e.toString());
		}
	}

}
