package minusone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		String[] st=new String[1];
		st[0]="--incognito";
		options.addArguments(st);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));// wait until the each element found
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("label input[id=\"checkBoxOption1\"]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("label input[id=\"checkBoxOption1\"]")).isSelected());
		driver.findElement(By.cssSelector("label input[id=\"checkBoxOption1\"]")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("label input[id=\"checkBoxOption1\"]")).isSelected());
		System.out.println(driver.findElements(By.xpath("//label//input[@type=\"checkbox\"]")).size());
		
		

	}

}
