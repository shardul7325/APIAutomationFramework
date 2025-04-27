package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description="Verify if login api is working")
	public void loginTest() {
		RestAssured.baseURI = "http://64.227.160.186:8080";
		RequestSpecification req = RestAssured.given();
		RequestSpecification req1 = req.header("Content-Type", "application/json");
		RequestSpecification req2 = req1.body("{\"username\": \"Shardul1\", \"password\": \"BE2j@aw9@HriBw\"}");
		Response response = req2.post("/api/auth/login");
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 2112);
	}
}
