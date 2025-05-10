package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	private static final Logger Logger = LogManager.getLogger(TestListener.class);
	
	public void onStart(ITestContext context) {
		Logger.info("Test Suite Started!!");
	  }
	
	public void onTestStart(ITestResult result) {
		Logger.info("Test started: " + result.getMethod().getMethodName());
	  }
	
	public void onTestSuccess(ITestResult result) {
		Logger.info("Description: " + result.getMethod().getDescription());
		Logger.info("Test Passed!!" + result.getMethod().getMethodName());
	  }
	
	public void onTestFailure(ITestResult result) {
		Logger.info("Description: " + result.getMethod().getDescription());
		Logger.error("Test Failed!!" + result.getMethod().getMethodName());	
	}
	
	public void onTestSkipped(ITestResult result) {
		Logger.info("Test skipped!!");
	  }
	
	
	public void onFinish(ITestContext context) {
		Logger.info("Test Suite Finished!!");
	  }
}
