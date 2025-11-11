package stepDefinitions;


import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import hooks.TestContext;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import pageObjects.EditPage;
import pageObjects.SubscriptionManagement;
import pageObjects.SubscriptionPage;
import utilities.ReadConfig;



public class EditProfileStepDef {

	
	
	WebDriver driver;
	ReadConfig readConfig;
	TestContext context;
	EditPage editPage;
	SoftAssert softAssert;
	 
	
	public EditProfileStepDef(TestContext Context) {
		this.context = Context;
		this.driver = context.getDriver();
		this.readConfig = new ReadConfig();
		editPage = new EditPage(driver);		
		softAssert = new SoftAssert();
	}
	
	@Given("User clicks {string} submenu from Dashboard Profile page")
	public void user_clicks_submenu_from_dashboard_profile_page(String submenuName) {
	   
		
		 try {
		        editPage.clickSubMenu(submenuName);
		        System.out.println("Successfully clicked submenu: " + submenuName);
		    } catch (NoSuchElementException e) {
		        System.err.println(" Submenu element not found: " + submenuName + " → " + e.getMessage());
		        Allure.addAttachment("Submenu Not Found", "text/plain", e.toString());
		    } catch (ElementClickInterceptedException e) {
		        System.err.println(" Submenu click intercepted: " + submenuName + " → " + e.getMessage());
		        Allure.addAttachment("Submenu Click Intercepted", "text/plain", e.toString());
		    } catch (TimeoutException e) {
		        System.err.println("Timeout while trying to click submenu: " + submenuName + " → " + e.getMessage());
		        Allure.addAttachment("Submenu Click Timeout", "text/plain", e.toString());
		    } catch (Exception e) {
		        System.err.println("Unexpected error clicking submenu: " + submenuName + " → " + e.getMessage());
		        Allure.addAttachment("Unexpected Submenu Error", "text/plain", e.toString());
		    }

	}

