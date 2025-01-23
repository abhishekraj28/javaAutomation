package WebDriverMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		d.get("https://www.instagram.com/");
		
		d.findElement(By.xpath("//span[normalize-space()='Blog']")).click();
		
		d.manage().window().maximize();
		
		Set<String> s=d.getWindowHandles();
		
		//Approach 1
		List<String> l=new ArrayList<String>(s);
		String id1=l.get(0);
		String id2=l.get(1);
		
		
		System.out.println("Before Switching the title is:"+d.getTitle());
		//Switch to the nextWindow
		d.switchTo().window(id2);
		System.out.println(d.getTitle());
		
		//Switch to first window
		d.switchTo().window(id1);
		System.out.println(d.getTitle());
		
		
	
		

	}

}
