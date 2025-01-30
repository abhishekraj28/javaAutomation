package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptExecutor {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		//ChromeDriver d=new ChromeDriver();
		
		//javaScript Executor
		JavascriptExecutor js=(JavascriptExecutor)d;
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		WebElement name=d.findElement(By.xpath("//input[@id='name']"));
		WebElement radio=d.findElement(By.xpath("//input[@id='male']"));
		
		//perform send keys option using javaexecutor
		js.executeScript("arguments[0].setAttribute('Value', 'John')", name);
		
		//perform click action
		js.executeScript("arguments[0].click()",radio);
		

	}

}
