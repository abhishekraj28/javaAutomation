package TestNGAnnotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 1. Login
 2. Search
 3. Logout
 4. Login
 5. Advanced Search
 6. Logout
 */
public class annotationBeforAfterMethod {

	@BeforeMethod
	void login() {
		System.out.println("This is login method");
	}
	
	@Test(priority=1)
	void search() {
		System.out.println("This is search method");
	}
	
	@Test(priority=2)
	void advSearch() {
		System.out.println("This is advanced search method");
	}
	
	@AfterMethod
	void logout() {
		System.out.println("This is logout method");
	}
	
}
