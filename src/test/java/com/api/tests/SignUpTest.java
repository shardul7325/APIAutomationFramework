package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class SignUpTest {

	@Test(description = "Create a new user account by signing up to the service")
	public void signUpTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.username("Rohit1234")
				.email("dnatsu535@gmail.com")
				.firstName("Rohit")
				.lastName("Sharma")
				.mobileNumber("9876543211")
				.password("Rohit1234")
				.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
	}
}
