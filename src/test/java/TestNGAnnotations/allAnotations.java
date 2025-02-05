package TestNGAnnotations;

import org.testng.annotations.*;

public class allAnotations {

	@BeforeSuite
	void beforeSuite() {
		System.out.println("This is before suite ");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("This is a before class");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("This is before method");
	}
	
	@Test
	void test1() {
		System.out.println("This is test1");
	}
	
	@Test
	void test2() {
		System.out.println("This is test2");
	}
	
	
	@AfterMethod
	void afterMethod() {
		System.out.println("This is after method");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("This is a after class");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("This is after suite ");
	}
	
}
