import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PerformanceTest {
    public static void main(String[] args) {
        // Automatically set up ChromeDriver
         // Set up ChromeDriver
         System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
       // WebDriverManager.chromedriver().setup();

        // Start WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Start time measurement
            long startTime = System.currentTimeMillis();

            // Open the login page
            String testUrl = "http://51.21.130.55:8097/";
            driver.get(testUrl);

            // Find and enter username
            WebElement usernameField = driver.findElement(By.name("username"));  // Update selector if needed
            usernameField.sendKeys("admin@lersha.com");

            // Find and enter password
            WebElement passwordField = driver.findElement(By.name("password"));  // Update selector if needed
            passwordField.sendKeys("Admin@123");

            // Click login button
            // WebElement loginButton = driver.findElement(By.tagName("button"));  // Update selector if needed
            // loginButton.click();
            WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
            loginButton.click();

            // Wait a few seconds for login to complete
            Thread.sleep(5000);

            // End time measurement
            long endTime = System.currentTimeMillis();
            long loadTime = endTime - startTime;  // Calculate load time in milliseconds

            // Print Performance Result with Colors
            System.out.println("\nPerformance Test Result:");
            if (loadTime < 5000) {
                System.out.println("\u001B[32m FAST: " + loadTime + " ms ✅\u001B[0m"); // Green
            } else if (loadTime >= 5000 && loadTime < 10000) {
                System.out.println("\u001B[33m MEDIUM: ⚠️" + loadTime + " ms ⚠️\u001B[0m"); // Yellow
            } else {
                System.out.println("\u001B[31m SLOW:❌ " + loadTime + " ms ❌\u001B[0m"); // Red
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
