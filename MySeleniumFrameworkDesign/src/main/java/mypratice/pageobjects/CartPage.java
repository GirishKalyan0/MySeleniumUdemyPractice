package mypratice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myparctice.abstractconponents.AdstractComponent;

public class CartPage extends AdstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}

	
	//PageFactory
	@FindBy(xpath="//div[@class=\"cartSection\"]/h3")List<WebElement> cartItems;
	@FindBy(xpath="//button[text()='Checkout']")WebElement checkoutbutton1;
	By checkoutbutton=By.xpath("//button[text()='Checkout']");

	
	//List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class=\"cartSection\"]/h3"));
	
	public List<WebElement> getcartItemList() {
		elementToBeVisible2(cartItems);
		return cartItems;
		
		
	}
	
	public Boolean matchMyProduct(String myproductName) {
		Boolean match=cartItems.stream().anyMatch(product->product.getText().equalsIgnoreCase(myproductName));
		
		return match;
	}
	public PaymentPage checkout() {
		scroll();
		elementToBeClickable(checkoutbutton);
		checkoutbutton1.click();
		//PaymentPage pagementpage=new PaymentPage(driver);
		return new PaymentPage(driver);
	}

}
