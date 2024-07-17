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

public class MyScrollWindowAndScrollDOM {

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

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,700)");
		List<WebElement> prices = driver.findElements(By.xpath("//table[@class=\"table-display\"]//td[3]"));
		int sum = 0;
		for (int i = 0; i < prices.size(); i++) {
			Integer.parseInt(prices.get(i).getText());
			sum = sum + Integer.parseInt(prices.get(i).getText());
		}
		System.out.println(sum);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class=\"table-display\"]//tbody//tr"));
		int x = 0;
		for (int i = 0; i < rows.size(); i++) {
			x++;
			if (i == 2) {
				System.out.println(rows.get(i).getText());
			}

		}
		System.out.println(x);
		int y = 0;
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class=\"table-display\"]//tbody//tr//th"));
		for (int i = 0; i < columns.size(); i++) {
			y++;

		}
		System.out.println(y);

	}

}
