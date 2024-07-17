package HandlingAjaxMouseInteractions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScrollWindowAndScrollDOM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]//td[4]"));
		int sum=0;
		for(int i=0;i<list.size();i++) {
			
			sum=sum+Integer.parseInt(list.get(i).getText());
			//System.out.println(sum);
		}
		System.out.println(sum);
		String total=driver.findElement(By.xpath("//div[@class=\"totalAmount\"]")).getText();
		String text=total.split(":")[1].trim();
		int num=Integer.parseInt(text);
		System.out.println(num);
		
		Assert.assertEquals(sum, num)
	
		;

	}

}
