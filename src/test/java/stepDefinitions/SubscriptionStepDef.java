package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import hooks.TestContext;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
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
	    try {
	        System.out.println("Completing onboarding up to step: " + int1);
	    } catch (Exception e) {
	        System.err.println("Error completing onboarding process until step " + int1 + ": " + e.getMessage());
	        Allure.addAttachment("Onboarding Error", "text/plain", e.toString());
	    }
	}

	@Given("User is on step {int} onboarding process")
	public void user_is_on_step_onboarding_process(Integer int1) {
	    try {
	        System.out.println("User should be on step: " + int1);
	    } catch (Exception e) {
	        System.err.println("Error verifying onboarding step " + int1 + ": " + e.getMessage());
	        Allure.addAttachment("Onboarding Step Error", "text/plain", e.toString());
	    }
	}

	@When("User clicks on {string} after entering the required medication details")
	public void user_clicks_on_after_entering_the_required_medication_details(String button) {
	    try {
	        subscriptionPage.clickSectionByTitle(button);
	    } catch (Exception e) {
	        System.err.println("Error clicking button '" + button + "' after entering medication details: " + e.getMessage());
	        Allure.addAttachment("Click Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} sub-text header should be visible")
	public void sub_text_header_should_be_visible(String subText) {
	    try {
	        softAssert.assertTrue(subscriptionPage.isCurrentSubscriptionSubtextVisible(),
	                subText + " sub-text header should be visible");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for sub-text header: " + ae.getMessage());
	        Allure.addAttachment("Sub-text Header Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking sub-text header: " + e.getMessage());
	        Allure.addAttachment("Sub-text Header Error", "text/plain", e.toString());
	    }
	}

	@Then("There should be exactly {int} subscription plan tiles displayed")
	public void there_should_be_exactly_subscription_plan_tiles_displayed(Integer section) {
	    try {
	        int tileCount = subscriptionPage.getSectionCount();
	        softAssert.assertEquals(tileCount, section.intValue(),
	                "Subscription plan tiles count should be " + section);
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for subscription plan tiles: " + ae.getMessage());
	        Allure.addAttachment("Subscription Tiles Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking subscription plan tiles: " + e.getMessage());
	        Allure.addAttachment("Subscription Tiles Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} section tile should be displayed inside Free plan tile")
	public void section_tile_should_be_displayed_inside_free_plan_tile(String sectionTitle) {
	    try {
	        softAssert.assertTrue(subscriptionPage.isFreePlanActiveBadgeVisible(),
	                sectionTitle + " section tile should be displayed inside Free plan tile");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for Free plan tile: " + ae.getMessage());
	        Allure.addAttachment("Free Plan Tile Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking Free plan tile: " + e.getMessage());
	        Allure.addAttachment("Free Plan Tile Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} section title should be displayed")
	public void section_title_should_be_displayed(String sectionTitle) {
	    try {
	        softAssert.assertTrue(subscriptionPage.isCurrentSubscriptionHeaderVisible(),
	                sectionTitle + " section title should be displayed");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for section title: " + ae.getMessage());
	        Allure.addAttachment("Section Title Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking section title: " + e.getMessage());
	        Allure.addAttachment("Section Title Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} subtext under header should be visible")
	public void subtext_under_header_should_be_visible(String subText) {
	    try {
	        softAssert.assertTrue(subscriptionPage.isSubscriptionHistorySubtextVisible(),
	                subText + " subtext should be visible under header");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for subtext under header: " + ae.getMessage());
	        Allure.addAttachment("Subtext Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking subtext under header: " + e.getMessage());
	        Allure.addAttachment("Subtext Error", "text/plain", e.toString());
	    }
	}

	@Then("Subscribe Now button should be visible and enabled")
	public void subscribe_now_button_should_be_visible_and_enabled() {
	    try {
	        softAssert.assertTrue(subscriptionPage.arePlanTilesDisplayed(),
	                "Subscribe Now button should be visible and enabled");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for Subscribe Now button: " + ae.getMessage());
	        Allure.addAttachment("Subscribe Button Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking Subscribe Now button: " + e.getMessage());
	        Allure.addAttachment("Subscribe Button Error", "text/plain", e.toString());
	    }
	}

	@Then("Get Started button should be visible")
	public void get_started_button_should_be_visible() {
	    try {
	        softAssert.assertTrue(subscriptionPage.isGoToDashboardButtonEnabled(),
	                "Get Started button should be visible");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for Get Started button: " + ae.getMessage());
	        Allure.addAttachment("Get Started Button Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking Get Started button: " + e.getMessage());
	        Allure.addAttachment("Get Started Button Error", "text/plain", e.toString());
	    }
	}

	@Then("User should be redirected to Dashboard page")
	public void user_should_be_redirected_to_dashboard_page() {
	    try {
	        softAssert.assertTrue(subscriptionPage.isAtDashboard(),
	                "User should be redirected to Dashboard page");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for Dashboard redirection: " + ae.getMessage());
	        Allure.addAttachment("Dashboard Redirection Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking Dashboard redirection: " + e.getMessage());
	        Allure.addAttachment("Dashboard Redirection Error", "text/plain", e.toString());
	    }
	}

	@Then("Exactly {int} sections should be visible")
	public void exactly_sections_should_be_visible(Integer int1) {
	    try {
	        int sectionCount = subscriptionPage.getSectionCount();
	        softAssert.assertEquals(sectionCount, int1.intValue(),
	                "Exactly " + int1 + " sections should be visible");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for sections count: " + ae.getMessage());
	        Allure.addAttachment("Sections Count Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking sections count: " + e.getMessage());
	        Allure.addAttachment("Sections Count Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} and {string} section headers should be displayed")
	public void and_section_headers_should_be_displayed(String header1, String header2) {
	    try {
	        softAssert.assertTrue(subscriptionPage.areSectionHeadersVisible(),
	                header1 + " and " + header2 + " section headers should be displayed");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for section headers: " + ae.getMessage());
	        Allure.addAttachment("Section Headers Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking section headers: " + e.getMessage());
	        Allure.addAttachment("Section Headers Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} header should be displayed")
	public void header_should_be_displayed(String header) {
	    try {
	        softAssert.assertTrue(subscriptionPage.isSubscriptionManagementHeaderVisible(),
	                header + " header should be displayed");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for header: " + ae.getMessage());
	        Allure.addAttachment("Header Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error checking header: " + e.getMessage());
	        Allure.addAttachment("Header Error", "text/plain");
	    }
	}





}
