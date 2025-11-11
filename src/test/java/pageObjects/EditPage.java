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
	
	// Check if a section is present by visible header or container
	public boolean isSectionPresent(String sectionName) {
	    try {
	        // Example: locate by section header text dynamically
	        By sectionHeader = By.xpath("//div[contains(@class, 'form-title') and contains(text(),'" + sectionName + "')]");
	        return driver.findElement(sectionHeader).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Check if slider gradient (e.g. BMI slider) is displayed correctly
	public boolean isSliderGradientCorrect() {
	    try {
	        WebElement slider = driver.findElement(bmiSliderGradient);
	        return slider.isDisplayed(); // Additional color check logic can be added if needed
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Check if a specified button is visible and enabled
	public boolean isButtonVisibleAndEnabled(String buttonText) {
	    try {
	        By button = By.xpath("//button[contains(text(),'" + buttonText + "')]");
	        WebElement btnElement = driver.findElement(button);
	        return btnElement.isDisplayed() && btnElement.isEnabled();
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Check if given radio button is visible and enabled
	public boolean isRadioButtonVisibleAndEnabled(String radioButtonValue) {
	    try {
	        By radioButton = By.xpath("//input[@type='radio' and @value='" + radioButtonValue + "']");
	        WebElement radioElement = driver.findElement(radioButton);
	        return radioElement.isDisplayed() && radioElement.isEnabled();
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Click a section by name (e.g. menu or tab)
	public void clickSection(String sectionName) {
	    By sectionElement = By.xpath("//div[contains(text(),'" + sectionName + "') or contains(@class,'section')]");
	    driver.findElement(sectionElement).click();
	}

	// Navigate or go to a section by name
	public void navigateToSection(String sectionName) {
	    clickSection(sectionName); // Simplified: can add url/nav logic if needed
	}

	// Click a button by visible text
	public void clickButton(String buttonText) {
	    By button = By.xpath("//button[contains(text(),'" + buttonText + "')]");
	    driver.findElement(button).click();
	}

	// Check if medication name input is displayed and empty
	public boolean isMedicationNameInputEmpty() {
	    try {
	        WebElement input = driver.findElement(medicationNameInput);
	        return input.isDisplayed() && input.getAttribute("value").isEmpty();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	

	// Check if a button is displayed by text
	public boolean isButtonDisplayed(String buttonText) {
	    try {
	        By button = By.xpath("//button[contains(text(),'" + buttonText + "')]");
	        return driver.findElement(button).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Get total count of buttons on the page
	public int getTotalButtons() {
	    return driver.findElements(By.tagName("button")).size();
	}

	// Click a button after adding medication logic (may add pre-checks)
	public void clickButtonAfterAddingMedication(String buttonText) {
	    // Custom logic if needed before clicking
	    clickButton(buttonText);
	}

	// Check if success message with given text is displayed
	public boolean isSuccessMessageDisplayed(String messageText) {
	    try {
	        By msg = By.xpath("//*[contains(text(),'" + messageText + "')]");
	        return driver.findElement(msg).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	// Click button without adding medication details (could add validation logic before clicking)
	public void clickButtonWithoutAddingMedicationDetails(String buttonText) {
	    clickButton(buttonText);
	}

	// Verify that user is on a given section page (header or section visible)
	public boolean isOnSectionPage(String sectionName) {
	    return isSectionPresent(sectionName);
	}

	
	
	
	
	public void clickSubMenu(String submenu) {
	    By submenuLocator = By.xpath("//a[contains(text(),'" + submenu + "')]");
	    driver.findElement(submenuLocator).click();
	}

	public void expandEditProfileSubMenu() {
	    By editProfileMenu = By.xpath("//a[contains(text(),'Edit Profile')]");
	    WebElement menu = driver.findElement(editProfileMenu);
	    if (!menu.isDisplayed()) {
	        // click to expand if not visible
	        driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	    }
	    menu.click();
	}

	public void clickElement(String elementName) {
	    By elementLocator = By.xpath("//*[contains(text(),'" + elementName + "')]");
	    driver.findElement(elementLocator).click();
	}

	
	public boolean isTabVisible(String tabName) {
	    By tabLocator = By.xpath("//button[contains(@class,'tab') and contains(text(),'" + tabName + "')]");
	    try {
	        return driver.findElement(tabLocator).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public boolean isVisibleByDefault(String elementName) {
	    By locator = By.xpath("//*[contains(text(),'" + elementName + "') and ancestor::div[contains(@style,'display: block')]]");
	    try {
	        return driver.findElement(locator).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public boolean isButtonVisible(String buttonText) {
	    By buttonLocator = By.xpath("//button[contains(text(),'" + buttonText + "')]");
	    try {
	        return driver.findElement(buttonLocator).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public void clickTab(String tabName) {
	    By tabLocator = By.xpath("//button[contains(@class,'tab') and contains(text(),'" + tabName + "')]");
	    driver.findElement(tabLocator).click();
	}

	public boolean isVisibleInsideSection(String elementText) {
	    By locator = By.xpath("//section//*[contains(text(),'" + elementText + "')]");
	    try {
	        return driver.findElement(locator).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public boolean isSubTextVisible(String subText) {
	    By locator = By.xpath("//*[contains(@class, 'subtext') and contains(text(),'" + subText + "')]");
	    try {
	        return driver.findElement(locator).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public String getUserName() {
	    return driver.findElement(By.id("name")).getAttribute("value");
	}

	public String getUserAge() {
	    return driver.findElement(By.id("age")).getAttribute("value");
	}

	public boolean isNameAndAgeProperlyAligned() {
	    // Basic sample implementation assuming vertical alignment means Y-coordinates are aligned with spacing
	    WebElement nameField = driver.findElement(By.id("name"));
	    WebElement ageField = driver.findElement(By.id("age"));
	    int nameY = nameField.getLocation().getY();
	    int ageY = ageField.getLocation().getY();
	    return Math.abs(ageY - nameY) > 0;  // Replace with exact alignment logic as needed
	}

	public String getUserWeight() {
	    return driver.findElement(By.id("weight")).getAttribute("value");
	}

	public String getUserHeight() {
	    return driver.findElement(By.id("height")).getAttribute("value");
	}

	public boolean areUnitsVisibleAndEnabled(String unit1, String unit2) {
	    By unit1Locator = By.xpath("//option[contains(text(),'" + unit1 + "')]");
	    By unit2Locator = By.xpath("//option[contains(text(),'" + unit2 + "')]");
	    try {
	        WebElement unit1Element = driver.findElement(unit1Locator);
	        WebElement unit2Element = driver.findElement(unit2Locator);
	        return unit1Element.isDisplayed() && unit1Element.isEnabled()
	            && unit2Element.isDisplayed() && unit2Element.isEnabled();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public boolean isWeightAndHeightProperlyAligned() {
	    WebElement weightField = driver.findElement(By.id("weight"));
	    WebElement heightField = driver.findElement(By.id("height"));
	    int weightY = weightField.getLocation().getY();
	    int heightY = heightField.getLocation().getY();
	    return Math.abs(weightY - heightY) > 0; // Adjust with more robust layout check if needed
	}

	public boolean isGradientSliderDisplayed(String sliderName) {
	    By sliderLocator = By.xpath("//div[contains(@class, 'bmi-slider-gradient')]");
	    try {
	        return driver.findElement(sliderLocator).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	
	
	
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
