package Assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class blazeDemoAssignment {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		
		
		d.get("https://blazedemo.com/");
		d.manage().window().maximize();
		
		List<WebElement> des=d.findElements(By.xpath("//select[@name='fromPort']//option"));
		
		//System.out.println(des.size());
		
		for(WebElement desc:des) {
			if(desc.getText().equals("San Diego")) {
				desc.click();
			}
		}
		
        des=d.findElements(By.xpath("//select[@name='toPort']//option"));
		
		//System.out.println(des.size());
		
		for(WebElement desc:des) {
			if(desc.getText().equals("New York")) {
				desc.click();
			}
		}
		
		d.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		

		
		//get all the prices
		int rows=d.findElements(By.xpath("//table[@class='table']//th")).size();
		int col=d.findElements(By.xpath("//table[@class='table']//tr")).size();
		
		ArrayList<Double> prList = new ArrayList<>();

		
		
		for(int i=2;i<rows;i++ ) {
				String pr=d.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
				double price = Double.parseDouble(pr.replace("$", "").trim());
				prList.add(price);
				
		}
		
        double minPrice = prList.stream().min(Double::compare).orElse(Double.MAX_VALUE);

        int minPriceIndex = prList.indexOf(minPrice) + 2; // Add 2 to adjust for header offset

        WebElement chooseButton = d.findElement(By.xpath("//table[@class='table']//tr[" + minPriceIndex + "]//td[1]//input"));
        chooseButton.click();
		
        
        
        //fill the form
        d.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Abhishek");
        d.findElement(By.xpath("//input[@id='address']")).sendKeys("Navi Mumbai");
        d.findElement(By.xpath("//input[@id='city']")).sendKeys("Airoli");
        d.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Abhishek");
        d.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
        d.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("400708");
        //I have selected visa
        d.findElement(By.xpath("//select[@id='cardType']//option[@value='visa']")).click();
        d.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("12345678");
        d.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("12");
        d.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2018");
        d.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Abhishek");
        d.findElement(By.xpath("//input[@id='rememberMe']")).click();
        d.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        


        //check whether thank you is displayed or not
        boolean b=d.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).isDisplayed();
        System.out.println(b);
        
        
        
        
        
        d.quit();
	}

}
