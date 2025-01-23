package WebDriverMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class closeSpecificBrowserWindow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait d1=new WebDriverWait(d, Duration.ofSeconds(10));

		
		
		
		d.get("https://www.instagram.com/");
		
		
		d.findElement(By.xpath("//span[normalize-space()='Threads']")).click();
		Thread.sleep(5000);
		
		d.manage().window().maximize();
		
		Set<String> s=d.getWindowHandles();
		
		for(String s1:s) {
			String s2=d.switchTo().window(s1).getTitle();
			System.out.println(s2);
			
			
			if(s2.equals("Threads")) {
				d.close();
				
			}
			
		}
		

	}

}
