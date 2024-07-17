package Maven_Testng.Maven_Testng;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class StreamsExampleWebpage {
	
@Test
	public void StreamEx() {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		 
		 driver.findElement(By.xpath("//th[contains (@aria-label,\"Veg/fruit name\")]")).click();
		 
		List<WebElement> items= driver.findElements(By.xpath("//tr/td[1]"));
		
		List <String>itemLists=items.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(itemLists);
		
		List<String>newList=itemLists.stream().sorted().collect(Collectors.toList());
		System.out.println(newList);
		Assert.assertTrue(itemLists.equals(newList));
		
		List <String> price;
		
		do {
		//to grabe the price of particular veggie
			List<WebElement> itemsrows= driver.findElements(By.xpath("//tr/td[1]"));
		price= itemsrows.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getPriceOfItem(s)).collect(Collectors.toList());
		
		price.forEach(s->System.out.println(s));
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label=\"Next\"]")).click();
		}
		
		}while(price.size()<1);
		
		

	}

private static  String getPriceOfItem(WebElement s) {
	// TODO Auto-generated method stub
	 String itemprice=s.findElement(By.xpath("following-sibling::td[1]")).getText();
	 
	
	return itemprice;
}

}
