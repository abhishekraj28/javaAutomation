package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handlingSSL {

	public static void main(String[] args) {


		ChromeOptions o=new ChromeOptions();
		//o.addArguments("--headless=new");
		o.setAcceptInsecureCerts(true);
		
		WebDriver d=new ChromeDriver(o);
		
		d.get("http://expired.badssl.com/");
		d.manage().window().maximize();
		
		System.out.println("Title of the page "+d.getTitle());

	}

}
