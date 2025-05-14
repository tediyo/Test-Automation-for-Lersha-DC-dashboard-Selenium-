

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class bankDashboard {
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
            // 1-#########################################################Open login page

            driver.get("http://51.21.130.55:8094/");
            driver.manage().window().maximize();

            // Wait setup
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increase timeout to 15 seconds

            // Input credentials
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("admin@Lersha.com");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("Admin@123");
            long startTime = System.currentTimeMillis();
            // Click login
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")));
            loginButton.click();
            Thread.sleep(3000);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime; 
            if (driver.getTitle().contains("Data Collection Dashboard")) {
                System.out.println(GREEN + "1- Login successful!" + RESET);
            } else {
                System.out.println(RED + "1- Login failed!" + RESET);
            }
           
            System.out.println( "Time taken to Log In to the Dashboard: " + duration + " ms" );


            if (duration <= 3000) {
                System.out.println(GREEN + "⚡ Load Time: Fast" + RESET);
            } else if (duration <= 7000) {
                System.out.println("\u001B[33m" + "⏱️ Load Time: Medium" + RESET);
            } else {
                System.out.println(RED + "🐌 Load Time: Slow" + RESET);
            }
            // Small wait after login
            Thread.sleep(3000);

                       // 2-#########################################################Click 'Document Section' Button
                       long buttonClickStart = System.currentTimeMillis();

                       try {
                           WebElement documentSectionButton = wait.until(ExpectedConditions.elementToBeClickable(
                               By.xpath("//span[contains(text(),'Document Section')]/parent::button")
                           ));
                           documentSectionButton.click();
                           Thread.sleep(3000); // wait for any result after click (adjust if needed)
                           long buttonClickEnd = System.currentTimeMillis();
                           long buttonClickDuration = buttonClickEnd - buttonClickStart;
           
                           System.out.println(GREEN + "2- 'Document Section' button click successful!" + RESET);
                           System.out.println("Time taken to click 'Document Section': " + buttonClickDuration + " ms");
           
                           if (buttonClickDuration <= 3000) {
                               System.out.println(GREEN + "⚡ Button Response Time: Fast" + RESET);
                           } else if (buttonClickDuration <= 7000) {
                               System.out.println(YELLOW + "⏱️ Button Response Time: Medium" + RESET);
                           } else {
                               System.out.println(RED + "🐌 Button Response Time: Slow" + RESET);
                           }
           
                       } catch (Exception e) {
                           System.out.println(RED + "2- Failed to click 'Document Section' button!" + RESET);
                           e.printStackTrace();
                       }
                       // 3-#########################################################Click 'Farmer List' Link
                       long farmerListClickStart = System.currentTimeMillis();

                       try {
                           WebElement farmerListLink = wait.until(ExpectedConditions.elementToBeClickable(
                               By.xpath("//span[text()='Farmer List']/ancestor::a")
                           ));
                           farmerListLink.click();
                           Thread.sleep(3000); // Optional: wait for navigation or next content to load
                           long farmerListClickEnd = System.currentTimeMillis();
                           long farmerListClickDuration = farmerListClickEnd - farmerListClickStart;
           
                           System.out.println(GREEN + "3- 'Farmer List' link click successful!" + RESET);
                           System.out.println("Time taken to click 'Farmer List': " + farmerListClickDuration + " ms");
           
                           if (farmerListClickDuration <= 3000) {
                               System.out.println(GREEN + "⚡ Link Response Time: Fast" + RESET);
                           } else if (farmerListClickDuration <= 7000) {
                               System.out.println(YELLOW + "⏱️ Link Response Time: Medium" + RESET);
                           } else {
                               System.out.println(RED + "🐌 Link Response Time: Slow" + RESET);
                           }
           
                       } catch (Exception e) {
                           System.out.println(RED + "3- Failed to click 'Farmer List' link!" + RESET);
                           e.printStackTrace();
                       }
           
                       // 3-#########################################################Click 'Farmer List' Link
long farmerLinkClickStart = System.currentTimeMillis();

try {
    WebElement farmerListLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//span[text()='Farmer List']/ancestor::a")
    ));
    farmerListLink.click();
    Thread.sleep(3000); // Optional: wait for navigation or next content to load
    long farmerLinkClickEnd = System.currentTimeMillis();
    long farmerLinkClickDuration = farmerLinkClickEnd - farmerLinkClickStart;

    System.out.println(GREEN + "3- 'Farmer List' link click successful!" + RESET);
    System.out.println("Time taken to click 'Farmer List': " + farmerLinkClickDuration + " ms");

    if (farmerLinkClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Link Response Time: Fast" + RESET);
    } else if (farmerLinkClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Link Response Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Link Response Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "3- Failed to click 'Farmer List' link!" + RESET);
    e.printStackTrace();
}

           // 4-#########################################################Click 'View Farmer (Eye)' Button
