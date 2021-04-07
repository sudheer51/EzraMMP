package org.iit.healthcare;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utility {
	
	static Random rand =new Random();
	public  static String getFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(d);
		return date;
	}
	public static String getRandomString(int noofChars) {
		String s = "";
		int bound = noofChars;
		for (int i = 0; i<bound; i++) {
			char c = (char) (97+rand.nextInt(26));
			s= s+c;
		}
		return s;
	}
	
	public static String getRandomStringUcase(int noofChars) {
		String s = "";
		int bound = noofChars;
		for (int i = 0; i<bound; i++) {
			char c = (char) (65+rand.nextInt(25));
			s= s+c;
		}
		return s;
	}
	
	public static String getRandomSpecialChars(int noofSpecialChars) {
		String s = "";
		int bound = noofSpecialChars;
		for (int i = 0; i<bound; i++) {
			char c = (char) (33+rand.nextInt(14));
			s= s+c;
		}
		return s;
	}
	public static String getRandomNumbers(int noofDigits) {
		String s = "";
		int bound = noofDigits;
		for (int i = 0; i<bound; i++) {
			char c = (char) (48+rand.nextInt(10));
			s= s+c;
		}
		return s;
	}
}



