package TestNG.Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependencyMethods {

	
	@Test(priority=0)
	void openApp() {
		
		Assert.assertTrue(true);
	}
	
	@Test(priority=1, dependsOnMethods= {"openApp"})
	void login() {
		
		Assert.assertTrue(false);
	}
	
	@Test(priority=2, dependsOnMethods= {"login"})
	void search() {
		
		Assert.assertTrue(true);
	}
	
	@Test(priority=3, dependsOnMethods= {"login","search"})
	void advSearch() {
		
		Assert.assertTrue(true);
	}
	
	@Test(priority=4, dependsOnMethods= {"login"})
	void logout() {
		
		Assert.assertTrue(true);
	}
	
}
