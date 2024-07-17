package minusone;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class UpdatedDropDowns {

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
		
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for(int i=1;i<5;i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
		}
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "9 Adult");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\"]")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\"]")).isSelected());
		driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\"]")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\"]")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\"]")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value=\"VTZ\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"PNQ\"]")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
			
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		
		
		
		
		

	}

}
