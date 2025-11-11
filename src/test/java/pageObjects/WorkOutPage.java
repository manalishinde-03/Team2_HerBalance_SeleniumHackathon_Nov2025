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
}
