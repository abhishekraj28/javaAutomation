package Mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {

	public static void main(String[] args) {

		WebDriver d=new ChromeDriver();
		
		d.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		d.manage().window().maximize();
		
		Actions act=new Actions(d);
		
		
		//select the elements which you want to drop
		WebElement rome=d.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy=d.findElement(By.xpath("//div[@id='box106']"));
		
		//drag and drop
		act.dragAndDrop(rome, italy).perform();

	}

}