long viewFarmerClickStart = System.currentTimeMillis();

try {
    WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("/html/body/div[2]/div/main/div/div/div[2]/div/table/tbody/tr[1]/td[7]/a/button")
    ));
    viewButton.click();
    Thread.sleep(5000); // Optional: wait for navigation to finish

    long viewFarmerClickEnd = System.currentTimeMillis();
    long viewFarmerClickDuration = viewFarmerClickEnd - viewFarmerClickStart;

    System.out.println(GREEN + "4- 'View Farmer' (eye icon) button click successful!" + RESET);
    System.out.println("Time taken to click 'View Farmer' button: " + viewFarmerClickDuration + " ms");

    if (viewFarmerClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Button Response Time: Fast" + RESET);
    } else if (viewFarmerClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Button Response Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Button Response Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "4- Failed to click 'View Farmer' button!" + RESET);
    e.printStackTrace();
}

// 5-#########################################################Click 'View Document' (eye icon) Button
long viewDocClickStart = System.currentTimeMillis();

try {
    WebElement viewDocButton = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.cssSelector("button[title='View document']")
    ));

    // Scroll into view and wait a bit
    js.executeScript("arguments[0].scrollIntoView(true);", viewDocButton);
    Thread.sleep(1000);

    // Try JS click first (works better for hidden or animated buttons)
    js.executeScript("arguments[0].click();", viewDocButton);
    Thread.sleep(3000); // Wait for document to load if needed

    long viewDocClickEnd = System.currentTimeMillis();
    long viewDocClickDuration = viewDocClickEnd - viewDocClickStart;

    System.out.println(GREEN + "5- 'View Document' button click successful!" + RESET);
    System.out.println("Time taken to click 'View Document' button: " + viewDocClickDuration + " ms");

    if (viewDocClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Button Response Time: Fast" + RESET);
    } else if (viewDocClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Button Response Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Button Response Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "5- Failed to click 'View Document' button!" + RESET);
    e.printStackTrace();
}

// 6-#########################################################Click Approve Button
long approveClickStart = System.currentTimeMillis();

try {
    // Wait for Approve button using its text and button tag
    WebElement approveButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[contains(text(), 'Approve')]")
    ));

    // Scroll into view
    js.executeScript("arguments[0].scrollIntoView(true);", approveButton);
    Thread.sleep(1000); // Wait briefly before clicking

    // Click using JavaScript (bypasses visual blockers)
    js.executeScript("arguments[0].click();", approveButton);
    Thread.sleep(3000); // Wait for action to complete

    long approveClickEnd = System.currentTimeMillis();
    long approveClickDuration = approveClickEnd - approveClickStart;

    System.out.println(GREEN + "6- 'Approve' button click successful!" + RESET);
    System.out.println("Time taken to click 'Approve' button: " + approveClickDuration + " ms");

    if (approveClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Approve Response Time: Fast" + RESET);
    } else if (approveClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Approve Response Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Approve Response Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "6- Failed to click 'Approve' button!" + RESET);
    e.printStackTrace();
}

// 7-#########################################################Click Fulfilled List
long fulfilledListClickStart = System.currentTimeMillis();

try {
    // Wait for Fulfilled List link by its visible text inside the <span>
    WebElement fulfilledListLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[span[contains(text(),'Fulfilled List')]]")
    ));

    // Scroll into view
    js.executeScript("arguments[0].scrollIntoView(true);", fulfilledListLink);
    Thread.sleep(1000);

    // Click using JavaScript
    js.executeScript("arguments[0].click();", fulfilledListLink);
    Thread.sleep(3000); // wait for page to load

    long fulfilledListClickEnd = System.currentTimeMillis();
    long fulfilledListClickDuration = fulfilledListClickEnd - fulfilledListClickStart;

    System.out.println(GREEN + "7- 'Fulfilled List' clicked successfully!" + RESET);
    System.out.println("Time taken to open 'Fulfilled List': " + fulfilledListClickDuration + " ms");

    if (fulfilledListClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Fulfilled List Load Time: Fast" + RESET);
    } else if (fulfilledListClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Fulfilled List Load Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Fulfilled List Load Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "7- Failed to click 'Fulfilled List'!" + RESET);
    e.printStackTrace();
}

// 9-#########################################################Click Reviewed List menu item
long reviewedListClickStart = System.currentTimeMillis();

