package PageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void gotopage() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	}
	//getItems(driver, products);
	
	@FindBy(xpath="//img[@alt=\"Cart\"]")WebElement cartbutton;
	@FindBy(xpath="//button[text()=\"PROCEED TO CHECKOUT\"]")WebElement checkoutbutton;
	@FindBy(xpath="//div/div[@class=\"product\"]//h4")List<WebElement> allvegies;
	@FindBy(xpath="//div[@class=\"product-action\"]/button")List<WebElement> addtocartbutton ;
	//By addtocartbutton1=By.xpath("//div[@class=\"product-action\"]/button");
	
	
	
	public void getItems(String[] products) {
		int j = 0;
		
		for (int i = 0; i < allvegies.size(); i++) {
			String x = allvegies.get(i).getText().split("-")[0].trim();
			// System.out.println(x);
			List<String> newlist = Arrays.asList(products);

			if (newlist.contains(x)) {
				addtocartbutton.get(i).click();
				j++;
				if (j == products.length) {
					break;
				}
			}
		}
	}
	
	public CartPage clickbuttons() {
		cartbutton.click();
		checkoutbutton.click();
		return new CartPage(driver);
		
		
	}

	

}
