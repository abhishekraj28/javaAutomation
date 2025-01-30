package Keyboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class tabsAndWindows {

	public static void main(String[] args) {
		
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://demo.opencart.com/");
		d.manage().window().maximize();
		
		//open another link in new tab
		//d.switchTo().newWindow(WindowType.TAB);
		
		//open in another window
		d.switchTo().newWindow(WindowType.WINDOW);
		
		d.get("https://text-compare.com/");
		

	}

}
