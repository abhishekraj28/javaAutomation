package TestNG.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class hardAssertions {

	
	@Test
	void test() {
		
		Assert.assertEquals(123, 123);
		Assert.assertEquals(123, "xyz");
		
		
		Assert.assertNotEquals(122, 122);
		Assert.assertNotEquals(123, "xyz");
		
		
		Assert.assertTrue(false);
		Assert.assertTrue(1==2);
		Assert.assertTrue(1==1);
		Assert.assertTrue(true);
		
		
		Assert.assertFalse(false);
		Assert.assertFalse(1==1);
		Assert.assertFalse(1==2);
		Assert.assertFalse(true);
		
		Assert.fail();
		
		
		
	}
}
