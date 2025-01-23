package WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class conditionalMethod {

	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://www.instagram.com/");
		d.manage().window().maximize();
		
		//IsDisplayed
		WebElement logo=d.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/section/main/article/div[2]/div[1]/div[1]/i"));
		System.out.println("Status: "+logo.isDisplayed());
		
		//We can write in this way also
		Boolean b=d.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div[1]/div/section/main/article/div[2]/div[1]/div[1]/i")).isDisplayed();
		System.out.println("Display Status: "+b);
		
		//IsEnabled
		b=d.findElement(By.xpath("//input[@aria-label=\"Phone number, username, or email\"]")).isEnabled();
		//b=d.findElement(By.xpath("//div[@class=\"x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1xmf6yo x1e56ztr x540dpk x1m39q7l x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh x1nhvcw1\"]")).isEnabled();

		System.out.println("Enabled Status is: "+b);
		
		//IsSelected
		
		WebElement sel=d.findElement(By.xpath("//div[@class=\"x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1xmf6yo x1e56ztr x540dpk x1m39q7l x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh x1nhvcw1\"]"));
		System.out.println("Before Selection");
		System.out.println("Selected Status: "+sel.isSelected());
		
		System.out.println("After Selection");
		sel.click();
		System.out.println("Selected Status: "+sel.isSelected());//It is returning false because login does not containing any selection
		
		
		
		
		
		
		
		d.quit();
	}

}
