package HandlingAjaxMouseInteractions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyCalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String month="6";
		String day="15";
		String year="2027";
		String[] list= {month,day,year};
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[@href=\"#/offers\"]")).click();
		Iterator<String> windows=driver.getWindowHandles().iterator();
		String x1=windows.next();
		String x2=windows.next();
		driver.switchTo().window(x2);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for=\"deliveryDate\"]")));
		driver.findElement(By.xpath("//div[@class=\"react-date-picker__wrapper\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"react-calendar__navigation__label\"]")).click();
		driver.findElement(By.xpath("//span[@class=\"react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from\"]")).click();
		List<WebElement> years=driver.findElements(By.xpath("//button[@class=\"react-calendar__tile react-calendar__decade-view__years__year\"]"));
		for(int i=0;i<years.size();i++) {
			if(years.get(i).getText().equalsIgnoreCase(year)) {
				years.get(i).click();
				break;
			}
		}
//		List<WebElement> months=driver.findElements(By.xpath("//div[@class=\"react-calendar__year-view__months\"]/button"));
//		for(int i=0;i<months.size();i++) {
//			if(months.get(i).getText().equalsIgnoreCase(month)) {
//				months.get(i).click();
//				break;
//			}
//		}
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
		.get(Integer.parseInt(month) - 1).click();
		List<WebElement> days=driver.findElements(By.xpath("//div[@class=\"react-calendar__month-view__days\"]/button"));
		for(int i=0;i<days.size();i++) {
			if(days.get(i).getText().equalsIgnoreCase(day)) {
				days.get(i).click();
				break;
			}
		}
		List<WebElement> numbers=driver.findElements(By.xpath("//input[@inputmode=\"numeric\"]"));
		
		for(int i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i).getAttribute("value"));
			Assert.assertEquals(numbers.get(i).getAttribute("value"), list[i]);
		}
			
		
		//System.out.println(driver.findElement(By.xpath("//div[@class=\"react-date-picker__inputGroup\"]")).getText());

	}

}