try {
    // Wait for the Reviewed List link using visible text in <span>
    WebElement reviewedListLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[span[contains(text(),'Reviewed List')]]")
    ));

    // Scroll into view
    js.executeScript("arguments[0].scrollIntoView(true);", reviewedListLink);
    Thread.sleep(1000); // smooth scroll

    // Click with JavaScript to avoid any interception issues
    js.executeScript("arguments[0].click();", reviewedListLink);
    Thread.sleep(3000); // wait for navigation or content load

    long reviewedListClickEnd = System.currentTimeMillis();
    long reviewedListDuration = reviewedListClickEnd - reviewedListClickStart;

    System.out.println(GREEN + "9- 'Reviewed List' clicked successfully!" + RESET);
    System.out.println("Time taken to open 'Reviewed List': " + reviewedListDuration + " ms");

    if (reviewedListDuration <= 3000) {
        System.out.println(GREEN + "⚡ Reviewed List Load Time: Fast" + RESET);
    } else if (reviewedListDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Reviewed List Load Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Reviewed List Load Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "9- Failed to click 'Reviewed List'!" + RESET);
    e.printStackTrace();
}

// 10-#########################################################Click Loan Section
long loanSectionClickStart = System.currentTimeMillis();

try {
    // Locate the "Loan Section" span inside a button
    WebElement loanSectionButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[span[contains(text(), 'Loan Section')]]")
    ));

    // Scroll into view
    js.executeScript("arguments[0].scrollIntoView(true);", loanSectionButton);
    Thread.sleep(1000); // smooth scroll

    // Click using JavaScript
    js.executeScript("arguments[0].click();", loanSectionButton);
    Thread.sleep(3000); // wait for any sub-menu or section to load

    long loanSectionClickEnd = System.currentTimeMillis();
    long loanSectionDuration = loanSectionClickEnd - loanSectionClickStart;

    System.out.println(GREEN + "10- 'Loan Section' clicked successfully!" + RESET);
    System.out.println("Time taken to open 'Loan Section': " + loanSectionDuration + " ms");

    if (loanSectionDuration <= 3000) {
        System.out.println(GREEN + "⚡ Loan Section Load Time: Fast" + RESET);
    } else if (loanSectionDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Loan Section Load Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Loan Section Load Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "10- Failed to click 'Loan Section'!" + RESET);
    e.printStackTrace();
}

// 11-#########################################################Click Approved List
long approvedListClickStart = System.currentTimeMillis();

try {
    // Locate span text and click its parent
    WebElement approvedListSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//span[normalize-space(text())='Approved List']")
    ));

    // Click its parent <a> or <button> using JS
    WebElement parentElement = approvedListSpan.findElement(By.xpath("./ancestor::a | ./ancestor::button"));
    js.executeScript("arguments[0].scrollIntoView(true);", parentElement);
    Thread.sleep(1000);

    js.executeScript("arguments[0].click();", parentElement);
    Thread.sleep(3000); // wait for page load

    long approvedListClickEnd = System.currentTimeMillis();
    long approvedListDuration = approvedListClickEnd - approvedListClickStart;

    System.out.println(GREEN + "11- 'Approved List' clicked successfully!" + RESET);
    System.out.println("Time taken to open 'Approved List': " + approvedListDuration + " ms");

    if (approvedListDuration <= 3000) {
        System.out.println(GREEN + "⚡ Approved List Load Time: Fast" + RESET);
    } else if (approvedListDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Approved List Load Time: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Approved List Load Time: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "11- Failed to click 'Approved List'!" + RESET);
    e.printStackTrace();
}

// 12-######################################################### Click Eye Icon Button
// 12-######################################################### Click Eye Icon Link (Wrapped in <a>)
long viewBtnClickStart = System.currentTimeMillis();

try {
    long actionStart = System.currentTimeMillis();

    // Wait for the button to be present and clickable
    WebElement targetButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("/html/body/div[2]/div/main/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[7]/div/a/button")
    ));

    // Scroll into view using JavaScript
    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", targetButton);
    Thread.sleep(500); // wait for smooth scroll

    // Use JS click (more robust than .click())
    js.executeScript("arguments[0].click();", targetButton);

    long actionEnd = System.currentTimeMillis();
    long eyeduration = actionEnd - actionStart;

    System.out.println(GREEN + "✅ Target button clicked successfully!" + RESET);
    System.out.println("⏱️ Time taken: " + eyeduration + " ms");

    if (duration <= 3000) {
        System.out.println(GREEN + "⚡ Click Action: Fast" + RESET);
    } else if (eyeduration <= 7000) {
        System.out.println(YELLOW + "⏱️ Click Action: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Click Action: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "❌ Failed to click the target button!" + RESET);
    e.printStackTrace();
}


// 13-#########################################################Click Disburse Loan
long disburseLoanClickStart = System.currentTimeMillis();

try {
    // Locate button by visible text or part of SVG class
    WebElement disburseLoanButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//button[contains(., 'Disburse Loan')]")
    ));

    // Scroll and click with JS for reliability
    js.executeScript("arguments[0].scrollIntoView(true);", disburseLoanButton);
    Thread.sleep(1000); // smooth scroll

    js.executeScript("arguments[0].click();", disburseLoanButton);
    Thread.sleep(3000); // wait for action to complete

    long disburseLoanClickEnd = System.currentTimeMillis();
    long disburseLoanDuration = disburseLoanClickEnd - disburseLoanClickStart;

    System.out.println(GREEN + "12- 'Disburse Loan' button clicked successfully!" + RESET);
    System.out.println("Time taken to click 'Disburse Loan': " + disburseLoanDuration + " ms");

    if (disburseLoanDuration <= 3000) {
        System.out.println(GREEN + "⚡ Disburse Loan Action: Fast" + RESET);
    } else if (disburseLoanDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Disburse Loan Action: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Disburse Loan Action: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "12- Failed to click 'Disburse Loan' button!" + RESET);
    e.printStackTrace();
}

