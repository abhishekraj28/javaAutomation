package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class disableAutomatedMessageOnScreen {

	public static void main(String[] args) {


		ChromeOptions o=new ChromeOptions();
		o.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		
		WebDriver d=new ChromeDriver(o);
		
		d.manage().window().maximize();
		d.get("https://demo.nopcommerce.com/");

	}

}
