package packagegoogleautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumgoogleautomatesearch {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\raman\\eclipse-workspace\\testerr\\HKAseleniumAutomatingGoogleSearch\\server\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();

        try {
            // Open Google's homepage
            driver.get("https://www.google.com");

            // Initialize WebDriverWait with a timeout of 20 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait for the Google search box to be visible and clickable
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

            // Enter the search query in the search box
            searchBox.sendKeys("Selenium with Java");

            // Submit the search query
            searchBox.submit();

            // Wait for CAPTCHA to appear and let the user solve it manually
            System.out.println("Please solve the CAPTCHA manually. The script will continue after you click 'Verify'.");

            // Pause the script here and wait for the user to solve the CAPTCHA
            // This is achieved by adding a simple input wait before proceeding
            System.out.println("Press Enter once you've solved the CAPTCHA and clicked 'Verify' to continue...");
            System.in.read(); // Wait for user to press Enter after solving CAPTCHA

            // Wait for the page to load after CAPTCHA is resolved
            wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("Selenium+with+Java"),
                ExpectedConditions.titleContains("selenium with java")
            ));

            // Validate the results page title
            String pageTitle = driver.getTitle();
            if (pageTitle.toLowerCase().contains("selenium with java")) {
                System.out.println("Test Passed: Page title is " + pageTitle);
            } else {
                System.out.println("Test Failed: Page title is " + pageTitle);
            }
        } catch (Exception e) {
            // Print any exception encountered during execution
            e.printStackTrace();
        } finally {
            // Close the browser after manual interaction
            driver.quit();
        }
    }
}