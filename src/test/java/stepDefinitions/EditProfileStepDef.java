package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import hooks.TestContext;
import io.cucumber.java.en.*;
import pageObjects.EditPage;
import pageObjects.SubscriptionManagement;
import pageObjects.SubscriptionPage;
import utilities.ReadConfig;



public class EditProfileStepDef {

	
	
	WebDriver driver;
	ReadConfig readConfig;
	TestContext context;
	EditPage editPage;
	SoftAssert softAssert;
	 
	
	public EditProfileStepDef(TestContext Context) {
		this.context = Context;
		this.driver = context.getDriver();
		this.readConfig = new ReadConfig();
		editPage = new EditPage(driver);		
		softAssert = new SoftAssert();
	}
	
	@Given("User clicks {string} submenu from Dashboard Profile page")
	public void user_clicks_submenu_from_dashboard_profile_page(String string) {
	   
		
        editPage.clickSubMenu(string);

	}

	@Given("User is on the Her Balance Dashboard with the Edit Profile submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_edit_profile_submenu_expanded() {

        editPage.expandEditProfileSubMenu();

	}

	@When("User clicks on {string}")
	public void user_clicks_on(String string) {

        editPage.clickElement(string);

	
	}

	@Then("There should be exactly {int} tabs")
	public void there_should_be_exactly_tabs(Integer int1) {
		int actualTabs = editPage.getTotalTabs();
        softAssert.assertEquals(actualTabs, int1.intValue(), "Tabs count mismatch");
        softAssert.assertAll();
	
	}

	@Then("{string}, {string}, {string} tabs should be visible")
	public void tabs_should_be_visible(String string, String string2, String string3) {

		 softAssert.assertTrue(editPage.isTabVisible(string));
	        softAssert.assertTrue(editPage.isTabVisible(string2));
	        softAssert.assertTrue(editPage.isTabVisible(string3));
	        softAssert.assertAll();
	
	}

	@Then("{string} should be visible by default")
	public void should_be_visible_by_default(String string) {

		 softAssert.assertTrue(editPage.isVisibleByDefault(string));
	        softAssert.assertAll();
	
	}

	@Then("{string} Button should be visible")
	public void button_should_be_visible(String string) {

		softAssert.assertTrue(editPage.isButtonVisible(string));
        softAssert.assertAll();
	}

	@Given("clicks {string} tab")
	public void clicks_tab(String string) {

        editPage.clickTab(string);

	}

	@Then("{string} should be visible inside section")
	public void should_be_visible_inside_section(String string) {

		softAssert.assertTrue(editPage.isVisibleInsideSection(string));
        softAssert.assertAll();
	
	}

	@Then("{string} sub text should be visible")
	public void sub_text_should_be_visible(String string) {

		softAssert.assertTrue(editPage.isSubTextVisible(string));
        softAssert.assertAll();
	
	}

	@Then("Should display the user’s Name as entered during the onboarding process")
	public void should_display_the_user_s_name_as_entered_during_the_onboarding_process() {
		String userName = editPage.getUserName();
	    softAssert.assertNotNull(userName, "User name should not be null");
	    softAssert.assertFalse(userName.isEmpty(), "User name should not be empty");
	    softAssert.assertAll();	
	}

	@Then("Should display the user’s Age as entered during the onboarding process")
	public void should_display_the_user_s_age_as_entered_during_the_onboarding_process() {

		String userAge = editPage.getUserAge();
	    softAssert.assertNotNull(userAge, "User age should not be null");
	    softAssert.assertFalse(userAge.isEmpty(), "User age should not be empty");
	    softAssert.assertAll();
	}

