package date;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		
		Calendar calendar2 = Calendar.getInstance();
		String weekString = null;
		
		// Ҵ��
		int year = calendar2.get(calendar2.YEAR);
		// ��
		int month = calendar2.get(calendar2.MONTH)+1;
		// ��
		int day = calendar2.get(calendar2.DAY_OF_MONTH);
		// ����
		int week = calendar2.get(calendar2.DAY_OF_WEEK);
		// ��������
		int amPm = calendar2.get(calendar2.AM_PM);
		// ����
		int hour = calendar2.get(calendar2.HOUR);
		// ��
		int minute = calendar2.get(calendar2.MINUTE);
		// ��
		int second = calendar2.get(calendar2.SECOND);

		switch (week) {
		case 1:
			weekString = "�Ͽ���";
			break;
		case 2:
			weekString = "������";
			break;
		case 3:
			weekString = "ȭ����";
			break;
		case 4:
			weekString = "������";
			break;
		case 5:
			weekString = "�����";
			break;
		case 6:
			weekString = "�ݿ���";
			break;
		case 7:
			weekString = "�����";
			break;
			
		default:
			break;
		}
		
		String amPmVal = null;
		
		switch (amPm) {
		case Calendar.AM:
			amPmVal = "����";
			break;
		case Calendar.PM:
			amPmVal = "����";
			break;
		default:
			break;
		}
		
		
		
		System.out.printf("%d�� %d��  %d�� %s %s %d�� %d�� %d��",year,month,day,weekString,amPmVal,hour,minute,second);
		
		
	}

}
