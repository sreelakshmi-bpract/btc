package com.btc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btc.utilities.WaitUtility;



public class BtcHomePage {
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(),\"Dashboard\")]")
	WebElement dashboardMsg;
	@FindBy(xpath="//button[contains(text(),\"Skip\")]")
	WebElement skipButton;
	@FindBy(xpath="//div[contains(text(),\"My Profile\")]")
	WebElement profileButton;
	@FindBy(xpath="//div[contains(text(), \"Store\")]")
	WebElement storeButton;
	@FindBy(xpath="//div[contains(text(), \"Ecommerce Manager\")]")
	WebElement ecommerceManagerButton;
	
	WaitUtility waitutility = new WaitUtility();
	
	public BtcHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDashboardMsg() { 
		waitutility.waitForAnElement(dashboardMsg, driver);
		String dashboardMsgText = dashboardMsg.getText();
		return dashboardMsgText;
	}
	public void clickSkipButtonBtn() {
		waitutility.waitForAnElement(skipButton, driver);
		skipButton.click();
	}
	public void clickMyProfileBtn() {
		profileButton.click();
	}
	public void clickStoreBtn() {
		storeButton.click();
	}
	public void clickEcommereceManager() {
		waitutility.waitForAnElement(ecommerceManagerButton, driver);
		ecommerceManagerButton.click();
	}
}
