package Testing;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleBrokenLinks {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("http://www.deadlinkcity.com/");
		d.manage().window().maximize();
		
		List<WebElement> link=d.findElements(By.tagName("a"));
		System.out.println("Total no of links "+link.size());
		
		int noOFBrokenLinks=0;
		for(WebElement linkele:link) {
			
			String linkatt=linkele.getAttribute("href");
			
			if(linkatt==null || linkatt.isEmpty()) {
				System.out.println("href attribute is null");
				continue;
			}
			
			
			//Hit url to the server
			
			try {
			//1) convert href value from string to URL format
			URL ur=new URL(linkatt);
			//2) open connection to the server
			HttpURLConnection conn=(HttpURLConnection) ur.openConnection();
			//3) connect to the server and sent request to the server
			conn.connect();
			
			if(conn.getResponseCode()>400) {
				System.out.println(linkatt+"=======>This is a broke link");
				noOFBrokenLinks++;
			}
			else
			{
				System.out.println(linkatt+"=====>It is not a broken link");
			}
			}
			catch(Exception e) {
				System.out.println(e);
				
			}
			
			
		}
		System.out.println(noOFBrokenLinks+" is the broken links");

	}

}
