package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;
import utilities.ReadConfig;

public class LaunchPage {
	private WebDriver driver;
	private ElementUtil util;
	private ReadConfig readConfig;
	private By menstrualPhase = By.xpath("//h6[text()='Menstrual Phase']");
	
	private By signUpButton = By.xpath(".//nav/div[2]/button[2]");
	
	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
		readConfig = new ReadConfig();
		
	}
	 public String getMenstrualText() {
		 return util.getElementText(menstrualPhase);
	       
	    }
	 public boolean isMenstrualPhaseDisplayed() {
		 return util.isElementDisplayed(menstrualPhase);
	       
	    }
	 
	 public void clickOnSignUpButton() {

			driver.findElement(signUpButton).isDisplayed();
			driver.findElement(signUpButton).click();
			
		}
}
