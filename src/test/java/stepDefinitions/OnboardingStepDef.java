package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;
import pageObjects.OnboardingPage;
import pageObjects.SignUpPage;
import utilities.ElementUtil;
import utilities.ReadConfig;

public class OnboardingStepDef {

	WebDriver driver;
	TestContext context;
	LaunchPage launchPage;
	SignUpPage signUpPage = new SignUpPage(driver);

	OnboardingPage onboardingPage = new OnboardingPage(driver);
	ReadConfig readConfig = new ReadConfig();
	private ElementUtil util;

	public OnboardingStepDef(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
		this.readConfig = new ReadConfig();
		util = new ElementUtil(this.driver);

	}

	@When("User clicks register button after entering valid details")
	public void user_clicks_register_button_after_entering_valid_details() {
		driver = context.getDriver();

		String email = readConfig.getEmail();
		String password = readConfig.getPassword();
		String confirmPassword = readConfig.getPassword();

		signUpPage = new SignUpPage(driver);
		onboardingPage = (OnboardingPage) signUpPage.registerWithValidCredentials(email, password, confirmPassword);

	}

	@Then("Title of the page should be Upload Your Recent Blood Work")
	public void title_of_the_page_should_be_upload_your_recent_blood_work() {
		driver = context.getDriver();
		onboardingPage = new OnboardingPage(driver);
		Assert.assertEquals(onboardingPage.getOnboardingPageTitle(), "Upload Your Recent Blood Work");

	}

	@Then("Verify the supporting text on Onboarding page1")
	public void verify_supporting_text_onboarding_step1() {
		driver = context.getDriver();
		onboardingPage = new OnboardingPage(driver);
		String expectedText = "Welcome to HerBalance! To create a health plan that truly fits you, "
				+ "upload your recent blood work so we can provide personalized weight management "
				+ "recommendations based on your unique health profile.";
		Assert.assertEquals(onboardingPage.getSupportingTextStep1(), expectedText);

	}

