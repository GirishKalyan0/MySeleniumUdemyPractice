package minusone;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyParcticeAddingItemsIntoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int j=0;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver,chrome.driver", "C:\\\\Users\\\\girishchandrac\\\\Desktop\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//Thread.sleep(3000);	
		String[] products= {"Apple","Potato","Capsicum","Pomegranate"};
		
		List<WebElement> allProducts=driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
		
		for(int i=0;i<allProducts.size();i++) {
			String name = allProducts.get(i).getText();
			String[] x = name.split("-");
			String newname=x[0].trim();
			
			List<String> newlist=Arrays.asList(products);
			
			if(newlist.contains(newname)) {
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				j++;
				
				if(j==products.length) {
					break;
				}
			}
		
		}
		

	}

}
