package com.api.tests;

import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Test to check the forgot password API")
	public void forgotPasswordTest() {

		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("dnatsu535@gmail.com");
		System.out.println(response.asPrettyString());
		
	}
}
