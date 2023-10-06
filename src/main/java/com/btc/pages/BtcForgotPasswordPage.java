package com.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btc.utilities.WaitUtility;

public class BtcForgotPasswordPage {
	WebDriver driver;
	
	@FindBy(xpath="//p[contains(text(),\"Forgot your password?\")]")
	WebElement forgotYourPasswordMsg;
	@FindBy(name="email")
	WebElement emailAddress;
	@FindBy(xpath="//button[contains(text(),\"Reset Password\")]")
	WebElement resetPasswordButton;
	@FindBy(xpath="//h3[contains(text(),\"Request sent successfully\")]")
	WebElement requestSentMsg;
	@FindBy(xpath="//a[contains(text(),\"Back\")]")
	WebElement backButton;
	
	WaitUtility waitutility = new WaitUtility();
	
	public BtcForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getForgotPasswordMsg() {
		waitutility.waitForAnElement(forgotYourPasswordMsg, driver);
		String ForgotPasswordMsg = forgotYourPasswordMsg.getText();
		return ForgotPasswordMsg;
	}
	public void enterEmail(String strEmail) {
		waitutility.waitForAnElement(emailAddress, driver);
		emailAddress.sendKeys(strEmail);
	}
	public void clickResetPassowrdbtn() {
		resetPasswordButton.click();
	}
	public void clickForgotPassowrdBackBtn() {
		waitutility.waitForAnElement(backButton, driver);
		backButton.click();
	}
	public void forgotPassword(String strEmail) {
		this.enterEmail(strEmail);
		this.clickResetPassowrdbtn();
	}
	public String getrequestSentMsg() {
		waitutility.waitForAnElement(requestSentMsg, driver);
		String requestSentMsgText = requestSentMsg.getText();
		return requestSentMsgText;
	}
}
