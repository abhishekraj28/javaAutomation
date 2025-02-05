package TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertionsDemo {

	@Test
	void testTitle() {
		
		String actual="Opencart";
		String expected="opencart";
		
		/*
		if(actual.equals(expected)) {
			System.out.println("Test Passes");
		}
		else {
			System.out.println("Test Fail");
			
		}
		*/
		
		//Assert.assertEquals(actual, expected);
	
		if(actual.equals(expected)) {
			System.out.println("Test Passes");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Test Fail");
			Assert.assertTrue(false);
			
		}
	
	
	}
}
