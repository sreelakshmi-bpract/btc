package com.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btc.utilities.WaitUtility;

public class BtcLoginPage {
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement emailLogin;
	@FindBy(name="password")
	WebElement passwordLogin;
	@FindBy(xpath="//button[contains(text(),\"Login\")]")
	WebElement loginButton;
	@FindBy(xpath="//p[contains(text(),\"Email or Username is required\")]")
	WebElement blankEmailMsg;
	@FindBy(xpath="//p[contains(text(),\"Password is required\")]")
	WebElement blankPasswordMsg;
	@FindBy(xpath="//div[contains(text(),\"Wrong credentials!\")]")
	WebElement wrongCrendentialMsg;
	@FindBy(xpath="//a[contains(text(),\"Forgot password?\")]")
	WebElement forgotPasswordButton;
	@FindBy(xpath="//h4[contains(text(),\"WELCOME TO\")]")
	WebElement welcomeToBitcoinTafMsg;
	@FindBy(xpath="//a[contains(text(),\"Get started\")]")
	WebElement registerButton;
	
		
	WaitUtility waitutility = new WaitUtility();
	
	public BtcLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String strEmail) {
		emailLogin.sendKeys(strEmail);
	}
	public void enterPassword(String strPassword) {
		passwordLogin.sendKeys(strPassword);
	}
	public void clickLoginBtn() {
		loginButton.click();
	}
	public void clickGetStartedBtn() {
		registerButton.click();
	}
	public void login(String strEmail, String strPassword) {
		this.enterEmail(strEmail);
		this.enterPassword(strPassword);
		this.clickLoginBtn();
	}
	public String getemailBlankMsg() {
		waitutility.waitForAnElement(blankEmailMsg, driver);
		String emaiBlankMsg = blankEmailMsg.getText();
		return emaiBlankMsg;
	}
	public String getpasswordBlankMsg() {
		waitutility.waitForAnElement(blankPasswordMsg, driver);
		String passwordBlankMsg = blankPasswordMsg.getText();
		return passwordBlankMsg;
	}
	public String getwrongCredentialMsg() {
		waitutility.waitForAnElement(wrongCrendentialMsg, driver);
		String wrongCredentialMsgText = wrongCrendentialMsg.getText();
		return wrongCredentialMsgText;
	}
	public void clickforgotPasswordButton() {
		forgotPasswordButton.click();
	}
	public String getWelcomeToBitcoinTafMsg() {
		waitutility.waitForAnElement(welcomeToBitcoinTafMsg, driver);
		String welcomeToBitcoinTafMsgText = welcomeToBitcoinTafMsg.getText();
		return welcomeToBitcoinTafMsgText;
	}
	
}
