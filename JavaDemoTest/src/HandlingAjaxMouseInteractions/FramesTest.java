package HandlingAjaxMouseInteractions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());//to know how many iframes are present in webpage
		//driver.switchTo().frame(0); NOT Recommended
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]")));
		WebElement part1=driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement part2=driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		Actions a=new Actions(driver);
		
		a.dragAndDrop(part1, part2).build().perform();
		driver.switchTo().defaultContent();		
		

	}

}
