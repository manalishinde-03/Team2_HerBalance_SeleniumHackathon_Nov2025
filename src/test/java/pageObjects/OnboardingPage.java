package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	By UploadPDFButton = By.xpath("//button[@class='upload-button']");

	By PDFFilesOnlyText = By.xpath(".//div/div[2]/div[1]/div[3]");
	By SkipForNowText = By.xpath("//div[@class='skip-link']");
	By SkipExplanationText = By.xpath("//div[@class='skip-text']");
	By ContinueWithoutReportBtn = By.xpath("//button[@class='continue-button']");
	By DataSecurityText = By.xpath("//div[@class='privacy-info']//div");
	
	By OnboardingPageStep3Title = By.xpath("//h2[text()='Health Conditions']");

	public String getPageTitle() {

		return driver.getTitle();
	}

	public String getOnboardingPageTitle() {

		return util.getElementText(OnboardingPageTitle);
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

}
