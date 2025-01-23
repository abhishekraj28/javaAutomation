package WebDriverMethodsWaitMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWait {

	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		WebDriverWait d1=new WebDriverWait(d, Duration.ofSeconds(10));
		
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
		
		WebElement w=d1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Username\"]")));
		w.sendKeys("Admin");
		
	    /*w=d1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Password\"]")));
		w.sendKeys("admin123");
		*/
		
		d.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("admin123");
		d.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		/*
		w=d1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
		w.click();
		*/
		

	}

}
