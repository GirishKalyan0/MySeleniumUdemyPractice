package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import abstarctpages.Reusablepage;

public class CheckOutPage extends Reusablepage {
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[contains(@style,\"width: 200px;\")]")WebElement dropdown;
	@FindBy(xpath="//input[@type=\"checkbox\"]")WebElement checkbox;
	@FindBy(xpath="//button[text()=\"Proceed\"]")WebElement proceedbtn;
	By proceedbtn1=By.xpath("//button[text()=\"Proceed\"]");
	
	
	
	
	//WebElement dropdown=driver.findElement(By.xpath("//select[contains(@style,\"width: 200px;\")]"));
	
	
	
	public HomePage checkoutactions(String str) {
		Byelementtobedisplay(proceedbtn1);
		Select option=new Select(dropdown);
		option.selectByValue(str);
		checkbox.click();
		proceedbtn.click();
		return new HomePage(driver);
		
		
		
	}

}
