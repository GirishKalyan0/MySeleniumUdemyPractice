package minusone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5 {

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
		driver.findElement(By.xpath("//a[@href=\"/nested_frames\"]")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name=\"frame-top\"]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name=\"frame-middle\"]")));
		WebElement middle=driver.findElement(By.id("content"));
		System.out.println(middle.getText());

	}

}
