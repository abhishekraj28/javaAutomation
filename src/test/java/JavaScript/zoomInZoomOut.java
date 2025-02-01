package JavaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zoomInZoomOut {

	public static void main(String[] args) {
		

		WebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.get("https://demo.nopcommerce.com/");
		/*
		d.manage().window().minimize();
		d.manage().window().maximize();
		*/
		
		JavascriptExecutor js= (JavascriptExecutor)d;
		js.executeScript("document.body.style.zoom='50%'");

	}

}
