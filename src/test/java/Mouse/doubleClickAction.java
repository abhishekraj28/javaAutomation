package Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleClickAction {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		d.manage().window().maximize();
		
		
		//switch to frame
		
		d.switchTo().frame("iframeResult");
		
		
		WebElement box1=d.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=d.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=d.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		//clear the box1
		box1.clear();
		box1.sendKeys("Welcome");
		
		//double click action
		Actions act=new Actions(d);
		act.doubleClick(button).perform();
		
		//validatin box2 contains same text as box1
		String text1=box2.getAttribute("value");
		//System.out.println(text1);
		if(text1.equals("Welcome")){
			System.out.println("Text copied");
		}
		else {
			System.out.println("Text not copied");
		}
		

	}

}
