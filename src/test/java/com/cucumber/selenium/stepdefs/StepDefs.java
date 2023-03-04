package com.cucumber.selenium.stepdefs;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.selenium.driverFactory.WebDriverFactory;
import com.cucumber.selenium.pageobjects.LandingPageObject;
import com.cucumber.selenium.pageobjects.ProductDescriptionPageModel;
import com.cucumber.selenium.pageobjects.SearchResultPageObject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	Scenario scn;
	 private static final Logger logger = LogManager.getLogger(StepDefs.class);		
	 WebDriver driver;
	 WebDriverWait wait;
	 String base_URL = "https://www.amazon.in"; //base url getting passed as argument to LandingPageObject for landingPageValidation()
	 
	 LandingPageObject landingPageObject;
	 SearchResultPageObject searchResultPageObject;
	 ProductDescriptionPageModel productDescriptionPageModel;
	 
	 
	 @Before
	 public void setup(Scenario scn) throws Exception {
		 this.scn=scn;

		String browserName = WebDriverFactory.getBrowserName();
		driver=WebDriverFactory.getWebDriverForBrowser(browserName);
		wait = new WebDriverWait(driver, 20);
		 landingPageObject = new LandingPageObject(driver, wait);
		 searchResultPageObject = new SearchResultPageObject(driver, wait);
		 productDescriptionPageModel = new ProductDescriptionPageModel(driver,wait);

	 }
	 
	
	 
		@Given("user opened browser")
		public void user_opened_browser() {
		    
		    driver.manage().window().maximize();
		    logger.info("Openened browser");

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
		}
		
		@Then("user add product to shopping cart")
		public void user_add_product_to_shopping_cart() throws InterruptedException {
		 
			productDescriptionPageModel.addToCart();
		
		}
	
		
		@When("user search for product  {string}")
		public void user_search_for_product(String product) {
			logger.info("search operation for :->"+product);
		 landingPageObject.productSearch(product);
		}

		@Then("search result is displayed for product {string}")
		public void search_result_is_displayed_for_product(String product) {
			logger.info("validating search result for :->"+product);
		   searchResultPageObject.validateSearchPage(product);
		   scn.log("search result is displayed");
		}

		 @After(order=0)
		 public void closebrowser() {
			 scn.log("closed browser");
			 driver.quit();
			 
		 }
		 @After(order=1)
		 public void takeScreenshot(Scenario scn) {
			 if(scn.isFailed()) {
				 TakesScreenshot scrnshot = (TakesScreenshot)driver;
				 byte [] data = scrnshot.getScreenshotAs(OutputType.BYTES);
				 scn.attach(data, "image/png", "failed step name:->"+scn.getName());
			 }
			 else {
				 scn.log("No error, no screenshot captured");
			 }
		 }

}
