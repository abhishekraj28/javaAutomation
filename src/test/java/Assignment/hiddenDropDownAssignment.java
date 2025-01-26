package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hiddenDropDownAssignment {

		public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
		
		//Login
		d.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("admin");
		d.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		d.findElement(By.xpath("//button[normalize-space()=\"Login\"]")).click();
		
		//click on PIM element
		d.findElement(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"][normalize-space()=\"PIM\"]")).click();
		
		//click on dropdown
		d.findElement(By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		Thread.sleep(3000);
		
		//select single element
		//d.findElement(By.xpath("//span[normalize-space()='Full-Time Permanent']")).click();
	
		//Count no of options
		List<WebElement> l=d.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println(l.size());
		
		for(WebElement w:l) {
			System.out.println(w.getText());
		}
		
		
		
		
		
	}

}
