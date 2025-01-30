package Table;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamicPaginatinTableEnhanced {

    public static void main(String[] args) throws InterruptedException {

        WebDriver d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        d.get("https://demo.opencart.com/admin/");
        d.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

        // Login
        WebElement user = d.findElement(By.xpath("//input[@id='input-username']"));
        //user.clear();
        user.sendKeys("demo");

        WebElement pwd = d.findElement(By.xpath("//input[@id='input-password']"));
       // pwd.clear();
        pwd.sendKeys("demo");

        Thread.sleep(3000);
       d.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Navigate to Customers page
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]"))).click();

        // Wait for the table to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-bordered table-hover']")));

        // Find the number of pages
        String page = d.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        int pageNo = Integer.parseInt(page.substring(page.indexOf("(") + 1, page.indexOf("Pages") - 1));

        // Click on pages and read data
        for (int i = 1; i <= 10; i++) {
            if (i > 1) {
                // Re-locate the pagination button for the current page
                WebElement pg = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ul[@class='pagination']//*[text()=" + i + "]")));
                
                // Scroll into view and click
                ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", pg);
                pg.click();

                // Wait for the table to reload
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-bordered table-hover']")));
            }

            // Read data from the table
            int rows = d.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("Reading data from page: " + i);

            // Example: Read table rows
            for (int j = 1; j <= rows; j++) {
                String cus = d.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + j + "]//td[2]")).getText();
                String email = d.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + j + "]//td[3]")).getText();
                System.out.println(cus + "\t" + email + "\t");
            }
        }

        //d.quit();
    }
}