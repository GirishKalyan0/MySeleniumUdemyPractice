package HandlingAjaxMouseInteractions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPracticeScope {

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
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println(driver.findElements(By.xpath("//div[@id=\"gf-BIG\"]//a")).size());
		List<WebElement> links = driver.findElements(By.xpath("//div[@id=\"gf-BIG\"]//td[1]//a"));
		System.out.println(links.size());

		for (int i = 1; i < links.size(); i++) {
			String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(click);

			Iterator<String> windows = driver.getWindowHandles().iterator();
			// windows.hasNext();
			String jump = windows.next();
			String jump2 = windows.next();
			driver.switchTo().window(jump2);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(jump);

		}
		driver.quit();

	}

}
