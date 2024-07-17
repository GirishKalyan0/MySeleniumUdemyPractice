package minusone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyPracticeAutosuggestions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options= new ChromeOptions();
		String[] st=new String[1];
		st[0]="--incognito";
		options.addArguments(st);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));// wait until the each element found
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys("Super Man");
		List<WebElement>options1=driver.findElements(By.cssSelector("ul[role=\"listbox\"] li"));
		
		for(WebElement option:options1) {
			if(option.getText().equalsIgnoreCase("superman logo")) {
				option.click();
				break;
			}
		}
		Thread.sleep(3000);

	}

}
