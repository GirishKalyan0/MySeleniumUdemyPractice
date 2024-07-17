package minusone;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodsDemo x = new MethodsDemo();
		String name= x.getData();
		System.out.println(name);
		x.getData1();
		
		MethodsDemo2 w = new MethodsDemo2();// calling another class and methods
		w.getUserData();
		
		getData3(); // using static keyword without creating object

	}
	
	public String getData() {
		System.out.println("Hello!!");
		return "xxxxx";
	}
	
	public void getData1() {
		System.out.println("Hello2!!");
		
	}
	
	public static void getData3() { // using static keyword without creating object
		System.out.println("Hello3!!");
	}

}
