package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollingDemo {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.get("https://demo.nopcommerce.com/");
		
		JavascriptExecutor js= (JavascriptExecutor)d;
		
		/*
		//Scroll page by pixel number
		js.executeScript("window.scrollBy(0,1500)","");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/
	
		
		/*
		//Scroll the page till element is visible
		WebElement fea=d.findElement(By.xpath("//strong[normalize-space()='Featured products']"));
		js.executeScript("arguments[0].scrollIntoView();",fea);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/
		
		
		//Scroll page till end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll up to initial position
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));

	}

}
