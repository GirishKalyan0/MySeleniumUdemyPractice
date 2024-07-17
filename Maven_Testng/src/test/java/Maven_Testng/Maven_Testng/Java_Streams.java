package Maven_Testng.Maven_Testng;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Java_Streams {
	
	
	//Streams cantnot return false, they return only true

	@Test
	public void Regular() {
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList();
		names.add("Bee");
		names.add("Anand");
		names.add("Yaan");
		names.add("Kalyan");
		names.add("Abhinav");
		names.add("Subhi");
		names.add("Athul");
		int count =0;
		for(int i=0;i<names.size();i++) {
			if(names.get(i).startsWith("A")) {
				count++;
				
			}
		}
		System.out.println(count);

	}
	@Test
	public void StreamFilter() {
		ArrayList<String> names=new ArrayList();
		names.add("Bee");
		names.add("Anand");
		names.add("Yaan");
		names.add("Kalyan");
		names.add("Abhinav");
		names.add("Subhi");
		names.add("Athul");
		
		long c= names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		 names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s)); // very optimized code line
		 names.stream().filter(s->s.length()<=4).limit(3).forEach(s->System.out.println(s)); // very optimized code line
		 
		
	}
	@Test
	public void SingleStepStream() {
		long x=Stream.of("Bee","Anand","Yaan","Kalyan","Abhinav","Subhi","Athul").filter(s->s.startsWith("A")).count();
		System.out.println(x);
	}
	
	@Test
	public void SystematicWay() {
		long x=Stream.of("Bee","Anand","Yaan","Kalyan","Abhinav","Subhi","Athul").filter(s->{
			s.startsWith("A");
			return true;
		}).count();
	}

}
