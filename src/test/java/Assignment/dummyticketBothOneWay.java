package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dummyticketBothOneWay {

	
static void selectDepartureDate(WebDriver d, String date, String month, String year) {
		
		WebElement dep=d.findElement(By.xpath("//div[@id='onewayfh']//div//input[@placeholder='Departure Date']"));
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


static void checkinDate(WebDriver d, String chedate, String chemonth, String cheyear) {
	
	d.findElement(By.xpath("//form[@id='both_oneway']//div//input[@name='checkin[]']")).click();
	
	//year selected
	while (true) {
	    String currentYear = d.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	    
	    if (currentYear.equals(cheyear)) {
	        break;  // Stop looping when the desired year is found
	    }

	    // Click the next button to move to the next year
	    d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	}
	
	//month selected
	WebElement mont=d.findElement(By.xpath("//select[@aria-label='Select month']"));
	Select selmon=new Select(mont);
	selmon.selectByVisibleText(chemonth);
	
	//select date
	List<WebElement> dat=d.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
			
	for(WebElement seldate:dat) {
		if(seldate.getText().equals(chedate)) {
			seldate.click();
			break;
			}
				
	}
	
}

static void checkoutDate(WebDriver d, String chedate, String chemonth, String cheyear) {
	
	d.findElement(By.xpath("//form[@id='both_oneway']//div//input[@name='checkout[]']")).click();
	
	//year selected
	while (true) {
	    String currentYear = d.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	    
	    if (currentYear.equals(cheyear)) {
	        break;  // Stop looping when the desired year is found
	    }

	    // Click the next button to move to the next year
	    d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	}
	
	//month selected
	WebElement mont=d.findElement(By.xpath("//select[@aria-label='Select month']"));
	Select selmon=new Select(mont);
	selmon.selectByVisibleText(chemonth);
	
	//select date
	List<WebElement> dat=d.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
			
	for(WebElement seldate:dat) {
		if(seldate.getText().equals(chedate)) {
			seldate.click();
			break;
			}
				
	}
	
}
	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(d, Duration.ofSeconds(10));
		
		d.manage().window().maximize();

		d.get("https://dummy-tickets.com/buyticket");
		
		d.findElement(By.xpath("//a[normalize-space()='Both']")).click();
		
		WebElement from=d.findElement(By.xpath("//form[@id='both_oneway']//div//input[@name='source[]']"));
		from.click();
		from.sendKeys("Mumbai");
		
		//get city
		Thread.sleep(5000);
		List<WebElement> cityfrom=d.findElements(By.xpath("//ul[@class='suggestions-list']//li//div[@class='city']"));
		
		for(WebElement selcit:cityfrom) {
			
			if(selcit.getText().equals("Mumbai")) {
				selcit.click();
				break;
			}
		}

		
		//select to city
		WebElement to=d.findElement(By.xpath("//form[@id='both_oneway']//div//input[@name='destination[]']"));
		to.click();
		to.sendKeys("Newdelhi");
		
		//get city
		Thread.sleep(5000);
		List<WebElement> cityto=d.findElements(By.xpath("//ul[@class='suggestions-list']//li//div[@class='city']"));
		
		for(WebElement selcit:cityto) {
			if(selcit.getText().equals("New Delhi")) {
				selcit.click();
				break;
			}
		}
		
		//Select Departure date
		String date="28";
		String month="Oct";
		String year="2024";
		selectDepartureDate(d, date, month, year);
		
		
		//select hotel city
		WebElement city=d.findElement(By.xpath("//form[@id='both_oneway']//div//input[@name='city[]']"));
		city.click();
		city.sendKeys("New Delhi");
		
		List<WebElement> cityn=d.findElements(By.xpath("//ul[@class='suggestions-cities-list']//li//p"));
		
		for(WebElement selcity:cityn) {
			if(selcity.getText().equals("New Delhi")) {
				selcity.click();
				break;
			}
		}
		
		//Select checkin date
		String chedate="28";
		String chemonth="Oct";
		String cheyear="2026";
		checkinDate(d, chedate, chemonth, cheyear);
		
		//select checkout date
		String indate="28";
		String inmonth="Oct";
		String inyear="2027";
		checkoutDate(d, indate, inmonth, inyear);
		
		//submit
		d.findElement(By.xpath("//form[@id='both_oneway']//input[@value='Submit']")).click();
		
		 String oldUrl = d.getCurrentUrl(); // Store old page URL
	        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl))); // Wait until URL changes

	        // Step 9: Verify that the new page is loaded
	        System.out.println("New page URL: " + d.getCurrentUrl());
	        
	        //Select country
	       // WebElement dcoun=
	        d.findElement(By.xpath("//span[@id='select2-dialcodes-container']")).click();
	        //dcoun.click();
	        
	        Thread.sleep(3000);
	       // WebElement coun=
	        //d.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("india");
	       // coun.sendKeys("india");
	        
	        
	        //Thread.sleep(3000);
	        List<WebElement> listcoun=d.findElements(By.xpath("//span[@class='select2-results']//ul//li"));
	        
	        for(WebElement selcoun:listcoun) {
	        	
	        	System.out.println(selcoun.getText());
	        	if(selcoun.getText().equals("India")) {
	        		selcoun.click();
	        	}
	        }
		
		
		
		
		
		
		
	}

}
;