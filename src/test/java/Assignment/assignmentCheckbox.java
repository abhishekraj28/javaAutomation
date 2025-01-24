package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignmentCheckbox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		List<WebElement> w=d.findElements(By.xpath("//th[normalize-space()='Select']/../../..//input[@type='checkbox']"));
		
		/*
		for(int i=0;i<w.size();i++) {
			System.out.println(w.get(i).getText());
			w.get(i).click();
		}
		*/
		
		for(WebElement e:w) {
			e.click();
		}
		
		
		Thread.sleep(5000);
		for(WebElement e:w) {
			if(e.isSelected()) {
				e.click();
			}
		}
		
		Thread.sleep(5000);
		d.quit();
		

	}

}
