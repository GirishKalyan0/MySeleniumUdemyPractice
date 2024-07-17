package DateClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d = new Date();

		SimpleDateFormat sd = new SimpleDateFormat("S_m_H_M_d_Y");    //seconds_minutes_hours_month_day_year
		SimpleDateFormat sd2 = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		String currentTimeandate=sd.format(d);
		System.out.println(currentTimeandate);
		System.out.println(sd2.format(d));
		
		

	}

}
