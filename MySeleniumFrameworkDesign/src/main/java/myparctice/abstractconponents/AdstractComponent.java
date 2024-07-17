package myparctice.abstractconponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mypratice.pageobjects.CartPage;
import mypratice.pageobjects.OrderPage;

public class AdstractComponent {
	WebDriver driver;
	@FindBy(css="[routerlink*='cart']")WebElement cartbutton;
	@FindBy(xpath="//button[@routerlink=\"/dashboard/myorders\"]")WebElement orderbtn;

	public AdstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void elementToBeVisible(By locate) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locate));
		
	}
	public void elementToBeVisible2(List<WebElement> cartItems) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
		
	}
	public void elementToBeinVisible(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public void elementToBeClickable(By ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	
	public void elementToBeVisible3(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
    public CartPage clickOnCart() {
		cartbutton.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
    
    public OrderPage clickOnOrders() {
    	orderbtn.click(); 
    	OrderPage orderpage=new OrderPage(driver);
		return orderpage;
    	}
    
	public void scroll() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	

}
