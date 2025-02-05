package TestNG.Assertions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class hardVsSoftAsssetions {

	
	void hard() {
		
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("Testing..");
		System.out.println("Testing..");
	}
	
	void soft() {
		
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(1, 2);
		
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		//It is a mandatory step
		sa.assertAll();
	}
}
