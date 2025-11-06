package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.LaunchPage;
import pageObjects.SignUpPage;
import utilities.ReadConfig;


public class CommonStepDef {

	WebDriver driver;
	TestContext context;
	LaunchPage launchPage;
	SignUpPage signUpPage = new SignUpPage(driver);
	ReadConfig readConfig = new ReadConfig();
	
	public CommonStepDef(TestContext context) {
		this.context = context;
	      this.driver = context.getDriver();
		
	}
	
	@Given("The browser is open")
	public void the_browser_is_open() {
		//String browserName = readConfig.getbrowser();
		
		String browserName ="chrome";
		driver = context.getDriverFactory().initialiseBrowser(browserName);
	}

	@Given("User enters the correct HerBalance URL")
	public void user_enters_the_correct_url() {

		context.setDriver(driver);
		String htmlPage = "LaunchPage.html";
		String URL = (readConfig.getApplicationURL())+htmlPage;
		System.out.println("URL>>>"+URL);
		context.getDriver().get(URL);

	}

	@Then("User is on the HerBalance Launch Page")
	public void admin_lands_on_login_page() {
		launchPage = new LaunchPage(driver);
		//Assert.assertTrue(launchPage.getPageURL().contains("LaunchPage"));
	}
	
	@Given("User clicks on sign up")
	public void user_clicks_on_sign_up() {
		launchPage = new LaunchPage(driver);
		launchPage.clickOnSignUpButton();
	}

	
	@Given("User is on sign up page")
	public void user_is_on_sign_up_page() {
		
		signUpPage = new SignUpPage(driver);
		
		
		String signUpPageTitle = signUpPage.getPageTitle();
		
		System.out.println("Page title is: " + signUpPageTitle);
		Assert.assertEquals(signUpPageTitle, "Her Balance - Register");
	    
	}

	
	
}
