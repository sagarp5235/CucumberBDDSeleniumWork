package com.cucumber.selenium.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageObject {
	
	private static final Logger logger = LogManager.getLogger(LandingPageObject.class);
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By searchBoxElement = By.xpath("//input[@id='twotabsearchtextbox']"); //locator for search box on home page
	private By searchButtonElement = By.xpath("//input[@id='nav-search-submit-button']"); //locator for search button.
	
	
	public LandingPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		
	}
	
	public void landingPageValidation(String base_URL) {
		driver.get(base_URL);
		logger.info("driver got invoked for URL->"+base_URL);
		Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
		logger.info("Assertion for landing page has been passed for->"+base_URL);
	}
	
	public void productSearch(String product) {
		logger.info("waiting for webelement to be clickable");
		wait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
		logger.info("Entering the product name");
		driver.findElement(searchBoxElement).sendKeys(product);
		logger.info("clicking on search button");
		driver.findElement(searchButtonElement).click();
	}
	

}
