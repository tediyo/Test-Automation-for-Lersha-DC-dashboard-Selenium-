import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

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
            // Wait and locate the "Farmers" link
           WebElement farmersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/dashboard/farmer')]")));
           farmersLink.click();

           // Wait until the button with both the class and the SVG path is clickable
           
           

            Thread.sleep(3000);

            // WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'lucide-chevron-down')]")));
            // dropdownButton.click();
            // Locate the Start Date input field
            WebElement startDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("startDate")));
            startDateInput.sendKeys("03-14-2025");  // Change the date as needed

            // Locate the End Date input field
            WebElement endDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("endDate")));
            endDateInput.sendKeys("03-25-2025");  // Change the date as needed

            // Optionally, trigger a search event (if required)
            // WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
            // searchButton.click();

            // Wait for results to load
            Thread.sleep(4000); // Adjust based on the actual response time

            // Verify if results are found
            // try {
            //     WebElement resultList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-results']")));
            //     System.out.println(GREEN + "Farmers filtered successfully!" + RESET);
            // } catch (org.openqa.selenium.TimeoutException e) {
            //     System.out.println(RED + "No farmers found for the selected date range!" + RESET);
            // }

            try {
                // Wait for the table of search results to be visible using the provided XPath
                WebElement resultTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/main/div/div[2]/div/div[3]/div[1]/div/table/tbody")));
                System.out.println(GREEN + "Farmers filtered successfully!" + RESET);

                // Fetch all the filtered farmer rows from the table
                List<WebElement> rows = resultTable.findElements(By.xpath(".//tr")); // Get all rows inside the tbody

                if (rows.size() > 1) {
                    System.out.println(GREEN + rows.size() + " farmers found!" + RESET); // Green color for success
                } else {
                    System.out.println(RED + "No farmers found for the selected date range!" + RESET); // Red color for failure
                }

                // Optionally, validate that each row contains the expected filtered data
                // for (WebElement row : rows) {
                //     if (!row.getText().contains("Amandf Fbaddba Duddcu" , "Zeleke Feleke Deleke", "Alemu Gam BA")) {
                //         System.out.println(RED + "Unexpected row data: " + row.getText() + RESET); // Red color for unexpected data
                //     }
                // }

                // List of expected names to check
String[] expectedNames = {"Amandf Fbaddba Duddcu", "Zeleke Feleke Deleke", "Alemu Gam BA","Utst Utst Utst"};

for (WebElement row : rows) {
    String rowText = row.getText();
    
    boolean found = false;
    for (String name : expectedNames) {
        if (rowText.contains(name)) {
            found = true;
            break; // Exit loop if any of the names match
        }
    }

    if (!found) {
        System.out.println(RED + "Unexpected row data: " + row.getText() + RESET); // Red color for unexpected data
    }
}


            } catch (org.openqa.selenium.TimeoutException e) {
                System.out.println(RED + "No farmers found for the selected date range!" + RESET); // Red color for timeout
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}


/////////////////////************************************************************************ */
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import java.time.Duration;

// public class farmers {
//     // ANSI color codes
//     static final String GREEN = "\u001B[32m";  // Green color for success
//     static final String RED = "\u001B[31m";    // Red color for failure
//     static final String YELLOW = "\u001B[33m"; // Yellow for warnings
//     static final String RESET = "\u001B[0m";   // Reset color

//     public static void main(String[] args) {
//         // Set up ChromeDriver
//         System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

//         // Launch Chrome
//         WebDriver driver = new ChromeDriver();

//         try {
//             // Open the login page
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

//             // Wait and locate the "Farmers" link
//             WebElement farmersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/dashboard/farmer')]")));
//             farmersLink.click();

//             // Wait for the dropdown button (with the chevron icon) to appear and click it
//             WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'lucide-chevron-down')]")));
//             dropdownButton.click();

//             // Wait for the start date input field to be visible and locate it
//             WebElement startDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("startDate")));
//             String startDate = "2024-03-01";  // Example start date
//             startDateInput.sendKeys(startDate);

//             // Wait for the end date input field to be visible and locate it
//             WebElement endDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("endDate")));
//             String endDate = "2024-03-31";  // Example end date
//             endDateInput.sendKeys(endDate);

//             // Check for valid date range
//             if (isValidDateRange(startDate, endDate)) {
//                 // Wait for results to load (adjust based on actual load time)
//                 Thread.sleep(5000); // Adjust based on the actual response time

//                 // Try to locate search results (adjust the XPath based on the structure)
//                 try {
//                     WebElement resultList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-results']")));
//                     if (resultList.isDisplayed()) {
//                         System.out.println(GREEN + "Farmers filtered successfully between " + startDate + " and " + endDate + "!" + RESET);
//                     }
//                 } catch (org.openqa.selenium.TimeoutException e) {
//                     System.out.println(RED + "No farmers found for the selected date range between " + startDate + " and " + endDate + "." + RESET);
//                 }
//             } else {
//                 // Handle invalid date range scenario
//                 System.out.println(RED + "Invalid date range! The start date cannot be later than the end date." + RESET);
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             driver.quit(); // Close the browser
//         }
//     }

//     // Method to validate the date range
//     private static boolean isValidDateRange(String startDate, String endDate) {
//         return startDate.compareTo(endDate) <= 0;
//     }
// }
