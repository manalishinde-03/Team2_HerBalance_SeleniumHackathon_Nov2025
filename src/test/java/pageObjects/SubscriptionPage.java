package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptionPage {

    private WebDriver driver;

    
    private final By pageTitle = By.xpath("//h1[text()='Subscription']");
	private final By subscriptionManagementHeader = By.xpath("//*[contains(text(),'Subscription Management')]");
	private final By allSections = By.cssSelector(".container > div, .history-section"); // Adjust as per hierarchy

	// ----- Section Headers -----
	private final By currentSubscriptionHeader = By.xpath("//div[contains(@class, 'section-title') and contains(text(),'Current Subscription')]");
	private final By currentSubscriptionSubtext = By.xpath("//div[contains(@class, 'section-subtitle') and contains(text(),'Your active subscription plan details')]");
	private final By subscriptionInformationSubheader = By.xpath("//div[contains(@class,'section-title') and contains(text(),'Subscription Information')]");
	private final By subscriptionBenefitsSubheader = By.xpath("//div[contains(@class,'section-title') and contains(text(),'Subscription Benefits')]");
	private final By goToDashboardButton = By.xpath("//button[contains(text(),'Go to Dashboard')]");

	// ----- Subscription Information -----
	private final By subscriptionInfoStatus = By.xpath("//td[text()='Status:']/following-sibling::td/span[contains(@class,'active')]");
	private final By subscriptionInfoPlan = By.xpath("//td[text()='Plan:']/following-sibling::td");
	private final By subscriptionInfoStartDate = By.xpath("//td[text()='Start Date:']/following-sibling::td");
	private final By subscriptionInfoEndDate = By.xpath("//td[text()='End Date:']/following-sibling::td");

	// ----- Subscription History -----
	private final By subscriptionHistoryHeader = By.xpath("//div[contains(@class, 'history-title') and contains(text(),'Subscription History')]");
	private final By subscriptionHistorySubtext = By.xpath("//div[contains(@class, 'history-subtitle') and contains(text(),'Your subscription payment history')]");
	private final By subscriptionHistorySections = By.cssSelector(".history-section > *:not(.history-title):not(.history-subtitle)"); // For two internal sections

	private final By freePlanHistoryHeader = By.xpath("//div[contains(@class,'history-box-header') and contains(text(),'Free Plan')]");
	private final By freePlanActiveBadge = By.xpath("//span[contains(@class,'history-active-badge') and contains(text(),'active')]");
	private final By freePlanDates = By.xpath("//div[contains(@class,'history-dates')]");
	private final By freePlanCost = By.xpath("//div[contains(@class,'history-payment')]");
	private final By freePlanTransactionId = By.xpath("//div[contains(@class,'history-trans-id') and contains(text(),'Transaction ID')]");
	private final By goToDashboardHistory = By.xpath("//div[contains(@class,'go-dashboard-row')]//button[contains(text(),'Go to Dashboard')]");
    // Page Locators using By
    private By headerTitle = By.xpath("//h2[contains(text(),'Choose Your Transformation Journey')]");
    private By headerSubText = By.xpath("//div[contains(text(),'personalization based on your menstrual cycle phases')]");

    // Free Plan
    private By freePlanTile = By.xpath("//h3[contains(text(),'Free Plan')]/ancestor::div[contains(@class, 'plan')]");
    private By freePlanSubscribeButton = By.xpath("//h3[contains(text(),'Free Plan')]/ancestor::div[contains(@class, 'plan')]//button[contains(text(),'Subscribe Now')]");

    // Monthly Plan
    private By monthlyPlanTile = By.xpath("//span[text()='Most Popular']/ancestor::div[contains(@class, 'plan')]");
    private By monthlyPlanSubscribeButton = By.xpath("//span[text()='Most Popular']/ancestor::div[contains(@class, 'plan')]//button[contains(text(),'Subscribe Now')]");

    // 3-Month Plan
    private By threeMonthPlanTile = By.xpath("//span[text()='Best Value']/ancestor::div[contains(@class, 'plan')]");
    private By threeMonthGetStartedButton = By.xpath("//span[text()='Best Value']/ancestor::div[contains(@class, 'plan')]//button[contains(text(),'Get Started')]");

    // Dashboard
    private By dashboardHeader = By.id("dashboard-header");

    // Constructor
    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods for interactions / assertions
    public boolean isHeaderDisplayed() {
        return driver.findElement(headerTitle).isDisplayed() &&
               driver.findElement(headerSubText).isDisplayed();
    }

    public void subscribeFreePlan() {
        driver.findElement(freePlanSubscribeButton).click();
    }

    public boolean isAtDashboard() {
        return driver.findElement(dashboardHeader).isDisplayed();
    }

    public boolean arePlanTilesDisplayed() {
        return driver.findElement(freePlanTile).isDisplayed() &&
               driver.findElement(monthlyPlanTile).isDisplayed() &&
               driver.findElement(threeMonthPlanTile).isDisplayed();
    }

    public void subscribeMonthlyPlan() {
        driver.findElement(monthlyPlanSubscribeButton).click();
    }

    public void startThreeMonthPlan() {
        driver.findElement(threeMonthGetStartedButton).click();
    }
    
    
    public boolean isSubscriptionManagementHeaderVisible() {
	    return driver.findElement(subscriptionManagementHeader).isDisplayed();
	}
	public int getSectionCount() {
	    return driver.findElements(allSections).size();
	}
	public boolean areSectionHeadersVisible() {
	    return driver.findElement(currentSubscriptionHeader).isDisplayed() && 
	           driver.findElement(subscriptionHistoryHeader).isDisplayed();
	}

	// --- Current Subscription Section ---
	public boolean isCurrentSubscriptionHeaderVisible() {
	    return driver.findElement(currentSubscriptionHeader).isDisplayed();
	}
	public boolean isCurrentSubscriptionSubtextVisible() {
	    return driver.findElement(currentSubscriptionSubtext).isDisplayed();
	}
	public boolean areCurrentSubscriptionSubheadersVisible() {
	    return driver.findElement(subscriptionInformationSubheader).isDisplayed() &&
	           driver.findElement(subscriptionBenefitsSubheader).isDisplayed();
	}
	public boolean isSubscriptionStatusVisible() {
	    return driver.findElement(subscriptionInfoStatus).isDisplayed();
	}
	public boolean isSubscriptionPlanVisible() {
	    return driver.findElement(subscriptionInfoPlan).isDisplayed();
	}
	public boolean isSubscriptionStartDateVisible() {
	    return driver.findElement(subscriptionInfoStartDate).isDisplayed();
	}
	public boolean isSubscriptionEndDateVisible() {
	    return driver.findElement(subscriptionInfoEndDate).isDisplayed();
	}
	public boolean isGoToDashboardButtonEnabled() {
	    WebElement btn = driver.findElement(goToDashboardButton);
	    return btn.isDisplayed() && btn.isEnabled();
	}

	// --- Subscription History Section ---
	public boolean isSubscriptionHistoryHeaderVisible() {
	    return driver.findElement(subscriptionHistoryHeader).isDisplayed();
	}
	public boolean isSubscriptionHistorySubtextVisible() {
	    return driver.findElement(subscriptionHistorySubtext).isDisplayed();
	}
	public int getSubscriptionHistorySectionCount() {
	    return driver.findElements(subscriptionHistorySections).size();
	}
	public boolean areFreePlanHistoryHeaderAndDashboardVisible() {
	    return driver.findElement(freePlanHistoryHeader).isDisplayed() &&
	           driver.findElement(goToDashboardHistory).isDisplayed();
	}
	public boolean isFreePlanDatesVisible() {
	    return driver.findElement(freePlanDates).isDisplayed();
	}
	public boolean isFreePlanCostVisible() {
	    return driver.findElement(freePlanCost).isDisplayed();
	}
	public boolean isFreePlanTransactionIdVisible() {
	    return driver.findElement(freePlanTransactionId).isDisplayed();
	}
	
	// Click the Dashboard button from Subscription page
	public void clickGoToDashboard() {
	    driver.findElement(goToDashboardButton).click();
	}

	// Get text of the subscription plan
	public String getSubscriptionPlanText() {
	    return driver.findElement(subscriptionInfoPlan).getText();
	}

	// Get current subscription status text (e.g. Active)
	public String getSubscriptionStatusText() {
	    return driver.findElement(subscriptionInfoStatus).getText();
	}

	// Verify if the Dashboard header text matches expected
	public boolean isDashboardHeaderText(String expectedText) {
	    return driver.findElement(dashboardHeader).getText().equals(expectedText);
	}

	// Check presence of free plan active badge in history
	public boolean isFreePlanActiveBadgeVisible() {
	    return driver.findElement(freePlanActiveBadge).isDisplayed();
	}

	// Get subscription history transactions count
	public int getSubscriptionHistoryTransactionCount() {
	    return driver.findElements(subscriptionHistorySections).size();
	}

	// Click a section title (by visible text)
	public void clickSectionByTitle(String sectionTitle) {
	    By sectionLocator = By.xpath("//div[contains(@class, 'section-title') and contains(text(),'" + sectionTitle + "')]");
	    driver.findElement(sectionLocator).click();
	}


}
