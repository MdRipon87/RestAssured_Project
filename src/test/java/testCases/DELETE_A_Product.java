package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DELETE_A_Product { 
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void delete_a_product() {
//  https://techfios.com/api-prod/api/product/delete.php
		
		HashMap payLoad = new HashMap();
		payLoad.put("id", "1480");

		Response response =
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payLoad)
		.when()
			.delete("/delete.php")
		.then()
			.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("responseBody :" + responseBody);	
		
// 	Parsing responseBody to Json
		
		JsonPath js = new JsonPath(responseBody);
		String message = js.getString("message");
		Assert.assertEquals(message, "Product was deleted.");
		
		
	}

}

