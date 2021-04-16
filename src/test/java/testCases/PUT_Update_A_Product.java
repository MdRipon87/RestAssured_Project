package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUT_Update_A_Product { 
	
	GET_Read_A_Product readAprod = new GET_Read_A_Product();
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void update_a_products() {
//  https://techfios.com/api-prod/api/product/update.php
		
		HashMap payLoad = new HashMap();
		payLoad.put("id", "1480");
		payLoad.put("name", "LG Phone");
		payLoad.put("price", "1000");
		payLoad.put("description", "Smart Phone");
		payLoad.put("category_id", "2");
		payLoad.put("category_name", "Electronics");
		
		Response response =
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payLoad)
		.when()
			.put("/update.php")
		.then()
			.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("responseBody :" + responseBody);	
		
// 	Parsing responseBody to Json
		
		JsonPath js = new JsonPath(responseBody);
		String message = js.getString("message");
		Assert.assertEquals(message, "Product was updated.");
		
		readAprod.read_a_product("1480");
		
	}

}

