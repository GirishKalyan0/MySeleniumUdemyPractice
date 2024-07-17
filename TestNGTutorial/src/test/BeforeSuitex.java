package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//import org.testng.annotations.BeforeTest;

public class BeforeSuitex {
	
	
	@BeforeSuite
	public void Beforejobb() {
		System.out.println("Before Suite");
	}
	
	
	@AfterSuite
	public void Afterjobb() {
		System.out.println("After Suite");
	}

}
