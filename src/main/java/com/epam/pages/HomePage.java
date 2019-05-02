package com.epam.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.utils.DriverUtil;

public class HomePage {
	private DriverUtil driverUtil;

	private String filmsLink = "#section-links > li:nth-child(4) > a";

	private String videoLink = "#section-links > li:nth-child(2) > a";

	public HomePage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	public filmsPage goToFilms() throws Exception {
		List<WebElement> sections = driverUtil.getListOfElements(By.className("section-icon"));
		for(WebElement section:sections ) {
			if (section.getAttribute("data-section").equalsIgnoreCase(("Films"))){
			section.click();
			break;
			}
		}
		
	
		return new filmsPage(driverUtil);
	}

	public videosPage goToVideos() throws Exception {
		driverUtil.click(By.cssSelector(videoLink));
		return new videosPage(driverUtil);
	}

	public filmsPage goToFilmsLink() throws Exception {
		driverUtil.click(By.cssSelector(filmsLink));
		return new filmsPage(driverUtil);
	}
	
	
	public List<WebElement> getModuleTitle() throws Exception {
		return driverUtil.getListOfElements((By.className("module_title")));
		
		
	}

}