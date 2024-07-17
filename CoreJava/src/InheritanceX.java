import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InheritanceX {

	public void getData() {
		// TODO Auto-generated method stub
		System.out.println("Inheritance From one class to other class");

	}
	
	@BeforeMethod
	public void beforeTest() {
		System.out.println("Run Before Test");
	}
	
	@AfterMethod
	public void AfterTest() {
		System.out.println("Run After Test");
	}
	

}
