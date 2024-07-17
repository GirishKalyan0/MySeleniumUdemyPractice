package mypratice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myparctice.abstractconponents.AdstractComponent;

public class LandingPage extends AdstractComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}

	
	//PageFactory
	@FindBy(xpath="//input[@type=\"email\"]")WebElement username;
	@FindBy(xpath="//input[@type=\"password\"]")WebElement userpassword;
	@FindBy(xpath="//input[@type=\"submit\"]")WebElement loginbutton;
	@FindBy(xpath="//div[contains(@class,\"ng-trigger-flyInOut\")]")WebElement errormessage;
	
	public ProductCataloguePage loginMethod(String email,String password) {
		username.sendKeys(email);
		userpassword.sendKeys(password);
		loginbutton.click();
		ProductCataloguePage productcatalogue=new ProductCataloguePage(driver);
		return productcatalogue;
	}
	
	public String geterrormesaagetext() {
		elementToBeVisible3(errormessage);
		errormessage.getText();
		return errormessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
		
	}

}
