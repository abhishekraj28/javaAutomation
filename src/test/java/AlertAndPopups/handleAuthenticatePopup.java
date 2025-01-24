package AlertAndPopups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleAuthenticatePopup {

	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		
		//d.get("https://the-internet.herokuapp.com/javascript_alerts");
		//Syntax: ("https:// Username:Password@link")
		d.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		d.manage().window().maximize();
		
		
		
	}

}
