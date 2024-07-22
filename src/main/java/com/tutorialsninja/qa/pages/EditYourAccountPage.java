package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditYourAccountPage {
	
	WebDriver driver;

	@FindBy(id = "input-firstname")
	WebElement editFirstName;
	
	@FindBy(id = "input-lastname")
	WebElement editLastName;
	
	@FindBy(id = "input-email")
	WebElement editEmail;
	
	@FindBy(id = "input-telephone")
	WebElement editPhoneNumber;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueButton;
	
	@FindBy(linkText = "Back")
	WebElement backButton;
	
	
	public EditYourAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AccountPage editOnlyFirstNameOnYourAccountInformation() {
		editFirstName.clear();
		editFirstName.sendKeys("Tony");
		continueButton.click();
		return new AccountPage(driver);
		
	}
	
	public AccountPage editInformationWithFirstAndLastName() {
		editFirstName.clear();
		editFirstName.sendKeys("Tony");
		editLastName.clear();
		editLastName.sendKeys("Stark");
		continueButton.click();
		return new AccountPage(driver);
	}
}
