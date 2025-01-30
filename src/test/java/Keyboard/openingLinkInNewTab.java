package Keyboard;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class openingLinkInNewTab {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		d.get("https://demo.nopcommerce.com/");
		d.manage().window().maximize();
		
		WebElement myAcc=d.findElement(By.xpath("//a[normalize-space()='Register']"));
		//WebElement reg=d.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act=new Actions(d);
		
		act.keyDown(Keys.CONTROL).click(myAcc).keyUp(Keys.CONTROL).perform();
		
		System.out.println(d.getCurrentUrl());
		
		//switch to registraton page
		List<String> ids=new ArrayList(d.getWindowHandles());
		
		d.switchTo().window(ids.get(1));
		
	}

}
