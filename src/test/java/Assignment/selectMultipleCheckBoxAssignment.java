package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectMultipleCheckBoxAssignment {

	public static void main(String[] Args) throws InterruptedException {
		
		
		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		WebElement w=d.findElement(By.xpath("//select[@id='colors']"));
		Select s=new Select(w);
		
		//select specific element
		//s.selectByValue("red");
		
		//Thread.sleep(3000);
		List<WebElement> l=s.getOptions();
		
		System.out.println(l.size());
		for(WebElement el:l) {
			System.out.println(el.getText());
			
			if(el.getText().equals("red")) {// || el.getText().equals("blue") || el.getText().equals("yellow")) {
				el.click();
			}
		}
	
	
	
	
	
	//d.quit();
	
	}
	
	
}
