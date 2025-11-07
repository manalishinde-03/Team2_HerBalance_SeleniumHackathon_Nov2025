package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptionPage {

    private WebDriver driver;

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
}
