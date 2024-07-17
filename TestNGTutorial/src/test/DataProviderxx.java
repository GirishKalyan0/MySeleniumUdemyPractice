package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderxx {
	
	@DataProvider
	public Object dataProviderxxx() {
		
		Object[][] data=new Object[3][2];
		data[0][0]="Username1";
		data[0][1]="password1";
		data[1][0]="Username2";
		data[1][1]="password2";
		data[2][0]="Username3";
		data[2][1]="password3";
		return data;
		
		
	}
	
	@Test(dataProvider="dataProviderxxx")
	public void Demo(String UserName,String Password) {
		System.out.println(UserName+" "+Password);
		
	}

}
