package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class selectDropDownAssignment {

	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		d.manage().window().maximize();
		
		WebElement l=d.findElement(By.xpath("//select[@id='country-list']"));
		Select c=new Select(l);
		
		//Select specific value
		//c.selectByValue("4");
		
		//getsize
		List<WebElement> w=c.getOptions();
		System.out.println(w.size());
		for(WebElement e:w) {
			System.out.println(e.getText());
			
			//Select using loop
			if(e.getText().equals("India")) {
				e.click();
			}
		}
		

	}

}
