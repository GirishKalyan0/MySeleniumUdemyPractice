package minusone;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvokingMultipleWindowsUsingOneDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\girishchandrac\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/angularpractice/");
		 
		 driver.switchTo().newWindow(WindowType.TAB);// or open new Window
		 
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String x=it.next();
		String x2=it.next();
		 
		 driver.switchTo().window(x2);
		 
		 driver.get("https://rahulshettyacademy.com/");
		 String text1=driver.findElement(By.xpath("//a[text()=\"Core java for Automation Testers + Interview Programs\"]")).getText();
		 System.out.println(text1);
		 driver.switchTo().window(x);
		 WebElement name =driver.findElement(By.xpath("//form//div//input[@name=\"name\"]"));
		 name.sendKeys(text1);
		 
		 //ScreenShot
		 File file=name.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file, new File("logo.png")); 
		 
		 //Height and width
		 float h= name.getRect().getDimension().getHeight();
		 float ww= name.getRect().getDimension().getWidth();
		 System.out.println(h+" "+ww);
		 
		 

	}

}
