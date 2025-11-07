package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
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

		assertTrue(onboardingPage.isOnboardingProgressBar1of10Displayed(), "Onboarding progress bar should show the current step as 1 of 10");

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
		assertTrue(onboardingPage.isExplanationTextDisplayed(), "Explanation text about continuing without lab results should be displayed");
	
		String expectedText = "You can continue without uploading lab\r\n"
				+ "results and add this\r\n"
				+ "information later for\r\n"
				+ "more personalized\r\n"
				+ "recommendations.";
		Assert.assertEquals(onboardingPage.getSkipExplanationText(), expectedText);
	}

	@Then("Continue Without Report button is displayed")
	public void continue_without_report_button_is_displayed() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isContinueWithoutReportBtnDisplayed(), "Continue Without Report button should be displayed");
	}

	@Then("Continue Without Report button is enabled")
	public void continue_without_report_button_is_enabled() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isContinueWithoutReportBtnEnabled(), "Continue Without Report button should be enabled");
	}

	@Then("Note about secure processing and no sharing with third parties is displayed")
	public void note_about_secure_processing_and_no_sharing_with_third_parties_is_displayed() {
		onboardingPage = new OnboardingPage(driver);
		assertTrue(onboardingPage.isDataSecurityTextDisplayed(), "Note about secure processing and no sharing with third parties Text should be displayed");
	
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
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("User should see Windows Explorer opened")
public void user_should_see_windows_explorer_opened() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
