import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTestCase {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/");
		
		String webName=driver.getTitle();
		
		if(webName.equals("OpenCart - Open Source Shopping Cart Solution")) {
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test fails");
		}
		
		//driver.close();
	
		driver.quit();
	}

}
