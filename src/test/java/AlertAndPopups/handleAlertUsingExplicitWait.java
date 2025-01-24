package AlertAndPopups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		WebDriver d=new ChromeDriver();
		
		//Explicit Wait
		WebDriverWait w=new WebDriverWait(d,Duration.ofSeconds(10));
		
		d.get("https://the-internet.herokuapp.com/javascript_alerts");
		d.manage().window().maximize();
		
		
		
		d.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		//Thread.sleep(5000);
		
		//Capture Alert
		Alert a=w.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(a.getText());
		a.accept();
		

	}

}
