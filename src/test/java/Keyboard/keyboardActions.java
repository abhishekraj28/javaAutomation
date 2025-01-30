package Keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyboardActions {

	public static void main(String[] args) {

		WebDriver d=new ChromeDriver();

		d.get("https://text-compare.com/");
		d.manage().window().maximize();
		
		d.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");
		Actions act=new Actions(d);

		//select the text(CTRL A)
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//copy the text(CTRL C)
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

		//Switch the tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//paste the text(CTRL V)
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

	}

}
