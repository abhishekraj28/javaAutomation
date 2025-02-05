package TestNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {
	
	
		//It will execute only once
		public void onStart(ITestContext context) {

			System.out.println("Test execution is started...");

			}

		//it will execute at every test methods
		public void onTestStart(ITestResult result) {

			System.out.println("Test started...");

	  		}

		  
		public void onTestSuccess(ITestResult result) {
			
			System.out.println("Test passed...");


		  }

		 
		public void onTestFailure(ITestResult result) {

			System.out.println("Test failed...");

		  }

		 
		public void onTestSkipped(ITestResult result) {

			System.out.println("Test skipped...");
		  }
		  
		  
		public void onFinish(ITestContext context) {

			System.out.println("Test execution is completed...");

		  }
	

}
