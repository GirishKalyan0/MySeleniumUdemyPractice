package test;

import org.testng.annotations.Test;

public class DependsOnMethodsxx {
	
	@Test
	public void dependsOnMethodsxx() {
		System.out.println("dependsOnMethods");
		
	}
	
	@Test
	public void ABCMobileLoginHomeLoan() {
		System.out.println("ABCMobileLoginHomeLoan");
	}
	
	@Test(enabled=false)// to skip the bug 
	public void ABCLoginAPIHomeLoan() {
		System.out.println("ABCLoginAPIHomeLoan");
		
	}
	
	

		
		@Test(dependsOnMethods= {"dependsOnMethodsxx"})
		public void WebLoginHomeLoan() {
			System.out.println("WebLoginHomeLoan");
			
		}
		
		@Test(timeOut=4000)
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




	 

	





 

}