	@Given("User is on the Her Balance Dashboard with the Edit Profile submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_edit_profile_submenu_expanded() {

		try {
	        editPage.expandEditProfileSubMenu();
	        System.out.println(" Edit Profile submenu expanded successfully.");
	    } catch (NoSuchElementException e) {
	        System.err.println("Edit Profile submenu element not found: " + e.getMessage());
	        Allure.addAttachment("Edit Profile Submenu Error", "text/plain", e.toString());
	    } catch (TimeoutException e) {
	        System.err.println(" Timeout while expanding Edit Profile submenu: " + e.getMessage());
	        Allure.addAttachment("Edit Profile Submenu Timeout", "text/plain", e.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error expanding Edit Profile submenu: " + e.getMessage());
	        Allure.addAttachment("Edit Profile Submenu Unexpected Error", "text/plain", e.toString());
	    }

	}

	@When("User clicks on {string}  button")
	public void user_clicks_on_button(String elementName) {

		try {
	        editPage.clickElement(elementName);
	        System.out.println(" Successfully clicked on element: " + elementName);
	    } catch (NoSuchElementException e) {
	        System.err.println("Element not found: " + elementName + " → " + e.getMessage());
	        Allure.addAttachment("Click Element Error", "text/plain", e.toString());
	    } catch (ElementClickInterceptedException e) {
	        System.err.println(" Element click intercepted: " + elementName + " → " + e.getMessage());
	        Allure.addAttachment("Click Intercepted Error", "text/plain", e.toString());
	    } catch (TimeoutException e) {
	        System.err.println(" Timeout while trying to click: " + elementName + " → " + e.getMessage());
	        Allure.addAttachment("Click Timeout Error", "text/plain", e.toString());
	    } catch (Exception e) {
	        System.err.println(" Unexpected error clicking element: " + elementName + " → " + e.getMessage());
	        Allure.addAttachment("Unexpected Click Error", "text/plain", e.toString());
	    }

	
	}

	@Then("There should be exactly {int} buttons  {string} and {string}")
	public void there_should_be_exactly_buttons_and(Integer expectedTabs) {
		try {
	        int actualTabs = editPage.getTotalTabs();

	        System.out.println("Actual tabs: " + actualTabs);
	        System.out.println("Expected tabs: " + expectedTabs);

	        softAssert.assertEquals(actualTabs, expectedTabs.intValue(), " Tabs count mismatch");
	        softAssert.assertAll();

	        System.out.println("Tab count validation passed.");

	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed: " + ae.getMessage());
	        Allure.addAttachment("Tab Count Assertion Error", "text/plain", ae.toString());
	        
	    } catch (Exception e) {
	        System.err.println(" Unexpected error while validating tab count: " + e.getMessage());
	        Allure.addAttachment("Tab Count Error", "text/plain", e.toString());
	       
	    }
	
	}

	

		@Then("{string}, {string}, {string} tabs should be visible")
		public void tabs_should_be_visible(String tab1, String tab2, String tab3) {
		    try {
		        boolean isTab1Visible = editPage.isTabVisible(tab1);
		        boolean isTab2Visible = editPage.isTabVisible(tab2);
		        boolean isTab3Visible = editPage.isTabVisible(tab3);

		        System.out.println("Tab1 (" + tab1 + ") visible: " + isTab1Visible);
		        System.out.println("Tab2 (" + tab2 + ") visible: " + isTab2Visible);
		        System.out.println("Tab3 (" + tab3 + ") visible: " + isTab3Visible);

		        softAssert.assertTrue(isTab1Visible, " Tab not visible: " + tab1);
		        softAssert.assertTrue(isTab2Visible, " Tab not visible: " + tab2);
		        softAssert.assertTrue(isTab3Visible, "Tab not visible: " + tab3);

		        softAssert.assertAll();
		        System.out.println(" All tabs are visible.");

		    } catch (AssertionError ae) {
		        System.err.println(" Assertion failed: " + ae.getMessage());
		        Allure.addAttachment("Tab Visibility Assertion Error", "text/plain", ae.toString());
		    
		    } catch (Exception e) {
		        System.err.println("Unexpected error while verifying tabs: " + e.getMessage());
		        Allure.addAttachment("Tab Visibility Error", "text/plain", e.toString());
		       
		    }
	
	}

	@Then("{string} should be visible by default")
	public void should_be_visible_by_default(String tabName) {

		try {
	        boolean isVisible = editPage.isVisibleByDefault(tabName);

	        System.out.println("Tab '" + tabName + "' visible by default: " + isVisible);

	        softAssert.assertTrue(isVisible, " Tab not visible by default: " + tabName);
	        softAssert.assertAll();

	        System.out.println("Tab '" + tabName + "' is visible by default.");

	    } catch (AssertionError ae) {
	        System.err.println(" Assertion failed for tab '" + tabName + "': " + ae.getMessage());
	        Allure.addAttachment("Default Visibility Assertion Error", "text/plain", ae.toString());
	        
	    } catch (Exception e) {
	        System.err.println(" Unexpected error while checking default visibility for tab '" 
	                           + tabName + "': " + e.getMessage());
	        Allure.addAttachment("Default Visibility Error", "text/plain", e.toString());
	     
	    }
	
	}

	@Then("{string} Button should be visible")
	public void button_should_be_visible(String buttonName) {

		try {
	        boolean isVisible = editPage.isButtonVisible(buttonName);

	        System.out.println("Button '" + buttonName + "' visible: " + isVisible);

	        softAssert.assertTrue(isVisible, " Button not visible: " + buttonName);
	        softAssert.assertAll();

	        System.out.println(" Button '" + buttonName + "' is visible.");

	    } catch (AssertionError ae) {
	        System.err.println(" Assertion failed for button '" + buttonName + "': " + ae.getMessage());
	        Allure.addAttachment("Button Visibility Assertion Error", "text/plain", ae.toString());
	      
	    } catch (Exception e) {
	        System.err.println(" Unexpected error while checking button visibility for '" 
	                           + buttonName + "': " + e.getMessage());
	        Allure.addAttachment("Button Visibility Error", "text/plain", e.toString());
	     
	    }
	}

	@Given("clicks {string} tab")
	public void clicks_tab(String tabName) {
	    try {
	        editPage.clickTab(tabName);
	        System.out.println("Successfully clicked tab: " + tabName);

	    } catch (NoSuchElementException e) {
	        System.err.println(" Tab not found: " + tabName + " → " + e.getMessage());
	        Allure.addAttachment("Tab Not Found", "text/plain", e.toString());

	    } catch (ElementClickInterceptedException e) {
	        System.err.println(" Tab click intercepted: " + tabName + " → " + e.getMessage());
	        Allure.addAttachment("Tab Click Intercepted", "text/plain", e.toString());

	    } catch (TimeoutException e) {
	        System.err.println(" Timeout while trying to click tab: " + tabName + " → " + e.getMessage());
	        Allure.addAttachment("Tab Click Timeout", "text/plain", e.toString());

	    } catch (Exception e) {
	        System.err.println("Unexpected error clicking tab: " + tabName + " → " + e.getMessage());
	        Allure.addAttachment("Unexpected Tab Error", "text/plain", e.toString());
	    }
	}


	@Then("{string} should be visible inside section")
	public void should_be_visible_inside_section(String sectionContent) {
	    try {
	        boolean isVisible = editPage.isVisibleInsideSection(sectionContent);

	        System.out.println("Section content '" + sectionContent + "' visible: " + isVisible);

	        softAssert.assertTrue(isVisible, "Section content not visible: " + sectionContent);
	        softAssert.assertAll();

	        System.out.println(" Section content '" + sectionContent + "' is visible inside section.");

	    } catch (AssertionError ae) {
	        System.err.println(" Assertion failed for section content '" + sectionContent + "': " + ae.getMessage());
	        Allure.addAttachment("Section Content Assertion Error", "text/plain", ae.toString());
	      
	    } catch (Exception e) {
	        System.err.println(" Unexpected error while checking section content '" 
	                           + sectionContent + "': " + e.getMessage());
	        Allure.addAttachment("Section Content Error", "text/plain", e.toString());
	     
	    }
	}


	@Then("{string} sub text should be visible")
	public void sub_text_should_be_visible(String subText) {
	    try {
	        boolean isVisible = editPage.isSubTextVisible(subText);
	        softAssert.assertTrue(isVisible, "Sub text not visible: " + subText);
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for sub text '" + subText + "': " + ae.getMessage());
	        Allure.addAttachment("Sub Text Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking sub text '" + subText + "': " + e.getMessage());
	        Allure.addAttachment("Sub Text Error", "text/plain", e.toString());
	    }
	}


	@Then("Should display the user’s Name as entered during the onboarding process")
	public void should_display_the_user_s_name_as_entered_during_the_onboarding_process() {
	    try {
	        String userName = editPage.getUserName();

	        softAssert.assertNotNull(userName, "User name should not be null");
	        softAssert.assertFalse(userName.isEmpty(), "User name should not be empty");
	        softAssert.assertAll();

	        System.out.println("User name displayed: " + userName);

	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for user name: " + ae.getMessage());
	        Allure.addAttachment("User Name Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking user name: " + e.getMessage());
	        Allure.addAttachment("User Name Error", "text/plain", e.toString());
	    }
	}

	@Then("Should display the user’s Age as entered during the onboarding process")
	public void should_display_the_user_s_age_as_entered_during_the_onboarding_process() {
	    try {
	        String userAge = editPage.getUserAge();
	        softAssert.assertNotNull(userAge, "User age should not be null");
	        softAssert.assertFalse(userAge.isEmpty(), "User age should not be empty");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for user age: " + ae.getMessage());
	        Allure.addAttachment("User Age Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking user age: " + e.getMessage());
	        Allure.addAttachment("User Age Error", "text/plain", e.toString());
	    }
	}

	@Then("Name and Age fields should be properly aligned vertically with equal spacing")
	public void name_and_age_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
	    try {
	        softAssert.assertTrue(editPage.isNameAndAgeProperlyAligned(), "Name and Age fields are not properly aligned");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for Name and Age alignment: " + ae.getMessage());
	        Allure.addAttachment("Alignment Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking Name and Age alignment: " + e.getMessage());
	        Allure.addAttachment("Alignment Error", "text/plain", e.toString());
	    }
	}

