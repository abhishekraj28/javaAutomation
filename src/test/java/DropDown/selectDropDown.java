package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectDropDown {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		WebElement country=d.findElement(By.xpath("//select[@id=\"country\"]"));
		Select dCountry=new Select(country);
		
		/*
		//Select option from drop down
		dCountry.selectByVisibleText("India");
		dCountry.selectByValue("india");
		Thread.sleep(3000);
		dCountry.selectByIndex(6);
		*/
		
		//Get all options from the drop down
		List<WebElement> op=dCountry.getOptions();
		System.out.println(op.size());
		for(WebElement o:op) {
			//System.out.println(o);
			System.out.println(o.getText());
		}

		
		
		
		
		
		
		
		d.quit();
	}

}
