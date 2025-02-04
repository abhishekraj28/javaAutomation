package Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dummyTicketFlightOneWay {

	
	static void selectDepartureDate(WebDriver d, String date, String month, String year) {
		
		WebElement dep=d.findElement(By.xpath("//div[@id='onewaymain']//div//input[@placeholder='Departure Date']"));
		dep.click();
		
		//select month
		WebElement mont=d.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selmon=new Select(mont);
		selmon.selectByVisibleText(month);
		
		//select year
		
		WebElement yea=d.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selyea=new Select(yea);
		selyea.selectByVisibleText(year);
		
		//select date
		List<WebElement> dat=d.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
		
		for(WebElement seldate:dat) {
			if(seldate.getText().equals(date)) {
				seldate.click();
				break;
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {

	WebDriver d=new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(d, Duration.ofSeconds(10));
	
	d.get("https://dummy-tickets.com/buyticket");
	d.manage().window().maximize();
	

	
	//select from city
	WebElement from=d.findElement(By.xpath("//form[@id='flight_oneway']//div//input[@name='source[]']"));
	from.click();
	from.sendKeys("Mumbai");
	
	//get city
	Thread.sleep(5000);
	List<WebElement> cityfrom=d.findElements(By.xpath("//ul[@class='suggestions-list']//li//div[@class='city']"));
	//System.out.println(cityfrom.size());
	for(WebElement selcit:cityfrom) {
		//System.out.println(selcit.getText());
		if(selcit.getText().equals("Mumbai")) {
			selcit.click();
			break;
		}
	}
	
	//select to city
	WebElement to=d.findElement(By.xpath("//form[@id='flight_oneway']//div//input[@name='destination[]']"));
	to.click();
	to.sendKeys("New delhi");
	
	//get city
	Thread.sleep(5000);
	List<WebElement> cityto=d.findElements(By.xpath("//ul[@class='suggestions-list']//li//div[@class='city']"));
	
	//System.out.println(cityto.size());
	for(WebElement selcit:cityto) {
		//System.out.println(selcit.getText());
		if(selcit.getText().equals("New Delhi")) {
			selcit.click();
			break;
		}
	}
	
	//select departure date
	String date="28";
	String month="Oct";
	String year="2024";
	
	selectDepartureDate(d, date, month, year);
	
	//click on submit
	d.findElement(By.xpath("//input[@id='flight_oneway_btn']")).click();
	
	
	// Click submit button
	d.findElement(By.xpath("//input[@id='flight_oneway_btn']")).click();

	// Wait for URL to change
	String oldUrl = d.getCurrentUrl();
	wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));

	// Wait for element to be visible
	d.findElement(By.xpath("//span[@role='presentation']")).click();
	d.findElement(By.xpath("//input[contains(@aria-label,'Search')]")).sendKeys("india");
	List<WebElement> country=d.findElements(By.xpath("//ul[@role='listbox']//li"));
	
	for(WebElement selcon:country) {
		if(selcon.getText().equals("India")) {
			selcon.click();
			break;
		}
	}

	
	
}


}
