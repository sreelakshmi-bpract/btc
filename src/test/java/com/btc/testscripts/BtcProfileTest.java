package com.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.btc.pages.BtcHomePage;
import com.btc.pages.BtcLoginPage;
import com.btc.pages.BtcProfilePage;



public class BtcProfileTest extends BtcTestHelper{
	BtcLoginPage btcloginpage;
	BtcHomePage  btchomepage;
	BtcProfilePage btcprofilepage;

	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
//	@Test
	public void verifyEditInfoMsg() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("sreelakshmi@bpract.com", "12345678");
		btchomepage = new BtcHomePage(driver);
		btchomepage.clickSkipButtonBtn();
		btchomepage.clickMyProfileBtn();
		btcprofilepage = new BtcProfilePage(driver);
		Assert.assertTrue(btcprofilepage.getYourActivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You Are In Profile Page", true);
		btcprofilepage.clickEditInfoBtn();
		Assert.assertTrue(btcprofilepage.getSocialMediaScopeMsg().contains("Social Media Scope"));
		Reporter.log("You are In Profile Edit Info Page", true);
		btcprofilepage.clickSaveChangesBtn();
	}
	@Test
	public void verifyValidEditInfo() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("sreelakshmi@bpract.com", "12345678");
		btchomepage = new BtcHomePage(driver);
		btchomepage.clickSkipButtonBtn();
		btchomepage.clickMyProfileBtn();
		btcprofilepage = new BtcProfilePage(driver);
		Assert.assertTrue(btcprofilepage.getYourActivityHistoryMsg().contains("Your Activity History"));
		Reporter.log("You Are In Profile Page", true);
		btcprofilepage.clickEditInfoBtn();
		Assert.assertTrue(btcprofilepage.getSocialMediaScopeMsg().contains("Social Media Scope"));
		Reporter.log("You are In Profile Edit Info Page", true);
		btcprofilepage.editInfo("sreelakshmi", "Dinesh", "female", "India", "Kerala", "Kannur", "sree");
		btcprofilepage.clickSaveChangesBtn();		
	}

}
