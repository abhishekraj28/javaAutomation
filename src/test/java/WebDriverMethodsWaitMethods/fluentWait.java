package WebDriverMethodsWaitMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class fluentWait {

	public static void main(String[] args) {
		
		
		WebDriver d=new ChromeDriver();

		//Fluent wait declaration
		Wait<WebDriver> d1=new FluentWait<WebDriver>(d)
			 .withTimeout(Duration.ofSeconds(10))
			 .pollingEvery(Duration.ofSeconds(3))
			 .ignoring(NoSuchElementException.class);
		
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
		
		
		//Fluent wait usage
		WebElement u=d1.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath("//input[@placeholder=\\\"Username\\\"]"));
			}
		});
		u.sendKeys("Admin");

		

	}

}
