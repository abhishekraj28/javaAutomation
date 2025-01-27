package Assignment;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class BlazeDemoAssignmentEmhanced {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://blazedemo.com/");
            driver.manage().window().maximize();

            // Select departure and destination cities
            selectOptionByText(driver, "//select[@name='fromPort']//option", "San Diego");
            selectOptionByText(driver, "//select[@name='toPort']//option", "New York");

            // Click "Find Flights"
            driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

            // Get all flight prices and find the minimum
            ArrayList<Double> prices = getFlightPrices(driver);
            double minPrice = prices.stream().min(Double::compare).orElse(Double.MAX_VALUE);
            int minPriceIndex = prices.indexOf(minPrice) + 2; // Adjust index for table header

            // Select the flight with the minimum price
            WebElement chooseButton = driver.findElement(By.xpath("//table[@class='table']//tr[" + minPriceIndex + "]//td[1]//input"));
            chooseButton.click();

            // Fill in the purchase form
            driver.findElement(By.id("inputName")).sendKeys("Abhishek");
            driver.findElement(By.id("address")).sendKeys("Navi Mumbai");
            driver.findElement(By.id("city")).sendKeys("Airoli");
            driver.findElement(By.id("state")).sendKeys("Maharashtra");
            driver.findElement(By.id("zipCode")).sendKeys("400708");
            driver.findElement(By.xpath("//select[@id='cardType']//option[@value='visa']")).click();
            driver.findElement(By.id("creditCardNumber")).sendKeys("12345678");
            driver.findElement(By.id("creditCardMonth")).clear();
            driver.findElement(By.id("creditCardMonth")).sendKeys("12");
            driver.findElement(By.id("creditCardYear")).clear();
            driver.findElement(By.id("creditCardYear")).sendKeys("2018");
            driver.findElement(By.id("nameOnCard")).sendKeys("Abhishek");
            driver.findElement(By.id("rememberMe")).click();
            driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

            // Verify the "Thank you" message
            boolean isThankYouMessageDisplayed = driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).isDisplayed();
            Assert.assertTrue(isThankYouMessageDisplayed, "Thank you message is not displayed!");

            System.out.println("Test passed: Thank you message displayed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    // Method to select an option by its text
    public static void selectOptionByText(WebDriver driver, String xpath, String value) {
        List<WebElement> options = driver.findElements(By.xpath(xpath));
        for (WebElement option : options) {
            if (option.getText().equals(value)) {
                option.click();
                break;
            }
        }
    }

    // Method to get flight prices from the table
    public static ArrayList<Double> getFlightPrices(WebDriver driver) {
        ArrayList<Double> prices = new ArrayList<>();
        int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();

        for (int i = 2; i < rows; i++) { // Start from 2 to skip the header row
            String priceText = driver.findElement(By.xpath("//table[@class='table']//tr[" + i + "]//td[6]")).getText();
            double price = Double.parseDouble(priceText.replace("$", "").trim());
            prices.add(price);
        }
        return prices;
    }
}

