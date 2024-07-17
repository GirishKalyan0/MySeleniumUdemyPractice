package HandlingAjaxMouseInteractions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);
		WebElement hellosign = driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1"));
		WebElement textbox= driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		
		a.moveToElement(hellosign).build().perform();
		a.moveToElement(textbox).click().keyDown(Keys.SHIFT).sendKeys("bean bags").doubleClick().build().perform();
		a.moveToElement(hellosign).contextClick().build().perform();
		//Thread.sleep(3000);
//		List<WebElement> searchresults=driver.findElements(By.xpath("//div//span[@class=\"s-heavy\"]"));
//		for(WebElement searchresults1:searchresults) {
//			//List<WebElement> mysearch= driver.findElements(By.xpath("//div//span[@class=\"s-heavy\"]"));
//			if (searchresults1.getText().equalsIgnoreCase(" for adults")) {
//				System.out.println(searchresults1.getText());
//				searchresults1.click();
//				break;
//			}
//		}
		
		
	

	}

}
