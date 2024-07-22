package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.TestBase;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.EditYourAccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;

public class AccountPageTest extends TestBase{

	public WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;
	EditYourAccountPage editYourAccountPage;
	
	@BeforeMethod
	public void setUp() {
		 driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		 HomePage homePage = new HomePage(driver);
		 loginPage = homePage.navigateToLoginPage();
		 accountPage = loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		 editYourAccountPage = accountPage.openLinkForEditAccountinformatin();
	}
	
	@Test(priority = 1)
	public void verifyUpdateOnlyFirstName() {
		accountPage = editYourAccountPage.editOnlyFirstNameOnYourAccountInformation(); 
		
		Assert.assertTrue(accountPage.getDisplayStatusOfUpdatedAcountInformation(), "Information not updated");
	}
	
	@Test(priority = 2)
	public void verifyUpdateInformationWithFirstandLastName() {
		accountPage = editYourAccountPage.editInformationWithFirstAndLastName();
		Assert.assertTrue(accountPage.getDisplayStatusOfUpdatedAcountInformation(), "Information fails to update");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
