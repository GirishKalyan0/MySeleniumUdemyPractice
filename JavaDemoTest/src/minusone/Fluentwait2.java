package minusone;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Fluentwait2 {

    public static void main(String[] args) {
        // Set up Chrome options for incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // Specify the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the desired URL
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Click the start button to initiate loading
        driver.findElement(By.cssSelector("div#start button")).click();

        // Set up Fluent Wait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  // Total wait time
                .pollingEvery(Duration.ofSeconds(3))  // Check every 3 seconds
                .ignoring(NoSuchElementException.class);  // Ignore NoSuchElementException

        // Wait until the element is visible and get it
        WebElement foo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));

        // Print the visibility status of the element
        System.out.println(foo.getText());
        System.out.println(foo.isDisplayed());

        // Close the browser
        driver.quit();
    }
}