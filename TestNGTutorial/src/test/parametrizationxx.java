
	
	package test;

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
	import org.testng.internal.Utils;

	public class parametrizationxx {
		@Parameters({"URL","UserName"})
		@Test
		public void Demo(String urlname, String UserName) {
			System.out.println("Hello World!!");
			System.out.println(urlname+" "+UserName);
			
		}
		
		@Test
		public void jobb() {
			System.out.println("Bye");
		}
		
		
		
		@Test
		public void BMethod() {
			System.out.println("Before Method");
		}
		
		@Test
		public void AMethod() {
			System.out.println("After Method");
		}

	}



