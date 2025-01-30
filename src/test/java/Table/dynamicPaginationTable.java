package Table;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamicPaginationTable {

    public static void main(String[] args) throws InterruptedException {

        WebDriver d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        d.get("https://demo.opencart.com/admin/");
        d.manage().window().maximize();

        Thread.sleep(3000);
        WebElement user = d.findElement(By.xpath("//input[@id='input-username']"));
        user.clear();
        user.sendKeys("demo");

        WebElement pwd = d.findElement(By.xpath("//input[@id='input-password']"));
        pwd.clear();
        pwd.sendKeys("demo");

        Thread.sleep(5000);
        d.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        d.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        d.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

        Thread.sleep(20000);
        // Find the number of pages
        String page = d.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        int pageNo = Integer.parseInt(page.substring(page.indexOf("(") + 1, page.indexOf("Pages") - 1));

       WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

        // Click on pages and read data
        for (int i = 1; i <= 10; i++) {

            if (i >1) {
                WebElement pg = d.findElement(By.xpath("//ul[@class='pagination']//*[text()="+i+"]"));
                pg.click();
                Thread.sleep(3000);
               
                // Scroll into view and wait for it to be clickable
                ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", pg);
                wait.until(ExpectedConditions.elementToBeClickable(pg)).click();
                
                
            }
            
            //read data from the page
            int rows=d.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("Reading data from page: " + i);
            
        /*
         //Read a particular column
            for(int j=1;j<=rows;j++) {
            	String cus=d.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[2]")).getText();
            	String email=d.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[3]")).getText();

            	System.out.println(cus+"\t"+email+"\t");
            	
            }
            */
            
            // Example: Read table rows
            for (WebElement row : d.findElements(By.xpath("//table/tbody/tr"))) {
                System.out.println(row.getText());
            }
            
            
        }
            
        

       d.quit();
    }
}
