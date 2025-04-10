// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import java.time.Duration;

// public class TestPartner {
//     static final String GREEN = "\u001B[32m";
//     static final String RESET = "\u001B[0m";
//     static final String RED = "\u001B[31m";

//     public static void main(String[] args) {
//         // Set path for ChromeDriver
//         System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

//         // Launch Chrome
//         WebDriver driver = new ChromeDriver();

//         try {
//             // Open login page
//             driver.get("http://51.21.130.55:8097/");
//             driver.manage().window().maximize();

//             // Wait setup
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//             // Input credentials
//             WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//             usernameField.sendKeys("admin@Lersha.com");

//             WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//             passwordField.sendKeys("Admin@123");

//             // Click login
//             WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
//             loginButton.click();

//             // Small wait after login
//             Thread.sleep(10000);

//             // Check for login success
//             if (driver.getTitle().contains("Dashboard")) {
//                 System.out.println(GREEN + "Login successful!" + RESET);
//             } else {
//                 System.out.println(RED + "Login failed!" + RESET);
//             }

//             // Click on the "Partners" span element
//             WebElement partnersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Partners')]")));
//             partnersLink.click();

//             // Small wait after clicking "Partners"
//             Thread.sleep(3000);

//             // Check if "Partners" page is loaded successfully
//             if (driver.getTitle().contains("Partner")) {
//                 System.out.println(GREEN + "Successfully clicked on 'Partners' and navigated to the Partners page!" + RESET);
//             } else {
//                 System.out.println(RED + "Failed to navigate to the Partners page!" + RESET);
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             driver.quit(); // Close the browser
//         }
//     }
// }
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestPartner {
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        // Set path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        // Launch Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Open login page
            driver.get("http://51.21.130.55:8097/");
            driver.manage().window().maximize();

            // Wait setup
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increase timeout to 15 seconds

            // Input credentials
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("admin@Lersha.com");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("Admin@123");

            // Click login
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
            loginButton.click();

            // Small wait after login
            Thread.sleep(10000);

            // Check for login success
            if (driver.getTitle().contains("Dashboard")) {
                System.out.println(GREEN + "Login successful!" + RESET);
            } else {
                System.out.println(RED + "Login failed!" + RESET);
            }

            // Click on the "Partners" span element
            WebElement partnersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Partners')]")));
            partnersLink.click();

            // Small wait after clicking "Partners"
            Thread.sleep(3000);

            // Wait for the Partners page to load
            WebElement partnersLinkAfterClick = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '/dashboard/partner')]")));

            // Check if the page loaded correctly by verifying the "Partners" link is visible
            if (partnersLinkAfterClick != null && partnersLinkAfterClick.isDisplayed()) {
                System.out.println(GREEN + "Successfully navigated to the Partners page!" + RESET);
            } else {
                System.out.println(RED + "Failed to navigate to the Partners page!" + RESET);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
