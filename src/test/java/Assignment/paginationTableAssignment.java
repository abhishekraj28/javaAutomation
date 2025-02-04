package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class paginationTableAssignment {

	public static void main(String[] args) throws InterruptedException {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		//int row=d.findElements(By.xpath("//div[@class='table-container']//tr")).size();
		int col=d.findElements(By.xpath("//div[@class='table-container']//tr//th")).size();
		
		//System.out.println(row+"\t"+col);
		
		for(int i=1;i<=4;i++) {
			
		
			int row=d.findElements(By.xpath("//div[@class='table-container']//tr")).size();
            System.out.println("Reading data from page: " + i);

		for(WebElement data:d.findElements(By.xpath("//table[@id='productTable']/tbody//tr"))){
				System.out.println(data.getText());
				
				if(i<1) {
					WebElement pgno=d.findElement(By.xpath("//ul[@id='pagination']//*[text()="+i+"]"));
					pgno.click();
					Thread.sleep(3000);
					}
				//String val=d.findElement(By.xpath("//div[@class='table-container']//tr["+k+"]//td["+j+"]")).getText();
				//System.out.println(val);
				//WebElement checkBox=d.findElement(By.xpath("))
				
				
				}
		}
		
	}

}


