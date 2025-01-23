package XPath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathAxesDemo {

	public static void main(String[] args) {
		
		WebDriver d=new ChromeDriver();
		
		d.get("https://demo.nopcommerce.com/");
		
		d.manage().window().maximize();
		
		
		//Self select the current node
		String s=d.findElement(By.xpath("//a[normalize-space()='Register']/self::a")).getText();
		System.out.println("Self is: "+s); 
		
		//Parent: Select the parent of the current node
		s=d.findElement(By.xpath("//a[normalize-space()='Register']/parent::li")).getText();
		System.out.println("Parent is: "+s);
		
		//Select all child of the current node
		List <WebElement> child =d.findElements(By.xpath("//a[normalize-space()='Register']/ancestor::div/child::*"));
		//System.out.println("Childs are: "+child);
		System.out.println("child is: "+child.size()); 
		
		//Select all ancestor
		s=d.findElement(By.xpath("//a[normalize-space()='Register']/ancestor::*")).getText();
		//System.out.println("Ancestors are: "+ancestor);
		System.out.println("Ancestors are: "+s); 
		
		//Select all descendants(children, grandchildren etc)
		List<WebElement> desc=d.findElements(By.xpath("//a[normalize-space()='Register']/ancestor::li/descendant::*"));
		System.out.println("Descendants are: "+desc.size());
		
		//Following 
		List<WebElement> foll=d.findElements(By.xpath("//a[normalize-space()='Register']/ancestor::li/following::*"));
		System.out.println("following nodes are: "+foll.size());
		
		//Preceding
		List<WebElement> prec=d.findElements(By.xpath("//a[normalize-space()='Register']/ancestor::li/following::*"));
		System.out.println("Preceding nodes are: "+prec.size());
		
		//Following Siblings: Select siblings after the current node
		List <WebElement> follsib=d.findElements(By.xpath("//a[normalize-space()='Register']/ancestor::li/following-sibling::*"));
		System.out.println("Following siblings are: "+follsib.size());
		
		
		//Preceding Siblings: Select siblings after the current node
		List <WebElement> Precsib=d.findElements(By.xpath("//a[normalize-space()='Register']/ancestor::li/preceding-sibling::*"));
		System.out.println("Preceding siblings are: "+Precsib.size());
				
		
		d.quit();

	}

}
