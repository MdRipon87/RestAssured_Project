package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GET_Read_A_Product {

	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void read_a_product(String idValue) {
		
		
		
		// https://techfios.com/api-prod/api/product/read_one.php?id=
		Response response =
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json;")
			.queryParam("id", idValue)
		.when()
			.get("/read_one.php")
		.then()
			.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	
		
	/*	
// 	Parsing responseBody to Json
		JsonPath js = new JsonPath(responseBody);
		
		String productId = js.getString("id");
		String productName= js.getString("name");
		String productDescription= js.getString("description");
		String productPrice = js.getString("price");
		String productCategory_id = js.getString("category_id");
		String productCategory_name = js.getString("category_name");
		
		Assert.assertEquals(productId, idValue);
		Assert.assertEquals(productName, "Samsung Phone 20.0");
		Assert.assertEquals(productDescription, "The best phone for programmers.");
		Assert.assertEquals(productPrice, "1200");
		Assert.assertEquals(productCategory_id, "2");
		Assert.assertEquals(productCategory_name, "Electronics");
		
		System.out.println(productId);*/
		
	
	/*	int statusCode = response.getStatusCode();
		System.out.println("Ststus Code :" + statusCode);
		
	//	Assert.assertEquals(statusCode, 201);
		softAssert.assertEquals(statusCode, 201);	
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response Time :" +responseTime);
		
		if (responseTime<= 2000){
			System.out.println(" Response time is within rang");
		}else {
			System.out.println("Not acceptable");
			
		}*/
		
		
	}



}
