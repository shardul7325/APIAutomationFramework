package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest3 {

	@Test(description="Verify if login api is working")
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("Shardul1", "BE2j@aw9@HriBw");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		
		System.out.println(response.asPrettyString());
//		Assert.assertEquals(response.getStatusCode(), 2112);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse);
	}
}
