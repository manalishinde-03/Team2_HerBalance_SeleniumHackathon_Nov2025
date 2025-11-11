package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;
import utilities.ReadConfig;

public class WorkOutPage {

	private WebDriver driver;
	private ElementUtil util;
	private ReadConfig readConfig;
	public WorkOutPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
		readConfig = new ReadConfig();

	}
	
	private By mainDashBoard = By.xpath("//h1[text()='Free Plan Dashboard']");
	
	private By workOut = By.xpath("//a[text()='Workout']");
	
	
	private By dailyPersonalisedWorkOut= By.xpath("//h1[text()='Daily Personalized Workouts']");
	
	private By backToDashBoard= By.xpath("//a[text()='← Back to Dashboard']");
	private By dailyWorkOutPlan= By.xpath("//h2[text()='Daily Workout Plan']");
	
	private By freshAI= By.xpath("//p[text()='Fresh AI-powered workout tailored to your current cycle phase.']");
	
	public String getMainDashBoardUrl() {
		return util.getPageURL();
	}
	public boolean isMainDashBoardDisplayed() {
		return util.isElementDisplayed(mainDashBoard);
	}
	
	public void clickOnWorkOut() {
		util.doClick(workOut);
	}
	
	public boolean isDailyPersonalisedDisplayed() {
		return util.isElementDisplayed(dailyPersonalisedWorkOut);
	}
	
	public String DailyPersonalisedGetText() {
		return util.getElementText(dailyPersonalisedWorkOut);
	}
	public boolean isBacktoDashBoardDisplayed() {
		return util.isElementDisplayed(backToDashBoard);
	}
	
	public String getBacktoDashBoardText() {
		return util.getElementText(backToDashBoard);
	}
	
	
	
	public boolean isdailyWorkOutPlanDisplayed() {
		return util.isElementDisplayed(dailyWorkOutPlan);
	}
	
	public String getdailyWorkOutPlanText() {
		return util.getElementText(dailyWorkOutPlan);
	}
	
	public boolean isfreshAIDisplayed() {
		return util.isElementDisplayed(freshAI);
	}
	
	public String getfreshAIText() {
		return util.getElementText(freshAI);
	}
}
