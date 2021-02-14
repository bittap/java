package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateT {

	public int todayCompareDate(String compareDate) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String date = format1.format(new Date());

		try {
			Date now = format1.parse(date);
			Date enforce_date = format1.parse(compareDate);
			return now.compareTo(enforce_date);
		} catch (ParseException e) {
			e.printStackTrace();
			return 100;
		}
		
		
		
		
	}
}
