import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssLocator {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		
		//by Tag ID
		//both are correct
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirt");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirt");

	}

}
