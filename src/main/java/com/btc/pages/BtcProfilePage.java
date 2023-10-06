package com.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btc.utilities.PageUtility;
import com.btc.utilities.WaitUtility;

public class BtcProfilePage {
	WebDriver driver;
	
	@FindBy(xpath="//h6[contains(text(),\"Your Activity History\")]")
	WebElement activityHistoryMsg;
	@FindBy(xpath="//button[contains(text(),\"Edit Info\")]")
	WebElement editInfoButton;
	@FindBy(xpath="//h6[contains(text(),\"Social Media Scope\")]")
	WebElement socialMediaScopeMsg;
	@FindBy(xpath="//button[contains(text(),\"Save Changes\")]")
	WebElement saveChangesButton;
	@FindBy(name="telegram")
	WebElement telegramName;
	@FindBy(name="first_name")
	WebElement firstNameField;
	@FindBy(name="last_name")
	WebElement lastNameField;
	@FindBy(name="gender")
	WebElement genderField;
	@FindBy(name="country")
	WebElement countryField;
	@FindBy(name="state")
	WebElement stateField;
	@FindBy(name="city")
	WebElement cityField;
			
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public BtcProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getYourActivityHistoryMsg() {
		waitutility.waitForAnElement(activityHistoryMsg, driver);
		String yourActivityHistoryMsg = activityHistoryMsg.getText();
		return yourActivityHistoryMsg;
	}
	public void clickEditInfoBtn() {
		editInfoButton.click();
	}
	public void clickSaveChangesBtn() {
		saveChangesButton.click();
	}
	public String getSocialMediaScopeMsg() {
		waitutility.waitForAnElement(socialMediaScopeMsg, driver);
		String socialMediaScopeMsgText = socialMediaScopeMsg.getText();
		return socialMediaScopeMsgText;
	}
	public void enterFirstName(String strFirstName) {
		firstNameField.sendKeys(strFirstName);
	}
	public void enterLastName(String strLastName) {
		lastNameField.sendKeys(strLastName);
	}
	public void selectGender(String strGender) {
		pageutility.selectByVisibleText(genderField, driver, strGender);
	}
	public void selectCountry(String strCountry) {
		pageutility.selectByVisibleText(countryField, driver, strCountry);
	}
	public void enterState(String strState) {
		stateField.sendKeys(strState);
	}
	public void enterCity(String strCity) {
		cityField.sendKeys(strCity);
	}
	public void enterTelegramUserName(String strUserName) {
		telegramName.sendKeys(strUserName);
	}
	public void editInfo(String strFirstName, String strLastName, String strGender, String strCountry, String strState, String strCity, String strTeleUserName) {
		this.enterFirstName(strFirstName);
		this.enterLastName(strLastName);
		this.selectGender(strGender);
		this.selectCountry(strCountry);
		this.enterState(strState);
		this.enterCity(strCity);
		this.enterTelegramUserName(strTeleUserName);
		this.clickSaveChangesBtn();
	}

}