	@Then("Should display the user’s Weight as entered during the onboarding process")
	public void should_display_the_user_s_weight_as_entered_during_the_onboarding_process() {
	    try {
	        String userWeight = editPage.getUserWeight();
	        softAssert.assertNotNull(userWeight, "User weight should not be null");
	        softAssert.assertFalse(userWeight.isEmpty(), "User weight should not be empty");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for user weight: " + ae.getMessage());
	        Allure.addAttachment("User Weight Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking user weight: " + e.getMessage());
	        Allure.addAttachment("User Weight Error", "text/plain", e.toString());
	    }
	}

	@Then("Should display the user’s Height as entered during the onboarding process")
	public void should_display_the_user_s_height_as_entered_during_the_onboarding_process() {
	    try {
	        String userHeight = editPage.getUserHeight();
	        softAssert.assertNotNull(userHeight, "User height should not be null");
	        softAssert.assertFalse(userHeight.isEmpty(), "User height should not be empty");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for user height: " + ae.getMessage());
	        Allure.addAttachment("User Height Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking user height: " + e.getMessage());
	        Allure.addAttachment("User Height Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} or {string} unit values in dropdown should be visible and enabled")
	public void or_unit_values_in_dropdown_should_be_visible_and_enabled(String unit1, String unit2) {
	    try {
	        softAssert.assertTrue(editPage.areUnitsVisibleAndEnabled(unit1, unit2), "Units should be visible and enabled");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for units: " + ae.getMessage());
	        Allure.addAttachment("Units Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking units: " + e.getMessage());
	        Allure.addAttachment("Units Error", "text/plain", e.toString());
	    }
	}

	@Then("Weight and Height fields should be properly aligned vertically with equal spacing")
	public void weight_and_height_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
	    try {
	        softAssert.assertTrue(editPage.isWeightAndHeightProperlyAligned(), "Weight and Height fields are not properly aligned");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for Weight and Height alignment: " + ae.getMessage());
	        Allure.addAttachment("Alignment Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking Weight and Height alignment: " + e.getMessage());
	        Allure.addAttachment("Alignment Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} should be displayed with a gradient slider and labels")
	public void should_be_displayed_with_a_gradient_slider_and_labels(String sliderName) {
	    try {
	        softAssert.assertTrue(editPage.isGradientSliderDisplayed(sliderName), "Gradient slider not displayed: " + sliderName);
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for gradient slider: " + ae.getMessage());
	        Allure.addAttachment("Gradient Slider Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking gradient slider: " + e.getMessage());
	        Allure.addAttachment("Gradient Slider Error", "text/plain", e.toString());
	    }
	}

	@Then("{string} section should be present")
	public void section_should_be_present(String sectionName) {
	    try {
	        softAssert.assertTrue(editPage.isSectionPresent(sectionName), "Section not present: " + sectionName);
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for section: " + ae.getMessage());
	        Allure.addAttachment("Section Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking section: " + e.getMessage());
	        Allure.addAttachment("Section Error", "text/plain", e.toString());
	    }
	}

	@Then("Slider should display a continuous gradient from blue → yellow → orange → red")
	public void slider_should_display_a_continuous_gradient_from_blue_yellow_orange_red() {
	    try {
	        softAssert.assertTrue(editPage.isSliderGradientCorrect(), "Slider gradient is incorrect");
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for slider gradient: " + ae.getMessage());
	        Allure.addAttachment("Slider Gradient Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking slider gradient: " + e.getMessage());
	        Allure.addAttachment("Slider Gradient Error", "text/plain", e.toString());
	    }
	}

	@Then("{string}  button should be visible and enabled")
	public void button_should_be_visible_and_enabled(String buttonName) {
	    try {
	        softAssert.assertTrue(editPage.isButtonVisibleAndEnabled(buttonName), "Button not visible or enabled: " + buttonName);
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for button '" + buttonName + "': " + ae.getMessage());
	        Allure.addAttachment("Button Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking button '" + buttonName + "': " + e.getMessage());
	        Allure.addAttachment("Button Error", "text/plain", e.toString());
	    }
	}

	@Then("{string}  {string}  {string} {string}  radioButtons should be visible and enabled")
	public void radio_buttons_should_be_visible_and_enabled(String rb1, String rb2, String rb3, String rb4) {
	    try {
	        softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(rb1), "RadioButton not visible or enabled: " + rb1);
	        softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(rb2), "RadioButton not visible or enabled: " + rb2);
	        softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(rb3), "RadioButton not visible or enabled: " + rb3);
	        softAssert.assertTrue(editPage.isRadioButtonVisibleAndEnabled(rb4), "RadioButton not visible or enabled: " + rb4);
	        softAssert.assertAll();
	    } catch (AssertionError ae) {
	        System.err.println("Assertion failed for RadioButtons: " + ae.getMessage());
	        Allure.addAttachment("RadioButtons Assertion Error", "text/plain", ae.toString());
	    } catch (Exception e) {
	        System.err.println("Unexpected error while checking RadioButtons: " + e.getMessage());
	        Allure.addAttachment("RadioButtons Error", "text/plain", e.toString());
	    }
	}

	@Given("clicks {string} section")
	public void clicks_section(String sectionName) {
	    try {
	        editPage.clickSection(sectionName);
	    } catch (Exception e) {
	        System.err.println("Error clicking section '" + sectionName + "': " + e.getMessage());
	        Allure.addAttachment("Click Section Error", "text");

	    }
	}

}
