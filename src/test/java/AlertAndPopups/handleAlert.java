package AlertAndPopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleAlert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://the-internet.herokuapp.com/javascript_alerts");
		d.manage().window().maximize();
		
		
		/*
		//Normal Alert with OK button
		d.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		
		Alert a=d.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		*/
		
		
		
		/*
		//Confirmation alert: ok and cancel button
		d.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(5000);
		
		Alert a1=d.switchTo().alert();
		System.out.println(a1.getText());
		a1.accept();
		a1.dismiss();
		*/
		
		
		
		//Prompt Alert: having input box 
		d.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		
		Alert a2=d.switchTo().alert();
		System.out.println(a2.getText());
		a2.sendKeys("Welcome");
		a2.accept();
		//a2.dismiss();
		
		
		
		
		
		Thread.sleep(2000);
		
		d.quit();
		
		

	}

}
