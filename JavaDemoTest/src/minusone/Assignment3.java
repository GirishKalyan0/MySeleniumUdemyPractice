package minusone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Assignment3 xx= new Assignment3();
		MyMethod();

	}
	
	public static  void MyMethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		String text = driver.findElement(By.xpath("//p[@class=\"text-center text-white\"]")).getText();

		String[] text1 = text.split("and");

		
		String[] text2 = text1[0].split("is");

		String username = text2[1].trim();

		System.out.println("Username: "+username);

		String[] text3 = text1[1].split("is");
		String password = text3[1].replace(")", "").trim();
		System.out.println("Password: "+password);

		driver.findElement(By.cssSelector("input#username")).sendKeys(username);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value=\"user\"]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#okayBtn")));
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class=\"form-control\"]"));
		Select options1 = new Select(dropdown);
		options1.selectByValue("consult");

		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.cssSelector("input#signInBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")));

		List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"card h-100\"]"));

		for (int i = 0; i < products.size(); i++) {
			driver.findElements(By.xpath("//button[@class=\"btn btn-info\"]")).get(i).click();
		}

		driver.findElement(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")).click();
		
	}

}
