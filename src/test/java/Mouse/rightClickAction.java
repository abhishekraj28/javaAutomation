package Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class rightClickAction {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		
		d.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		d.manage().window().maximize();
		
		WebElement button=d.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions rc=new Actions(d);
		
		//right click action
		rc.contextClick(button).perform();
		
		//click on paste
		d.findElement(By.xpath("//span[normalize-space()='Paste']")).click();
		
		Thread.sleep(5000);
		//close alert
		d.switchTo().alert().accept();
		
	}

}
