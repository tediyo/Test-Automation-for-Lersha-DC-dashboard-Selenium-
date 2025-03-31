import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Open Google
        driver.get("https://www.google.com");

        // Find the search bar, enter "Chelsea FC", and submit
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Tewodros Berhanu ");
        searchBox.submit();

        // Wait for results to load
        try { Thread.sleep(20000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Check if the title contains "Google"
        if (driver.getTitle().contains("Google")) {
            System.out.println("Test Passed: Google is in the title");
        } else {
            System.out.println("Test Failed: Title does not contain Google");
        }

        // Close browser
        driver.quit();
    }
}
