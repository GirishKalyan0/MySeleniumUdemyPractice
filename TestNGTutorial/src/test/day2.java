package test;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

public class day2 {
	
	@Test
	public void ghgh() {
		System.out.println("ghfhjf");
	}
	
	
	@Test
	public void onlythisInclude1() {
		System.out.println("onlythisInclude1");
	}
	
	@Test(groups= {"Smoke"})
	public void onlythisInclude2() {
		System.out.println("onlythisInclude2");
	}

}
