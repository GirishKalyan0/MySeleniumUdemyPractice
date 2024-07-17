import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InheriteFromParentX extends InheritanceX { //extends InheritanceX

	
	@Test
	public void testRun() {
		// TODO Auto-generated method stub
		
		//InheritanceX x=new InheritanceX();
		//x.getData();
		getData();
		
		passingParametersByConstructor x=new passingParametersByConstructor(3);//parameterized constuctor
		
		System.out.println(x.increament());
		
		
		System.out.println(x.decreament());
		
//		MyParcticeConstuctor y=new MyParcticeConstuctor(3);
//		System.out.println(y.decreament());
		
		
		System.out.println(x.multiplyByTwo());
		System.out.println(x.multiplyByThree());
	
		

	}

}
