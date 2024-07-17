package minusone;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

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
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"] //a[@value=\"VTZ\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"ctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"PNQ\"]")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_0")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
			
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		for(int i=1;i<5;i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
		}
		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "9 Adult");
		
		
		driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\"]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\"]")).isSelected());
		
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		WebElement options1= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select option= new  Select(options1);
		Thread.sleep(2000);
		option.selectByVisibleText("USD");
		
		driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
		
		
		
		
		
		

	}

}
