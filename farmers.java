import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class farmers {
    // ANSI color codes
    static final String GREEN = "\u001B[32m";  // Green color for success
    static final String RED = "\u001B[31m";    // Red color for failure
    static final String RESET = "\u001B[0m";  // Reset color

    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open the farmers page
            driver.get("http://164.160.187.141:8097/");
            driver.manage().window().maximize();

            // Add WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait and locate the username field
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("admin@Lersha.com");

            // Wait and locate the password field
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("Admin@123");

            // Wait and locate the "Sign in" button using text
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
            loginButton.click();

            // Wait after login
            Thread.sleep(3000);

            // Locate the Start Date input field
            WebElement startDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("startDate")));
            startDateInput.sendKeys("2025-01-01");  // Change the date as needed

            // Locate the End Date input field
            WebElement endDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("endDate")));
            endDateInput.sendKeys("2025-03-03");  // Change the date as needed

            // Optionally, trigger a search event (if required)
            // WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
            // searchButton.click();

            // Wait for results to load
            Thread.sleep(30000); // Adjust based on the actual response time

            // Verify if results are found
            try {
                WebElement resultList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-results']")));
                System.out.println(GREEN + "Farmers filtered successfully!" + RESET);
            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println(RED + "No farmers found for the selected date range!" + RESET);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
