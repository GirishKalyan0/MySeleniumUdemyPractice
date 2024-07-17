package HandlingAjaxMouseInteractions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenURL {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 //String link=driver.findElement(By.xpath("//a[contains(@href,\"restapi\")]")).getAttribute("href");
//		HttpURLConnection con = (HttpURLConnection) new URL(link).openConnection();
//		con.setRequestMethod("HEAD");
//		con.connect();
//		int respcode=con.getResponseCode();
//		System.out.println(respcode);
		
		List<WebElement> links=driver.findElements(By.xpath("//li[@class=\"gf-li\"]//a"));
		SoftAssert a=new SoftAssert();
		for(int i=0;i<links.size();i++) {
			String link=links.get(i).getAttribute("href");
			HttpURLConnection con = (HttpURLConnection) new URL(link).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int respcode=con.getResponseCode();
			System.out.println(respcode);
			a.assertTrue(respcode<400, "\"Failed Link\"+links.get(i).getText()+\"with responsecode\"+respcode");
//			if(respcode<400) {
//				Assert.assertTrue(true);
//				
//			}else {
//				Assert.assertTrue(false);
//				System.out.println("Failed Link"+links.get(i).getText()+"with responsecode"+respcode);
//			}
//			
			
		}
		a.assertAll();

	}

}
