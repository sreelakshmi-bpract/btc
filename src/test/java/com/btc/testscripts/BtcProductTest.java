package com.btc.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.btc.pages.BtcHomePage;
import com.btc.pages.BtcLoginPage;
import com.btc.pages.BtcProductPage;

public class BtcProductTest extends BtcTestHelper{
	
	BtcLoginPage btcloginpage;
	BtcHomePage btchomepage;
	BtcProductPage btcproductpage;
	
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = launchBrowser(browser);
	}
	@Test
	public void enterAddNewProduct() throws InterruptedException {
		btcloginpage = new BtcLoginPage(driver);
		btcloginpage.login("info@cloudlumen.com", "12345678");
		btchomepage = new BtcHomePage(driver);
		Assert.assertTrue(btchomepage.getDashboardMsg().contains("Dashboard"));
		Reporter.log("Login Successfull", true);
		btchomepage.clickStoreBtn();
		btchomepage.clickEcommereceManager();
		btcproductpage = new BtcProductPage(driver);
		Assert.assertTrue(btcproductpage.getProductIndexPageMsg().contains("Product"));
		Reporter.log("You are now on product index page", true);
		btcproductpage.clickaddProductButton();
		btcproductpage.clickaddproduct();
		Assert.assertTrue(btcproductpage.getaddProductPageMsg().contains("Product Add"));
		Reporter.log("You are on add product page", true);
		btcproductpage.clickProductPaymentType();
	}

}
