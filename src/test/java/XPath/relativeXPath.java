package XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class relativeXPath {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		//Xpath with single attribute
		//driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("iphone");

		
		//Xpath with multiple attribute
		//driver.findElement(By.xpath("//input[@id='small-searchterms'][@name='q']")).sendKeys("iphone");
		
		//Xpath with 'AND', 'OR' operator
		//Using 'AND' operator both the attribute should be correct
	    //driver.findElement(By.xpath("//input[@id='small-searchterms' and @name='q']")).sendKeys("iphone");
		
	    
	    //Using 'OR' operator atleast one attribute should be correct
	    //driver.findElement(By.xpath("//input[@id='small-searchterms' or @name='q']")).sendKeys("iphone");

		
	    //Xpath with inner text
	    //driver.findElement(By.xpath("//a[text()=Register]")).click();
	    
	    
	    //If there is somme element which doesn't have linktext then what should happen
	   /* String t=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
	    System.out.println(t);
	    
	    if(t.equals("Welcome to our store")) {
	    	System.out.println("True");
	    }
	    else
	    {
	    	System.out.println("False");
	    }
	    
	    Boolean t1=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
	    System.out.println(t1);
         */
	    
	    
	    //Xpath using 'contains'                                      we can write 'Sear" or "Search store'
	    //driver.findElement(By.xpath("//input[contains(@placeholder,'Sear')]")).sendKeys("iphone");
	    
	    
	  //Xpath using 'starts-with'                                      we can write 'Sear" or "Search store'
	  //driver.findElement(By.xpath("//input[(@placeholder,'Sear')]")).sendKeys("iphone");

		
		//Xpath using chained
		Boolean b=driver.findElement(By.xpath("//*[@class='header-logo']/a/img")).isDisplayed();
		System.out.println(b);
	    
		
	}

}
