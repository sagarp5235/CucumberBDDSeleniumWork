package com.cucumber.selenium.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDescriptionPageModel {

	private static final Logger logger = LogManager.getLogger(ProductDescriptionPageModel.class);
	WebDriver driver;
	WebDriverWait wait;
	
	private By addToCartBtn = By.xpath("//input[@id='add-to-cart-button']");
	
	public ProductDescriptionPageModel(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		
	}
	
	public void openProductDescription() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		String original = iterator.next();
		logger.info("On the search result page");
		String prodDescription= iterator.next();
		logger.info("Switching to product description tab");
		driver.switchTo().window(prodDescription);
		WebElement productTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
		logger.info("Validating product description");
        Assert.assertEquals("Product Title",true,productTitle.isDisplayed());
        logger.info("product descrption validation passed");
        driver.close();
        driver.switchTo().window(original);
	}
	
	public void addToCart() throws InterruptedException {
		
		logger.info("Adding product to shopping cart");
		driver.findElement(addToCartBtn);
		logger.info("validating product is added to cart");
		Thread.sleep(2000);
		driver.close();
		
	}
	

	
}
