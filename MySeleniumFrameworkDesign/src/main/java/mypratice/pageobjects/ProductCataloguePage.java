package mypratice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myparctice.abstractconponents.AdstractComponent;

public class ProductCataloguePage extends AdstractComponent {
	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// List<WebElement> itemNames=driver.findElements(By.cssSelector(".mb-3"));
	// PageFactory
	@FindBy(css = ".mb-3")
	List<WebElement> itemNames;

	@FindBy(css = ".ng-animating")
	WebElement animation;
	By productsby = By.cssSelector(".mb-3");
	By itemtocart = By.cssSelector(".card-body button:last-of-type");
	By toast = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		elementToBeVisible(productsby);
		return itemNames;
	}

	public WebElement getProductByName(String myproductName) {

		WebElement myProduct = itemNames.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(myproductName)).findFirst()
				.orElse(null);

		return myProduct;

	}

	public void addProductToCart(String myproductName) {
		WebElement myProduct = getProductByName(myproductName);
		myProduct.findElement(itemtocart).click();
		elementToBeVisible(toast);
		elementToBeinVisible(animation);

	}

}
