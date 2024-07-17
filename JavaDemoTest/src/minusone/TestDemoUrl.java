package minusone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestDemoUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		String[] st=new String[1];
		st[0]="--incognito";
		options.addArguments(st);
		
		
		//options.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		System.out.println("Girish");
		
		
		//Fire Fox  called gecko driver
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
//		WebDriver driver1 = new FirefoxDriver();
//		driver1.manage().window().maximize();
//		driver1.get("https://rahulshettyacademy.com");
//		System.out.println(driver1.getTitle());
//		System.out.println(driver1.getCurrentUrl());
//		System.out.println("Girish");
		
		//Edge Browser
		System.setProperty("webdriver.edge.driver", "C:\\Users\\girishchandrac\\Desktop\\msedgedriver.exe");
		WebDriver driver1 = new EdgeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://rahulshettyacademy.com");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());		
		System.out.println("Girish");
		
		
		
		//driver.close();
		driver1.quit();
		driver.quit();

	}

	
}
