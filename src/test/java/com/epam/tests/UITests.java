package com.epam.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.base.BaseTest;
import com.epam.pages.filmsPage;
import com.epam.pages.videosPage;
import com.epam.pages.HomePage;


public class UITests extends BaseTest {

	@Test(enabled = true)
	public void goToFilmsPage() throws Exception {

		initializeTest();
		HomePage homePage = new HomePage(driverUtil);
		filmsPage films =homePage.goToFilmsLink();

		Assert.assertEquals(films.getModuleTitle().getText()," STAR WARS FILM SELECTOR  ");
	}
	
	@Test(enabled = true)
	public void goToVideoPage() throws Exception {

		initializeTest();
		HomePage homePage = new HomePage(driverUtil);
		videosPage videos= homePage.goToVideos();
		
		Assert.assertEquals(videos.getModuleTitle().getText(),"THE STAR WARS SHOW //");
	}



}
