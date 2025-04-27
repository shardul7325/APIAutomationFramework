package com.api.base;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	
//	protected Response postRequest(LoginRequest loginRequest, String endPoint) {
	protected Response postRequest(Object loginRequest, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(loginRequest).post(endPoint);
	}
	
	protected Response getRequest(String endPoint) {
		return requestSpecification.get(endPoint);
	}
	
	protected Response putRequest(Object loginRequest, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(loginRequest).put(endPoint);
	}
}
