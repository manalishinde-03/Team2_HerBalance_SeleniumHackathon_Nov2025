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

	// Locators
	private By mainDashBoard = By.xpath("//h1[text()='Free Plan Dashboard']");
	private By workOut = By.xpath("//a[text()='Workout']");
	private By dailyPersonalisedWorkOut = By.xpath("//h1[text()='Daily Personalized Workouts']");
	private By backToDashBoard = By.xpath("//a[text()='← Back to Dashboard']");
	private By dailyWorkOutPlan = By.xpath("//h2[text()='Daily Workout Plan']");
	private By freshAI = By.xpath("//p[text()='Fresh AI-powered workout tailored to your current cycle phase.']");
	private By noWorkOutPlan = By.xpath("//strong[text()='No workout plan found']");
	private By noWorkoutMessageStrong = By.xpath("//p/strong[text()='No workout plan found']");
	private By noWorkoutMessageDetail = By.xpath("//p[contains(text(),'Generate a personalized daily workout plan')]");
	private By generateWorkoutBtn = By.xpath("//button[text()='Generate Workout Plan']");
	private By lutealPhaseSection = By.xpath("//h2[text()='Your Luteal Phase Workouts']");
	private By lutealPhaseDescription = By.xpath("//div[@class='section']/p[contains(text(),'luteal phase')]");
	private By benefitsSection = By.xpath("//h2[text()='Benefits of Cycle-Synced Workouts']");
	private By sevenDayPlanDescription = By.xpath("//div[contains(@class,'green-box')]/p");

	private boolean isDisplayed(By locator) {
		return util.isElementDisplayed(locator);
	}

	private String getText(By locator) {
		return util.getElementText(locator);
	}

	public String getMainDashBoardUrl() {
		return util.getPageURL();
	}

	public boolean isMainDashBoardDisplayed() {
		return isDisplayed(mainDashBoard);
	}

	public void clickOnWorkOut() {
		util.doClick(workOut);
	}

	public boolean isDailyPersonalisedDisplayed() {
		return isDisplayed(dailyPersonalisedWorkOut);
	}

	public String getDailyPersonalisedText() {
		return getText(dailyPersonalisedWorkOut);
	}

	public boolean isBacktoDashBoardDisplayed() {
		return isDisplayed(backToDashBoard);
	}

	public String getBacktoDashBoardText() {
		return getText(backToDashBoard);
	}

	public boolean isDailyWorkOutPlanDisplayed() {
		return isDisplayed(dailyWorkOutPlan);
	}

	public String getDailyWorkOutPlanText() {
		return getText(dailyWorkOutPlan);
	}

	public boolean isFreshAIDisplayed() {
		return isDisplayed(freshAI);
	}

	public String getFreshAIText() {
		return getText(freshAI);
	}

	public boolean isNoWorkOutPlanDisplayed() {
		return isDisplayed(noWorkOutPlan);
	}

	public String getNoWorkOutPlanText() {
		return getText(noWorkOutPlan);
	}

	public boolean isNoWorkoutMessageDisplayed() {
		return util.isElementDisplayed(noWorkoutMessageStrong) && util.isElementDisplayed(noWorkoutMessageDetail);
	}

	public String getNoWorkoutMessageText() {
		String strongText = util.getElementText(noWorkoutMessageStrong);
		String detailText = util.getElementText(noWorkoutMessageDetail);
		return strongText + " " + detailText;
	}

	public String getNoWorkoutMessageAlignment() {
		return util.getCssValue(noWorkoutMessageDetail, "text-align");
	}
	
	public boolean isGenerateWorkoutButtonDisplayed() {
	    return util.isElementDisplayed(generateWorkoutBtn);
	}

	public String getGenerateWorkoutButtonText() {
	    return util.getElementText(generateWorkoutBtn);
	}
	public boolean isLutealPhaseSectionDisplayed() {
	    return util.isElementDisplayed(lutealPhaseSection);
	}

	public String getLutealPhaseSectionText() {
	    return util.getElementText(lutealPhaseSection);
	}
	
	public boolean isLutealPhaseDescriptionDisplayed() {
	    return util.isElementDisplayed(lutealPhaseDescription);
	}

	public String getLutealPhaseDescriptionText() {
	    return util.getElementText(lutealPhaseDescription);
	}
	public boolean isBenefitsSectionDisplayed() {
	    return util.isElementDisplayed(benefitsSection);
	}

	public String getBenefitsSectionText() {
	    return util.getElementText(benefitsSection);
	}
	public boolean isSevenDayPlanDescriptionDisplayed() {
	    return util.isElementDisplayed(sevenDayPlanDescription);
	}

	public String getSevenDayPlanDescriptionText() {
	    return util.getElementText(sevenDayPlanDescription);
	}
}
