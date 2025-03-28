// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class PerformanceTest {
//     public static void main(String[] args) {
//         // Automatically set up ChromeDriver
//          // Set up ChromeDriver
//          System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
//        // WebDriverManager.chromedriver().setup();

//         // Start WebDriver
//         WebDriver driver = new ChromeDriver();

//         try {
//             // Start time measurement
//             long startTime = System.currentTimeMillis();

//             // Open the login page
//             String testUrl = "http://51.21.130.55:8097/";
//             driver.get(testUrl);

//             // Find and enter username
//             WebElement usernameField = driver.findElement(By.name("username"));  // Update selector if needed
//             usernameField.sendKeys("admin@lersha.com");

//             // Find and enter password
//             WebElement passwordField = driver.findElement(By.name("password"));  // Update selector if needed
//             passwordField.sendKeys("Admin@123");

//             // Click login button
//             // WebElement loginButton = driver.findElement(By.tagName("button"));  // Update selector if needed
//             // loginButton.click();
//             WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
//             loginButton.click();

//             // Wait a few seconds for login to complete
//             Thread.sleep(5000);

//             // End time measurement
//             long endTime = System.currentTimeMillis();
//             long loadTime = endTime - startTime;  // Calculate load time in milliseconds

//             // Print Performance Result with Colors
//             System.out.println("\nPerformance Test Result:");
//             if (loadTime < 5000) {
//                 System.out.println("\u001B[32m FAST: ✅" + loadTime + " ms ✅\u001B[0m"); // Green
//             } else if (loadTime >= 5000 && loadTime < 10000) {
//                 System.out.println("\u001B[33m MEDIUM: ⚠️  " + loadTime + " ms ⚠️\u001B[0m"); // Yellow
//             } else {
//                 System.out.println("\u001B[31m SLOW:❌ " + loadTime + " ms ❌\u001B[0m"); // Red
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Close the browser
//             driver.quit();
//         }
//     }
// }
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PerformanceTest {
    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        // WebDriverManager.chromedriver().setup();

        // Start WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Measure network speed before test
            double networkSpeed = checkNetworkSpeed();
            System.out.println("\nNetwork Speed: " + networkSpeed + " Mbps");

            // Start time measurement
            long startTime = System.currentTimeMillis();

            // Open the login page
            String testUrl = "http://51.21.130.55:8097/";
            driver.get(testUrl);

            // Find and enter username
            WebElement usernameField = driver.findElement(By.name("username"));
            usernameField.sendKeys("admin@lersha.com");

            // Find and enter password
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("Admin@123");

            // Click login button
            WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
            loginButton.click();

            // Wait a few seconds for login to complete
            Thread.sleep(5000);

            // End time measurement
            long endTime = System.currentTimeMillis();
            long loadTime = endTime - startTime;

            // Print Performance Result
            System.out.println("\nPerformance Test Result:");
            if (loadTime < 5000) {
                System.out.println("\u001B[32m FAST: ✅" + loadTime + " ms ✅\u001B[0m"); // Green
            } else if (loadTime >= 5000 && loadTime < 10000) {
                System.out.println("\u001B[33m MEDIUM: ⚠️  " + loadTime + " ms ⚠️\u001B[0m"); // Yellow
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

    // Method to check network speed
    public static double checkNetworkSpeed() {
        String testFileUrl = "http://speedtest.tele2.net/1MB.zip"; // Public test file (1MB)
        int fileSizeInBits = 1 * 8 * 1024 * 1024; // Convert 1MB to bits

        try {
            URL url = new URL(testFileUrl);
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);

            long startTime = System.currentTimeMillis();

            // Read the input stream (simulate download)
            InputStream inputStream = connection.getInputStream();
            while (inputStream.read() != -1) { }
            inputStream.close();

            long endTime = System.currentTimeMillis();
            double timeTakenInSeconds = (endTime - startTime) / 1000.0;

            // Calculate speed (Mbps)
            double speedMbps = fileSizeInBits / (timeTakenInSeconds * 1_000_000);
            if (speedMbps > 10) {
                            System.out.println("\u001B[32mNetwork Speed: " + String.format("%.2f", speedMbps) + " Mbps (FAST) ✅\u001B[0m");
                        } else if (speedMbps >= 1) {
                            System.out.println("\u001B[33mNetwork Speed: " + String.format("%.2f", speedMbps) + " Mbps (MEDIUM) ⚠️\u001B[0m");
                        } else {
                            System.out.println("\u001B[31mNetwork Speed: " + String.format("%.2f", speedMbps) + " Mbps (SLOW) ❌\u001B[0m");
                        }
                
            return speedMbps;
        } catch (Exception e) {
            System.out.println("Failed to check network speed.");
            return -1;
        }
    }
}
// //public static double checkNetworkSpeed() {
//     String testFileUrl = "http://speedtest.tele2.net/1MB.zip"; // Public test file (1MB)
//     int fileSizeInBits = 1 * 8 * 1024 * 1024; // Convert 1MB to bits

//     try {
//         URL url = new URL(testFileUrl);
//         URLConnection connection = url.openConnection();
//         connection.setUseCaches(false);

//         long startTime = System.currentTimeMillis();

//         // Read the input stream (simulate download)
//         InputStream inputStream = connection.getInputStream();
//         while (inputStream.read() != -1) { }
//         inputStream.close();

//         long endTime = System.currentTimeMillis();
//         double timeTakenInSeconds = (endTime - startTime) / 1000.0;

//         // Calculate speed (Mbps)
//         double speedMbps = fileSizeInBits / (timeTakenInSeconds * 1_000_000);

//         // Color-coded output based on speed
//         if (speedMbps > 10) {
//             System.out.println("\u001B[32mNetwork Speed: " + String.format("%.2f", speedMbps) + " Mbps (FAST) ✅\u001B[0m");
//         } else if (speedMbps >= 1) {
//             System.out.println("\u001B[33mNetwork Speed: " + String.format("%.2f", speedMbps) + " Mbps (MEDIUM) ⚠️\u001B[0m");
//         } else {
//             System.out.println("\u001B[31mNetwork Speed: " + String.format("%.2f", speedMbps) + " Mbps (SLOW) ❌\u001B[0m");
//         }

//         return speedMbps;
//     } catch (Exception e) {
//         System.out.println("\u001B[31mFailed to check network speed.❌\u001B[0m");
//         return -1;
//     }
// }
 