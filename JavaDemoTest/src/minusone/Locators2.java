package minusone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Locators2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options= new ChromeOptions();
		String[] st=new String[1];
		st[0]="--incognito";
		options.addArguments(st);
		
		
		//options.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));// wait until the each element found
		
		driver.manage().window().maximize();
		
		String name = "girish";
		Locators2 x = new Locators2();
		String password=x.getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1500);
		String text=driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(text, "You are successfully logged in.");
		System.out.println(text);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.login-container h2")).getText(), "Hello "+name+",");
		driver.findElement(By.cssSelector(".logout-btn")).click();	
		
		
		
		
		
	}
	
	public String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordtext= driver.findElement(By.cssSelector("p.infoMsg")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray= passwordtext.split("'");
		//rahulshettyacademy' to Login.
		String x= passwordArray[1].split("'")[0];
		return x;
	}

}
