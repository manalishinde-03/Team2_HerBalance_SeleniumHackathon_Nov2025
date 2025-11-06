package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ElementUtil;
import utilities.ReadConfig;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil util;
	private ReadConfig readConfig;
	private By menstrualPhase = By.xpath("//dummy");
	public LoginPage(WebDriver driver) {
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
}
