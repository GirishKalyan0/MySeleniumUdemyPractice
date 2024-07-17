package minusone;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum =5;
		String name="Girish Kalyan";
		char letter = 'B';
		boolean major= true;
		double percentage = 7.25;
		
		System.out.println(myNum+" is your number");
		
		//-----Arrays-----
		int[] arr= new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		int[] arr2 = {6,7,8,9,10};
		System.out.println(arr2[4]);
		
		// for loop
		
	for (int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
	}
	for (int i=0;i<arr2.length;i++) {
		System.out.println(arr2[i]);
	}
		
	String[] names= {"Yaan", "Bee"};
	for (int i=0;i<names.length;i++) {
		System.out.println(names[i]);
	}
		
	for (int x : arr){
		System.out.println(x);
	}

	}

}
