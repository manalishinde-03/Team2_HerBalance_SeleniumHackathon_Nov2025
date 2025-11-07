package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage {

	
	
	// Main Titles
	private final By pageMainTitle = By.xpath("//h1[text()='Profile']");
	private final By editProfileTitle = By.xpath("//div[contains(@class, 'edit-title') and contains(text(),'Edit Your Profile')]");
	private final By subtextEditProfile = By.xpath("//div[contains(@class,'edit-subtitle') and contains(text(),'Update your personal information and preferences')]");

	// Tabs
	private final By allTabs = By.xpath("//div[@class='tabs']//button");
	private final By basicInformationTab = By.xpath("//button[contains(@class,'tab') and contains(text(),'Basic Information')]");
	private final By bodyMetricsTab = By.xpath("//button[contains(@class,'tab') and contains(text(),'Body Metrics')]");
	private final By preferencesHealthTab = By.xpath("//button[contains(@class,'tab') and contains(text(),'Preferences & Health')]");

	// Back Button
	private final By backButton = By.cssSelector("a.back-link");

	// Basic Information Tab
	private final By sectionTitleBasicInfo = By.xpath("//div[contains(@class, 'form-title') and text()='Basic Information']");
	private final By subHeaderBasicInfo = By.xpath("//div[contains(@class, 'form-subtitle') and contains(text(),'Update your name and age')]");
	private final By nameInputField = By.id("name");
	private final By ageInputField = By.id("age");
	private final By nextBodyMetricsButton = By.xpath("//button[contains(@class, 'next-btn') and contains(text(),'Next: Body Metrics')]");

	// Body Metrics Tab
	private final By sectionTitleBodyMetrics = By.xpath("//div[contains(@class, 'form-title') and contains(text(),'Body Metric')]");
	private final By subHeaderBodyMetrics = By.xpath("//div[contains(@class, 'form-subtitle') and contains(text(),'Update your weight and height information')]");
	private final By weightInputField = By.id("weight");
	private final By heightInputField = By.id("height");
	private final By weightUnitDropdown = By.id("weight-unit");
	private final By heightUnitDropdown = By.id("height-unit");
	private final By bmiCalculationSection = By.xpath("//div[contains(@class,'bmi-calculation')]");
	private final By bmiCategorySection = By.xpath("//div[contains(@class,'bmi-category')]");
	private final By bmiCategoryNote = By.xpath("//div[contains(@class,'bmi-note')]");
	private final By bmiSliderGradient = By.xpath("//div[contains(@class,'bmi-slider-gradient')]");
	private final By backButtonBodyMetrics = By.xpath("//button[contains(@class, 'back-link')]");
	private final By nextMetricsButton = By.xpath("//button[contains(@class, 'next-btn') and contains(text(),'Next: Body Metrics')]");

	// Preferences & Health Tab
	private final By sectionTitlePreferencesHealth = By.xpath("//div[contains(@class, 'form-title') and contains(text(),'Preferences & Health')]");
	private final By subHeaderPreferencesHealth = By.xpath("//div[contains(@class, 'form-subtitle') and contains(text(),'Update your dietary preferences and medications')]");
	private final By radioPescatarian = By.xpath("//input[@type='radio' and @value='Pescatarian Diet']");
	private final By radioNonVegetarian = By.xpath("//input[@type='radio' and @value='Non-Vegetarian']");
	private final By radioVegetarian = By.xpath("//input[@type='radio' and @value='Vegetarian diet']");
	private final By radioVegan = By.xpath("//input[@type='radio' and @value='Vegan Diet']");
	private final By addMedicationButton = By.xpath("//button[contains(text(),'Add Medication')]");
	private final By infoTextMedicationSupplements = By.xpath("//div[contains(@class,'medication-info-text')]");
	private final By backButtonPreferences = By.xpath("//button[contains(@class, 'back-link')]");
	private final By saveProfileButton = By.xpath("//button[contains(text(),'Save Profile')]");

	// Medication Popup/Modal
	private final By enterMedicationHeader = By.xpath("//div[contains(@class, 'medication-modal')]//div[contains(text(), 'Enter Medication name')]");
	private final By medicationNameInput = By.xpath("//input[@id='medication-name']");
	private final By okMedicationButton = By.xpath("//button[contains(text(),'Ok')]");
	private final By cancelMedicationButton = By.xpath("//button[contains(text(),'Cancel')]");
	private final By successMedicationMessage = By.xpath("//div[contains(@class,'success-message') and contains(text(),'Your Medication name is saved')]");
	private WebDriver driver;

	public EditPage(WebDriver driver) {
	    this.driver = driver;
	}

	 

	public boolean isEditProfileTitleVisible() {
	    return driver.findElement(editProfileTitle).isDisplayed();
	}

	public boolean isSubTextVisible() {
	    return driver.findElement(subtextEditProfile).isDisplayed();
	}

	public int getTotalTabs() {
	    return driver.findElements(allTabs).size();
	}

	public boolean areTabsVisible() {
	    return driver.findElement(basicInformationTab).isDisplayed()
	        && driver.findElement(bodyMetricsTab).isDisplayed()
	        && driver.findElement(preferencesHealthTab).isDisplayed();
	}

	public boolean isBasicInformationTabDefaultActive() {
	    return driver.findElement(basicInformationTab).getAttribute("class").contains("active");
	}

	public boolean isBackButtonVisible() {
	    return driver.findElement(backButton).isDisplayed();
	}

	public void clickTab(String tabName) {
	    switch(tabName.trim()) {
	        case "Basic Information":
	            driver.findElement(basicInformationTab).click();
	            break;
	        case "Body Metrics":
	            driver.findElement(bodyMetricsTab).click();
	            break;
	        case "Preferences & Health":
	            driver.findElement(preferencesHealthTab).click();
	            break;
	    }
	}

	// Add similar public methods for the rest of your scenarios...

	
	
	
}
