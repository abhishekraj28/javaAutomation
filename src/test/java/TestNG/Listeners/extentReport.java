package TestNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport implements ITestListener{
	
	//UI of the report
	public ExtentSparkReporter sparkReporter;
	//populate common info on the report
	public ExtentReports extent;
	//create test case entries in the report and update sataus of the test methods
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		
		//Specify the location
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/Myreport.html");
		
		//Title of the report
		sparkReporter.config().setDocumentTitle("Automation Report");
		//Name of the report
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer name", "local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester name", "Abhishek");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		

		//Create new entry in project
		test=extent.createTest(result.getName());
		
		//Update status as pass/fail/skip
		test.log(Status.PASS, "Test case passed is : "+result.getName());
	  }

	 
	public void onTestFailure(ITestResult result) {

		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is"+result.getName());
		test.log(Status.FAIL, "Test case failed cause is: "+result.getThrowable());

	  }

	 
	public void onTestSkipped(ITestResult result) {

		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is : "+result.getName());
	  }
	  
	  
	public void onFinish(ITestContext context) {

         extent.flush();
	  }

}
