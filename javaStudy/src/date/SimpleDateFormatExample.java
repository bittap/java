package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {

	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
		
		
		System.out.println(simpleDateFormat.format(now));
	}

}
