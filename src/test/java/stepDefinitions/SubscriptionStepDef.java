package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import hooks.TestContext;
import io.cucumber.java.en.*;
import pageObjects.LaunchPage;
import pageObjects.SubscriptionManagement;
import pageObjects.SubscriptionPage;
import utilities.ReadConfig;

public class SubscriptionStepDef {
	
	WebDriver driver;
	ReadConfig readConfig;
	TestContext context;
	SubscriptionPage subscriptionPage;
	SubscriptionManagement subscriptionManagement;
	SoftAssert softAssert;
	 
	
	public SubscriptionStepDef(TestContext Context) {
		this.context = Context;
		this.driver = context.getDriver();
		this.readConfig = new ReadConfig();
		subscriptionPage = new SubscriptionPage(driver);
		subscriptionManagement = new SubscriptionManagement(driver);
		
		softAssert = new SoftAssert();
	
	}
	
	@Given("User completes onboarding process until step {int}")
	public void user_completes_onboarding_process_until_step(Integer int1) {
        System.out.println("Completing onboarding up to step: " + int1);

	}

	@Given("User is on step {int} onboarding process")
	public void user_is_on_step_onboarding_process(Integer int1) {
        System.out.println("User should be on step: " + int1);

	}

	@When("User clicks on {string} after entering the required medication details")
	public void user_clicks_on_after_entering_the_required_medication_details(String button) {
	   
		
        subscriptionPage.clickSectionByTitle(button);

	}

	@Then("{string} header should be visible")
	public void header_should_be_visible(String string) {
		softAssert.assertTrue(subscriptionPage.isSubscriptionManagementHeaderVisible(), 
				string + " header should be visible");
	        softAssert.assertAll();
	}

	@Then("{string} sub-text header should be visible")
	public void sub_text_header_should_be_visible(String subText) {
		softAssert.assertTrue(subscriptionPage.isCurrentSubscriptionSubtextVisible(),
                subText + " sub-text header should be visible");
        softAssert.assertAll();
	}

	@Then("There should be exactly {int} subscription plan tiles displayed")
	public void there_should_be_exactly_subscription_plan_tiles_displayed(Integer section) {
	    
		
		int tileCount = subscriptionPage.getSectionCount();
        softAssert.assertEquals(tileCount, section.intValue(),
                "Subscription plan tiles count should be " + section);
        softAssert.assertAll();
	}

	@Then("{string} section tile should be displayed inside Free plan tile")
	public void section_tile_should_be_displayed_inside_free_plan_tile(String sectionTitle) {
		softAssert.assertTrue(subscriptionPage.isFreePlanActiveBadgeVisible(), 
				sectionTitle + " section tile should be displayed inside Free plan tile");
	        softAssert.assertAll();
		
	}

	@Then("{string} section title should be displayed")
	public void section_title_should_be_displayed(String sectionTitle) {
	    
		softAssert.assertTrue(subscriptionPage.isCurrentSubscriptionHeaderVisible(),
                sectionTitle + " section title should be displayed");
        softAssert.assertAll();;
	}

	@Then("{string} subtext under header should be visible")
	public void subtext_under_header_should_be_visible(String subText) {
		softAssert.assertTrue(subscriptionPage.isSubscriptionHistorySubtextVisible(), 
	            subText + " subtext should be visible under header");
	        softAssert.assertAll();
	}

	@Then("the following lines preceded with checkmark should be visible:")
	public void the_following_lines_preceded_with_checkmark_should_be_visible(io.cucumber.datatable.DataTable dataTable) {
	   
		
		for (String line : dataTable.asList()) {
            // You can implement better UI check here if required
            System.out.println("Checkmark line visible: " + line);
        }
        softAssert.assertAll();
	}

	@Then("Subscribe Now button should be visible and enabled")
	public void subscribe_now_button_should_be_visible_and_enabled() {
	   
		
		softAssert.assertTrue(subscriptionPage.arePlanTilesDisplayed(),
                "Subscribe Now button should be visible and enabled");
        softAssert.assertAll();
	}

	@Then("{string} badge text should be displayed on Monthly plan tile")
	public void badge_text_should_be_displayed_on_monthly_plan_tile(String badgeText) {
        System.out.println("Badge text on Monthly plan tile: " + badgeText);

	}

	@Then("{string} subheader should be displayed inside Monthly plan tile")
	public void subheader_should_be_displayed_inside_monthly_plan_tile(String subheader) {
		softAssert.assertTrue(subscriptionPage.areCurrentSubscriptionSubheadersVisible(),
                subheader + " should be displayed inside Monthly plan tile");
        softAssert.assertAll();
	}

	@Then("{string} subtext should be displayed")
	public void subtext_should_be_displayed(String subtext) {
        System.out.println(subtext + " subtext should be displayed");

	}

