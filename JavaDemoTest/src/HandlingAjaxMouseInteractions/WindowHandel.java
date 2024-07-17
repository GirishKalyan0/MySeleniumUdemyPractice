package HandlingAjaxMouseInteractions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@target=\"_blank\"]")).click();
		Set<String>windows= driver.getWindowHandles();
		Iterator<String>x=windows.iterator();
        String x1=x.next();
		String x2=x.next();
		driver.switchTo().window(x2);
		//String username =driver.findElement(By.xpath("//a[@href=\"mailto:mentor@rahulshettyacademy.com\"]")).getText();
		//String t=driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText().split("at")[1].trim().split(" ")[0];
		
		String username = driver.findElement(By.xpath("//p[@class=\"im-para red\"]")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println("Username: "+username);
		driver.switchTo().window(x1);
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
		
		
		
		
		

	}

}
