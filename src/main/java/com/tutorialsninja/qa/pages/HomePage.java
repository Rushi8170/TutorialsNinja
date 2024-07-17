package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccountDropDown;
	
	@FindBy(linkText = "Login")
	WebElement selectLoginOption;
	
	@FindBy(linkText = "Register")
	WebElement selectRegisterOption;
	
	@FindBy(name = "search")
	WebElement searchBoxField;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public SearchPage searchForAProduct(String searchProduct) {
		searchBoxField.sendKeys(searchProduct);
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public SearchPage selectSearchOption(String searchProduct) {
		searchBoxField.sendKeys(searchProduct);
		searchButton.click();
		return new SearchPage(driver);
	} 
	
	public LoginPage navigateToLoginPage() {
		myAccountDropDown.click();
		selectLoginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage seletRegisterOption() {
		myAccountDropDown.click();
		selectRegisterOption.click();
		return new RegisterPage(driver);
	}
}
