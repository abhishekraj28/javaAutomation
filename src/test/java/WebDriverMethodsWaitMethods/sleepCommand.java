package WebDriverMethodsWaitMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sleepCommand {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
		
		Thread.sleep(10000);
		
		d.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		
		Thread.sleep(5000);
		d.close();
		
	}

}
