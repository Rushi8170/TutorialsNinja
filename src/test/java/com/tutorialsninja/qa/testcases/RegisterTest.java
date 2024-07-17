package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.TestBase;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utility;

public class RegisterTest extends TestBase {

	public WebDriver driver;
	RegisterPage registerPage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.seletRegisterOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "validRegisterData")
	public void verifyRegisterAndAccountWithMandatoryFields(String fname, String lname, String email, String mn,
			String pass, String cpass) {
		
		registerPage.register(fname, lname, email, mn, pass, cpass);
		
		String actualSuccessHeading = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!", "Account was not created");

	}

	@DataProvider(name = "validRegisterData")
	public Object[][] getData() {
		Object[][] data = Utility.getTestDataFromExel("Register");
		return data;
	}

}
