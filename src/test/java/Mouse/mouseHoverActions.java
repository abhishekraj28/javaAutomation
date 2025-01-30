package Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHoverActions {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		
		d.get("https://demo.opencart.com/");
		d.manage().window().maximize();
		
		WebElement desk=d.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac=d.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		
		Actions action=new Actions(d);
		
		//Mouse hover
		action.moveToElement(desk).moveToElement(mac).click().build().perform();

	}

}
