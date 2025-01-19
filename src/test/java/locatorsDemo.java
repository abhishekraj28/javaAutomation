import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatorsDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/");
		
		driver.manage().window().maximize();
		
		//by name locator
		//driver.findElement(By.name("search")).sendKeys("Apple");
		
		
		//by id locator
		//boolean isDisplay=driver.findElement(By.id("logo")).isDisplayed();
		//System.out.println(isDisplay);
		
		//by linkText and partialLinkedText
		//driver.findElement(By.linkText("Tablets")).click();
		//driver.findElement(By.partialLinkText("Tablet")).click();
		
		
		//by className locator
		List<WebElement> headerLinks=driver.findElements(By.className("list-inline-item"));
		System.out.println(headerLinks.size());
		
		
		//by tagName locator
		List<WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		
		List<WebElement> links=driver.findElements(By.tagName("img"));
		System.out.println(links.size());
		
		driver.quit();
		
		
	}

}
