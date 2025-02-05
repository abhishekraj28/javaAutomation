package TestNGAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 1. Login
 2. search
 3. Advanced Search
 4. Logout
 */
public class annotationBeforAfterClass {

	@BeforeClass
	void login() {
		System.out.println("This is login method");
	}
	
	@Test(priority=0)
	void search() {
		System.out.println("This is search method");
	}
	
	@Test(priority=1)
	void advSearch() {
		System.out.println("This is advanced method");
	}
	
	@AfterClass
	void logout() {
		System.out.println("This is logout method");
	}
}
