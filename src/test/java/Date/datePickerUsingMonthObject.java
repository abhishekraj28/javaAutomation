package Date;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class datePickerUsingMonthObject {

	
	//User defined method for converting month from String to month object
     static Month convertMonth(String month) {
    	 HashMap<String,Month> monthMap=new HashMap<String, Month>();
    	 
    	 monthMap.put("January", Month.JANUARY);
    	 monthMap.put("February", Month.FEBRUARY);
    	 monthMap.put("March", Month.MARCH);
    	 monthMap.put("April", Month.APRIL);
    	 monthMap.put("May", Month.MAY);
    	 monthMap.put("June", Month.JUNE);
    	 monthMap.put("July", Month.JULY);
    	 monthMap.put("August", Month.AUGUST);
    	 monthMap.put("September", Month.SEPTEMBER);
    	 monthMap.put("October", Month.OCTOBER);
    	 monthMap.put("November", Month.NOVEMBER);
    	 monthMap.put("December", Month.DECEMBER);
    	 
    	 Month vMonth=monthMap.get(month);
    	 if(vMonth==null) {
    		 System.out.println("Invalid Month");
    	 }
    	 return vMonth;

    	 
     }
	
	
	
	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		//input DOB
		String date="";
		String month="";
		String year="";
		
		//d.switchTo().frame("");
		d.findElement(By.xpath("//input[@id='start-date']")).click();
		
		
		//select year
		WebElement yearDrop=d.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear=new Select(yearDrop);
		selectYear.selectByVisibleText(year);
		
		
		
		
		while(true) {
			String displayMonth=d.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			//convert required month and display month into object
			Month expectedMonth=convertMonth(month);
			Month currentMonth=convertMonth(displayMonth);
			
			//compare
			int result=expectedMonth.compareTo(currentMonth);
			
			
			if(result>0) {
				d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else if(result<0) {
				d.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

			}
			else {
				break;
			}
		
		}
		

	}

}
