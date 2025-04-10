// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;

// public class LoginTest {
//     public static void main(String[] args) {
//         // Set the path for ChromeDriver
//         System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

//         // Launch Chrome browser
//         WebDriver driver = new ChromeDriver();

//         try {
//             // Navigate to the login page
//             driver.get("http://164.160.187.141:8097/");

//             // Maximize the browser window
//             driver.manage().window().maximize();

//             // Find and fill the username field

//             WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//             usernameField.sendKeys("admin@Lersha.com");
//             // WebElement usernameField = driver.findElement(By.id("username")); // Replace with actual ID if different
//             // usernameField.sendKeys("admin@Lersha.com");

//             // Find and fill the password field
//             WebElement passwordField = driver.findElement(By.name("password")); // Replace with actual ID if different
//             passwordField.sendKeys("Admin@123");

//             // // Find and click the login button
//             // WebElement loginButton = driver.findElement(By.name("loginButton")); // Replace with actual ID if different
//             // loginButton.click();
          
//             WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
//             loginButton.click();
//             // Wait for a few seconds (optional, can use WebDriverWait instead)
//             Thread.sleep(30000);

//             // Check login success (example: check title)
//             if (driver.getTitle().contains("Dashboard")) {
//                 System.out.println("Login successful!");
//             } else {
//                 System.out.println("Login failed!");
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Close the browser
//             driver.quit();
//         }
//     }
// }


// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import java.time.Duration;

// public class LoginTest {
//     public static void main(String[] args) {
//         // Set up ChromeDriver
//         System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

//         // Launch Chrome
//         WebDriver driver = new ChromeDriver();
        
//         try {
//             // Open login page
//             driver.get("http://164.160.187.141:8097/");
//             driver.manage().window().maximize();

//             // Add WebDriverWait
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//             // Wait and locate the username field
//             WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//             usernameField.sendKeys("admin@Lersha.com");

//             // Wait and locate the password field
//             WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//             passwordField.sendKeys("Admin@123");

//             // Wait and locate the "Sign in" button using text
//             WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
//             loginButton.click();

//             // Wait after login
//             Thread.sleep(300000);

//             // Check login success
//             if (driver.getTitle().contains("Dashboard")) {
//                 System.out.println("Login successful!");
//             } else {
//                 System.out.println("Login failed!");
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             driver.quit(); // Close the browser
//         }
//     }
// }


// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import java.time.Duration;

// public class LoginTest {
//     // ANSI escape code for green color
// final String GREEN = "\u001B[32m"; 
// final String RESET = "\u001B[0m";  // Reset the color to default
//     public static void main(String[] args) {
//         // Set up ChromeDriver
//         System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

//         // Launch Chrome
//         WebDriver driver = new ChromeDriver();
        
//         try {
//             // Open login page
//             driver.get("http://164.160.187.141:8097/");
//             driver.manage().window().maximize();

//             // Add WebDriverWait
//             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//             // Wait and locate the username field
//             WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//             usernameField.sendKeys("admin@Lersha.com");

//             // Wait and locate the password field
//             WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
//             passwordField.sendKeys("Admin@123");

//             // Wait and locate the "Sign in" button using text
//             WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
//             loginButton.click();

//             // Wait after login
//             Thread.sleep(3000);

//             // Check login success
//             if (driver.getTitle().contains("Dashboard")) {
//                 System.out.println("Login successful!");
//             } else {
//                 System.out.println("Login failed!");
//             }

//             // Add search functionality
            

// // Locate the search input field
// WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search farmer...']")));

// // Input the search term "Rachael Nolan Schuppe"
// searchInput.sendKeys("Rachael Nolan Schuppe");

// // Optionally, if you want to wait for the results to appear (you can customize this part based on how the results load)
// try {
//     // Wait for the search results to appear (adjust the XPath based on your page structure)
//     WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Rachael Nolan Schuppe')]")));

//     // If the result is found, print a success message
//     System.out.println("Search successful! Found: " + searchResult.getText());

// } catch (org.openqa.selenium.TimeoutException e) {
//     // If the result is not found within the time frame
//     System.out.println(GREEN +"Search attempted for: Rachael Nolan Schuppe" +RESET);

//     System.out.println("No results found for the search term.");
// }

// // Wait to observe the search result (optional, adjust the wait time if necessary)
// Thread.sleep(30000);

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

public class LoginTest {
    // ANSI escape code for green color
    static final String GREEN = "\u001B[32m"; 
    static final String RESET = "\u001B[0m";  // Reset the color to default
    static final String YELLOW = "\u001B[33m";  // ANSI escape code for yellow color
    static final String RED = "\u001B[31m";  // ANSI escape code for red color
    
    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open login page
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

            // Check login success
            if (driver.getTitle().contains("Dashboard")) {
                // Print success message in green
                System.out.println(GREEN + "Login successful!" + RESET);
            } else {
                // Print failure message in red
                System.out.println(RED + "Login failed!" + RESET);
            }

            // Add search functionality

            // Locate the search input field
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search farmer...']")));

            // Input the search term "Rachael Nolan Schuppe"
            searchInput.sendKeys("Rachael Nolan Schuppe");

            // Optionally, if you want to wait for the results to appear (you can customize this part based on how the results load)
            try {
                // Wait for the search results to appear (adjust the XPath based on your page structure)
                WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Rachael Nolan Schuppe')]")));

                // If the result is found, print a success message in green
                System.out.println(GREEN + "Search successful! Found: " + searchResult.getText() + RESET);

            } catch (org.openqa.selenium.TimeoutException e) {
                // If the result is not found within the time frame
                System.out.println(YELLOW + "Search attempted for: Rachael Nolan Schuppe" + RESET);

                System.out.println(RED + "No results found for the search term." + RESET);
            }

            // Wait to observe the search result (optional, adjust the wait time if necessary)
            Thread.sleep(30000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}

// // import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import java.time.Duration;

// public class LoginTest {
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
//             driver.get("http://164.160.187.141:8097/");
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
//             Thread.sleep(3000);

//             // Check for login success
//             if (driver.getTitle().contains("Dashboard")) {
//                 System.out.println(GREEN + "Login successful!" + RESET);
//             } else {
//                 System.out.println(RED + "Login failed!" + RESET);
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             driver.quit(); // Close browser
//         }
//     }
// }
