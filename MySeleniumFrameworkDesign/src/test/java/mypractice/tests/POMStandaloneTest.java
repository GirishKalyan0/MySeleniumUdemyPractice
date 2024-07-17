package mypractice.tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import myparctice.testcomponents.BaseTest;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import mypratice.pageobjects.CartPage;
import mypratice.pageobjects.FinalPage;
import mypratice.pageobjects.LandingPage;
import mypratice.pageobjects.OrderPage;
import mypratice.pageobjects.PaymentPage;
import mypratice.pageobjects.ProductCataloguePage;

public class POMStandaloneTest extends BaseTest {
	String myproductName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups={"purchase"})
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String countryName = " India";

		ProductCataloguePage productcatalogue = landingpage.loginMethod(input.get("email"), input.get("password"));

		List<WebElement> itemNames = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("myproductName"));
		CartPage cartpage = productcatalogue.clickOnCart();

		cartpage.getcartItemList();
		Boolean match = cartpage.matchMyProduct(input.get("myproductName"));
		Assert.assertTrue(match);
		PaymentPage pagementpage = cartpage.checkout();

		pagementpage.getText("ind");
		FinalPage finalpage = pagementpage.submit();

		String text = finalpage.getText1();
		Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	
	
	@Test(dependsOnMethods= {"submitorder"})
	public void OrderHistoryTest() {
		//Verify "ZARA COAT 3" is present or not
		ProductCataloguePage productcatalogue = landingpage.loginMethod("KKK11@nomail.com", "Kk@123456");
		OrderPage orderpage=productcatalogue.clickOnOrders();
		Assert.assertTrue(orderpage.verifyOrderDisplay(myproductName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map=new HashMap();
//		map.put("email", "KKK11@nomail.com");
//		map.put("password", "Kk@123456");
//		map.put("myproductName", "ZARA COAT 3");
//		
//		HashMap<String,String> map2=new HashMap();
//		map2.put("email", "KK111@nomail.com");
//		map2.put("password", "Kk@123456");
//		map2.put("myproductName", "ADIDAS ORIGINAL");
		List<HashMap<String,String>> data= getJasonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\mypractice\\testdata\\purchaseorderdata.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"KKK11@nomail.com","Kk@123456","ZARA COAT 3"},{"KK111@nomail.com","Kk@123456","ADIDAS ORIGINAL"}};
//	}
	
	
	
	

}
