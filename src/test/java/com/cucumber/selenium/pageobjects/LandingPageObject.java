package com.cucumber.selenium.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageObject {

	private static final Logger logger = LogManager.getLogger(LandingPageObject.class);

	private WebDriver driver;
	private WebDriverWait wait;

	private By searchBoxElement = By.xpath("//input[@id='twotabsearchtextbox']"); // locator for search box on home page
	private By searchButtonElement = By.xpath("//input[@id='nav-search-submit-button']"); // locator for search button.
    private By letUsHelpYouOptions = By.xpath("//div[text()='Let Us Help You']//parent::div//ul/li/a[text()]"); 
    private By makeMoneyWithUsOptions = By.xpath("//div[text()='Make Money with Us']//parent::div//ul/li/a[text()]");
    private By connectWithUsOptions = By.xpath("//div[text()='Connect with Us']//parent::div//ul/li/a[text()]");
    private By getToKnowUsOptions = By.xpath("//div[text()='Get to Know Us']//parent::div//ul/li/a[text()]");
	public LandingPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	public void landingPageValidation(String base_URL) {
		driver.get(base_URL);
		logger.info("driver got invoked for URL->" + base_URL);
		Assert.assertEquals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				driver.getTitle());
		logger.info("Assertion for landing page has been passed for->" + base_URL);
	}

	public void productSearch(String product) {
		logger.info("waiting for webelement to be clickable");
		wait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
		logger.info("Entering the product name");
		driver.findElement(searchBoxElement).sendKeys(product);
		logger.info("clicking on search button");
		driver.findElement(searchButtonElement).click();
	}

	public void scrollToBottomOfPage() {
		WebElement getToKnow = driver.findElement(By.xpath("//div[text()='Get to Know Us']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		logger.info("Scrolling to bottom of page to search for options");
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getToKnow);
	}

	public void mainOptionsCount(int count) {
		List<WebElement> footerMainCatListEle = driver.findElements(By.xpath(
				"//div[@class='navFooterVerticalRow navAccessibility']/div[@class='navFooterLinkCol navAccessibility']/div[text()]"));
		Assert.assertEquals(count, footerMainCatListEle.size());
		logger.info("validating count of main categories");

	}

	public void mainOptionsNameValidation(String nameOfCategory1, String nameOfCategory2, String nameOfCategory3,
			String nameOfCategory4) {

		List<WebElement> footerMainCatListEle = driver.findElements(By.xpath(
				"//div[@class='navFooterVerticalRow navAccessibility']/div[@class='navFooterLinkCol navAccessibility']/div[text()]"));
		logger.info("validating names of main category:>");
		Assert.assertEquals(nameOfCategory1, footerMainCatListEle.get(0).getText());
		logger.info(nameOfCategory1 + " validation passed");
		Assert.assertEquals(nameOfCategory2, footerMainCatListEle.get(1).getText());
		logger.info(nameOfCategory2 + " validation passed");
		Assert.assertEquals(nameOfCategory3, footerMainCatListEle.get(2).getText());
		logger.info(nameOfCategory3 + " validation passed");
		Assert.assertEquals(nameOfCategory4, footerMainCatListEle.get(3).getText());
		logger.info(nameOfCategory4 + " validation passed");

	}

	public void getToKnowUsCategoryValidation(List<String> expectedGettoKnowUsOptions) {
		List<WebElement> gettoKnowUsOptionsActElement = driver.findElements(getToKnowUsOptions);
		logger.info("validating options under Get to know us category");
		for (int i = 0; i < expectedGettoKnowUsOptions.size(); i++) {
			if (expectedGettoKnowUsOptions.get(i).equals(gettoKnowUsOptionsActElement.get(i).getText())) {
				Assert.assertTrue(true);
				logger.info("validation passed for :->" + gettoKnowUsOptionsActElement.get(i).getText());
			} else {
				Assert.fail();

			}

		}

	}

	public void connectWithUsCategoryValidation(List<String> expectedConnectWithUsOptions) {
		List<WebElement> ConnectWithUsOptionsActElement = driver.findElements(connectWithUsOptions);

		for (int i = 0; i < expectedConnectWithUsOptions.size(); i++) {
			if (expectedConnectWithUsOptions.get(i).equals(ConnectWithUsOptionsActElement.get(i).getText())) {
				Assert.assertTrue(true);
				logger.info("validation passed for :->" + ConnectWithUsOptionsActElement.get(i).getText());

			} else {
				Assert.fail();
			}

		}

	}

	public void makeMoneyWithUsCategoryValidation(List<String> expectedMakeMoneyWithUsOptions) {

		List<WebElement> makeMoneyWithUsOptionsActElement = driver.findElements(makeMoneyWithUsOptions);

		for (int i = 0; i < expectedMakeMoneyWithUsOptions.size(); i++) {
			if (expectedMakeMoneyWithUsOptions.get(i).equals(makeMoneyWithUsOptionsActElement.get(i).getText())) {
				Assert.assertTrue(true);
				logger.info("validation passed for :->" + makeMoneyWithUsOptionsActElement.get(i).getText());

			} else {
				Assert.fail();
			}

		}
	}

	public void letUsHelpYouCategoryValidation(List<String> expectedLetUsHelpYou) {
		List<WebElement> letUshelpYouOptionsActElement = driver.findElements(letUsHelpYouOptions);

		for (int i = 0; i < expectedLetUsHelpYou.size(); i++) {
			if (expectedLetUsHelpYou.get(i).equals(letUshelpYouOptionsActElement.get(i).getText())) {
				Assert.assertTrue(true);
				logger.info("validation passed for :->" + letUshelpYouOptionsActElement.get(i).getText());

			} else {
				Assert.fail();
			}

		}
	}
}
