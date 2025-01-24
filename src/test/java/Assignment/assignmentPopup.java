package Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignmentPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://mypage.rediff.com/login");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		Alert a=d.switchTo().alert();
		a.accept();
		
	}

}
