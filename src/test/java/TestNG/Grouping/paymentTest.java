package TestNG.Grouping;

import org.testng.annotations.Test;

public class paymentTest {

	@Test(priority=0, groups= {"sanity","regression","functional"})
	void paymentByCash() {
		System.out.println("payment in cash");
	}
	
	@Test(priority=0, groups= {"sanity","regression","functional"})
	void paymentByUPI() {
		System.out.println("payment in UPI");
	}
	
}
