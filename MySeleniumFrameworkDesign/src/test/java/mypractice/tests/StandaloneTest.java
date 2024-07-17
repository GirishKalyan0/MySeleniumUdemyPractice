package mypractice.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import mypratice.pageobjects.LandingPage;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String myproductName="ZARA COAT 3";
		String countryName=" India";
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(options);
	
		WebDriverWait x=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		
		
		
		driver.get("https://rahulshettyacademy.com/client/");//KKK11@nomail.com, Kk@123456
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("KKK11@nomail.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Kk@123456");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		
//		Thread.sleep(4000);
		
		List<WebElement> itemNames=driver.findElements(By.cssSelector(".mb-3"));
//		for(int i=0;i<itemNames.size();i++) {
//			if(itemNames.get(i).getText().equalsIgnoreCase("ZARA COAT 3")) {
//				
//			}
//		}
		
		WebElement myProduct=itemNames.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(myproductName)).findFirst().orElse(null);
		myProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		x.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		x.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//		Actions a=new Actions(driver);
//		a.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class=\"cartSection\"]/h3"));
		Boolean match=cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(myproductName));
		//System.out.println(match);
		Assert.assertTrue(true);
		x.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Checkout']")));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		   WebElement checkoutButton = x.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout']")));
          

           // Click the checkout button
           checkoutButton.click();
           
           driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("Ind");
          
   		js.executeScript("window.scrollBy(0,1000)");
   		x.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section .ta-results")));
		driver.findElement(By.xpath("(//button[@type='button']/span)[2]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
		
		String message= driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]")).getText();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	
		
		
	}

}
