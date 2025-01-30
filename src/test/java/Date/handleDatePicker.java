package Date;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleDatePicker {

	
	//Select Date, month and year
	static void futureDate(WebDriver d,String year, String month,String date) {
		
		while(true) {
			String curmon=d.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curryear=d.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(curmon.equals(month) && curryear.equals(year)) {
				break;
			}
			
			d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			//d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

		}

	
		//select date
		List<WebElement> listdate=d.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
		for(WebElement dat:listdate) {
			if(dat.getText().equals(date)) {
				dat.click();
				break;
			}
		}
	}
	
	
static void pastDate(WebDriver d,String year, String month,String date) {
		
		while(true) {
			String curmon=d.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curryear=d.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(curmon.equals(month) && curryear.equals(year)) {
				break;
			}
			
			d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

		}

	
		//select date
		List<WebElement> listdate=d.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));
		for(WebElement dat:listdate) {
			if(dat.getText().equals(date)) {
				dat.click();
				break;
			}
		}
	}
	
	
	
	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		
		d.get("https://jqueryui.com/datepicker/");
		d.manage().window().maximize();
		
		
		//switch to frame
		d.switchTo().frame(0);
		
		//Using Send Keys
		//d.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("09/11/2024");
		
		//method 2 using date picker
		String year="2028";
		String month="October";
		String date="28";
		
		d.findElement(By.xpath("//input[@id='datepicker']")).click();
	    futureDate(d, year, month, date);
		
		
			
			
			
		

		
	}

}
