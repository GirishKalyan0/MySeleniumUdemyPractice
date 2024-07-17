package minusone;

public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String is an object that represents sequence of characters
		//String literal if values are same it dont create new object, it refers first (s)
		String s = "My name is CCCC";
		String s1 = "xx";
		
		
		//New instance if values are same it creates different object
		String x =new String("Welcome");
		String x1= new String("Welcome");
		
		String[] splittedArray= s.split("is");
		System.out.println(splittedArray[0]);
		System.out.println(splittedArray[1]);
		//System.out.println(splittedArray[2]);
		System.out.println(splittedArray[1].trim());// will remove spaces
		
		
		
		for (int i=0;i<s.length();i++) {
			System.out.println(s.charAt(i));
		}
		
		for (int i=s.length()-1;i>=0;i--) {
			System.out.println(s.charAt(i));
		}
	
	

	}

}
