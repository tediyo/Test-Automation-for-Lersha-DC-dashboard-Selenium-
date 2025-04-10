

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicLoad {
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String YELLOW = "\u001B[33m"; // Yellow color for loading time

    public static void main(String[] args) {
        // Set path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");

        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open login page
            driver.get("http://51.21.130.55:8097/");
            driver.manage().window().maximize();

            // Wait setup
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increase timeout to 15 seconds

            // Input credentials
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("admin@Lersha.com");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("Admin@123");

            // Click login
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
            loginButton.click();

            // Small wait after login
            Thread.sleep(3000);

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

            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search partner']")));
            searchInput.clear();
            searchInput.sendKeys("251932797175");

            // Step 2: Wait for the table to load the results (ensure the table is visible)
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

            // Step 3: Wait for the search result to load (you can check for the visibility of a row or a specific element in the table)
            WebElement resultRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//table/tbody/tr[td[contains(text(),'251932797175')]]")
            ));

            // Step 4: Locate the eye button inside the specific row
            WebElement eyeButton = resultRow.findElement(By.xpath(".//td[6]/div/button[1]"));
            
            // Start time measurement for the eye button click
            long startTime = System.currentTimeMillis();

            // Step 5: Click the eye button
            eyeButton.click();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;  // Calculate loading time for eye button
            System.out.println(YELLOW + "Time taken to load Eye Button: " + duration + " ms" + RESET);

            // Wait for the "Company Detail" tab button to be clickable
            WebElement companyDetailTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space()='Company Detail']")
            ));

            // Start time measurement for Company Detail tab button click
            startTime = System.currentTimeMillis();

            // Optional: Scroll into view before clicking
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", companyDetailTab);
            Thread.sleep(3000); // Small wait in case of transitions

            // Click it using JS or normal click
            companyDetailTab.click();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for Company Detail tab button
            System.out.println(YELLOW + "Time taken to load 'Company Detail' tab: " + duration + " ms" + RESET);

            System.out.println(GREEN + "'Company Detail' tab clicked successfully!" + RESET);

            // Wait for the second button using full XPath
            // Wait until the Project List button is clickable by its visible text
            WebElement projectListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space(text())='Project List']")
            ));

            // Start time measurement for Project List button click
            startTime = System.currentTimeMillis();

            // Optional: Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectListButton);
            Thread.sleep(3000); // Wait a bit for scroll

            // Click the Project List button
            projectListButton.click();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for Project List button
            System.out.println(YELLOW + "Time taken to load 'Project List' button: " + duration + " ms" + RESET);

            System.out.println(GREEN + "Clicked the 'Project List' button successfully!" + RESET);

            WebElement row2Col5Button = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[3]/div/div[3]/div/div[2]/div/table/tbody/tr[2]/td[5]/div/button")
            ));

            // Start time measurement for Row 2 Column 5 button click
            startTime = System.currentTimeMillis();

            // Optional: Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", row2Col5Button);
            Thread.sleep(3000); // Brief pause to ensure scroll is done

            // Click the button
            row2Col5Button.click();
            Thread.sleep(3000);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for Row 2 Column 5 button
            System.out.println(YELLOW + "Time taken to load 'Row 2, Column 5' button: " + duration + " ms" + RESET);

            System.out.println(GREEN + "Clicked on RealPerformance Project, 5th column of the table!" + RESET);

            // Wait for the button to be clickable
            WebElement buttonToClick = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[2]")
            ));
            Thread.sleep(3000);

            // Start time measurement for button click
            startTime = System.currentTimeMillis();

            // Click the button
            buttonToClick.click();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for Agent button
            System.out.println(YELLOW + "Time taken to load 'Agent' button: " + duration + " ms" + RESET);

            System.out.println(GREEN + "Agent clicked successfully!" + RESET);

            WebElement buttonToClickForm = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[3]")
            ));
            Thread.sleep(3000);

            // Start time measurement for FormLists button click
            startTime = System.currentTimeMillis();

            // Click the button
            buttonToClickForm.click();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for FormLists button
            System.out.println(YELLOW + "Time taken to load 'FormLists' button: " + duration + " ms" + RESET);

            System.out.println(GREEN + "FormLists clicked successfully!" + RESET);

            WebElement buttonToClickfarmer = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[4]")
            ));
            Thread.sleep(3000);

            // Start time measurement for Farmer button click
            startTime = System.currentTimeMillis();

            // Click the button
            buttonToClickfarmer.click();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for Farmer button
            System.out.println(YELLOW + "Time taken to load 'Farmer' button: " + duration + " ms" + RESET);

            System.out.println(GREEN + "Farmer clicked successfully!" + RESET);

            WebElement buttonToClickFormback = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[3]")
            ));
            Thread.sleep(3000);

            // Start time measurement for FormListsBack button click
            startTime = System.currentTimeMillis();

            // Click the button
            buttonToClickFormback.click();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for FormListsBack button
            System.out.println(YELLOW + "Time taken to load 'FormListsBack' button: " + duration + " ms" + RESET);

            System.out.println(GREEN + "FormlistsBack clicked successfully!" + RESET);

            WebElement finalButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[5]/div/div[2]/div/div/div[1]/button")));
            js.executeScript("arguments[0].scrollIntoView(true);", finalButton);
            Thread.sleep(3000);

            // Start time measurement for Section button click
            startTime = System.currentTimeMillis();

            finalButton.click();
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;  // Calculate loading time for Section button
            System.out.println(YELLOW + "Time taken to load 'Section' button: " + duration + " ms" + RESET);

            System.out.println(GREEN + "✅ Section button clicked successfully!" + RESET);

            // WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"radix-:rn:-content-formList\"]/div/div[2]/div/div[2]/div[7]/div/div[2]/button[1]")));

            // // Start time measurement for EDIT button click
            // startTime = System.currentTimeMillis();

            // // Scroll the button into view before clicking
            // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
            // Thread.sleep(10000); // Wait for stabilization after scroll

            // try {
            //     // Try clicking the button
            //     button.click();
            //     Thread.sleep(20000);
            //     endTime = System.currentTimeMillis();
            //     duration = endTime - startTime;  // Calculate loading time for EDIT button
            //     System.out.println(YELLOW + "Time taken to load 'EDIT' button: " + duration + " ms" + RESET);
            //     System.out.println(GREEN + "✅ EDIT Button clicked successfully!" + RESET);
            // } catch (Exception e) {
            //     // Catch and log any errors if clicking fails
            //     System.out.println(RED + "❌ Click failed: " + e.getMessage()  + RESET);
            // }
// Locate the button element for the EDIT button
WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//*[@id=\"radix-:rn:-content-formList\"]/div/div[2]/div/div[2]/div[7]/div/div[2]/button[1]")));

// Start time measurement for the EDIT button click
 startTime = System.currentTimeMillis();  // Start time before scrolling

// Scroll the button into view before clicking
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
Thread.sleep(10000); // Wait for stabilization after scroll

try {
    // Try clicking the button
    button.click();
    Thread.sleep(20000); // Wait for any potential page load or effect after click
     endTime = System.currentTimeMillis(); // End time after clicking
     duration = endTime - startTime;  // Calculate loading time for EDIT button

    // Print the loading time for the button
    System.out.println(YELLOW + "Time taken to load 'EDIT' button: " + duration + " ms" + RESET);
    System.out.println(GREEN + "✅ EDIT Button clicked successfully!" + RESET);
} catch (Exception e) {
    // Catch and log any errors if clicking fails
    System.out.println(RED + "❌ Click failed: " + e.getMessage()  + RESET);
}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
