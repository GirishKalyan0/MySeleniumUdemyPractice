package Maven_Testng.Maven_Testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.testng.annotations.Test;

public class MapMethod {

	@Test
	public  void StreamMap() {
		// TODO Auto-generated method stub
		// Ends with "n" and convert to UpperCase
		Stream.of("Bee","Anand","Yaan","Kalyan","Abhinav","Subhi","Athul").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println("Test1 "+s));
		
		// Starts with "a" and convert to UpperCase
		List<String> names=Arrays.asList("Bee","Anand","Yaan","Kalyan","Abhinav","Subhi","Athul");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("Test1 "+s));

	}
	@Test
	public void Merge() {
		ArrayList<String> names=new ArrayList();
		names.add("Bee");
		names.add("Anand");
		names.add("Yaan");
		names.add("Kalyan");
		names.add("Abhinav");
		names.add("Subhi");
		names.add("Athul");
		
		List<String> names1=Arrays.asList("XXX","YYY","ZZZ","AAA","EEE","Subhi","Yaan");
		
		Stream<String> newS=Stream.concat(names.stream(), names1.stream());
		newS.sorted().forEach(s->System.out.println("Test2 "+s));
		
	
		
		
	}
	@Test
	public void Match() {
		ArrayList<String> names=new ArrayList();
		names.add("Bee");
		names.add("Anand");
		names.add("Yaan");
		names.add("Kalyan");
		names.add("Abhinav");
		names.add("Subhi");
		names.add("Athul");
		
		List<String> names1=Arrays.asList("XXX","YYY","ZZZ","AAA","EEE","Subhi","Yaan");
		
		Stream<String> newS=Stream.concat(names.stream(), names1.stream());
		//newS.sorted().forEach(s->System.out.println(s));
		
		Boolean flag=newS.anyMatch(s->s.equalsIgnoreCase("Yaan"));
		Assert.assertTrue(flag);
		System.out.println("Test3 "+flag);
		
		
	}
	@Test
	public void Collect() {
		List<String>x=Stream.of("Bee","Anand","Yaan","Kalyan","Abhinav","Subhi","Athul").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println("Test4 "+x.get(0));
	}
	@Test
	public void Assignment() {
		List<Integer>x=Arrays.asList(2,4,3,6,7,3,5,3,5,9);
		x.stream().distinct().forEach(s->System.out.println("Test5 "+s));
		
		x.stream().distinct().sorted().collect(Collectors.toList()).forEach(s->System.out.println("Test6 "+s));;
		
	}
	
	
	

}