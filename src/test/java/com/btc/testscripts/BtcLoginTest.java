package com.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.btc.pages.BtcHomePage;
import com.btc.pages.BtcLoginPage;

public class BtcLoginTest extends BtcTestHelper{
	BtcLoginPage btcloginpage;
	BtcHomePage btchomepage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	@Test(priority=0)
	public void verifyWithValidData() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("info@cloudlumen.com", "123456");
		BtcHomePage btchomepage = new BtcHomePage(driver);
		Assert.assertTrue(btchomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("Login Successfull", true);
	}
	
	@Test(priority=1)
	public void verifyWithBlankEmail() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("", "123456");
		Assert.assertTrue(btcloginpage.getemailBlankMsg().contains("Email or Username is required"));
		Reporter.log("Failed to login", true);
	}
	@Test(priority=2)
	public void verifyblankPassword() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("info@cloudlumen.com", "");
		Assert.assertTrue(btcloginpage.getpasswordBlankMsg().contains("Password is required"));
		Reporter.log("Failed", true);
	}
	@Test(priority=3)
	public void verifyInvalidPassword() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("info@cloudlumen.com", "12345678");
		Assert.assertTrue(btcloginpage.getwrongCredentialMsg().contains("Wrong credentials!"));
		Reporter.log("Failed1");
	}
	@Test(priority=4)
	public void verifyInvalidEmail() {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("info@cloudlumen.", "123456");
		Assert.assertTrue(btcloginpage.getwrongCredentialMsg().contains("Wrong credentials!"));
		Reporter.log("Failed2");
	}
}
