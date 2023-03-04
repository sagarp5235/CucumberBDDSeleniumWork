package com.cucumber.selenium.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPageObject {
	
	private static final Logger logger = LogManager.getLogger(SearchResultPageObject.class);
	WebDriver driver;
	WebDriverWait wait;
	private By productList = By.xpath("//span[text()=\"RESULTS\"]//ancestor::div[@class='s-main-slot s-result-list s-search-results sg-row']//span[@class='a-size-medium a-color-base a-text-normal']");
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
		List<WebElement>prodToclick = driver.findElements(productList);
		prodToclick.get(2).click();
		
	}
	
	

}
