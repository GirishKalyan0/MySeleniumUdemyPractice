package mypractice.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	
	public static ExtentReports getReporterObject() {
	String path =System.getProperty("user.dir")+"//reports/index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Girish Web Automation Reports");
	reporter.config().setDocumentTitle("Test Results");
	
	ExtentReports extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Girish");
	return extent;
	}
}
