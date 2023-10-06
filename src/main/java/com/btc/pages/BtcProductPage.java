package com.btc.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btc.utilities.PageUtility;
import com.btc.utilities.WaitUtility;

public class BtcProductPage {
	WebDriver driver;
	
	@FindBy(xpath="//h4[contains(text(), \"Product\")]")
	WebElement productIndexMsg;
	@FindBy(id="add_button")
	WebElement addButton;
	@FindBy(id="add_product") 
	WebElement addproductButton;
	@FindBy(xpath="//h4[contains(text(), \"Product Add\")]")
	WebElement addProductPageMsg;
	@FindBy(id="product_name")
	WebElement productNameField;
	@FindBy(id="product_category_id")
	WebElement productCategoryField;
	@FindBy(id="category_id")
	WebElement categoryField;
	@FindBy(name="meta_keywords")
	WebElement metaKeywordField;
	@FindBy(name="meta_description")
	WebElement metaDescriptionField;
	@FindBy(name="short_description")
	WebElement shorDescriptionField;
	@FindBy(name="title")
	WebElement titleField;
	@FindBy(xpath="//div[@class=\"ql-editor\"]")
	WebElement productDescField;
	@FindBy(name="product_url")
	WebElement productUrlField;
	@FindBy(xpath="//div[@id=\"drop-zone\"]/input")
	WebElement productImage;
	@FindBy(name="start_up")
	WebElement startUpButton;
	@FindBy(name="referral_bonus")
	WebElement referralBonusButton;
	@FindBy(name="bv_percentage")
	WebElement productBV;
	@FindBy(name="month")
	WebElement selectProductMonth;
	@FindBy(name="price")
	WebElement productPriceField;
	@FindBy(name="custom_days")
	WebElement productCustomDays;
	@FindBy(name="package_label")
	WebElement productPackageLabel;
	@FindBy(name="apple_price_id")
	WebElement productPriceId;
	@FindBy(name="apple_subscription_price_id")
	WebElement productSubscriptionId;
	@FindBy(xpath="//button[contains(text(), \"remove\")]")
	WebElement priceIdRemoveButton;
	@FindBy(xpath="//button[contains(text(), \"Reset\")]")
	WebElement priceIdResetButton;
	@FindBy(xpath="//button[contains(text(), \"Add Price\")]")
	WebElement addPriceButton;
	@FindBy(name="is_combo")
	WebElement enableComboOption;
	@FindBy(name="add_on")
	WebElement enableAddOnOption;
	@FindBy(name="active")
	WebElement enableDisableProduct;
	@FindBy(xpath="//span[contains(text(),\"Paypal Marius\")]")
	WebElement productPaymentPaypalMarius;
	@FindBy(xpath="//span[contains(text(),\"Bitcoin\")]")
	WebElement productPaymentBitcoin;
	@FindBy(name="video")
	WebElement productVimeoVideo;
	@FindBy(name="doc")
	WebElement productDoc;
	@FindBy(name="sample_doc")
	WebElement productSampleDoc;
	
	@FindBy(xpath="//span[contains(text(),\"Long Term Trade Reports for Bitcoin & ALT coins - Insider Info Before Market Moves\")]")
	WebElement firstProductFromList;
	
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public BtcProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getProductIndexPageMsg(){
		waitutility.waitForAnElement(productIndexMsg, driver);
		String productIndexMsgText = productIndexMsg.getText();
		return productIndexMsgText;
	}
	public void clickaddProductButton() throws InterruptedException {
//		waitutility.hardwait();
		addButton.click();
	}
	public void clickaddproduct() {
		waitutility.waitForAnElement(firstProductFromList, driver);
		addproductButton.click();
	}
	public String getaddProductPageMsg() {
		waitutility.waitForAnElement(addProductPageMsg, driver);
		String addProductPageMsgText = addProductPageMsg.getText();
		return addProductPageMsgText;
	}
	public void enterProductName(String strName) {
		productNameField.sendKeys(strName);
	}
	public void enterProductCategory(String strProductCate) {
		productCategoryField.sendKeys(strProductCate);
	}
	public void entercategoryField(String strCate) {
		categoryField.sendKeys(strCate);
	}
	public void enterMetaKeyword(String strMetaKey) {
		metaKeywordField.sendKeys(strMetaKey);
	}
	public void enterMetaDescription(String strMetaDesc) {
		metaDescriptionField.sendKeys(strMetaDesc);
	}
	public void enterShortDesc(String strShortDec) {
		shorDescriptionField.sendKeys(strShortDec);
	}
	public void enterTitle(String strTitle) {
		titleField.sendKeys(strTitle);
	}
	public void enterProductDesc(String strProductDesc) {
		productDescField.sendKeys(strProductDesc);
	}
	public void enterProductUrl(String strProductUrl) {
		productUrlField.sendKeys(strProductUrl);
	}
	public void selectProductImage(String strProductImg) throws AWTException, InterruptedException {
		waitutility.waitForAnElement(productImage, driver);
		pageutility.uploadFiles(productImage, driver, strProductImg);
	}
	public void clickstartUpBtn() {
		startUpButton.click();
	}
	public void clickreferralBonusButton() {
		referralBonusButton.click();
	}
	public void enterProductBV(String strProductBV) {
		productBV.sendKeys(strProductBV);
	}
	public void selectProductMonth(String strProMonth) {
		selectProductMonth.sendKeys(strProMonth);
	}
	public void clickProductPaymentType() {
		waitutility.waitUntilClickable(productPaymentPaypalMarius, driver);
		productPaymentPaypalMarius.click();
		productPaymentBitcoin.click();
	}

}
