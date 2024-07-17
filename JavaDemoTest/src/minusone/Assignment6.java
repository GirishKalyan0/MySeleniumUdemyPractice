package minusone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id=\"checkBoxOption2\"]")).click();
		String text1 = driver.findElement(By.xpath("//label[@for=\"benz\"]")).getText();
		System.out.println(text1);
		WebElement options1= driver.findElement(By.xpath("//select[@id=\"dropdown-class-example\"]"));
		Select dropdown= new Select(options1);
		dropdown.selectByVisibleText(text1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(text1);
		driver.findElement(By.xpath("//input[@id=\"confirmbtn\"]")).click();
		String text2=driver.switchTo().alert().getText();
		System.out.println(text2);
		if(text2.contains(text1)) {
			
			driver.switchTo().alert().accept();
		}else {
			driver.close();
		}
		

	}

}
