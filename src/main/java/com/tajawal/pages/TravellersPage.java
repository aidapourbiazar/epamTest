package com.tajawal.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tajawal.utils.DriverUtil;


/**
 * The class constructs Second result page elements needed for tests
 * @author aida
 */
public class TravellersPage {
	
	private DriverUtil driverUtil;
	
    private String phoneNUmer= "contact.phoneNumber";
    private String firstName = "contact.firstName";
    private String lastName = "contact.lastName";
    private String emailAddress = "contact.email";
    private String selectTitle = "contact.title";
    private String continueButton = "//button[@data-testid ='FlightPAX__ContinueToPaymentButton']";
    private String firstNameError = "//div[@data-testid ='FlightPAX__Adult1__FirstNameErrorLabel";
    private String lastNameError = "//div[@data-testid ='FlightPAX__Adult1__LastNameErrorLabel";
    
	public TravellersPage(DriverUtil driverUtil) throws Exception {
		this.driverUtil = driverUtil;

	}

	public void fillContactForm(String Title, String firstName, String lastName,String emailAddress, String phone) {
	selectTitle(Title);
	putFirstName(firstName);
	putLastName(lastName);
	putEmailAddress(emailAddress);
	putPhoneNumber(phone);
		
	}

	public void selectTitle(String title) {
		WebElement month_dropdown = driverUtil.getElement(By.name(selectTitle));
		Select month=new Select(month_dropdown);
		 
		List<WebElement> dropdown=month.getOptions();
		 
		 for(int i=0;i<dropdown.size();i++){
		 
				 if (dropdown.get(i).getText().equalsIgnoreCase(title)) 
					 dropdown.get(i).click();
		 
		 }
		
	}

	public void putLastName(String lastname) {
		driverUtil.getElement(By.name(lastName)).sendKeys(lastname);

	}

	public void putPhoneNumber(String phone) {
		driverUtil.getElement(By.name(phoneNUmer)).sendKeys(phone);
		
	}

	public void putEmailAddress(String email) {
		driverUtil.getElement(By.name(emailAddress)).sendKeys(email);
		
	}

	public void putFirstName(String firstname) {
		driverUtil.getElement(By.name(firstName)).sendKeys(firstname);
		
	}
	
	public void goToPayment()  {
		driverUtil.getElement(By.xpath(continueButton)).click();
		//return new SelectSeatPage(driverUtil);
	}
	

	public boolean verifyFirstNameWarningPresent() {
	    try {
	    	driverUtil.getElement(By.xpath(firstNameError));
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

	public boolean verifylastNameWarningPresent() {
	    try {
	    	driverUtil.getElement(By.xpath(lastNameError));
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	public String verifyUrlTravellersPage() {
	    
	    	String url = driverUtil.getUrl();
	   return url;
	}
	


	}
	
	
