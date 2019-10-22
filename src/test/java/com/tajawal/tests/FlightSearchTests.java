package com.tajawal.tests;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tajawal.base.BaseTest;
import com.tajawal.pages.HomePage;

import com.tajawal.pages.ResultPage;
import com.tajawal.pages.SelectSeatPage;
import com.tajawal.pages.TravellersPage;
import com.tajawal.utils.DriverUtil;
import com.tajawal.utils.TestData;

/**
 * 
 * @author aida
 */

public class FlightSearchTests extends BaseTest {

	@DataProvider
	public Object[][] languages() {
		return new Object[][] { { "en", "tajawal" } };// , {"en", "almosafer"}};
	}

	@Test( dataProvider = "languages")
	public void firstScenario(String language, String url) throws Exception {

		// initializes the test with English language passed as parameter
		initializeTest(language, url);
		// load English property file

		initProperties(language);

		HomePage home = new HomePage(driverUtil);
		// search for flight
		ResultPage result = home.search(TestData.FromInputList(), TestData.ToInputList());
		driverUtil.waitForClassElementToBeVisible(ResultPage.searchResult, 30);
		result.selectShortStop();
		if (result.getShortStop().contains("direct")) {
			Assert.assertEquals(result.getResultStopTypes(), getValue("directFlight"));
		} else if (result.getShortStop().contains("1 stop")) {
			Assert.assertEquals(result.getResultStopTypes(), getValue("oneStop"));
		}

		driverUtil.waitForClassElementToBeVisible(ResultPage.searchResult, 30);
		// fill out travellers page with data being red from property file
		TravellersPage traveller = result.selectFlight();
		Thread.sleep(4000);
		// switching to iframe
		driverUtil.getDriver().switchTo().frame(driverUtil.getDriver()
				.findElement(By.xpath("//iframe[contains(@src, 'id=GTM-KVD5VT')]")));
		// driverUtil.getDriver().findElement(By.id("spWorker")).switchTo();
		traveller.fillContactForm(getValue("title"), getValue("firstName"), getValue("lastName"),
				getValue("emailAddress"), getValue("phoneNumber"));
		traveller.goToPayment();
		Assert.assertTrue(driverUtil.getUrl().contains(getValue("TravellersPageUrl")));

	}

	@Test(dataProvider = "languages")
	public void secondScenario(String language, String url) throws Exception {

		initializeTest(language, url);

		initProperties(language);

		HomePage home = new HomePage(driverUtil);

		ResultPage result = home.search(TestData.FromInputList(), TestData.ToInputList());

		driverUtil.waitForClassElementToBeVisible(ResultPage.searchResult, 20);
		result.sortPrice();
		Thread.sleep(4000);
		Assert.assertEquals(result.getMinPrice(), result.getCheapestPriceValue());

	}
}
