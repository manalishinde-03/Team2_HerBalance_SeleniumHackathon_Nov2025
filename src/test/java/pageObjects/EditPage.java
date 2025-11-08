package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage {

	
	
	// Main Titles
	// ---- Main UI ----
	private final By editProfileTitle = By.xpath("//div[contains(@class, 'edit-title') and contains(text(),'Edit Your Profile')]");
	private final By editProfileSubtitle = By.xpath("//div[contains(@class,'edit-subtitle') and contains(text(),'Update your personal information and preferences')]");
	private final By allTabs = By.xpath("//div[@class='tabs']//button");
	private final By basicInformationTab = By.xpath("//button[contains(@class,'tab') and contains(text(),'Basic Information')]");
	private final By bodyMetricsTab = By.xpath("//button[contains(@class,'tab') and contains(text(),'Body Metrics')]");
	private final By preferencesHealthTab = By.xpath("//button[contains(@class,'tab') and contains(text(),'Preferences & Health')]");
	private final By backButton = By.cssSelector("a.back-link");

	// ---- Basic Information Tab ----
	private final By sectionHeaderBasic = By.xpath("//div[contains(@class, 'form-title') and text()='Basic Information']");
	private final By sectionSubtitleBasic = By.xpath("//div[contains(@class, 'form-subtitle') and contains(text(),'Update your name and age')]");
	private final By nameInputField = By.id("name");
	private final By ageInputField = By.id("age");
	private final By nextBodyMetricsButton = By.xpath("//button[contains(@class, 'next-btn') and contains(text(),'Next: Body Metrics')]");

	// ---- Body Metrics Tab ----
	private final By sectionHeaderBody = By.xpath("//div[contains(@class, 'form-title') and contains(text(),'Body Metric')]");
	private final By sectionSubtitleBody = By.xpath("//div[contains(@class, 'form-subtitle') and contains(text(),'Update your weight and height information')]");
	private final By weightInputField = By.id("weight");
	private final By heightInputField = By.id("height");
	private final By weightUnitDropdown = By.id("weight-unit");
	private final By heightUnitDropdown = By.id("height-unit");
	private final By instructionHeightDecimal = By.xpath("//*[contains(text(),'Please enter your height in decimal format')]");
	private final By bmiCalculationSection = By.xpath("//*[contains(text(),'BMI Calculation Number')]");
	private final By bmiSliderGradient = By.xpath("//div[contains(@class,'bmi-slider-gradient')]");
	private final By bmiCategorySection = By.xpath("//div[contains(@class,'bmi-category')]");
	private final By bmiCategoryNote = By.xpath("//*[contains(text(),'BMI Category note')]");
	private final By backButtonBodyMetrics = By.xpath("//button[contains(@class, 'back-link')]");
	private final By nextMetricsButton = By.xpath("//button[contains(@class, 'next-btn') and contains(text(),'Next: Body Metrics')]");

	// ---- Preferences & Health Tab ----
	private final By sectionHeaderPreferences = By.xpath("//div[contains(@class, 'form-title') and contains(text(),'Preferences & Health')]");
	private final By sectionSubtitlePreferences = By.xpath("//div[contains(@class, 'form-subtitle') and contains(text(),'Update your dietary preferences and medications')]");
	private final By radioPescatarian = By.xpath("//input[@type='radio' and @value='Pescatarian Diet']");
	private final By radioNonVegetarian = By.xpath("//input[@type='radio' and @value='Non-Vegetarian']");
	private final By radioVegetarian = By.xpath("//input[@type='radio' and @value='Vegetarian diet']");
	private final By radioVegan = By.xpath("//input[@type='radio' and @value='Vegan Diet']");
	private final By addMedicationButton = By.xpath("//button[contains(text(),'Add Medication')]");
	private final By infoTextMedicationSupplements = By.xpath("//*[contains(text(),'Information text for Medication & Supplements')]");
	private final By backButtonPreferences = By.xpath("//button[contains(@class, 'back-link')]");
	private final By saveProfileButton = By.xpath("//button[contains(text(),'Save Profile')]");

	// ---- Medication Modal ----
	private final By medicationModalHeader = By.xpath("//*[contains(text(),'Enter Medication name')]");
	private final By medicationNameInput = By.xpath("//input[@id='medication-name']");
	private final By okMedicationButton = By.xpath("//button[contains(text(),'Ok')]");
	private final By cancelMedicationButton = By.xpath("//button[contains(text(),'Cancel')]");
	private final By successMedicationMessage = By.xpath("//*[contains(text(),'Your Medication name is saved')]");

	private WebDriver driver;

	public EditPage(WebDriver driver) {
	    this.driver = driver;
	}

	// ---- Main UI ----
	public boolean isEditProfileTitleVisible() {
	    return driver.findElement(editProfileTitle).isDisplayed();
	}
	public boolean isEditProfileSubtitleVisible() {
	    return driver.findElement(editProfileSubtitle).isDisplayed();
	}
	public int getTotalTabs() {
	    return driver.findElements(allTabs).size();
	}
	public boolean areAllTabsVisible() {
	    return driver.findElement(basicInformationTab).isDisplayed() &&
	           driver.findElement(bodyMetricsTab).isDisplayed() &&
	           driver.findElement(preferencesHealthTab).isDisplayed();
	}
	public boolean isBasicTabDefaultActive() {
	    return driver.findElement(basicInformationTab).getAttribute("class").contains("active");
	}
	public boolean isBackButtonVisible() {
	    return driver.findElement(backButton).isDisplayed();
	}

	// ---- Basic Information Tab ----
	public boolean isSectionHeaderBasicVisible() {
	    return driver.findElement(sectionHeaderBasic).isDisplayed();
	}
	public boolean isSectionSubtitleBasicVisible() {
	    return driver.findElement(sectionSubtitleBasic).isDisplayed();
	}
	public boolean isNameInputFieldVisible() {
	    return driver.findElement(nameInputField).isDisplayed();
	}
	public boolean isAgeInputFieldVisible() {
	    return driver.findElement(ageInputField).isDisplayed();
	}
	public String getNameFieldValue() {
	    return driver.findElement(nameInputField).getAttribute("value");
	}
	public String getAgeFieldValue() {
	    return driver.findElement(ageInputField).getAttribute("value");
	}
	public boolean isNextBodyMetricsButtonEnabled() {
	    WebElement btn = driver.findElement(nextBodyMetricsButton);
	    return btn.isDisplayed() && btn.isEnabled();
	}

	// ---- Body Metrics Tab ----
	public void clickBodyMetricsTab() {
	    driver.findElement(bodyMetricsTab).click();
	}
	public boolean isSectionHeaderBodyVisible() {
	    return driver.findElement(sectionHeaderBody).isDisplayed();
	}
	public boolean isSectionSubtitleBodyVisible() {
	    return driver.findElement(sectionSubtitleBody).isDisplayed();
	}
	public boolean isWeightInputFieldVisible() {
	    return driver.findElement(weightInputField).isDisplayed();
	}
	public boolean isHeightInputFieldVisible() {
	    return driver.findElement(heightInputField).isDisplayed();
	}
	public boolean isInstructionHeightDecimalVisible() {
	    return driver.findElement(instructionHeightDecimal).isDisplayed();
	}
	public boolean isWeightUnitDropdownEnabled() {
	    WebElement el = driver.findElement(weightUnitDropdown);
	    return el.isDisplayed() && el.isEnabled();
	}
	public boolean isHeightUnitDropdownEnabled() {
	    WebElement el = driver.findElement(heightUnitDropdown);
	    return el.isDisplayed() && el.isEnabled();
	}
	public boolean isBMISectionVisible() {
	    return driver.findElement(bmiCalculationSection).isDisplayed();
	}
	public boolean isBMICategorySectionVisible() {
	    return driver.findElement(bmiCategorySection).isDisplayed();
	}
	public boolean isBMICategoryNoteVisible() {
	    return driver.findElement(bmiCategoryNote).isDisplayed();
	}
	public boolean isBMISliderGradientVisible() {
	    return driver.findElement(bmiSliderGradient).isDisplayed();
	}
	public boolean isBackButtonBodyMetricsVisible() {
	    WebElement btn = driver.findElement(backButtonBodyMetrics);
	    return btn.isDisplayed() && btn.isEnabled();
	}
	public boolean isNextMetricsButtonEnabled() {
	    WebElement btn = driver.findElement(nextMetricsButton);
	    return btn.isDisplayed() && btn.isEnabled();
	}

	// ---- Preferences & Health Tab ----
	public void clickPreferencesTab() {
	    driver.findElement(preferencesHealthTab).click();
	}
	public boolean isSectionHeaderPreferencesVisible() {
	    return driver.findElement(sectionHeaderPreferences).isDisplayed();
	}
	public boolean isSectionSubtitlePreferencesVisible() {
	    return driver.findElement(sectionSubtitlePreferences).isDisplayed();
	}
	public boolean areDietaryRadioButtonsEnabled() {
	    return driver.findElement(radioPescatarian).isEnabled() &&
	           driver.findElement(radioNonVegetarian).isEnabled() &&
	           driver.findElement(radioVegetarian).isEnabled() &&
	           driver.findElement(radioVegan).isEnabled();
	}
	public boolean isAddMedicationButtonEnabled() {
	    WebElement btn = driver.findElement(addMedicationButton);
	    return btn.isDisplayed() && btn.isEnabled();
	}
	public boolean isInfoTextMedicationSupplementsVisible() {
	    return driver.findElement(infoTextMedicationSupplements).isDisplayed();
	}
	public boolean isBackButtonPreferencesVisible() {
	    WebElement btn = driver.findElement(backButtonPreferences);
	    return btn.isDisplayed() && btn.isEnabled();
	}
	public boolean isSaveProfileButtonEnabled() {
	    WebElement btn = driver.findElement(saveProfileButton);
	    return btn.isDisplayed() && btn.isEnabled();
	}
	public void clickAddMedicationButton() {
	    driver.findElement(addMedicationButton).click();
	}

	// ---- Medication Modal ----
	public boolean isMedicationModalHeaderVisible() {
	    return driver.findElement(medicationModalHeader).isDisplayed();
	}
	public boolean isMedicationNameInputPresentAndEmpty() {
	    WebElement input = driver.findElement(medicationNameInput);
	    return input.isDisplayed() && input.getAttribute("value").isEmpty();
	}
	public boolean areOkAndCancelButtonsVisible() {
	    return driver.findElement(okMedicationButton).isDisplayed() &&
	           driver.findElement(cancelMedicationButton).isDisplayed();
	}
	public int getMedicationDialogButtonCount() {
	    int count = 0;
	    if (driver.findElement(okMedicationButton).isDisplayed()) count++;
	    if (driver.findElement(cancelMedicationButton).isDisplayed()) count++;
	    return count;
	}
	public void enterMedicationAndConfirm(String medicationName) {
	    driver.findElement(medicationNameInput).sendKeys(medicationName);
	    driver.findElement(okMedicationButton).click();
	}
	public void clickCancelMedicationButton() {
	    driver.findElement(cancelMedicationButton).click();
	}
	public boolean isSuccessMedicationMessageVisible() {
	    return driver.findElement(successMedicationMessage).isDisplayed();
	}

}
