package com.epam.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.utils.DriverUtil;

public class filmsPage {
	private DriverUtil driverUtil;

	
	public filmsPage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}


	public WebElement getModuleTitle() throws Exception {
		return driverUtil.getElement((By.className("module_title")));

	}	
}