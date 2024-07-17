package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day5 {
	
	@Test(groups= {"Smoke"})
	public void WebLoginHomeLoan() {
		System.out.println("WebLoginHomeLoan");
		
	}
	
	@Test
	public void MobileLoginHomeLoan() {
		System.out.println("MobileLoginHomeLoan");
	}
	
	@Test
	public void LoginAPIHomeLoan() {
		System.out.println("LoginAPIHomeLoan");
		
	}
	
	@Test
	public void jobb() {
		System.out.println("Bye");
	}
	
	@BeforeTest
	public void Beforejobb() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void Afterjobb() {
		System.out.println("After Test");
	}
	
	




 

}
