import java.time.Duration;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
// import org.openqa.selenium.devtools.v134.network.Network;
// import org.openqa.selenium.devtools.v134.network.model.Response;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServerTime {
    static final String GREEN = "\u001b[32m";
    static final String RESET = "\u001b[0m";
    static final String RED = "\u001b[31m";

    public static void main(String[] args) {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run without UI
        ChromeDriver driver = new ChromeDriver(options);

        // Extracting login details
        String url = "http://164.160.187.141:8097/";
        String username = "admin@Lersha.com";
        String password = "Admin@123";

        System.out.println(GREEN + "Extracted URL: " + url + RESET);
        System.out.println(GREEN + "Extracted Username: " + username + RESET);
        System.out.println(GREEN + "Extracted Password: " + password + RESET);

        // Enable Chrome DevTools Protocol (CDP) for measuring server response time
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));

        // Capture server response time (TTFB)
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            System.out.println(GREEN + "URL: " + res.getUrl() + RESET);
            System.out.println(GREEN + "Status Code: " + res.getStatus() + RESET);
            System.out.println(GREEN + "Response Time (TTFB): " + res.getTiming().getReceiveHeadersEnd() + " ms" + RESET);
        });

        try {
            driver.get(url);
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Enter username
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys(username);

            // Enter password
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys(password);

            // Click the Sign-in button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
            loginButton.click();

            Thread.sleep(3000);

            // Verify login success
            if (driver.getTitle().contains("Dashboard")) {
                System.out.println(GREEN + "Login successful!" + RESET);
            } else {
                System.out.println(RED + "Login failed!" + RESET);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}