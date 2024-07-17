package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

public class day1 {
	@Test
	public void Demo() {
		System.out.println("Hello World!!");
		
	}
	
	@Test(groups= {"Smoke"})
	public void jobb() {
		System.out.println("Bye");
	}
	
	
	
	@BeforeMethod
	public void BMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void AMethod() {
		System.out.println("After Method");
	}

}
