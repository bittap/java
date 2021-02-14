package test;

import java.sql.Date;

public class Test {
	public static void main(String[] args) {
		java.util.Date date2 = new java.util.Date();
		Date date = new Date(date2.getTime());
		System.out.println(date);
		
	}
}
