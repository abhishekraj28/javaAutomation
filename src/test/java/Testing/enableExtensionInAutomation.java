package Testing;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class enableExtensionInAutomation {

	public static void main(String[] args) {


		ChromeOptions o=new ChromeOptions();
		
		
		//Enable selectorhub extension 
		File f=new File("C:\\Users\\rajab\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		o.addExtensions(f);
		
		
		//Enable  extensionublockorigin 
		File f1=new File("C:\\Users\\rajab\\Downloads\\uBlock-Origin-Lite-Chrome-Web-Store.crx");
		o.addExtensions(f1);

		WebDriver d=new ChromeDriver(o);
		
	
		d.manage().window().maximize();
		d.get("https://text-compare.com/");

	}

}
