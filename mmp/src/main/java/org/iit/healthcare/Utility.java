package org.iit.healthcare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {
	
	public static String readTextFromFile(String fileName) {
		FileReader fr = null;
		BufferedReader br = null;
		String txt = "";
		String str = "";

		File f = new File(fileName);
		try {
			fr = new FileReader(f.getAbsolutePath());
			br = new BufferedReader(fr);

			while ((str = br.readLine()) != null) {

				txt = txt + str;
				System.out.println("Reading the text:--" + str);
				// System.out.println("print text " + text);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				br.close();
				fr.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return txt;
	}
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
