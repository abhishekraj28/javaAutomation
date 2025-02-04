package TestNG;

import org.testng.annotations.Test;

public class firstTestCase {

	@Test
	void openApp(){
		System.out.println("Opening App");
	}
	
	@Test
	void login() {
		System.out.println("login into application");
	}
	
	@Test
	void logout() {
		System.out.println("logging off from application");
	}
}
