package enum_package;

import java.util.Calendar;

public class InvokeEnum {

	public static void main(String[] args) {
		Week today1 = Week.TUESDAY;
		
		if(today1 == Week.TUESDAY) {
			System.out.println("���ÿ����� �������� ���� �޸𸮸� �����Ѵ�.");
		}

		// ������ ���Ͽ� �ش��ϴ� ������ �����Ѵ�.
		Week today = null;
		Calendar cal = Calendar.getInstance();
		int week = cal.get(cal.DAY_OF_WEEK);
		
		switch (week) {
		case 1: today = Week.MONDAY;
			break;
		case 2: today = Week.THURSDAY;
			break;
		case 3: today = Week.WEDNESDA;
			break;
		case 4: today = Week.THURSDAY;
			break;
		case 5: today = Week.FRIDAY;
			break;
		case 6: today = Week.SATURDAY;
			break;
		case 7: today = Week.SUNDAY;
			break;
		default:
			break;
		}
		
		System.out.println(today);
		
	}

}
