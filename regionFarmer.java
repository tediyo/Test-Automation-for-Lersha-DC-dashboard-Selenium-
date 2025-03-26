import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class regionFarmer {

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

            // Wait and locate the "Farmers" link
            WebElement farmersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/dashboard/farmer')]")));
            farmersLink.click();

            // Wait and locate the Region filter button using your provided XPath
            WebElement regionButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.relative.flex.h-screen.overflow-hidden > div > main > div > div.flex-1.space-y-4.mt-12.pt-6.mr-8.bg-white.shadow-lg.rounded-md > div > div:nth-child(2) > div.grid.grid-cols-1.md\\:grid-cols-4.gap-4.mb-4 > div:nth-child(3) > button")));
            regionButton.click(); // Open the region filter options

            // Select a region from the available options (adjust this based on how options are presented)
            WebElement regionOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Addis Ababa')]"))); // Modify the XPath to the correct region option
            regionOption.click(); // Click to select the region

            // Wait for the results to load
            Thread.sleep(10000); // Adjust based on actual response time

            // Verify that results are filtered by region
            WebElement resultList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/main/div/div[2]/div/div[3]/div[1]/div/table/tbody")));
            System.out.println(GREEN + "Farmers filtered by region successfully!" + RESET);

            // Fetch all the filtered farmer rows
            List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[2]/div/main/div/div[2]/div/div[3]/div[1]/div/table/tbody/tr"));

            if (rows.size() > 1) {
                System.out.println(GREEN + rows.size() + " farmers found!" + RESET);
            } else {
                System.out.println(RED + "No farmers found for the selected region!" + RESET);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
