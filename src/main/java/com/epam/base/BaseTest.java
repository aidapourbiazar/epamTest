package com.epam.base;

import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;

import com.epam.utils.DriverUtil;

public class BaseTest {

	protected DriverUtil driverUtil;
	WebDriver drv;
	private static final Properties properties = new Properties();

	@BeforeMethod(alwaysRun = true, enabled = true)
	public void setup() throws Exception {
		try {

			String exePath = "src//test//resources//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			WebDriver drv = new ChromeDriver();
			driverUtil = new DriverUtil(drv);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void initializeTest() throws Exception {
		try {

			driverUtil.goToUrl(getUrl());

			driverUtil.maximizeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String getUrl() {
		ResourceBundle resource = ResourceBundle.getBundle(getEnvironment());
		return resource.getString("starWarsUrl");
	}

	private String getEnvironment() {
		String environment;	
			environment = System.getProperty("environment");		
		return environment;
	}
}
