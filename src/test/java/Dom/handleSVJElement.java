package Dom;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleSVJElement {

	public static void main(String[] args) throws InterruptedException {


		ChromeOptions o=new ChromeOptions();
		o.addExtensions(new File("C:\\Users\\rajab\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx"));
		WebDriver d=new ChromeDriver(o);
	
		d.manage().window().maximize();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		d.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		d.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//absolute/full x-path
		//d.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a/svg")).click();

		
		//relative x-path
		//d.findElement(By.xpath("//*[name()='path' and contains(@d,'M422,332H9')]")).click();
		
		//using SVJ Element
		d.findElement(By.xpath("//a[@class='oxd-main-menu-item active']//*[name()='svg']")).click();
	}

}
