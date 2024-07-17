package PageObjects;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstarctpages.Reusablepage;

public class OffersPage extends Reusablepage{
	
	WebDriver driver;

	public OffersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()=\"Veg/fruit name\"]")WebElement sortbtn;

	
	
	public void offerpageactions() {
		switchWindow();
	    sortbtn.click();
	}
}
