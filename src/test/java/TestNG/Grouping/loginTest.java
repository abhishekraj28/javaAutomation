package TestNG.Grouping;

import org.testng.annotations.Test;

public class loginTest {

	@Test(priority=0, groups= {"sanity"})
	void loginByEmail() {
		System.out.println("Login by email");
	}
	
	
	@Test(priority=1, groups= {"sanity"})
	void loginByPhone() {
		System.out.println("Login by phone");
	}
	
	
	@Test(priority=2, groups= {"sanity"})
	void loginByGoogle() {
		System.out.println("Login by google");
	}
}
