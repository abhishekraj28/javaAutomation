package Locators;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment1 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/index.html");

		
		//print total number of links
		List<WebElement> list=driver.findElements(By.tagName("a"));
		System.out.println(list);
		
		
		//print total number of images
		List<WebElement> list1=driver.findElements(By.tagName("img"));
		System.out.println(list1);
		
		
		//click on any product
		driver.findElement(By.linkText("Laptops")).click();
		
		
		
		
	}

}
