package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class selfHerokuApp {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		
		d.get(" https://juice-shop.herokuapp.com/#/login");
		d.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//d.findElement(By.xpath("//span[@class='mat-button-wrapper']/span[contains(text(), 'Dismiss')])")).click();

		d.findElement(By.xpath("//input[@id='email']")).sendKeys("aaasaaa220921@gmail.com");
		d.findElement(By.xpath("//input[@id='password']")).sendKeys("Ak28102@");
		

		
		d.findElement(By.xpath("//span[@class='mat-checkbox-inner-container']\\")).click();
		d.findElement(By.xpath("//button[@id='loginButton']")).click();

	}

}
