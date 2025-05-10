package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	private static final Logger Logger = LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec); //This is where the request will be executed.
		logResponse(response);
		
		return response;
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		Logger.info("BASE URI: " + requestSpec.getBaseUri());
		Logger.info("Request Header: " + requestSpec.getHeaders());
		Logger.info("Request Payload: " + requestSpec.getBody());
	}
	
	public void logResponse(Response response) {
		Logger.info("STATUS CODE: " + response.getStatusCode());
		Logger.info("Response Header: " + response.getHeaders());
		Logger.info("Response Body: " + response.getBody().prettyPrint());
	}

}
