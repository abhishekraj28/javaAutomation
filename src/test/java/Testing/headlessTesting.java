package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headlessTesting {

	public static void main(String[] args) {

		ChromeOptions o=new ChromeOptions();
		o.addArguments("--headless=new");

		WebDriver driver=new ChromeDriver(o);
		
		driver.get("https://www.opencart.com/");
		
		String webName=driver.getTitle();
		
		if(webName.equals("OpenCart - Open Source Shopping Cart Solution")) {
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test fails");
		}
		
		
		driver.quit();

	}

}
