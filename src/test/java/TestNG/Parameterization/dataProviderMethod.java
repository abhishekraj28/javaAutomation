package TestNG.Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class dataProviderMethod {

	WebDriver d;
	
	@BeforeClass
	void setup() {
		d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
	}
	
	@Test(dataProvider="dp")
	void login(String email, String pwd) {
		d.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		d.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		d.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		d.findElement(By.xpath("//input[@value='Login']")).click();
		
		boolean status=d.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		
		if(status==true) {
			d.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		
		}
		else
		{
			Assert.fail();
		}
	}
	
	
	@AfterClass
	void tearDown() {
		d.quit();
	}
	
	@DataProvider(name="dp", indices= {0,1,3,})
	Object[][] loginData(){
		
		Object data[][]= {
				{"raj28102@gmail.com","1234"},
				{"rajabhishek2810@gmail.com","123456"},
				{"asdff@mail.com", "2314314"},
				{"jnafhuf@gmail","241344"}
				
				
		};
		
		return data;
	}
	
	
	
}
