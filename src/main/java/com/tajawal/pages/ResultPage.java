package com.tajawal.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tajawal.utils.DriverUtil;
/**
 * The class constructs result page elements needed for tests
 * @author aida
 */
public class ResultPage {

	private DriverUtil driverUtil;
	public static String searchResult = "search-result-leg-card";
	public String directStop = "stop-0";


	

	public ResultPage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	
	
	public void selectShortStop() throws Exception {
	
		driverUtil.getElement(By.className("form-check-label")).click();

	}

	public TravellersPage selectFlight() throws Exception {
	
		driverUtil.getElement(By.xpath("//button[contains(@class,'btn-primary')]")).click();
	
	return new TravellersPage(driverUtil);
	}
	
	
	
	public String getShortStop() throws Exception {
	
		return driverUtil.getElement(By.className("form-check-label")).getText();

	}
	
	public String getResultStopTypes() throws Exception {
		
		return driverUtil.getElement(By.xpath("//span[@data-testid = 'FlightSearchResult__Itinerary1__Leg1__StopsLabel']")).getText();

	}
	



	public void sortPrice() throws Exception {
		getSortDropdown().click();
	
		verifyCheapestPrice();
	}
	
	public WebElement getSortDropdown() throws Exception {

		return driverUtil.getElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div/button"));

	}
	
	
 
		public  boolean verifyCheapestPrice() throws Exception {
			
			return driverUtil.getElement(By.id("sortBy-price:asc")).isSelected();

		}
		
      public  int getCheapestPriceValue() throws Exception {
			
			return Integer.valueOf(driverUtil.getElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[3]/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]")).getText().replaceAll("[,]", ""));

		}


	
      public int getMinPrice() {		
			
			List<WebElement> elements = driverUtil.getDriver().findElements(By.xpath("//div[contains(@data-testid,'PriceLabel')]"));
			List<String> priceList = new ArrayList<String>();
		
			for(WebElement element : elements){
			
		priceList.add(element.getText().replaceAll("[,]", ""));
			System.out.println(element.getText().replaceAll("[,]", ""));
			    }
			
			
			 int minValue =Integer.valueOf(priceList.get(0));
			for(int i=0 ; i<priceList.size()-1 ; i++)
				{
			    if(Integer.valueOf(priceList.get(i)) >= Integer.valueOf(priceList.get(i+1))){
			    	minValue =Integer.valueOf(priceList.get(i+1));
			    }
			
				}
			return minValue;
	
	}

	
	
	
      

	}
	
	
