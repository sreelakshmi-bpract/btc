package com.btc.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.btc.pages.BtcHomePage;
import com.btc.pages.BtcLoginPage;

public class BtcHomeTest extends BtcTestHelper{
	BtcLoginPage btcloginpage;
	BtcHomePage btchomepage;
	
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	@Test
	public void verifySkipButtonOnDashboard() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("sreelakshmi@bpract.com", "12345678");
		btchomepage = new BtcHomePage(driver);
		btchomepage.clickSkipButtonBtn();	
	}
	

}
