package Table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class staticTable {

	public static void main(String[] args) {


		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://testautomationpractice.blogspot.com/");
		d.manage().window().maximize();
		
		//1: Find no of rows in a table
		int rows=d.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println(rows);
		
		//2: Find no of cols in a table
		int col=d.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println(col);
		
		//3: find a specific col(Example: 5 row 1 col)
		String s=d.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println(s);
		
		// Example(6 row 3 col)
		String s1=d.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[3]")).getText();
		System.out.println(s1);
		
		/*
		//5: Read all the data from rows and col
		for(int i=2;i<=rows;i++) {
			for(int j=1;j<=col;j++) {
				String tn=d.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
				System.out.println(tn+"\t");
			}
			System.out.println();
		}
		
		

		//6: Print bookname whose author is mukesh
		for(int i=2;i<=rows;i++) {
			String a=d.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			
			if(a.equals("Mukesh")) {
				String bn=d.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();
				System.out.println(bn);
			}
		}
		*/
	}

}
