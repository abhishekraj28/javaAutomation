package JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadFile {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		
		d.manage().window().maximize();
		d.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//Single upload file
		d.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\rajab\\Downloads\\Exploratory Testing.docx");
		
		if(d.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Exploratory Testing.docx")) {
			System.out.println("Upload Successful");
			
		}else
		{
			System.out.println("Upload failed");
		}

	}

}
