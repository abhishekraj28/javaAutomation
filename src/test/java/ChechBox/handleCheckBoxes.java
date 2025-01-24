package ChechBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		//1-Select specific checkbox
		//d.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2-Select all the checkboxes
		List<WebElement> el=d.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

		/*
		//Using normal for loop
		for(int i=0;i<el.size();i++) {
			el.get(i).click();
		}
		*/
		
		
		/*
		//Using enhanced for loop
		for(WebElement el1:el) {
			el1.click();
			
		}
		*/
		
		/*
		//3- select last three checkboxes
		for(int i=4;i<el.size();i++) {
			el.get(i).click();
		}
		*/
		
		
		/*
		//4- select first three checkboxes
		for(int i=0;i<3;i++) {
			el.get(i).click();
		}
		*/
		
		
		//5- Unselect chechboxesif they are selected
		for(int i=0;i<3;i++) {
			el.get(i).click();
		}
		
		Thread.sleep(5000);
		
		for(WebElement e:el) {
			if(e.isSelected()) {
				e.click();
			}
		}
		
		d.quit();
		
	}

}
