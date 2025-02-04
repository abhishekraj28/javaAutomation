package ExcelOperations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class fdCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {


		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		
		d.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		String filepath=System.getProperty("user.dir")+"\\ExcelData\\cal.xlsx";
		int rows=excelUtility.getRow(filepath, "sheet1");
		
		for(int i=0;i<=rows;i++) {
			
			//1) Read data from excel
			String pric=excelUtility.getCellData(filepath, "sheet1", i, 0);
			String rateOF=excelUtility.getCellData(filepath, "sheet1", i, 1);
			String per1=excelUtility.getCellData(filepath, "sheet1", i, 2);
			String per2=excelUtility.getCellData(filepath, "sheet1", i, 3);
			String fre=excelUtility.getCellData(filepath, "sheet1", i, 4);
			String expvalue=excelUtility.getCellData(filepath, "sheet1", i, 5);
			
			//2) pass above data into application
			d.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
			d.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOF);
			d.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select day=new Select(d.findElement(By.xpath("//select[@id='tenurePeriod']")));
			day.selectByVisibleText(per2);
			
			Select freq=new Select(d.findElement(By.xpath("//select[@id='frequency']")));
			freq.selectByVisibleText(fre);
			
			d.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			
			//3) Validation
			
			String actval=d.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(expvalue)== Double.parseDouble(actval)) {
				System.out.println("Test passed");
				excelUtility.setCellData(filepath, "sheet1", i, 7, "passed");
				excelUtility.fillGreenColors(filepath, "sheet1", i, 7);
				
			}
			else {
				System.out.println("Test failed");
				excelUtility.setCellData(filepath, "sheet1", i, 7, "failed");
				excelUtility.fillGreenColors(filepath, "sheet1", i, 7);
			}
			
			Thread.sleep(3000);
			d.findElement(By.xpath("//div[@class='cal_div']//a[2]")).click();
			
		}
		
		d.quit();
	}

}
