package org.iit.healthcare;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {
	
	public  static String getFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(d);
		return date;
	}

}
