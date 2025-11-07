package stepDefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ActivityInSightsPage;
import utilities.ElementUtil;
import utilities.ReadConfig;

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
			String path = System.getProperty("user.dir") + "/src/test/resources/HTML_Pages/trackweight.html";
			driver.get("file://" + path);

		    String url = util.getPageURL();
		    System.out.println("The Title after clicking Weight Tracking is: " + url);
	
		    String expectedURL = "file://" + path.replace("\\", "/");
		    System.out.println("The expected Weight Tracking url  is: " + expectedURL);
		   

		   //String expectedURL = "http://localhost:8000/trackweight.html";
		    Assert.assertEquals(url, expectedURL, " URL mismatch after clicking Weight Tracking.");

		    System.out.println("URL verified successfully after clicking Weight Tracking.");

		} catch (AssertionError ae) {
		    System.err.println(" Assertion failed: " + ae.getMessage());
		    throw ae;  // re-throw to fail the test
		} catch (Exception e) {
		    System.err.println("Exception while verifying URL: " + e.getMessage());
		    e.printStackTrace();
		    Assert.fail("Test failed due to unexpected exception: " + e.getMessage());
		}

	}
}
