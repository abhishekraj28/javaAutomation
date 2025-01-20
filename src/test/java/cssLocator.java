import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssLocator {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		//by Tag ID  tag#id
		//both are correct                   tag#id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirt");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirt");

		
		//by class 
		//both are correct                   tag.class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirt");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirt");

		
		//tag attribute                      tag[attribute="value"]
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirt");
		//driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("T-shirt");
		//driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("T-shirt");

		
		//by tag class attribute           tag.class[attribute='value']
		//driver.findElement(By.cssSelector("input.search-box-text[name=\"q\"]")).sendKeys("T-shirt");
		driver.findElement(By.cssSelector(".search-box-text[name=\"q\"]")).sendKeys("T-shirt");

		
		
		
	}

}
