package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class orangeHRMTest {

	WebDriver d;
	@Test(priority=0)
	void openApp() {
		
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test(priority=1)
	void logoDis() throws InterruptedException {
		
		Thread.sleep(3000);
		Boolean status=d.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Status is: "+status);
	}
	
	@Test(priority=2)
	void login() {
		
		d.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		d.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		d.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority=3)
	void closeApp() {
	
		d.quit();
	}
}
