package pageObjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
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
	private By userNameElem = By.xpath("//username");

	private By passWordElem = By.xpath("//password");
	private By loginButton = By.xpath("//login");
	private By activityInsights = By.xpath("activity");
	private List<By> activitySubmenuOptions = Arrays.asList(By.xpath("//trackweight']"), By.xpath("//foodintake"),
			By.xpath("menustrallogs"));
	private By trackWeight = By.xpath("trackweight");

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

}
