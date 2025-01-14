package LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

public class LoginTest {

    @Test
    public void testLogin() {
        // Use WebDriverManager to automatically handle the ChromeDriver setup
        WebDriverManager.chromedriver().setup();

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("http://example.com/login");

            // Verify that the page title contains "Login"
            Assertions.assertTrue(driver.getTitle().contains("Login"));

            // Find the username, password fields, and the login button
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login"));

            // Enter credentials and click the login button
            username.sendKeys("user123");
            password.sendKeys("password123");
            loginButton.click();

            // Wait for the next page to load
            Thread.sleep(3000);  // This is for simulation; better would be to use WebDriverWait

            // Verify that the page title contains "Dashboard" after login
            Assertions.assertTrue(driver.getTitle().contains("Dashboard"));

            // Print success message if the test passes
            System.out.println("Test case: Đăng nhập thành công - PASS");
        } catch (Exception e) {
            // If an error occurs, print failure message
            System.out.println("Test case: Đăng nhập thành công - FAIL");
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}