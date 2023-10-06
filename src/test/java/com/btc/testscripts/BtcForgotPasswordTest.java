package com.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.btc.pages.BtcForgotPasswordPage;
import com.btc.pages.BtcLoginPage;

public class BtcForgotPasswordTest extends BtcTestHelper{
	BtcLoginPage btcloginpage;
	BtcForgotPasswordPage btcforgotpasswordpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	@Test(priority=0)
	public void verifyYourForgotPassword() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.clickforgotPasswordButton();
		btcforgotpasswordpage = new BtcForgotPasswordPage(driver);
		Assert.assertTrue(btcforgotpasswordpage.getForgotPasswordMsg().contains("Forgot your password?"));
		Reporter.log("You are in forgot password page", true);		
	}
	@Test(priority=1)
	public void verifyInValidEmailAddress() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.clickforgotPasswordButton();
		btcforgotpasswordpage = new BtcForgotPasswordPage(driver);
		btcforgotpasswordpage.forgotPassword("sreelakshmi@bpract.com");
		Assert.assertTrue(btcforgotpasswordpage.getrequestSentMsg().contains("Request sent successfully"));
		Reporter.log("Email Sent Successfully", true);
	}
	@Test(priority=2)
	public void verifyBackButtonInForgotPassowrdPage() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.clickforgotPasswordButton();
		btcforgotpasswordpage = new BtcForgotPasswordPage(driver);
		btcforgotpasswordpage.clickForgotPassowrdBackBtn();
		Assert.assertTrue(btcloginpage.getWelcomeToBitcoinTafMsg().contains("WELCOME TO"));
		Reporter.log("Back To Login Page", true);
	}
}
