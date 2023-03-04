package com.cucumber.selenium.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPageObject {
	
	private static final Logger logger = LogManager.getLogger(SearchResultPageObject.class);
	WebDriver driver;
	WebDriverWait wait;
	 private By productToClick = By.xpath("//span[contains(text(),'Samsung Galaxy M04 Light Green')]");
	
	public SearchResultPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public void validateSearchPage(String product) {
		logger.info("validating the search result page");
		Assert.assertEquals("Error loading search results", "Amazon.in : "+product, driver.getTitle());
		logger.info("validation for result page passed for product->"+product);
	}
	
	public void productClickOperation() {
		logger.info("clicking on the product");
		driver.findElement(productToClick).click();
		
	}
	
	

}
