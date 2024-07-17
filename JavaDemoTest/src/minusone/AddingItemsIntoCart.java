package minusone;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddingItemsIntoCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j=0;
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.cheom.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] neededItems= {"Cucumber","Brocolli","Carrot"};
		
		List<WebElement> items=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<items.size();i++) {
			String[] name=items.get(i).getText().split("-");
			String newname=name[0].trim();
			List itemsList= Arrays.asList(neededItems);
			if(itemsList.contains(newname)) {
				
				driver.findElements(By.xpath("//button[text()=\"ADD TO CART\"]")).get(i).click();
				j++;
				if(j==3) {
					break;
				}
			}
			
		}

	}

}
