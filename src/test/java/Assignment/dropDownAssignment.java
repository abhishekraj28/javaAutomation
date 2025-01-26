package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropDownAssignment {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://www.bjs.com/");
		d.manage().window().maximize();
		
		Thread.sleep(5000);
		//Search product
		WebElement w=d.findElement(By.xpath("//input[@placeholder='What are you looking for today?']"));
		w.click();
		w.sendKeys("T-shirt");
		d.findElement(By.xpath("//i[@class='fa fa-search']")).click();

	}

	

}
