package pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ElementUtil;
import utilities.ReadConfig;

public class ActivityInSightsPage {
	private WebDriver driver;
	private ElementUtil util;
	private ReadConfig readConfig;
	private By userNameElem = By.xpath("//input[@type='email']");

	private By passWordElem = By.xpath("//input[@type='password']");
	private By loginButton = By.xpath("//button[@class='login-btn']");
	private By activityInsights = By.xpath("//div[@class='menu-item' and normalize-space(text())='Activity Insights']");
	private List<By> activitySubmenuOptions = Arrays.asList(By.xpath("//a[text()='Track Weight']"),
			By.xpath("//a[text()='Food Intake']"), By.xpath("//a[text()='Menstrual Phase Logs']"));
	private By trackWeight = By.xpath("//a[text()='Track Weight']");
	private By backToDashBoard = By.xpath("//a[normalize-space()='← Back to Dashboard']");
	private By startingWeightCard = By.xpath("//label[normalize-space()='Starting Weight']");

	private By currentWeightCard = By.xpath("//label[normalize-space()='Current Weight']");
	private By goalWeightCard = By.xpath("//label[normalize-space()='Goal Weight']");
	private By startingWeightValue = By.xpath("//label[normalize-space()='Starting Weight']/following-sibling::div");
	private By currentWeightValue = By.xpath("//label[normalize-space()='Current Weight']/following-sibling::div");
	private By goalWeightValue = By.xpath("//label[normalize-space()='Goal Weight']/following-sibling::div");
	private By progressOverviewHeader = By.xpath("//h2[normalize-space()='Progress Overview']");
	private By weightLossProgressBar = By.xpath("//label[normalize-space()='Weight Loss Progress']");
	// h3[text()='Weight Progression Over Time']
	private By weightProgressOverTimeHeader = By.xpath("//h3[text()='Weight Progression Over Time']");
	private By remainingBar = By.xpath("//p[normalize-space()='Remaining']");
	private By chartCanvas = By.id("weightChart");

	public ActivityInSightsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
		readConfig = new ReadConfig();

	}

	public void enterUsername() {
		String userName = readConfig.getUsername();
		util.doSendKeys(userNameElem, userName);

	}

	public void enterPassword() {
		String passWord = readConfig.getPassword();
		util.doSendKeys(passWordElem, passWord);
	}

	public void clickOnLogin() {
		util.doClick(loginButton);
	}

	public void clickOnActivityInsights() {

		util.doClick(activityInsights);
	}

	public boolean isActivityInsightsExpanded() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			for (By option : activitySubmenuOptions) {
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(option));
				if (!element.isDisplayed()) {
					System.out.println("Submenu item not visible: " + option);
					return false;
				}
			}
			return true;
		} catch (TimeoutException e) {
			System.out.println(" Activity Insights submenu is not fully expanded.");
			return false;
		}
	}

	public void clickOnTrackWeight() {
		util.doClick(trackWeight);
	}

	public boolean backToDashBoardDisplayed() {
		return util.isElementAvailable(backToDashBoard);
	}

	public boolean startingWeightCardDisplayed() {
		return util.isElementAvailable(startingWeightCard);
	}

	public boolean currentWeightCardDisplayed() {
		return util.isElementAvailable(currentWeightCard);
	}

	public boolean goalWeightCardDisplayed() {
		return util.isElementAvailable(goalWeightCard);
	}

	public boolean isCardCenterAligned(By cardLocator) {
		WebElement card = driver.findElement(cardLocator);
		return isHorizontallyCentered(card);
	}

	public boolean isStartingWeightCardCentered() {
		return isCardCenterAligned(startingWeightCard);
	}

	public boolean isCurrentWeightCardCentered() {
		return isCardCenterAligned(currentWeightCard);
	}

	public boolean isGoalWeightCardCentered() {
		return isCardCenterAligned(goalWeightCard);
	}

	public boolean isHorizontallyCentered(WebElement element) {
		WebElement parent = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].parentElement;", element);

		int elementCenter = element.getLocation().getX() + element.getSize().getWidth() / 2;
		int parentCenter = parent.getLocation().getX() + parent.getSize().getWidth() / 2;

		int tolerance = 5;
		return Math.abs(elementCenter - parentCenter) <= tolerance;
	}

	public boolean isStartingWeightValueDisplayed() {

		return util.isElementAvailable(startingWeightValue);
	}

	public String getStartingWeightValue() {

		return util.getElementText(startingWeightValue).trim();
	}

	public String getCurrentWeightValue() {
		return util.getElementText(currentWeightValue).trim();
	}

	public boolean isGoalWeightValueDisplayed() {

		return util.isElementAvailable(goalWeightValue);
	}

	public String goalWeightValue() {

		return util.getElementText(goalWeightValue).trim();
	}

	public String getProgressOverviewHeaderText() {
		return util.getElementText(progressOverviewHeader).trim();
	}

	public boolean isProgressOverviewHeaderDisplayed() {
		return util.isElementAvailable(progressOverviewHeader);
	}

	public boolean isWeightLossProgressBarDisplayed() {

		return util.isElementAvailable(weightLossProgressBar);
	}

	public String getWeightLossProgressBarText() {
		return util.getElementText(weightLossProgressBar).trim();
	}

	public boolean isRemainingDisplayed() {

		return util.isElementAvailable(remainingBar);
	}

	public String getRemainingText() {
		return util.getElementText(remainingBar).trim();
	}

	public boolean isWeightProgressOverTimeHeaderDisplayed() {

		return util.isElementAvailable(weightProgressOverTimeHeader);
	}

	public String getWeightProgressOverTimeHeaderText() {
		return util.getElementText(weightProgressOverTimeHeader).trim();
	}

	public boolean isGraphVisible() {
		return util.isElementAvailable(chartCanvas);
	}

	// Extract X-axis labels from Chart.js config
	public String[] getXAxisLabels() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object labelsObj = js.executeScript("return weightChart.config.data.labels;");
		// convert JS returned list to Java String[]
		return ((java.util.List<String>) labelsObj).toArray(new String[0]);
	}

	// Extract Y-axis title from Chart.js config
	public String getYAxisTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return weightChart.config.options.scales.y.title.text;");
	}

	// Extract Y-axis tick labels
	@SuppressWarnings("unchecked")
	public List<String> getYAxisTickLabels() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object ticksObj = js.executeScript("return weightChart.scales.y.ticks.map(t => t.label);");
		return (List<String>) ticksObj;
	}
}
