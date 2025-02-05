package TestNG.Grouping;

import org.testng.annotations.Test;

public class signupTest {

	
	@Test(priority=0, groups= {"regression"})
	void signupByEmail() {
		System.out.println("signup by email");
	}
	
	
	@Test(priority=1, groups= {"regression"})
	void signupByPhone() {
		System.out.println("signup by phone");
	}
	
	
	@Test(priority=2, groups= {"regression"})
	void signupByGoogle() {
		System.out.println("signup by google");
	}
}

