package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	WebElement editYourAccountInformationOption;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement yourAccountHasBeenSuccessfullyUpdated;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDisplayStatusOfEditYourAccountInformation() {
		boolean displayStatus = editYourAccountInformationOption.isDisplayed();
		return displayStatus;
	}
	
	public boolean getDisplayStatusOfUpdatedAcountInformation() {
		boolean displayStatus = yourAccountHasBeenSuccessfullyUpdated.isDisplayed();
		return displayStatus;
	}
	
	public EditYourAccountPage openLinkForEditAccountinformatin() {
		editYourAccountInformationOption.click();
		return new EditYourAccountPage(driver);
	}
	
	
	
}
