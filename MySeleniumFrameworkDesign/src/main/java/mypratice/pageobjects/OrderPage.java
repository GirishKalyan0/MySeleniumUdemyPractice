package mypratice.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myparctice.abstractconponents.AdstractComponent;

public class OrderPage extends AdstractComponent{
	
	public WebDriver driver;
	

	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")List<WebElement> orderedpdtNames;
	
//	public List<WebElement> getcartItemList() {
//		elementToBeVisible2(cartItems);
//		return cartItems;
//	}
	
	
	
	public Boolean verifyOrderDisplay(String myproductName) {
		Boolean match=orderedpdtNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(myproductName));
		
		return match;
	}

}
