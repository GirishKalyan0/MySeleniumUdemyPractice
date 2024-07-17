package myparctice.testcomponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import mypractice.resources.ExtentReportNG;


public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReportNG.getReporterObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	
	    @Override
	    public void onTestStart(ITestResult result) {
	        // Code to execute when a test starts
	    	test=extent.createTest(result.getMethod().getMethodName());
	        System.out.println("Test started: " + result.getName());
	        extentTest.set(test);	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Code to execute when a test succeeds
	    	extentTest.get().log(Status.PASS, "Test Passes");
	        System.out.println("Test succeeded: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // Code to execute when a test fails
	    	extentTest.get().log(Status.FAIL, "Test Filed");
	    	extentTest.get().fail(result.getThrowable());
	    	
	    	try {
				driver= (WebDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
	    	String filePath = null;
			try {
				filePath = getScreenShot(result.getMethod().getMethodName(), driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	        System.out.println("Test failed: " + result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Code to execute when a test is skipped
	        System.out.println("Test skipped: " + result.getName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Code to execute when a test fails but within success percentage
	        System.out.println("Test failed but within success percentage: " + result.getName());
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Code to execute before any test method starts
	        System.out.println("Test onStart: " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Code to execute after all test methods have run
	        System.out.println("Test onFinish: " + context.getName());
	        extent.flush();
	    }

	    // Add any custom methods if needed
	    public void customMethod() {
	        System.out.println("Custom method executed");
	    }

}
