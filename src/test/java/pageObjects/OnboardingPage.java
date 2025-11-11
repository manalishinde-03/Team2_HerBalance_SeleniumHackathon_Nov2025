package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ElementUtil;
import utilities.ExcelReader;
import utilities.ReadConfig;

public class OnboardingPage {

	private WebDriver driver;
	private ElementUtil util;
	ReadConfig readConfig;

	public OnboardingPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
		readConfig = new ReadConfig();
	}
	
	private String sheetName = "Onboarding";

	//List<Map<String, String>> personalDetailsData;
	//String personalDetailsData;
	Map<String, String> personalDetailsData;

	By OnboardingPageTitle = By.xpath("//*[contains(text(),'Upload Your Recent Blood Work')]");
	By SupportingTextOnboardingStep1 = By.xpath("/html/body/div/p");
	By OnboardingProgressBarStep1 = By.xpath("/html/body/div/div[1]/div");
	By progressStepText = By.xpath("//div[@class='onboarding-progress' and contains(., '1 of 10')]");
	By progressStepTextStep3 = By.xpath("//div[@class='onboarding-header' and contains(., '3 of 10')]");
	By progressStepTextStep4 = By.xpath("//div[@class='onboarding-header' and contains(., '4 of 10')]");
	By progressStepTextStep5 = By.xpath("//div[@class='onboarding-header' and contains(., '5 of 10')]");
	By progressStepTextStep6 = By.xpath("//div[@class='onboarding-header' and contains(., '6 of 10')]");
	By UploadPDFButton = By.xpath("//label[@class='upload-button']");
	By fileInput = By.id("bloodWorkUpload");

	By Step3SubTitleText = By.xpath("//p[@class='subtitle']");
	By BackButtonStep3 = By.xpath("//button[text()='Back']");
	By ContinueButtonStep3 = By.xpath("//button[text()='Continue']");
	By radioOptions = By.cssSelector(".conditions-grid .radio-option");
	By radioOptionsText = By.xpath("//label[@class='radio-option']");
	By NoteStep3Text = By.xpath("//span[contains(text(), 'Conditions like PCOS')]");

	By PDFFilesOnlyText = By.xpath(".//div/div[2]/div[1]/div[3]");
	By SkipForNowText = By.xpath("//div[@class='skip-link']");
	By SkipExplanationText = By.xpath("//div[@class='skip-text']");
	By ContinueWithoutReportBtn = By.xpath("//button[@class='continue-button']");
	By DataSecurityText = By.xpath("//div[@class='privacy-info']//div");

	By OnboardingPageStep3Title = By.xpath("//h2[text()='Health Conditions']");
	By OnboardingPageStep4SubTitle = By.xpath("//p[@class='subtitle']");
	By OnboardingPageStep4Title = By.xpath("//h2[text()='Personal Details']");
	By OnboardingPageStep5Title = By.xpath("//h2[text()='Menstrual Cycle Awareness']");
	By OnboardingPageStep6Title = By.xpath("//h2[text()='Last Period Date']");

	By inputBoxes = By.xpath("//input[@type='text']");
	By inputFieldLabelsStep4 = By.xpath("//label");
	By helperTextsInputFieldStep4 = By.xpath("//p[@class='input-hint']");
	By radioButtonsStep4 = By.cssSelector(".form-card .radio-option");

	By firstNameField = By.xpath("//input[@id='first_name']");
	By ageField = By.xpath("//input[@id='age']");
	By bpStatusOptions = By.cssSelector("label.radio-option span");
	By OnboardingPageStep5SubTitle = By.xpath("//p[@class='subtitle']");
	By Step5QuestionText = By.xpath("//div/div[2]/div/label");

	By radioButtonsStep5 = By.cssSelector(".options-grid .radio-option");
	By cycleInfoOptions = By.cssSelector("label.radio-option span");
	By OnboardingPageStep6SubTitle = By.xpath("//p[@class='subtitle']");
	By Step6QuestionText = By.xpath("//label[@for='last_period_date']");
	By Step6CalendarIcon = By.xpath("//i[@class='fas fa-calendar-alt icon']");
	By Step6Calendar_dateField = By.id("last_period_date");
	By Step6LabelDateField = By.xpath("//div/div[2]/div/div[2]/div[1]/span[1]");
	By Step6CycleLengthSlider = By.xpath("//input[@id='cycle_length']");
	By Step6DefaultCycleLengthSlider = By.id("cycle_length_display");
	By Step6InformationText = By.xpath("//p[@class='slider-hint']");
	By Step6DescTextCurrentPhase = By.xpath("//p[@class='phase-name']");
	By Step6ErrorMsg = By.xpath("");;

	public String getPageTitle() {

		return driver.getTitle();
	}

	public String getOnboardingPageTitle() {

		return util.getElementText(OnboardingPageTitle);
	}

	public String getOnboardingPageStep3SubTitle() {

		return util.getElementText(Step3SubTitleText);
	}

	public String getSupportingTextStep1() {

		return util.getElementText(SupportingTextOnboardingStep1);
	}

	public boolean isOnboardingProgressBarDisplayed() {

		return util.isElementDisplayed(OnboardingProgressBarStep1);

	}

	public boolean isOnboardingProgressBar1of10Displayed() {

		return util.isElementDisplayed(progressStepText);

	}

	public boolean isOnboardingProgressBar3of10Displayed() {

		return util.isElementDisplayed(progressStepTextStep3);

	}

	public boolean isOnboardingProgressBar5of10Displayed() {

		return util.isElementDisplayed(progressStepTextStep5);

	}

	public boolean isUploadPDFButtonDisplayed() {

		return util.isElementDisplayed(UploadPDFButton);
	}

	public boolean isUploadPDFButtonEnabled() {

		return util.isElementEnabled(UploadPDFButton);
	}

	public boolean isPDFFilesOnlyTextDisplayed() {

		return util.isElementDisplayed(PDFFilesOnlyText);
	}

	public boolean isSkipForNowTextDisplayed() {

		return util.isElementDisplayed(SkipForNowText);
	}

	public boolean isExplanationTextDisplayed() {

		return util.isElementDisplayed(SkipExplanationText);
	}

	public String getSkipExplanationText() {
		System.out.println("Actual >> " + util.getElementText(SkipExplanationText));
		return util.getElementText(SkipExplanationText);
	}

	public boolean isContinueWithoutReportBtnDisplayed() {

		return util.isElementDisplayed(ContinueWithoutReportBtn);
	}

	public boolean isContinueWithoutReportBtnEnabled() {

		return util.isElementEnabled(ContinueWithoutReportBtn);
	}

	public boolean isDataSecurityTextDisplayed() {

		return util.isElementDisplayed(DataSecurityText);
	}

	public String getPDFFilesOnlyTextStep1() {

		return util.getElementText(PDFFilesOnlyText);
	}

	public String getDataSecurityTextStep1() {

		System.out.println("Actual >> " + util.getElementText(DataSecurityText));
		return util.getElementText(DataSecurityText);
	}

	public void clickOnContinueWithoutReportBtn() {
		util.doClick(ContinueWithoutReportBtn);

	}

	public String getOnboardingPageStep3Title() {

		return util.getElementText(OnboardingPageStep3Title);
	}

	public void clickOnUploadPDFBtn() {
		util.doClick(UploadPDFButton);

	}

	public boolean fileUploadDialogIsDisplayed() {

		return util.isElementDisplayed(fileInput);

	}

	public int radioButtonsSize() {

		List<WebElement> radioButtons = util.getElements(radioOptions);

		return radioButtons.size();

	}

	public int inputBoxCountStep4() {

		List<WebElement> inputBox = util.getElements(inputBoxes);

		return inputBox.size();

	}

	public boolean isBackButtonStep3Displayed() {

		return util.isElementDisplayed(BackButtonStep3);
	}

	public boolean isBackButtonStep3Enabled() {

		return util.isElementEnabled(BackButtonStep3);
	}

	public boolean isContinueButtonStep3Displayed() {

		return util.isElementDisplayed(ContinueButtonStep3);
	}

	public boolean isContinueButtonStep3Enabled() {

		return util.isElementEnabled(ContinueButtonStep3);
	}

	public Collection<String> radioButtonsOptionsText() {

		List<WebElement> texts = util.getElements(radioOptions);
		List<String> actualOptions = texts.stream().map(e -> e.getText().trim()).collect(Collectors.toList());

		System.out.println("Actual options -" + actualOptions.toString());
		return actualOptions;
	}

	public String getNoteTextStep3() {

		System.out.println("Actual >> " + util.getElementText(NoteStep3Text));

		String text = util.getElementText(NoteStep3Text);
		return text;
	}

	public void selectHealthConditionAndClickOnContinue(String condition) {
		WebElement healthConditionRadioButton = driver
				.findElement(By.xpath("//label[contains(., '" + condition + "')]/input[@type='radio']"));
		util.doClick(healthConditionRadioButton);

		util.doClick(ContinueButtonStep3);

	}

	public String getOnboardingPageStep4Title() {

		return util.getElementText(OnboardingPageStep4Title);
	}

	public String getOnboardingPageStep4SubTitle() {

		return util.getElementText(OnboardingPageStep4SubTitle);
	}

	public List<String> getActualInputFieldLabels() {

		List<WebElement> actualLabelElements = util.getElements(inputFieldLabelsStep4);

		List<String> actualLabels = new ArrayList<>();
		for (WebElement label : actualLabelElements) {
			actualLabels.add(label.getText().trim());
		}
		System.out.println("Input Field labels --" + actualLabels.toString());
		return actualLabels;
	}

	public List<String> getActualHelperTexts() {

		List<WebElement> actualHelperTextElements = util.getElements(helperTextsInputFieldStep4);
		List<String> actualHelperTexts = new ArrayList<>();
		for (WebElement label : actualHelperTextElements) {
			actualHelperTexts.add(label.getText().trim());
		}
		System.out.println("Actual helper texts --" + actualHelperTexts.toString());
		return actualHelperTexts;
	}

	public int radioButtonsStep4Size() {

		List<WebElement> radioButtonsOnStep4 = util.getElements(radioButtonsStep4);

		return radioButtonsOnStep4.size();

	}

	public Collection<String> getActualBPDescriptionOptions() {

		List<WebElement> texts = util.getElements(radioButtonsStep4);
		List<String> actualOptions = texts.stream().map(e -> e.getText().trim()).collect(Collectors.toList());

		System.out.println("Actual options -" + actualOptions.toString());
		return actualOptions;

	}

	public boolean isOnboardingProgressBar4of10Displayed() {

		return util.isElementDisplayed(progressStepTextStep4);

	}

	public void clickOnBackBtnStep4() {
		util.doClick(BackButtonStep3);
	}

	public void clickOnContinueBtnStep4() {
		util.doClick(ContinueButtonStep3);

	}

	public String getOnboardingPageStep5Title() {

		return util.getElementText(OnboardingPageStep5Title);
	}

	public void enterPersonalDetailsStep4(String name, String age) {

		util.doSendKeys(firstNameField, name);

		util.doSendKeys(ageField, age);

	}

	public void selectBloodPressureStatus(String BPStatus) {

		List<WebElement> bpStatusRadioButtons = util.getElements(bpStatusOptions);
		for (WebElement option : bpStatusRadioButtons) {
			if (option.getText().trim().equalsIgnoreCase(BPStatus)) {
				option.click();
				break;
			}
		}
	}

	public Collection<String> getActualRadioOptionsMenstrualCycleAwareness() {

		List<WebElement> texts = util.getElements(radioButtonsStep5);
		List<String> actualOptions = texts.stream().map(e -> e.getText().trim()).collect(Collectors.toList());

		System.out.println("Actual options -" + actualOptions.toString());
		return actualOptions;

	}

	public int radioButtonsStep5Size() {

		List<WebElement> radioButtonsOnStep5 = util.getElements(radioButtonsStep5);

		return radioButtonsOnStep5.size();

	}

	public String getOnboardingPageStep5SubTitle() {

		return util.getElementText(OnboardingPageStep5SubTitle);
	}

	public String getOnboardingPageStep5QuestionText() {

		return util.getElementText(Step5QuestionText);
	}

	public void selectCycleInfoOption(String cycleInfo) {

		List<WebElement> cycleInfoRadioButtons = util.getElements(cycleInfoOptions);
		for (WebElement option : cycleInfoRadioButtons) {
			if (option.getText().trim().equalsIgnoreCase(cycleInfo)) {
				option.click();
				break;
			}
		}
	}

	public String getOnboardingPageStep6Title() {

		return util.getElementText(OnboardingPageStep6Title);
	}

	public String getOnboardingPageStep6SubTitle() {

		return util.getElementText(OnboardingPageStep6SubTitle);
	}

	public String getOnboardingPageStep6QuestionText() {

		return util.getElementText(Step6QuestionText);
	}

	public boolean isCalendarIconStep6Displayed() {

		return util.isElementDisplayed(Step6CalendarIcon);
	}

	public String getDateFieldPlaceholderText() {

		String actualPlaceholderText = util.getAttributeVal(Step6Calendar_dateField, "placeholder");

		return actualPlaceholderText;
	}

	public String getDefaultCycleLength() {

		return util.getElementText(Step6DefaultCycleLengthSlider);
	}

	public boolean isCycleLengthLabelDisplayed() {

		return util.isElementDisplayed(Step6LabelDateField);
	}

	public boolean isCycleLengthSliderDisplayed() {

		return util.isElementDisplayed(Step6CycleLengthSlider);
	}

	public String getInfoTextStep6() {

		return util.getElementText(Step6InformationText);
	}

	public boolean isOnboardingProgressBar6of10Displayed() {

		return util.isElementDisplayed(progressStepTextStep6);

	}

	public String getErrorMsgStep6() {
		

		return util.getElementText(Step6ErrorMsg);
	}

	public void enterPersonalDetailsStep4(String testCase) {

		personalDetailsData = ExcelReader.getTestData(sheetName, testCase);

	System.out.println("Test data from excel --" + personalDetailsData);

		String firstName = personalDetailsData.get("FirstName");
		String age = personalDetailsData.get("Age");
		String BPStatus = personalDetailsData.get("BPStatus");

		System.out.println("First Name Input :" + firstName);

		if (firstName != null && !firstName.isEmpty()) {
			util.doSendKeys(firstNameField, firstName);
		} else {
			System.out.println("First Name is missing or empty");
		}

		if (age != null && !age.isEmpty()) {
			util.doSendKeys(ageField, age);

		} else {
			System.out.println("Age is missing or empty");
		}

			
		List<WebElement> bpStatusRadioButtons = util.getElements(bpStatusOptions);
		for (WebElement option : bpStatusRadioButtons) {
			if (option.getText().trim().equalsIgnoreCase(BPStatus)) {
				option.click();
				break;
			}
		}

		util.doClick(ContinueButtonStep3);
	}

	public void selectLastPeriodDate(String testcase) {
		
		
		
		Map<String, String> testData = ExcelReader.getTestData(sheetName, testcase);
	    String dateFromExcel = testData.get("LastPeriodDate");
	    
	    
	    DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
	    DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    String formattedDate = LocalDate.parse(dateFromExcel, inputFormat).format(outputFormat);

	    System.out.println("Converted date: " + formattedDate);
	    
	    System.out.println("Date from Excel: " + dateFromExcel);
	    
	 // Split date parts
	    String[] dateParts = formattedDate.split("/");
	    String month = dateParts[0];
	    String day = dateParts[1];
	    String year = dateParts[2];

	    util.doClick(Step6Calendar_dateField);  // opens the calendar
	    selectDateFromCalendar(month, day, year);
		
	}

	private void selectDateFromCalendar(String month, String day, String year) {
		util.doClick(By.xpath("//span[@id='calendar_year']"));
	   // util.doClick(By.xpath("//option[text()='" + year + "']"));

	  //  util.doClick(By.xpath("//select[@class='ui-datepicker-month']"));
	   // util.doClick(By.xpath("//option[" + (Integer.parseInt(month)) + "]"));

	    util.doClick(By.xpath("//div[@class='calendar-day' and text()='" + Integer.parseInt(day) + "']"));
		
	}

	public String getDescTextCurrentPhaseStep6() {
		
		System.out.println(">>>>>>>>>>>>>"+util.getElementText(Step6DescTextCurrentPhase));
		return util.getElementText(Step6DescTextCurrentPhase);
	}

}
