package pageObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ElementUtil;
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

	By OnboardingPageTitle = By.xpath("//*[contains(text(),'Upload Your Recent Blood Work')]");
	By SupportingTextOnboardingStep1 = By.xpath("/html/body/div/p");
	By OnboardingProgressBarStep1 = By.xpath("/html/body/div/div[1]/div");
	By progressStepText = By.xpath("//div[@class='onboarding-progress' and contains(., '1 of 10')]");
	By progressStepTextStep3 = By.xpath("//div[@class='onboarding-header' and contains(., '3 of 10')]");
	By progressStepTextStep4 = By.xpath("//div[@class='onboarding-header' and contains(., '4 of 10')]");
	By progressStepTextStep5 = By.xpath("//div[@class='onboarding-header' and contains(., '5 of 10')]");
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

}
