package mypratice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myparctice.abstractconponents.AdstractComponent;

public class PaymentPage extends AdstractComponent{
	
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")WebElement textfield;
	@FindBy(xpath="(//button[@type='button']/span)[2]")WebElement india;
	@FindBy(xpath="//a[contains(@class,'action__submit')]")WebElement submit;
	By countrylist=By.cssSelector("section .ta-results");
	
	
	public void getText(String text) {
		//scroll();
		Actions a=new Actions(driver);
		a.sendKeys(textfield, text).build().perform();
		elementToBeVisible(countrylist);
		india.click();
	}
	
	
	
	public FinalPage submit() {
		scroll();
		submit.click();
		//FinalPage finalpage=new FinalPage(driver);
		return new FinalPage(driver);
	}
	
	
	
	

}
