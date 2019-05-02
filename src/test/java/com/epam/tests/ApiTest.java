package com.epam.tests;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.utils.DriverUtil;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {

	
	
	/**
	 * Test Description: validate json keys for first id using list and hash map
	 */
	@Test
	
	public void apiTestgetPlanets() throws Exception {
	
	RequestSpecification httpRequest = RestAssured.given();
    
    Response response = httpRequest.get("https://swapi.co/api/planets/");
    
    int status = response.statusCode();
    Assert.assertEquals(200, status);
    Assert.assertNotNull(response.body().toString());   
  
    List<HashMap<String,Object>>planetList=response.jsonPath().getList("results");
    HashMap<String,Object> planetListDetails=planetList.get(0);
    
    Assert.assertTrue(planetListDetails.containsKey("name"));
    Assert.assertTrue(planetListDetails.containsKey("rotation_period"));
    Assert.assertTrue(planetListDetails.containsKey("orbital_period"));
    Assert.assertTrue(planetListDetails.containsKey("diameter"));
    Assert.assertTrue(planetListDetails.containsKey("climate"));
    Assert.assertTrue(planetListDetails.containsKey("gravity"));
    Assert.assertTrue(planetListDetails.containsKey("terrain"));
    Assert.assertTrue(planetListDetails.containsKey("surface_water"));
    Assert.assertTrue(planetListDetails.containsKey("population"));
    Assert.assertTrue(planetListDetails.containsKey("residents"));
    Assert.assertTrue(planetListDetails.containsKey("films"));
    Assert.assertTrue(planetListDetails.containsKey("created"));
    Assert.assertTrue(planetListDetails.containsKey("edited"));
    Assert.assertTrue(planetListDetails.containsKey("url"));
	}
	
	
	/**
	 * Test Description: validate json schema response for planets response
	 */
	
	@Test
	
	public void apiTestValidatePLanetSchema() throws Exception {

    RestAssured.given().

    get("https://swapi.co/api/planets/").
   then().
    statusCode(200).and().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response.json"));
   
	}

	
	@DataProvider(name="planetID")
	public Object[][] createTestDataRecords() {
	   return new Object[][]{
	       {"1", "Tatooine"},
	       {"2","Alderaan"},
	      {"3","Yavin IV"}
	   };
	}
	
	/**
	 * Test Description: validate name attribute and value for 3 path parameter IDs using data provider
	 */
	
	@Test(dataProvider="planetID")
	public void testgetByID(String planetId, String name) {
	 
		RestAssured.given().
	       pathParam("planetId",planetId).
	   when().
	       get("http://swapi.co/api/planets/{planetId}").
	  then().
	   statusCode(200).and().assertThat().body("name", equalTo(name)).and().statusCode(200);
	    
      ;
	
	}
}