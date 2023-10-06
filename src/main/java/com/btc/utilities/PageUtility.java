package com.btc.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByVisibleText(WebElement element, WebDriver driver, String str) {
		Select s = new Select(element);
		s.selectByVisibleText(str);
	}
	
	public void scrollToElement(WebElement element, WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void uploadFiles(WebElement element, WebDriver driver, String path) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		element.sendKeys(path);
	 }

}
