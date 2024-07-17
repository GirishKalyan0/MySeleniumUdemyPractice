package DateClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("S_m_H_M_d_Y"); 
		System.out.println(sd.format(cal.getTime()));
		System.out.println(cal.get(Calendar.AM_PM));
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR));

	}

}
