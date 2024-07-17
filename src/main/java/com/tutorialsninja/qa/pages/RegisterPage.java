package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	@FindBy(id = "input-firstname")
	WebElement firstNameTextField;
	
	@FindBy(id = "input-lastname")
	WebElement lastNameTextField;
	
	@FindBy(id = "input-email")
	WebElement emailTextField;
	
	@FindBy(id = "input-telephone")
	WebElement phoneTextField;
	
	@FindBy(id = "input-password")
	WebElement passwordTextField;
	
	@FindBy(id = "input-confirm")
	WebElement confirmPasswordTextField;
	
	@FindBy(name = "agree")
	WebElement selectPrivacyButton;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement selectContinueBUtton;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstName) {
		firstNameTextField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameTextField.sendKeys(lastName);
	}
	
	public void enterEmailAddress(String emailAddress) {
		emailTextField.sendKeys(emailAddress);
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		phoneTextField.sendKeys(phoneNumber);
	}
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTextField.sendKeys(confirmPassword);
	}
	
	public void selectPrivacyButtonField() {
		selectPrivacyButton.click();
	}
	
	public void clickOnContinueButton() {
		selectContinueBUtton.click();
	}
	public void register(String firstName, String lastName, String emailAddress, String phoneNumber, String password, String confirmPassword) {
		firstNameTextField.sendKeys(firstName);
		lastNameTextField.sendKeys(lastName);
		emailTextField.sendKeys(emailAddress);
		phoneTextField.sendKeys(phoneNumber);
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(confirmPassword);
		selectPrivacyButton.click();
		selectContinueBUtton.click();
	}
}
