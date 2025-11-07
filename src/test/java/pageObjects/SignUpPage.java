package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;
import utilities.ReadConfig;


public class SignUpPage {

	
	private WebDriver driver;
	private ElementUtil util;
	private ReadConfig readConfig;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
		readConfig = new ReadConfig();
	}
	
	private By email = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='password']");
	private By confirmPassword = By.xpath("//input[@id='confirm-password']");
	private By registerButton = By.xpath("//*[@id=\"signupForm\"]/button");
	private By TnCcheckBox = By.xpath("//input[@id='terms']");
	
	public String getPageTitle() {

		return driver.getTitle();
	}

	public Object registerWithValidCredentials(String email, String password, String confirmPassword) {

		Object obj = null;

		util.doSendKeys(this.email, email);
		
		util.doSendKeys(this.password, password);
		util.doSendKeys(this.confirmPassword, confirmPassword);
		
		util.doClick(TnCcheckBox);
		
		util.doClick(registerButton);
	

		// Check what object to return
//		if (email == null || email.isBlank()) {
//			// throw error if either of credentials are empty or missing
//			obj = util.getElementText(errorMessage_nullUsername);
//		} else if (password == null || password.isBlank()) {
//			obj = util.getElementText(errorMessage_nullPassword);
//		}
//
//		else if (role == null || role.isBlank()) {
//			obj = util.getElementText(errorMessage_nullRole);
//		}
//		else { // No error. Happy path
//
//			obj = new HomePage(driver);
//		}
		
		obj = new OnboardingPage(driver);
		return obj;

	}
	
}
