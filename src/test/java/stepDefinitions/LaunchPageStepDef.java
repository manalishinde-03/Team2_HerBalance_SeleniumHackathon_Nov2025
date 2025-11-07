package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import hooks.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;
import utilities.ReadConfig;

public class LaunchPageStepDef {
	WebDriver driver;
	ReadConfig readConfig;
	TestContext context;
	LaunchPage launchPage;
	SoftAssert softAssert;
	 boolean menstralDisplay = false;
	  String actualMenstralText = "";
	
	public LaunchPageStepDef(TestContext Context) {
		this.context = Context;
		this.driver = context.getDriver();
		this.readConfig = new ReadConfig();
		launchPage = new LaunchPage(driver);
		softAssert = new SoftAssert();
	
	}
	@Given("User is on the browser")
	public void user_is_on_the_browser() {
		String browserName = readConfig.getbrowser();
		driver = context.getDriverFactory().initialiseBrowser(browserName);
	}

	@When("User enters app url")
	public void user_enters_app_url() {
		String htmlPage = "LaunchPage.html";
		String URL = (readConfig.getApplicationURL())+htmlPage;
		System.out.println("URL>>>"+URL);
		context.setDriver(driver);
		context.getDriver().get(URL);
	}

	@Then("Display cards for {string}, {string}, {string}, and {string}")
	public void display_cards_for_and(String expectedMenstralText, String expectedFollicularText, String expectedOvulationText, String expectedLuteal) {
		 try {
		        menstralDisplay = launchPage.isMenstrualPhaseDisplayed();
		        actualMenstralText = launchPage.getMenstrualText();
		    } catch (Exception e) {
		        System.out.println("Expected: Dummy xpath should not be found.");
		    }
		    softAssert.assertEquals(actualMenstralText, expectedMenstralText, "Text mismatch for Menstrual card");
		    softAssert.assertTrue(menstralDisplay, "The menstrual card is NOT displayed!");
		    softAssert.assertAll(); 
		

	}

}
