package WebDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigationalCommands {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//USing get url method we can only pass String
		//driver.get("gttps://demo.nopcommerce.com");
		
		
		//Using navigate.to() method we can pass both string and object
		driver.navigate().to("https://demo.nopcommerce.com");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		/*Using object
		URL u=new URL("https://demo.nopcommerce.com/");
		driver.navigate().to(u);
		*/
		
		
		//Using navigate().back()
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		//Using navigate().forward()
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		//Using navigate().refresh()
		driver.navigate().refresh();
		
		
		
		
		
		
	}

}
