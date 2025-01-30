package Slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sliderDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();

		d.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		d.manage().window().maximize();
		
		Thread.sleep(5000);
		Actions act=new Actions(d);
		
		//Starting 
		WebElement start=d.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		System.out.println(start.getLocation());
		act.dragAndDropBy(start, 100, 233).perform();
		
		
		//Ending
		WebElement end=d.findElement(By.xpath("//span[2]"));
		System.out.println(end.getLocation());
		act.dragAndDropBy(end, -117, 233).perform();
	}

}
