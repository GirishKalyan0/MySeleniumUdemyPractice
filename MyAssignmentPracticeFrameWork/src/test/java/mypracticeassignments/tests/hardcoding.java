package mypracticeassignments.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.HomePage;
import PageObjects.LandingPage;
import PageObjects.OffersPage;
import test.Components.BaseTest;

public class hardcoding extends BaseTest {

	@Test
	public void submit() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		String[] products = { "Brinjal", "Mushroom", "Pomegranate", "Strawberry" };
		landingpage.getItems(products);
		CartPage cartpage = landingpage.clickbuttons();
		CheckOutPage checkout = cartpage.cartpageactions("rahulshettyacademy");
		HomePage homepage = checkout.checkoutactions("India");
		OffersPage offerpage = homepage.homepageactions();
		offerpage.offerpageactions();

	}

}
