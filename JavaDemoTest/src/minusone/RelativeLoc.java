package minusone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement Namefield= driver.findElement(By.cssSelector("[name='name']"));
		
		String name=driver.findElement(with(By.tagName("label")).above(Namefield)).getText();
		System.out.println(name);
		
		WebElement name2= driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(name2)).click();
		
		WebElement text = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(text)).click();
		
		WebElement x=driver.findElement(By.id("inlineRadio1"));
		String mm=driver.findElement(with(By.tagName("label")).toRightOf(x)).getText();
		System.out.println(mm);

	}

}
