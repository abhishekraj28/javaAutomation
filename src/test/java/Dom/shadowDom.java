package Dom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadowDom {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		
		d.get("https://books-pwakit.appspot.com/");
		
		//This Element is inside single shadow DOM.
		SearchContext shadow = d.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");

	}

}
