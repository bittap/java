package date;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		
		Calendar calendar2 = Calendar.getInstance();
		String weekString = null;
		
		// Ò´Óø
		int year = calendar2.get(calendar2.YEAR);
		// êÅ
		int month = calendar2.get(calendar2.MONTH)+1;
		// ìí
		int day = calendar2.get(calendar2.DAY_OF_MONTH);
		// èøìí
		int week = calendar2.get(calendar2.DAY_OF_WEEK);
		// çíîñ£¯çíı­
		int amPm = calendar2.get(calendar2.AM_PM);
		// ãÁÊà
		int hour = calendar2.get(calendar2.HOUR);
		// İÂ
		int minute = calendar2.get(calendar2.MINUTE);
		// õ©
		int second = calendar2.get(calendar2.SECOND);

		switch (week) {
		case 1:
			weekString = "ÀÏ¿äÀÏ";
			break;
		case 2:
			weekString = "¿ù¿äÀÏ";
			break;
		case 3:
			weekString = "È­¿äÀÏ";
			break;
		case 4:
			weekString = "¼ö¿äÀÏ";
			break;
		case 5:
			weekString = "¸ñ¿äÀÏ";
			break;
		case 6:
			weekString = "±İ¿äÀÏ";
			break;
		case 7:
			weekString = "Åä¿äÀÏ";
			break;
			
		default:
			break;
		}
		
		String amPmVal = null;
		
		switch (amPm) {
		case Calendar.AM:
			amPmVal = "¿ÀÀü";
			break;
		case Calendar.PM:
			amPmVal = "¿ÀÈÄ";
			break;
		default:
			break;
		}
		
		
		
		System.out.printf("%d³â %d¿ù  %dÀÏ %s %s %d½Ã %dºĞ %dÃÊ",year,month,day,weekString,amPmVal,hour,minute,second);
		
		
	}

}
