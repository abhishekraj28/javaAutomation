package Screenshot;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class takeScreenshot {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.get("https://demo.nopcommerce.com/");
		
		TakesScreenshot sc=(TakesScreenshot)d;
		
		
		//Full pageScreenshot
		
		File sf=sc.getScreenshotAs(OutputType.FILE);
		File targetFile=new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
		sf.renameTo(targetFile);//copy sourcefile to target file
		
		
		
		//capture specific section of screenshot
		WebElement pro=d.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File sf1=pro.getScreenshotAs(OutputType.FILE);
		File targetFile1=new File(System.getProperty("user.dir")+"\\Screenshots\\featureProduct.png");
		sf1.renameTo(targetFile1);//copy sourcefile to target file
		
		
		

		//capture screenshot webelement
		WebElement pr=d.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sf2=pr.getScreenshotAs(OutputType.FILE);
		File targetFile2=new File(System.getProperty("user.dir")+"\\Screenshots\\logo.png");
		sf2.renameTo(targetFile2);//copy sourcefile to target file
		
		
		d.quit();
		

	}

}
