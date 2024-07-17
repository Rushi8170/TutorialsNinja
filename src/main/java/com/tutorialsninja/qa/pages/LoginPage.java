package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(id = "input-email")
	WebElement emailAdressField;
	
	@FindBy(id = "input-password")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement selectLogin;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	WebElement emailPasswordNotMatching;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	public AccountPage login(String emailText, String enterPass) {
		emailAdressField.sendKeys(emailText);
		passwordField.sendKeys(enterPass);
		selectLogin.click();
		return new AccountPage(driver);
	}
	
	public String retriveEmailPasswordNotMatchingWarningText() {
		String warningText = emailPasswordNotMatching.getText();
		return warningText;
	}

}
