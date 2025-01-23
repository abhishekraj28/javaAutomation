package WebDriverMethods;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificBrowserWindowSe {

    public static void main(String[] args) throws InterruptedException {
        
        // Initialize WebDriver
        WebDriver d = new ChromeDriver();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Open Instagram
        d.get("https://www.instagram.com/");
        
        
        // Click on the Threads link (ensure the XPath is correct)
        d.findElement(By.xpath("//span[normalize-space()='Threads']")).click();
        
        Thread.sleep(5000);
        // Maximize the browser window
        d.manage().window().maximize();
        
        
        /*
        // Wait for a short duration to allow the new window/tab to open
        try {
            Thread.sleep(3000); // Use Thread.sleep temporarily for debugging
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        
        // Get all window handles
        Set<String> windows = d.getWindowHandles();
        
        // Iterate through all windows
        for (String window : windows) {
            // Switch to each window and get its title
            String title = d.switchTo().window(window).getTitle();
            System.out.println("Window Title: " + title);
            
            /*
            // Close the specific window based on the title
            if (title.contains("Instagram Blog")) { // Adjust title as needed
                d.close();
                System.out.println("Closed window with title: " + title);
            }
            */
        }
        
        // Quit the WebDriver
        //d.quit();
    }
}