// 14-#########################################################Click Disburse Loan ( Yes/ No)

try {
    long okClickStart = System.currentTimeMillis();

    // Wait until the button with text 'Ok' and matching class is clickable
    WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[text()='Ok' and contains(@class, 'bg-[var(--primary)]')]")
    ));

    // Scroll into view and click using JavaScript (for consistency)
    js.executeScript("arguments[0].scrollIntoView(true);", okButton);
    Thread.sleep(300); // give scroll some time
    js.executeScript("arguments[0].click();", okButton);

    long okClickEnd = System.currentTimeMillis();
    long okClickDuration = okClickEnd - okClickStart;

    System.out.println(GREEN + "✅ 'Ok' button clicked successfully!" + RESET);
    System.out.println("⏱️ Time taken: " + okClickDuration + " ms");

    if (okClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Ok Button Action: Fast" + RESET);
    } else if (okClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Ok Button Action: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Ok Button Action: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "❌ Failed to click the 'Ok' button!" + RESET);
    e.printStackTrace();
}

// 15-######################################################### Rejected Loan ( Yes/ No)
try {
    long rejectedListClickStart = System.currentTimeMillis();

    // Wait for the "Rejected List" link to be clickable
    WebElement rejectedListLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[.//span[text()='Rejected List']]")
    ));
    Thread.sleep(5000);
    // Scroll into view and click using JavaScript
    js.executeScript("arguments[0].scrollIntoView(true);", rejectedListLink);
    Thread.sleep(300); // let it scroll
    js.executeScript("arguments[0].click();", rejectedListLink);

    long rejectedListClickEnd = System.currentTimeMillis();
    long rejectedListClickDuration = rejectedListClickEnd - rejectedListClickStart;

    System.out.println(GREEN + "✅ 'Rejected List' clicked successfully!" + RESET);
    System.out.println("⏱️ Time taken: " + rejectedListClickDuration + " ms");

    if (rejectedListClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Rejected List Click: Fast" + RESET);
    } else if (rejectedListClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Rejected List Click: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Rejected List Click: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "❌ Failed to click 'Rejected List'!" + RESET);
    e.printStackTrace();
}

// 15-######################################################### Disbursed Loan ( Yes/ No)

try {
    long disbursedListClickStart = System.currentTimeMillis();

    // Wait for the "Disbursed List" link to be clickable
    WebElement disbursedListLink = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//a[.//span[text()='Disbursed List']]")
    ));
    Thread.sleep(5000);
    // Scroll into view and click using JavaScript
    js.executeScript("arguments[0].scrollIntoView(true);", disbursedListLink);
    Thread.sleep(3000); // smooth scroll pause
    js.executeScript("arguments[0].click();", disbursedListLink);

    long disbursedListClickEnd = System.currentTimeMillis();
    long disbursedListClickDuration = disbursedListClickEnd - disbursedListClickStart;

    System.out.println(GREEN + "✅ 'Disbursed List' clicked successfully!" + RESET);
    System.out.println("⏱️ Time taken: " + disbursedListClickDuration + " ms");

    if (disbursedListClickDuration <= 3000) {
        System.out.println(GREEN + "⚡ Disbursed List Click: Fast" + RESET);
    } else if (disbursedListClickDuration <= 7000) {
        System.out.println(YELLOW + "⏱️ Disbursed List Click: Medium" + RESET);
    } else {
        System.out.println(RED + "🐌 Disbursed List Click: Slow" + RESET);
    }

} catch (Exception e) {
    System.out.println(RED + "❌ Failed to click 'Disbursed List'!" + RESET);
    e.printStackTrace();
}


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
