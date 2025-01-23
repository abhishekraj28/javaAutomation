package WebDriverMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getMethods {

	public static void main(String[] args) {
		
		
		WebDriver d=new ChromeDriver();
		
		//get(URL): opens the url on the web browser
		d.get("https://www.instagram.com/");
		
		//gettitle(): Return title of the webpage
		System.out.println(d.getTitle());
		
		//getCurrentUrl(): Return URL of the webpage
		System.out.println(d.getCurrentUrl());
		
		//getPageSource(): Return source code of the page
		//System.out.println(d.getPageSource());
		
		//getWindowHandle(): Return ID of the single browser window
		//System.out.println(d.getWindowHandle());
		
		//getWindowHandles(): Return ID of the multiple browser window
		d.findElement(By.linkText("Blog")).click();
		Set<String> s=d.getWindowHandles();
		System.out.println(s);
		
		
		
		d.quit();
	}

}
