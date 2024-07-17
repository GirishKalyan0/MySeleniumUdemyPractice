package mypractice.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import myparctice.testcomponents.BaseTest;
import myparctice.testcomponents.Retry;
import mypratice.pageobjects.CartPage;
import mypratice.pageobjects.FinalPage;
import mypratice.pageobjects.PaymentPage;
import mypratice.pageobjects.ProductCataloguePage;

public class ErrorsHandingTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorCheck() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String myproductName = "ZARA COAT 3";
		String countryName = " India";

		landingpage.loginMethod("KKK1gdug1@nomail.com", "Kk@123]456");
		Assert.assertEquals("Incorrect email password.", landingpage.geterrormesaagetext());
		// div[contains(text(),'Incorrect email or password.')]

	}
	
	@Test
	public void ProductErrorCheck() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String myproductName = "ZARA COAT 3";
		String countryName = " India";

		ProductCataloguePage productcatalogue = landingpage.loginMethod("KK111@nomail.com", "Kk@123456");

		List<WebElement> itemNames = productcatalogue.getProductList();
		productcatalogue.addProductToCart(myproductName);
		CartPage cartpage = productcatalogue.clickOnCart();

		cartpage.getcartItemList();
		Boolean match = cartpage.matchMyProduct("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
