package com.tajawal.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.tajawal.utils.DriverUtil;
import com.tajawal.utils.TestData;

/**
 * The class constructs Home page elements needed for tests
 * @author aida
 *
 */
public class HomePage {
	private DriverUtil driverUtil;

private String FromSearch = "FlightSearchBox__FromAirportInput";

private String option1Search = "//li[@data-testid = 'FlightSearchBox__AirportOption1']";

private String searchButton = "//button[@data-testid = 'FlightSearchBox__SearchButton']";
private String attNameDataId = "data-testid";

	public HomePage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	/**
	 * 
	 * @return ResultPage
	 * @throws Exception
	 */
	public ResultPage search(String fromInput,String ToInput) throws Exception {
		
		getPageTag("input", attNameDataId , FromSearch ).sendKeys(fromInput);
		
		driverUtil.getDriver().findElement(By.xpath(option1Search)).click();
		getPageTag("input","placeholder", "Destination").sendKeys(ToInput);
		Thread.sleep(3000);
		driverUtil.getDriver().findElement(By.xpath(option1Search)).click();
		Thread.sleep(3000);
		driverUtil.getDriver().findElement(By.xpath(searchButton)).click();
	

		return new ResultPage(driverUtil);
	}

	public WebElement getPageTag(String TagName, String attName, String attValue) throws Exception {

		List<WebElement> elements = driverUtil.getDriver().findElements(By.tagName(TagName));
	    WebElement elementFound=null;
		for(WebElement element : elements){
		    if(element.getAttribute(attName).equals(attValue)){
		        elementFound =element;
		    }
		   
		}
		return elementFound;

		}
	
	
	
	
	
}

