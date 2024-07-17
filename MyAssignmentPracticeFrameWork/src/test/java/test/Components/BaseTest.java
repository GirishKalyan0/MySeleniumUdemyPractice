package test.Components;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;

	public  WebDriver invokeBrowser() throws IOException {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\assignmentResources\\Global.properties");
		prop.load(file);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		
		

	}else if(browserName.equalsIgnoreCase("edge")) {
		//edgecode
	}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		return driver;
		
		
	}
	
	@BeforeMethod
	public LandingPage navigateTo() throws IOException {
		driver=invokeBrowser();
		landingpage=new LandingPage(driver);
		landingpage.gotopage();
		
		return landingpage;
		
	}
	@AfterMethod
	public void closedriver() {
		driver.quit();
	}
	

}
