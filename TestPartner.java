import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TestPartner {
    static final String GREEN = "\u001B[32m";
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";

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
        
            // Step 5: Click the eye button
            eyeButton.click();
            System.out.println(GREEN + "Eye button clicked successfully!" + RESET);
        

                // Wait for the "Company Detail" tab button to be clickable
WebElement companyDetailTab = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//button[normalize-space()='Company Detail']")
));

// Optional: Scroll into view before clicking
((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", companyDetailTab);
Thread.sleep(3000); // Small wait in case of transitions

// Click it using JS or normal click
companyDetailTab.click(); // or use JS click if needed
// ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", companyDetailTab);

System.out.println(GREEN + "'Company Detail' tab clicked successfully!" + RESET);

// Wait for the second button using full XPath
// Wait until the Project List button is clickable by its visible text
WebElement projectListButton = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//button[normalize-space(text())='Project List']")
));

// Optional: Scroll into view
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", projectListButton);
Thread.sleep(3000); // Wait a bit for scroll

// Click the Project List button
projectListButton.click();

System.out.println(GREEN + "Clicked the 'Project List' button successfully!" + RESET);

WebElement row2Col5Button = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[3]/div/div[3]/div/div[2]/div/table/tbody/tr[2]/td[5]/div/button")
));

// Optional: Scroll into view
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", row2Col5Button);
Thread.sleep(3000); // Brief pause to ensure scroll is done

// Click the button
row2Col5Button.click();
Thread.sleep(3000);
//System.out.println(GREEN + "Clicked the button in row 2, column 5 of the table!" + RESET);

System.out.println(GREEN + "Clicked on RealPerformance Project, 5th column of the table!" + RESET);


// Wait for the button to be clickable
WebElement buttonToClick = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[2]")
));
Thread.sleep(3000);
// Click the button
buttonToClick.click();
System.out.println(GREEN + "Agent clicked successfully!" + RESET);


WebElement buttonToClickForm = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[3]")
));
Thread.sleep(3000);
// Click the button
buttonToClickForm.click();
System.out.println(GREEN + "Agent clicked successfully!" + RESET);

WebElement buttonToClickfarmer = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[4]")
));
Thread.sleep(3000);
// Click the button
buttonToClickfarmer.click();
System.out.println(GREEN + "Agent clicked successfully!" + RESET);

WebElement buttonToClickFormback = wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("/html/body/div[2]/div/main/div[2]/div/div[1]/button[3]")
));
Thread.sleep(3000);
// Click the button
buttonToClickFormback.click();
System.out.println(GREEN + "Agent clicked successfully!" + RESET);

WebElement finalButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("/html/body/div[2]/div/main/div[2]/div/div[5]/div/div[2]/div/div/div[1]/button")));
js.executeScript("arguments[0].scrollIntoView(true);", finalButton);
Thread.sleep(3000);
finalButton.click();
System.out.println(GREEN + "✅ Final button clicked successfully!" + RESET);


WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"radix-:rn:-content-formList\"]/div/div[2]/div/div[2]/div[7]/div/div[2]/button[1]")));

// Scroll the button into view before clicking
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
Thread.sleep(10000); // Wait for stabilization after scroll

try {
    // Try clicking the button
    button.click();
    Thread.sleep(10000);
    System.out.println(GREEN + "✅ Button clicked successfully!" + RESET);
} catch (Exception e) {
    // Catch and log any errors if clicking fails
    System.out.println(RED + "❌ Click failed: " + e.getMessage()  + RESET);
}






 /*********************************** */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
