package com.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.btc.pages.BtcLoginPage;
import com.btc.pages.BtcRegisterPage;

public class BtcRegisterTest extends BtcTestHelper{
	BtcLoginPage btcloginpage;
	BtcRegisterPage btcregisterpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
//	@Test(priority=0)
	public void verifyWelcomeToBitCoinTafMsg() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.clickGetStartedBtn();
		btcregisterpage = new BtcRegisterPage(driver);
		Assert.assertTrue(btcregisterpage.getWelcomeToBitCoinTafMsg().contains("WELCOME TO BITCOINTAF"));
		Reporter.log("Successfully Redirected to Register Page", true);
	}
//	@Test(priority=1)
	public void verifyAllPositiveValues() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.clickGetStartedBtn();
		btcregisterpage = new BtcRegisterPage(driver);
		btcregisterpage.register("Sreelakshmi Dinesh", "sreelakshmi+31071@bpract.com", "12345678", "12345678");		
	}
	@Test
	public void verifyBlankFirstNameMsg() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.clickGetStartedBtn();
		btcregisterpage = new BtcRegisterPage(driver);
		btcregisterpage.register("", "sreelakshmi+31071@bpract.com", "12345678", "12345678");
		Assert.assertTrue(btcregisterpage.getFirstNameRequiredMsg().contains("First Name is required"));
		Reporter.log("Displayed as First Name is Required", true);
	}

}
