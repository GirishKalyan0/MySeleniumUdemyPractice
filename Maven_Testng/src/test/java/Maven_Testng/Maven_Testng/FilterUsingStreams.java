package Maven_Testng.Maven_Testng;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FilterUsingStreams {
	@Test

	public void Filter() {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		 
		 driver.findElement(By.xpath("//input[@id=\"search-field\"]")).sendKeys("Rice");
		List<WebElement> items= driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> names=items.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(items.size(), names.size());
		
		
		
		 

	}

}
