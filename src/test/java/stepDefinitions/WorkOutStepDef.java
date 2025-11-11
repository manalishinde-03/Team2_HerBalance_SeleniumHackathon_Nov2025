package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.TestContext;
import pageObjects.WorkOutPage;
import utilities.ElementUtil;
import utilities.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
			System.out.println("The return value for maindashboard display is :"+isMainDashBoard);
			
		} catch (Exception e) {
			System.err.println("Exception  opening main DashBoard : " + e.getMessage());
			e.printStackTrace();

		}
	}

	@When("user clicks workout button on navigation bar")
	public void user_clicks_workout_button_on_navigation_bar() {
		workOutPage.clickOnWorkOut();
	}

	@Then("User should see page title as {string}")
	public void user_should_see_page_title_as(String expectedTitle) {
		boolean isDailyPersonalised = workOutPage.isDailyPersonalisedDisplayed();
		
		System.out.println("The Daily Personalised Page is displayed  "+isDailyPersonalised);
		System.out.println("The text of Daily personalised element is :");
	}

}
