package TestNG.Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class paramTest {

	WebDriver d;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) throws InterruptedException{
		
		switch(br) {
			case "chrome":d=new ChromeDriver();
			break;
			case "edge":d=new EdgeDriver();
			break;
			
			default:System.out.println("Invalid browser");
			return;
		}
		
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
	
	
	@Test(priority=3)
	void testTitle() {
		Assert.assertEquals(d.getTitle(),"OrangeHRM");
	}
	
	
	@Test(priority=3)
	void testUrl() {
		Assert.assertEquals(d.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	void teardown() {
		d.quit();
	}
	
	
}

