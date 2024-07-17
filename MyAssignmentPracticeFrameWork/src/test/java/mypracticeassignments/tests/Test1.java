package mypracticeassignments.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\girishchandrac\\\\Desktop\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		String[] products = { "Apple", "Potato", "Capsicum", "Pomegranate" };

		addItems(driver, products);
		driver.findElement(By.xpath("//a[@class=\"cart-icon\"]")).click();
		driver.findElement(By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"promoCode\"]")));
		driver.findElement(By.xpath("//input[@class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class=\"promoBtn\"]")).click();

		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"promoInfo\"]")));
		System.out.println(driver.findElement(By.xpath("//span[@class=\"promoInfo\"]")).getText());

	}

	public static void addItems(WebDriver driver, String[] products) {
		
		int j = 0;
		List<WebElement> allProducts = driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
		for (int i = 0; i < allProducts.size(); i++) {
			String name = allProducts.get(i).getText();
			String[] x = name.split("-");
			String newname = x[0].trim();

			List<String> newlist = Arrays.asList(products);

			if (newlist.contains(newname)) {
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				j++;

				if (j == products.length) {
					break;

				}
			}
		}
	}

}
