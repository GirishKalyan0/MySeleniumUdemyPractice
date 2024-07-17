package minusone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		String[] st=new String[1];
		st[0]="--incognito";
		options.addArguments(st);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));// wait until the each element found
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//form/div/input[@name=\"name\"]")).sendKeys("Girish Kalyan");
		driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("girishkalyan@nomail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Kk@12345");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticdropdown=driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown=new Select(staticdropdown);
		dropdown.selectByVisibleText("Female");
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("12/04/1999");
		
		driver.findElement(By.xpath("//input[@value=\'Submit\']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("div[class*=\"dismissible\"]")).getText());
		
		
		
		

	}

}
