package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstarctpages.Reusablepage;

public class CartPage extends Reusablepage{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class=\"promoCode\"]")WebElement promocode;
	@FindBy(xpath="//button[@class=\"promoBtn\"]")WebElement promocodebutton;
	@FindBy(xpath="//span[@class=\"promoInfo\"]")WebElement promoinfoText;
	@FindBy(xpath="//button[text()=\"Place Order\"]")WebElement placeorderbtn;
	By prmocodevisible=By.xpath("//input[@class=\"promoCode\"]");
	By prmocodevinfo=By.xpath("//span[@class=\"promoInfo\"]");
	

	
	
	
	
	public CheckOutPage cartpageactions(String str) {
		Byelementtobedisplay(prmocodevisible);
		promocode.sendKeys(str);
		promocodebutton.click();
		Byelementtobedisplay(prmocodevinfo);
		String text=promoinfoText.getText();
		System.out.println(text);
		placeorderbtn.click();
		return new CheckOutPage(driver);
		
	}
	

}
