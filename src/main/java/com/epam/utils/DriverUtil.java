package com.epam.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtil {

	private WebDriver driver;

	public DriverUtil(WebDriver newDriver) {

		this.driver = newDriver;

	}

	public void maximizeBrowser() throws Exception {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw e;
		}

	}

	public void goToUrl(String url) throws Exception {
		try {
			driver.get(url);
		} catch (Exception e) {

			throw e;
		}
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public List<WebElement> getListOfElements(WebElement table) {
		List<WebElement> list = new ArrayList<WebElement>();
		list = (table).findElements(By.tagName("tr"));
		return list;
	}
	
	public List<WebElement> getListOfElements(By locator) {
		List<WebElement> list = new ArrayList<WebElement>();
		
		return list;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
