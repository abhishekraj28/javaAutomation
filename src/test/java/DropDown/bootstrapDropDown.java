package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bootstrapDropDown {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		d.manage().window().maximize();
		
		
		d.findElement(By.xpath("//button[contains(@class,\"multiselect\")]")).click();
		
		//select single checkbox from bootstrap drop down 
		d.findElement(By.xpath("//input[@value=\"Java\"]")).click();
		
		
		//Capture all options and print it
		List<WebElement> l=d.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));

		//Display size
		System.out.println(l.size());
		
		
		//Print all element
		for(WebElement e:l) {
			
			System.out.println(e.getText());
	
			
			//Select all element
			e.click();
			
			
			//Select specific element
			String op=e.getText();
			if(op.equals("Python") || op.equals("MySQL")) {
				e.click();
			}
			
			
		}
		
		
		
		
		
		
		Thread.sleep(3000);

		d.quit();
	}

}
