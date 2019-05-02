package com.epam.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.utils.DriverUtil;

public class videosPage {
	private DriverUtil driverUtil;

	
	public videosPage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	public List<WebElement> getModuleTitles() throws Exception {
		return driverUtil.getListOfElements((By.className("module_title")));


	}
	
	public WebElement getModuleTitle() throws Exception {
		return driverUtil.getElement((By.className("module_title")));

	}	
}