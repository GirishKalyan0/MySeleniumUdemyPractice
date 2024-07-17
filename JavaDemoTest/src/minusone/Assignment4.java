package minusone;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		System.setProperty("webdriver.chrom.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href=\"/windows\"]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/windows/new\"]")));
		driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
		Set<String>windows=driver.getWindowHandles();	
		Iterator<String>it=windows.iterator();
		String it1=it.next();
		String it2=it.next();
		driver.switchTo().window(it2);
		String text1=driver.findElement(By.cssSelector(".example")).getText();
		System.out.println(text1);
		driver.switchTo().window(it1);
		String text2=driver.findElement(By.cssSelector(".example h3")).getText();
		System.out.println(text2);
	}

}
