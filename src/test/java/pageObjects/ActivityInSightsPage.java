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
	private By backToDashBoard = By.xpath("//a[text()='Back to Dashboard']");
	private By startingWeightCard = By
			.xpath("//*[contains(text(),'Starting weight')]/ancestor::div[contains(@class,'info')]");

	private By currentWeightCard = By
			.xpath("//*[contains(text(),'Current weight')]/ancestor::div[contains(@class,'info')]");
	private By goalWeightCard = By.xpath("//*[contains(text(),'Goal weight')]/ancestor::div[contains(@class,'info')]");

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

}
