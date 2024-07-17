package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.TestBase;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends TestBase {

	public WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchValidProduct() {
		searchPage = homePage.searchForAProduct("HP");
		Assert.assertTrue(searchPage.displayStatusOfHPProduct(), "Valid Product");

	}

	@Test(priority = 2)
	public void verifySearchInalidProduct() {
		searchPage = homePage.searchForAProduct("Honda");

		Assert.assertEquals(searchPage.retriveNoProductSearchMessageText(), "There is no product that matches the search criteria.", "No product found");

	}
}
