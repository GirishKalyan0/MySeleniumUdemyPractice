package minusone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(arr.length);
		for (int x:arr) {
			if (x%2==0) {
			System.out.println(x);
			//break;
		}else {
			System.out.println(x+" Not divisible by 2");
		}

	}
		ArrayList<String> a = new ArrayList<String>();
		a.add("Girish");
		a.add("Kalyan");
		System.out.println(a.get(1));
		
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		
		System.out.println("$$$$$$$");
		
		for(String val:a) {
			System.out.println(val);
		}
		
		System.out.println(a.contains("selenium"));
		
		
		//Convert Array to Array list
		String[] name = {"mike","Bob","john"};
		List<String> nameArrayList=Arrays.asList(name);
		System.out.println(nameArrayList.contains("Bob"));
		System.out.println(nameArrayList);
		
		
		String[] x = {"w","r","s","y"};
		List<String> newx=Arrays.asList(x);
		

}
}
