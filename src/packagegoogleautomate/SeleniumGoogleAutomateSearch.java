
package packagegoogleautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SeleniumGoogleAutomateSearch {

    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\raman\\eclipse-workspace\\testerr\\HKAseleniumAutomatingGoogleSearch\\server\\chromedriver.exe");
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open Google's homepage
            driver.get("https://www.google.com");
            
            // Wait for the search box to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            
            // Enter the search query
            searchBox.sendKeys("Selenium with Java");
            
            // Submit the search
            searchBox.submit();
            
            // Wait for the results page to load
            wait.until(ExpectedConditions.titleContains("Selenium with Java"));
            
            // Validate the results page title
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("Selenium with Java")) {
                System.out.println("Test is Passed");
            } else {
                System.out.println("Test is Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
            driver.quit();
        }
    }
}