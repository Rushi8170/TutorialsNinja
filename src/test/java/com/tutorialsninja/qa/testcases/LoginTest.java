package com.tutorialsninja.qa.testcases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.TestBase;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utility;

public class LoginTest extends TestBase {

	public WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));

		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToLoginPage();
	}

	@AfterMethod
	public void tearDoen() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validSetOfLoginCredential")
	public void verifyLoginwithValidCrediantials(String email, String password) {

		accountPage =  loginPage.login(email, password);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformation(),
				"Edit your account information option is not displayed");

	}

	@DataProvider(name = "validSetOfLoginCredential")
	public Object[][] supplyTestData() {
		Object[][] data = Utility.getTestDataFromExel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCrediantial() {

		loginPage.login("jarvis@" + generateTimStamp() + "gmail.com", "123");
		
		String actualWarningMessages = loginPage.retriveEmailPasswordNotMatchingWarningText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessages.contains(expectedWarningMessage),
				"Expected warning message is displayed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailandValidPassword() {
		loginPage.login("jarvis@" + generateTimStamp() + "gmail.com", "12345");

		String actualWarningMessages = loginPage.retriveEmailPasswordNotMatchingWarningText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessages.contains(expectedWarningMessage),
				"Expected warning message is displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {

		loginPage.login("jarvis@gmail.com", "123");

		String actualWarningMessages = loginPage.retriveEmailPasswordNotMatchingWarningText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessages.contains(expectedWarningMessage),
				"Expected warning message is displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutCrediantials() {

		loginPage.login("", "");

		String actualWarningMessages = loginPage.retriveEmailPasswordNotMatchingWarningText();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessages.contains(expectedWarningMessage),
				"Expected warning message is displayed");

	}

	public String generateTimStamp() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
}
