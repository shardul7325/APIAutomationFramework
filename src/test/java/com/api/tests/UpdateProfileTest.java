package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManageService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Test to update a user's profile info")
	public void updateProfileInfoTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("Rohit1234", "Rohit1234"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("-----------------------------------------------------------");
		
		UserProfileManageService userProfileManageService = new UserProfileManageService();
		response = userProfileManageService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "Rohit1234");
		
		System.out.println("-----------------------------------------------------------");
		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Virat")
				.lastName("Kohli")
				.email("dnatsu535@gmail.com")
				.mobileNumber("9876543212")
				.build();		
		
		response = userProfileManageService.updateProfile(loginResponse.getToken(), profileRequest);
		Assert.assertEquals(userProfileResponse.getFirstName(), "Virat");
		System.out.println(response.asPrettyString());
		
	}
}
