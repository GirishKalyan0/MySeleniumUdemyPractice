package minusone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestionOnType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		String[] st=new String[1];
		st[0]="--incognito";
		options.addArguments(st);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));// wait until the each element found
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id=\"autosuggest\"]")).sendKeys("Ind");
		List<WebElement> options1 =driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"] a"));
		for(WebElement option:options1) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		} 
		

	}

}