	@Then("Verify Onboarding progress bar is displayed")
	public void verify_onboarding_progressBar_isDisplayed() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isOnboardingProgressBarDisplayed(), "Onboarding progress bar should be displayed");

	}

	@Then("Verify Progress bar shows the current step as 1 of 10")
	public void verify_onboarding_progressBar_stepas1of10_isDisplayed() {
		onboardingPage = new OnboardingPage(driver);

		assertTrue(onboardingPage.isOnboardingProgressBar1of10Displayed(),
				"Onboarding progress bar should show the current step as 1 of 10");

	}

	@Then("Verify Upload PDF button is displayed")
	public void verify_upload_pdf_button_is_displayed() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isUploadPDFButtonDisplayed(), "Upload PDF button should be displayed");

	}

	@Then("Verify Upload PDF button is enabled")
	public void verify_upload_pdf_button_is_enabled() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isUploadPDFButtonEnabled(), "Upload PDF button should be enabled");
	}

	@Then("Verify PDF files only \\(Max 10MB) is visible")
	public void verify_pdf_files_only_max_10mb_is_visible() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isPDFFilesOnlyTextDisplayed(), "PDF Files Only Text should be displayed");

		String expectedText = "PDF files only (Max 10MB)";
		Assert.assertEquals(onboardingPage.getPDFFilesOnlyTextStep1(), expectedText);
	}

	@Then("Skip for Now card is visible")
	public void skip_for_now_card_is_visible() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isSkipForNowTextDisplayed(), "Skip For Now Text should be displayed");
	}

	@Then("Explanation text about continuing without lab results is displayed")
	public void explanation_text_about_continuing_without_lab_results_is_displayed() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isExplanationTextDisplayed(),
				"Explanation text about continuing without lab results should be displayed");

		String expectedText = "You can continue without uploading lab\r\n" + "results and add this\r\n"
				+ "information later for\r\n" + "more personalized\r\n" + "recommendations.";
		Assert.assertEquals(onboardingPage.getSkipExplanationText(), expectedText);
	}

	@Then("Continue Without Report button is displayed")
	public void continue_without_report_button_is_displayed() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isContinueWithoutReportBtnDisplayed(),
				"Continue Without Report button should be displayed");
	}

	@Then("Continue Without Report button is enabled")
	public void continue_without_report_button_is_enabled() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isContinueWithoutReportBtnEnabled(),
				"Continue Without Report button should be enabled");
	}

	@Then("Note about secure processing and no sharing with third parties is displayed")
	public void note_about_secure_processing_and_no_sharing_with_third_parties_is_displayed() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isDataSecurityTextDisplayed(),
				"Note about secure processing and no sharing with third parties Text should be displayed");

		String expectedText = "By sharing your blood work, we can create a personalized weight management plan that works with your body's unique biochemistry.\r\n"
				+ "Your data is securely processed and never shared with third parties.";
		Assert.assertEquals(onboardingPage.getDataSecurityTextStep1(), expectedText);

	}

	@When("User clicks on Continue Without Report Button")
	public void user_clicks_on_continue_without_report_button() {
		onboardingPage = new OnboardingPage(driver);
		onboardingPage.clickOnContinueWithoutReportBtn();

	}

	@Then("User should navigate to step3 Health Conditions")
	public void user_should_navigate_to_step3_health_conditions() {
		onboardingPage = new OnboardingPage(driver);
		Assert.assertEquals(onboardingPage.getOnboardingPageStep3Title(), "Health Conditions");

	}

	@When("User clicks on Upload PDF Button")
	public void user_clicks_on_upload_pdf_button() {
		onboardingPage.clickOnUploadPDFBtn();
	}

	@When("User clicks on Back Button on Step4")
	public void user_clicks_on_back_button_step4() {
		onboardingPage.clickOnBackBtnStep4();
	}

	@When("User clicks on Continue Button on Step4")
	public void user_clicks_on_continue_button_step4() {
		onboardingPage.clickOnContinueBtnStep4();
	}

	@Then("User should see Windows Explorer opened")
	public void file_upload_dialog_should_be_opened() throws InterruptedException {
		WebElement fileInput = driver.findElement(By.id("bloodwork-upload"));

		fileInput.sendKeys("C:\\Users\\manal_\\Documents\\test.txt");
		// Assert.assertTrue(fileInput.isDisplayed(), "File input is not available");
		Assert.assertTrue(onboardingPage.fileUploadDialogIsDisplayed(), "File upload dialog should be displayed ");
	}

	@Given("User is on Upload Blood Work page")
	public void user_is_on_upload_blood_work_page() {

		try {

			String htmlPage = "onboarding1.html";
			String URL = (readConfig.getApplicationURL()) + htmlPage;
			System.out.println("URL>>>" + URL);
			context.getDriver().get(URL);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Then("Progress bar shows the current step as  3 of 10")
	public void progress_bar_shows_the_current_step_as_of() {

		assertTrue(onboardingPage.isOnboardingProgressBar3of10Displayed(),
				"Onboarding progress bar should show the current step as 3 of 10");
	}

	@Then("Back button is displayed")
	public void back_button_is_displayed() {

		assertTrue(onboardingPage.isBackButtonStep3Displayed(), "Back button should be displayed");
	}

	@Then("Back button should be enabled")
	public void back_button_should_be_enabled() {
		assertTrue(onboardingPage.isBackButtonStep3Enabled(), "Back button should be enabled");
	}

	@Then("Continue button should be visible")
	public void continue_button_should_be_visible() {

		assertTrue(onboardingPage.isContinueButtonStep3Displayed(), "Continue button should be displayed");
	}

	@Then("Continue button should be enabled")
	public void continue_button_should_be_enabled() {

		assertTrue(onboardingPage.isContinueButtonStep3Enabled(), "Continue button should be enabled");
	}

	@Then("Header should be Health conditions")
	public void header_should_be_health_conditions() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep3Title(), "Health Conditions");
	}

	@Then("Sub title for the header in Step3 is visible")
	public void sub_title_for_the_header_in_step3_is_visible() {

		Assert.assertEquals(onboardingPage.getOnboardingPageStep3SubTitle(),
				"Want to manually enter any key conditions or comorbidities?");
	}

	@Then("Total {int} Radio buttons should be visible")
	public void total_radio_buttons_should_be_visible(int expectedCount) {

		Assert.assertEquals(onboardingPage.radioButtonsSize(), expectedCount);
	}

	@Then("Health condition options should be :")
	public void health_condition_options_should_be_visible(io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedOptions = dataTable.asList();
		Assert.assertEquals(onboardingPage.radioButtonsOptionsText(), expectedOptions, "Radio options do not match");
	}

	@Then("Note text should displayed")
	public void note_text_should_displayed() {

		String expectedText = "Conditions like PCOS, thyroid issues, and insulin resistance affect how your body\r\n"
				+ "responds to workouts, food, and stress. We'll weave this into your personalized plan.";

		Assert.assertEquals(onboardingPage.getNoteTextStep3(), expectedText);

	}

	@Given("User is on Health Conditions page")
	public void user_is_on_health_conditions_page() {

		try {

			String htmlPage = "onboarding3.html";
			String URL = (readConfig.getApplicationURL()) + htmlPage;
			System.out.println("URL>>>" + URL);
			context.getDriver().get(URL);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("User selects {string} health condition and clicks on Continue Button")
	public void user_selects_one_health_condition_and_clicks_on_continue_button(String healthCondition) {
		onboardingPage = new OnboardingPage(driver);
		onboardingPage.selectHealthConditionAndClickOnContinue(healthCondition);
	}

	@Then("Title of the page should be Personal Details")
	public void title_of_the_page_should_be_personal_details() {

		Assert.assertEquals(onboardingPage.getOnboardingPageStep4Title(), "Personal Details");
	}

	@Then("Verify description text for step4")
	public void verify_description_text_for_step4() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep4SubTitle(),
				"Let's get to know you better to personalize your experience.");
	}

	@Then("Verify input box count is {int} on step4")
	public void verify_input_box_count_on_step4(int expectedCount) {

		Assert.assertEquals(onboardingPage.inputBoxCountStep4(), expectedCount);
	}

	@Then("User should see the following input field labels:")
	public void user_should_see_the_following_input_field_labels(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedLabels = dataTable.asList();

		// Verify all expected labels are present
		for (String expected : expectedLabels) {
			Assert.assertTrue(onboardingPage.getActualInputFieldLabels().contains(expected));
		}
	}

	@Then("User should see the following helper text under the input fields:")
	public void verify_helper_text_for_the_fields(io.cucumber.datatable.DataTable dataTable) {
		List<String> expectedHelperTexts = dataTable.asList();

		for (String expected : expectedHelperTexts) {
			Assert.assertTrue(onboardingPage.getActualHelperTexts().contains(expected));
		}
	}

	@Then("Total number of radio buttons should be {int}")
	public void total_number_of_radio_buttons_should_be(int expectedCount) {

		Assert.assertEquals(onboardingPage.radioButtonsStep4Size(), expectedCount);
	}

	@Then("Blood pressure description options should be :")
	public void blood_pressure_description_options_should_be(io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedBPDescriptionOptions = dataTable.asList();

		Assert.assertEquals(onboardingPage.getActualBPDescriptionOptions(), expectedBPDescriptionOptions,
				"Radio options do not match");

	}

	@Then("Progress bar shows the current step as  4 of 10")
	public void progress_bar_shows_the_current_step_as_of1() {
		assertTrue(onboardingPage.isOnboardingProgressBar4of10Displayed(),
				"Onboarding progress bar should show the current step as 4 of 10");
	}

	@Then("Verify user navigates to Step5 after clicking Continue button")
	public void verify_user_navigates_to_step5_after_clicking_continue_button() {

		Assert.assertEquals(onboardingPage.getOnboardingPageStep5Title(), "Menstrual Cycle Awareness");
	}

	@Given("User is on Personal Details page")
	public void user_is_on_personal_details_page() {

		try {

			String htmlPage = "onboarding4.html";
			String URL = (readConfig.getApplicationURL()) + htmlPage;
			System.out.println("URL>>>" + URL);
			context.getDriver().get(URL);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("User enters valid personal details {string},{string} and {string} and clicks on Continue Button")
	public void user_enters_valid_personal_details_and_and_clicks_on_continue_button(String FirstName, String Age,
			String BPStatus) {
		onboardingPage = new OnboardingPage(driver);
		onboardingPage.enterPersonalDetailsStep4(FirstName, Age);
		onboardingPage.selectBloodPressureStatus(BPStatus);
		onboardingPage.clickOnContinueBtnStep4();
	}

	@Then("Title of the page should be Menstrual Cycle Awareness")
	public void title_of_the_page_should_be_menstrual_cycle_awareness() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep5Title(), "Menstrual Cycle Awareness");
	}

	@Then("Verify description text for step5")
	public void verify_description_text_for_step5() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep5SubTitle(),
				"Understanding your cycle helps us optimize your weight loss journey.");
	}

	@Then("User should see the question on Step5")
	public void user_should_see_the_question_on_step5() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep5QuestionText(),
				"Do you currently track your menstrual cycle?");
	}

	@Then("Progress bar shows the current step as  5 of 10")
	public void progress_bar_shows_the_current_step_as_of5() {
		assertTrue(onboardingPage.isOnboardingProgressBar5of10Displayed(),
				"Onboarding progress bar should show the current step as 5 of 10");
	}

	@Then("Total number of radio buttons in Step5 should be {int}")
	public void total_number_of_radio_buttons_should_be_step5(int expectedCount) {

		Assert.assertEquals(onboardingPage.radioButtonsStep5Size(), expectedCount);
	}

	@Then("Following Radio options for  menstrual cycle awareness should be displayed")
	public void following_radio_options_for_menstrual_cycle_awareness_should_be_displayed(
			io.cucumber.datatable.DataTable dataTable) {

		List<String> expectedRadioOptions = dataTable.asList();

		Assert.assertEquals(onboardingPage.getActualRadioOptionsMenstrualCycleAwareness(), expectedRadioOptions,
				"Radio options do not match");

	}

	@When("User clicks on Back Button on Step5")
	public void user_clicks_on_back_button_on_step5() {
		onboardingPage.clickOnBackBtnStep4();

	}

	@Then("User should navigate to step4 Personal Details")
	public void user_should_navigate_to_step4_personal_details() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep4Title(), "Personal Details");

	}

	@Given("User is on Menstrual Cycle Awareness page")
	public void user_is_on_Menstrual_Cycle_page() {

		try {

			String htmlPage = "onboarding5.html";
			String URL = (readConfig.getApplicationURL()) + htmlPage;
			System.out.println("URL>>>" + URL);
			context.getDriver().get(URL);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@When("User selects {string} radio option on step5 and clicks on Continue Button")
	public void user_selects_radio_option_on_step5_and_clicks_on_continue_button(String cycleInfo) {
		onboardingPage = new OnboardingPage(driver);
		onboardingPage.selectCycleInfoOption(cycleInfo);
		onboardingPage.clickOnContinueBtnStep4();

	}

	@Then("Title of the page should be Last Period Date")
	public void title_of_the_page_should_be_last_period_date() {

		Assert.assertEquals(onboardingPage.getOnboardingPageStep6Title(), "Last Period Date");

	}

	@Then("Verify description text for step6")
	public void verify_description_text_for_step6() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep6SubTitle(),
				"This helps us understand your current cycle phase and tailor recommendations.");
	}

	@Then("User should see the question on Step6")
	public void user_should_see_the_question_on_step6() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep6QuestionText(),
				"When did your last menstrual period start?");
	}

	@Then("User should see the calendar icon in step6")
	public void user_should_see_the_calendar_icon_in_step() {
		assertTrue(onboardingPage.isCalendarIconStep6Displayed(), "Calendar Icon should be displayed");
	}

	@Then("Date input field with placeholder {string} should be displayed")
	public void date_input_field_with_placeholder_should_be_displayed(String datePlaceholderText) {
		Assert.assertEquals(onboardingPage.getDateFieldPlaceholderText(), datePlaceholderText);
	}

	@Then("Label {string} should be visible")
	public void label_should_be_visible(String string) {
		assertTrue(onboardingPage.isCycleLengthLabelDisplayed(), "Label should be displayed");
	}

	@Then("Slider control for cycle length should be displayed")
	public void slider_control_for_cycle_length_should_be_displayed() {
		assertTrue(onboardingPage.isCycleLengthSliderDisplayed(), "Slider control should be displayed");
	}

	@Then("Default cycle length value {string} should be shown beside the slider")
	public void default_cycle_length_value_should_be_shown_beside_the_slider(String defaultLength) {
		Assert.assertEquals(onboardingPage.getDefaultCycleLength(), defaultLength);

	}

	@Then("Information text {string} should be visible")
	public void information_text_should_be_visible(String expectedInfoText) {

		Assert.assertEquals(onboardingPage.getInfoTextStep6(), expectedInfoText);
	}

	@Then("Progress bar shows the current step as  6 of 10")
	public void progress_bar_shows_the_current_step_as_6of10() {

		assertTrue(onboardingPage.isOnboardingProgressBar6of10Displayed(),
				"Onboarding progress bar should show the current step as 6 of 10");
	}

	@When("User clicks on Back Button on Step6")
	public void user_clicks_on_back_button_on_step6() {
		onboardingPage.clickOnBackBtnStep4();
	}

	@Then("User should navigate to step5 Menstrual Cycle Awareness")
	public void user_should_navigate_to_step5_menstrual_cycle_awareness() {
		Assert.assertEquals(onboardingPage.getOnboardingPageStep5Title(), "Menstrual Cycle Awareness");

	}

	@When("User clicks continue button without selecting last menstrual date")
	public void user_clicks_continue_button_without_selecting_last_menstrual_date() {
		onboardingPage.clickOnContinueBtnStep4();
	}

	@When("User clicks continue button after entering invalid value in date")
	public void user_clicks_continue_button_after_entering_invalid_value_in_date() {

		// onboardingPage.enterDateInStep6();
		onboardingPage.clickOnContinueBtnStep4();
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String expectedError) {

		Assert.assertEquals(onboardingPage.getErrorMsgStep6(), "Please select your last period start date");
	}

	@Then("Verify user gets error message on Step4")
	public void verify_user_gets_error_message_on_step4() {
		Assert.assertEquals(onboardingPage.getErrorMsgStep6(), "Please select your last period start date");
	}

	@When("User enters valid personal details for {string} and clicks on Continue Button")
	public void user_enters_valid_personal_details_excel_and_and_clicks_on_continue_button(String testCase) {

		onboardingPage.enterPersonalDetailsStep4(testCase.trim());

	}

	@When("User selects last menstrual date in Step 6 for {string}")
	public void user_selects_last_menstrual_date_in_step(String testCase) {
		
		try {

			String htmlPage = "onboarding62.html";
			String URL = (readConfig.getApplicationURL()) + htmlPage;
			System.out.println("URL>>>" + URL);
			context.getDriver().get(URL);
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}

		onboardingPage.selectLastPeriodDate(testCase.trim());
		onboardingPage.clickOnContinueBtnStep4();
	}

	
	
	@Then("Description text about the current phase {string} should be visible")
	public void description_text_about_the_current_phase_should_be_visible(String expected) {
		
		String actualText = onboardingPage.getDescTextCurrentPhaseStep6();
		Assert.assertTrue(actualText.contains("Based on your last period starting on"));
		Assert.assertTrue(actualText.contains("you're currently in"));
	}

}
