package Frames;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleFrame {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://ui.vision/demo/webtest/frames/");
		d.manage().window().maximize();
		
		//Frame 1
		WebElement f1=d.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		
		//Passed frame as a webelement
		d.switchTo().frame(f1);
		
		d.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		
		d.switchTo().defaultContent();
		
		//Frame 2
		WebElement f2=d.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
		d.switchTo().frame(f2);
		
		d.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");
		
		d.switchTo().defaultContent();
		
		
		//frame 3
		//WebElement f3=d.findElement(By.xpath("//frame[@src='frame_3.html']"));
		f2=d.findElement(By.xpath("//frame[@src='frame_3.html']"));
		d.switchTo().frame(f2);
		d.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");
		
		//iframe inside frame 3
		//we can use index if there is only one inner frame if it is having multiple framne we are unable to recongize the indexes of the frame 
		d.switchTo().frame(0);
		
		d.findElement(By.xpath("(//div[@id=\"i6\"]//div[@class=\"AB7Lab Id5V1\"])")).click();
		
		
		/*
		//suppose we are unable to check or click on any checkbox/radio button we can use javascriptexecutor
		WebElement w1=d.findElement(By.xpath("//div[@id=\"i21\"]//div[@class=\"uHMk6b fsHoPb\"]"));
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].click();", w1);
		*/
		
		//Select all checkbox
		List<WebElement> w=d.findElements(By.xpath("//span[normalize-space()='How do you plan to use the software?']/../../../..//div[@class='uHMk6b fsHoPb']"));

		for(WebElement w2:w) {
			w2.click();
		}
		d.switchTo().defaultContent();

			
		//Frame 5
		WebElement f5=d.findElement(By.xpath("//frame[@src=\"frame_5.html\"]"));
		d.switchTo().frame(f5);
		
		d.findElement(By.xpath("//input[@name=\"mytext5\"]")).sendKeys("Entered in frame 5");
		d.navigate().to("https://a9t9.com");
		System.out.println(d.getCurrentUrl());
		
		boolean b=d.findElement(By.xpath("//img[@alt=\"Ui.Vision by a9t9 software - Image-Driven Automation\"]")).isDisplayed();
		System.out.println(b);
		
		
		
		
		
		d.quit();
		

	}

}
