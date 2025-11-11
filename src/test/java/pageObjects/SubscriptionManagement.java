package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SubscriptionManagement {
	
	
	
	
	// ----- Main Page -----
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
	private WebDriver driver;

	 public SubscriptionManagement(WebDriver driver) {
	        this.driver = driver;
	    }

	// --- Main Page ---
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

	
	
	
	
	
	
	
	
	

}
