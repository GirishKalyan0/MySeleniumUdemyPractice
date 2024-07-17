package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstarctpages.Reusablepage;

public class HomePage extends Reusablepage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()=\"Top Deals\"]")WebElement offersbtn;
	By offersbtn1=By.xpath("//a[text()=\"Top Deals\"]");
	
	public OffersPage homepageactions() {
		Byelementtobedisplay(offersbtn1);
		offersbtn.click();
		return new OffersPage(driver);
	}

}
