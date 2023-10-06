package com.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btc.utilities.WaitUtility;

public class BtcRegisterPage {
	WebDriver driver;
	
	@FindBy(xpath="//h4[contains(text(),\"WELCOME TO \")]")
	WebElement registerPageMsg;
	@FindBy(name="first_name")
	WebElement firstNameField;
	@FindBy(name="email")
	WebElement emailAddress;
	@FindBy(name="password")
	WebElement passwordFiled;
	@FindBy(name="repassword")
	WebElement repasswordField;
	@FindBy(name="agree")
	WebElement agreeButton;
	@FindBy(xpath="//p[contains(text(),\"First Name is required\")]")
	WebElement firstBlankMsg;
	
	WaitUtility waitutility = new WaitUtility();
	
	public BtcRegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getWelcomeToBitCoinTafMsg() {
		waitutility.waitForAnElement(registerPageMsg, driver);
		String welcomeToBitcoinTafMsgText = registerPageMsg.getText();
		return welcomeToBitcoinTafMsgText;
	}
	public void enterFirstName(String strFirstName) {
		waitutility.waitForAnElement(firstNameField, driver);
		firstNameField.sendKeys(strFirstName);
	}
	public void enterEmailAddress(String strEmail) {
		emailAddress.sendKeys(strEmail);
	}
	public void enterPassword(String strPassword) {
		passwordFiled.sendKeys(strPassword);
	}
	public void enterRepassword(String strRepassword) {
		repasswordField.sendKeys(strRepassword);
	}
	public void clickAgreeButtonBtn() {
		agreeButton.click();
	}
	public void register(String strFirstName, String strEmail, String strPassword, String strRepassword) {		
		this.enterFirstName(strFirstName);
		this.enterEmailAddress(strEmail);
		this.enterPassword(strPassword);
		this.enterRepassword(strRepassword);
		this.clickAgreeButtonBtn();
	}
	public String getFirstNameRequiredMsg() {
		waitutility.waitForAnElement(firstBlankMsg, driver);
		String firstNameRequiredMsgText = firstBlankMsg.getText();
		return firstNameRequiredMsgText;
	}

}
