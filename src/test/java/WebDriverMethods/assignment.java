package WebDriverMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment {

	public static void main(String[] args) {
		
		
		WebDriver d=new ChromeDriver();
		
		//GetMethods
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		String title=d.getTitle();
		System.out.println(title);
		String curtit=d.getCurrentUrl();
		System.out.println(curtit);
		//System.out.println(d.getPageSource());
		System.out.println(d.getWindowHandle());
		d.findElement(By.linkText("merrymoonmary")).click();
		Set<String> hs=d.getWindowHandles();
		System.out.println(hs);
		
		
		
		//Conditional Methods
		boolean b=d.findElement(By.xpath("//img[@class='wikipedia-icon']")).isDisplayed();
		System.out.println(b);
		
		b=d.findElement(By.xpath("//textarea[@id='textarea']")).isEnabled();
		System.out.println(b);
		
		WebElement sel=d.findElement(By.xpath("//input[@id='male']"));
		System.out.println("Before Selection");
		System.out.println("Selected Status: "+sel.isSelected());
		
		System.out.println("After Selection");
		sel.click();
		System.out.println("Selected Status: "+sel.isSelected());
		
		
		
		//Browser methods
		d.close();
		d.quit();

	}

}