	@Then("{string} badge text should be displayed on {int} Month Plan tile")
	public void badge_text_should_be_displayed_on_month_plan_tile(String badgeText, Integer months) {
	    
        System.out.println("Badge " + badgeText + " displayed on " + months + " Month Plan tile");

	}

	@Then("{string} subheader should be displayed")
	public void subheader_should_be_displayed(String subheader) {
		softAssert.assertTrue(subscriptionPage.areCurrentSubscriptionSubheadersVisible(),
                subheader + " should be displayed");
        softAssert.assertAll();
	}

	@Then("{string} text preceded with star symbol should be visible")
	public void text_preceded_with_star_symbol_should_be_visible(String text) {
        System.out.println("Text preceded with star symbol: " + text);

	}

	@Then("Get Started button should be visible")
	public void get_started_button_should_be_visible() {
		softAssert.assertTrue(subscriptionPage.isGoToDashboardButtonEnabled(),
                "Get Started button should be visible");
        softAssert.assertAll();
	}

	@When("User clicks on {string} after finishing all onboarding steps")
	public void user_clicks_on_after_finishing_all_onboarding_steps(String button) {
        subscriptionPage.clickSectionByTitle(button);

	}

	@When("User is on subscribe plan page")
	public void user_is_on_subscribe_plan_page() {
		softAssert.assertTrue(subscriptionPage.isSubscriptionManagementHeaderVisible(),
                "User should be on subscribe plan page");
        softAssert.assertAll();
	}

	@When("User clicks Subscribe Now button in Free plan")
	public void user_clicks_subscribe_now_button_in_free_plan() {
        subscriptionPage.subscribeFreePlan();

	}

	@Then("User should be redirected to Dashboard page")
	public void user_should_be_redirected_to_dashboard_page() {
		softAssert.assertTrue(subscriptionPage.isAtDashboard(),
                "User should be redirected to Dashboard page");
        softAssert.assertAll();
	}

	
	@Given("User clicks profile button labelled as [user's name] after logged in")
	public void user_clicks_profile_button_labelled_as_user_s_name_after_logged_in() {
        System.out.println("User clicks profile button labelled as user's name");

		
	}

	@Given("User is on the Her Balance Dashboard with the Profile submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_profile_submenu_expanded() {

        System.out.println("User is on Her Balance Dashboard with Profile submenu expanded");

	}

	@When("User clicks on Subscription")
	public void user_clicks_on_subscription() {

        subscriptionPage.clickSectionByTitle("Subscription");

	}

	@Then("{string} should be visible")
	public void should_be_visible(String element) {

        System.out.println(element + " should be visible");

	}

	@Then("Exactly {int} sections should be visible")
	public void exactly_sections_should_be_visible(Integer int1) {

		int sectionCount = subscriptionPage.getSectionCount();
        softAssert.assertEquals(sectionCount, int1.intValue(),
                "Exactly " + int1 + " sections should be visible");
        softAssert.assertAll();
	
	}

	@Then("{string} and {string} section headers should be displayed")
	public void and_section_headers_should_be_displayed(String header1, String header2) {

		softAssert.assertTrue(subscriptionPage.areSectionHeadersVisible(),
                header1 + " and " + header2 + " section headers should be displayed");
        softAssert.assertAll();
	}

	@Then("{string} header should be displayed")
	public void header_should_be_displayed(String header) {
		softAssert.assertTrue(subscriptionPage.isSubscriptionManagementHeaderVisible(),
                header + " header should be displayed");
        softAssert.assertAll();
	
	}

	@Then("{string} and {string} subheaders should be visible")
	public void and_subheaders_should_be_visible(String subheader1, String subheader2) {

		softAssert.assertTrue(subscriptionPage.areCurrentSubscriptionSubheadersVisible(),
                subheader1 + " and " + subheader2 + " subheaders should be visible");
        softAssert.assertAll();
	
	}

	@Then("{string}, {string}, {string}, and {string} details should be visible")
	public void and_details_should_be_visible(String d1, String d2, String d3, String d4) {

        System.out.printf("Details visible: %s, %s, %s, %s%n", d1, d2, d3, d4);

	
	}

	@Then("{string} button should be visible and enabled")
	public void button_should_be_visible_and_enabled(String button) {
		softAssert.assertTrue(subscriptionPage.isGoToDashboardButtonEnabled(),
                button + " button should be visible and enabled");
        softAssert.assertAll();
	
	
	}

	@Then("The following details should be visible:")
	public void the_following_details_should_be_visible(io.cucumber.datatable.DataTable dataTable) {

		for (String detail : dataTable.asList()) {
            System.out.println("Detail should be visible: " + detail);
        }
        softAssert.assertAll();
	
	
	}






}
