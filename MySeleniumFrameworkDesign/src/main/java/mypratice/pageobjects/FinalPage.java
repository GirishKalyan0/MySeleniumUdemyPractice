package mypratice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import myparctice.abstractconponents.AdstractComponent;

public class FinalPage extends AdstractComponent{
	
	WebDriver driver;
	public FinalPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class=\"hero-primary\"]")WebElement message;
	
	
	
	
	public String getText1() {
		String text=message.getText();
		return text;
		}
	
	
	
	

}
