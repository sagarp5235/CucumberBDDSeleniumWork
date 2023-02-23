package com.cucumber.selenium.stepdefs;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.selenium.pageobjects.LandingPageObject;
import com.cucumber.selenium.pageobjects.ProductDescriptionPageModel;
import com.cucumber.selenium.pageobjects.SearchResultPageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	 private static final Logger logger = LogManager.getLogger(StepDefs.class);		
	 WebDriver driver;
	 WebDriverWait wait;
	 String base_URL = "https://www.amazon.in";
	 
	 LandingPageObject landingPageObject;
	 SearchResultPageObject searchResultPageObject;
	 ProductDescriptionPageModel productDescriptionPageModel;
	 
		@Given("user opened browser")
		public void user_opened_browser() {
		    driver = new ChromeDriver();
		    wait = new WebDriverWait(driver, 20);
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.manage().deleteAllCookies();
		    driver.manage().window().maximize();
		    logger.info("Openened browser");

		    landingPageObject = new LandingPageObject(driver, wait);
		    searchResultPageObject = new SearchResultPageObject(driver, wait);
		    productDescriptionPageModel = new ProductDescriptionPageModel(driver,wait);
		}



		@Given("user navigated to home page")
		public void user_navigated_to_home_page() {
			landingPageObject.landingPageValidation(base_URL);
		}
		@When("user search for {string}")
		public void user_search_for_laptop(String product) {
			
			landingPageObject.productSearch(product);
		    		}
		@Then("search result is displayed {string}")
		public void search_result_is_displayed(String product) {
			searchResultPageObject.validateSearchPage(product);
		}
		
		@Then("user click on any product")
		public void user_click_on_any_product() {
			
		searchResultPageObject.productClickOperation();	
		}



		@Then("procuct descrption is opened")
		public void procuct_descrption_is_open_and_browser_is_closed() {
			productDescriptionPageModel.openProductDescription();
			productDescriptionPageModel.closeBrowser();

		}
		
		@Then("browser is closed")
		public void browser_is_closed() {
			productDescriptionPageModel.closeBrowser();
		}


}
