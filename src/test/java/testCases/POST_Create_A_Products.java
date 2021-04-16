package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class POST_Create_A_Products {

	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void create_a_products() {
//  https://techfios.com/api-prod/api/product/create.php
		HashMap payLoad = new HashMap();
		
		payLoad.put("name", "Smart Phone");
		payLoad.put("price", "1300");
		payLoad.put("description", "Smart Phone");
		payLoad.put("category_id", "2");
		payLoad.put("category_name", "Electronics");
		
		Response response =
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payLoad)
		.when()
			.post("/create.php")
		.then()
			.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("responseBody :" + responseBody);	
		
// 	Parsing responseBody to Json
		
		JsonPath js = new JsonPath(responseBody);
		String message =js.getString("message");
		Assert.assertEquals(message, "Product was created.");
		
	}

}