	@Then("Name and Age fields should be properly aligned vertically with equal spacing")
	public void name_and_age_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
		softAssert.assertTrue(editPage.isNameAndAgeProperlyAligned());
        softAssert.assertAll();
	
	}

	@Then("Should display the user’s Weight as entered during the onboarding process")
	public void should_display_the_user_s_weight_as_entered_during_the_onboarding_process() {

		String userWeight = editPage.getUserWeight();
	    softAssert.assertNotNull(userWeight, "User weight should not be null");
	    softAssert.assertFalse(userWeight.isEmpty(), "User weight should not be empty");
	    softAssert.assertAll();	}

	@Then("Should display the user’s Height as entered during the onboarding process")
	public void should_display_the_user_s_height_as_entered_during_the_onboarding_process() {

		String userHeight = editPage.getUserHeight();
	    softAssert.assertNotNull(userHeight, "User height should not be null");
	    softAssert.assertFalse(userHeight.isEmpty(), "User height should not be empty");
	    softAssert.assertAll();	
	}

	@Then("{string} or {string} unit values in dropdown should be visible and enabled")
	public void or_unit_values_in_dropdown_should_be_visible_and_enabled(String string, String string2) {
	    softAssert.assertTrue(editPage.areUnitsVisibleAndEnabled(string, string2), "Units should be visible and enabled");
	    softAssert.assertAll();

	
	
	}

	@Then("Weight and Height fields should be properly aligned vertically with equal spacing")
	public void weight_and_height_fields_should_be_properly_aligned_vertically_with_equal_spacing() {

		softAssert.assertTrue(editPage.isWeightAndHeightProperlyAligned());
        softAssert.assertAll();
	
	}

	@Then("{string} should be displayed with a gradient slider and labels")
	public void should_be_displayed_with_a_gradient_slider_and_labels(String string) {
		softAssert.assertTrue(editPage.isGradientSliderDisplayed(string));
        softAssert.assertAll();
	
	}

	@Then("{string} section should be present")
	public void section_should_be_present(String string) {

		softAssert.assertTrue(editPage.isSectionPresent(string));
	    softAssert.assertAll();
	}

	@Then("Slider should display a continuous gradient from blue → yellow → orange → red")
	public void slider_should_display_a_continuous_gradient_from_blue_yellow_orange_red() {

		softAssert.assertTrue(editPage.isSliderGradientCorrect());
	    softAssert.assertAll();
	}

	@Then("{string} Button should be visible and enabled")
	public void button_should_be_visible_and_enabled(String string) {

		softAssert.assertTrue(editPage.isButtonVisibleAndEnabled(string));
	    softAssert.assertAll();
	}

	@Then("{string}, {string}, {string}, {string} RadioButtons should be visible and enabled")
	public void radio_buttons_should_be_visible_and_enabled(String string, String string2, String string3, String string4) {
		softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(string));
	    softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(string2));
	    softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(string3));
	    softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(string4));
	    softAssert.assertAll();
	
	}

	@Given("clicks {string} section")
	public void clicks_section(String string) {

	    editPage.clickSection(string);

	}

	@Given("User is on the {string} section")
	public void user_is_on_the_section(String string) {

	    editPage.navigateToSection(string);

	
	}

	@When("User clicks on {string} Button")
	public void user_clicks_on_button(String string) {
	    editPage.clickButton(string);

	
	}

	@Then("Should display empty input field for entering medication name")
	public void should_display_empty_input_field_for_entering_medication_name() {

		softAssert.assertTrue(editPage.isMedicationNameInputEmpty());
	    softAssert.assertAll();
	}

	@Then("{string} and {string} buttons should be displayed")
	public void and_buttons_should_be_displayed(String string, String string2) {

		softAssert.assertTrue(editPage.isButtonDisplayed(string));
	    softAssert.assertTrue(editPage.isButtonDisplayed(string2));
	    softAssert.assertAll();
	}

	@Then("There should be exactly {int} buttons  {string} and {string}")
	public void there_should_be_exactly_buttons_and(Integer int1, String string, String string2) {

		int actualButtons = editPage.getTotalButtons();
	    softAssert.assertEquals(actualButtons, int1.intValue());
	    softAssert.assertTrue(editPage.isButtonDisplayed(string));
	    softAssert.assertTrue(editPage.isButtonDisplayed(string2));
	    softAssert.assertAll();
	}

	@When("User clicks on {string} button after adding medication")
	public void user_clicks_on_button_after_adding_medication(String string) {

	    editPage.clickButtonAfterAddingMedication(string);

	
	}

	@Then("User should see success message {string}")
	public void user_should_see_success_message(String string) {
		softAssert.assertTrue(editPage.isSuccessMessageDisplayed(string));
	    softAssert.assertAll();
	
	}

	@When("User clicks on {string} button without adding medication details")
	public void user_clicks_on_button_without_adding_medication_details(String string) {

	    editPage.clickButtonWithoutAddingMedicationDetails(string);

	}

	@Then("User should navigate back to {string} section page")
	public void user_should_navigate_back_to_section_page(String string) {

		softAssert.assertTrue(editPage.isOnSectionPage(string));
	    softAssert.assertAll();
	
	}



}
