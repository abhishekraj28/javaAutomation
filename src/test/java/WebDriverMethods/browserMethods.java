package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserMethods {

	public static void main(String[] args) throws InterruptedException {
		
		
        WebDriver d=new ChromeDriver();
		
	
		d.get("https://www.instagram.com/");
		d.manage().window().maximize();
		Thread.sleep(5000);
		d.findElement(By.linkText("Blog")).click();
		Thread.sleep(5000);
		
		//close single browser window where the driver is focused
		d.close();
		
		//close all the browser windows
		d.quit();

	}

}
