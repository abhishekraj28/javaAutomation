package DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		d.get("https://www.google.com");
		d.manage().window().maximize();
		
		d.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenuim");
		Thread.sleep(3000);
		                   //d.findElements(By.xpath("//div[@class='erkvQe']//ul[@role='listbox']//li"));
		List<WebElement> l=d.findElements(By.xpath("//div[@id='Alh6id']//li"));
		
		System.out.println(l.size());
		for(WebElement el:l) {
			System.out.println(el.getText());
			
			/*
			if(el.getText().equals("selenium")) {
				el.click();
			
			}
			*/
		}
		
		/*
		WebElement f=d.findElement(By.xpath("https://www.google.com/sorry/index?continue=https://www.google.com/search%3Fq%3Dselenium%26sca_esv%3D82dc02b9bfb58d5d%26source%3Dhp%26ei%3D-d2VZ6-RBvLN1e8PqpPKiA4%26iflsig%3DACkRmUkAAAAAZ5XsCSkBvNWExqJh7LsJ22C3aNMSF6aG%26oq%3DSelenuim%26gs_lp%3DEgdnd3Mtd2l6IghTZWxlbnVpbSoCCAAyChAAGIAEGLEDGAoyBxAAGIAEGAoyBxAAGIAEGAoyChAAGIAEGLEDGAoyChAAGIAEGLEDGAoyChAAGIAEGLEDGAoyChAAGIAEGLEDGAoyBxAAGIAEGAoyBxAAGIAEGAoyBxAAGIAEGApI2hhQAFgZcAB4AJABAZgBd6ABuAOqAQMxLjO4AQHIAQD4AQGYAgOgAs0CwgIFEAAYgASYAwCSBwMwLjOgB-4e%26sclient%3Dgws-wiz%26sei%3D_d2VZ8HvFIDH4-EP2eCguA4&q=EhAkAuKAPf0ALGFRVQK3S9QuGP2717wGIjCocJy2q4eOJYUjFyC1o2ZlXueN6GtiX8L771muOWaCeLWrV6qr2gam6V_yLa_wQgQyAXJaAUM"));
		d.switchTo().frame(f);
		f.getSize();
		f.getText();
		/*
		d.switchTo().frame(0);
		
		d.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();

*/
	}

}
