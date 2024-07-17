package minusone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name="United States (USA)";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@id=\"autocomplete\"]")).sendKeys("Uni");
		List<WebElement> names = driver.findElements(By.xpath("//ul[@id=\"ui-id-1\"]//li//div"));
		for(int i=0;i<names.size();i++) {
			
			if(names.get(i).getText().equalsIgnoreCase(name)) {
				names.get(i).click();
			}
		}
		System.out.println( driver.findElement(By.xpath("//input[@id=\"autocomplete\"]")).getAttribute("value"));
		

	}

}
