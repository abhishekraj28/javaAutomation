package TestNG.Listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;


//Trigger listener class apart from XML file
//@Listeners(TestNG.Listeners.listeners.class)
public class orangeHRM {

WebDriver d;
	
	@BeforeClass
	void setup() throws InterruptedException{
		
		d=new ChromeDriver();
			
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}
	
	
	@Test(priority=1)
	void testLogo() {
		
		boolean status=d.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status,true);
	}
	

	@Test(priority=2)
	void testUrl() {
		Assert.assertEquals(d.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/");
	}
	
	@Test(priority=3, dependsOnMethods={"testUrl"})
	void testTitle() {
		Assert.assertEquals(d.getTitle(),"OrangeHRM");
	}
	
	
	@AfterClass
	void teardown() {
		d.quit();
	}
}
