package dataType;

public class PrimitiveType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 숫자  -> byte,short,char,int,long
		System.out.println("Byte의 범위:"+Byte.MIN_VALUE+"~"+Byte.MAX_VALUE);
		System.out.println("short의 범위:"+Short.MIN_VALUE+"~"+Short.MAX_VALUE);
		System.out.println("int의 범위:"+Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		System.out.println("long의 범위:"+Long.MIN_VALUE+"~"+Long.MAX_VALUE);
		
		// 문자 -> char, string
		/* 
		char = 2byte타입의 문자로 유니코드로도 가능하다.
		작은 따옴표로 표시한다
		*/ 
		char ch = 65;
		System.out.println("char:"+ch); // 유니코드
		char ch2 = 'A';
		System.out.println("char:"+ch2);
		/*
		String = 문자열 표시
		 */
		String str = "태영";
		System.out.println("String:"+str);
		// 실수 -> float, double
		// ** 자바는 실수 리터럴을 기본적으로 double 타입으로 생각하므로 맨 뒤에 소문자 f 또는 대문자 F를 붙이지 않으면 오류발생
		//float flo = 3.14; // 오류
		double dou = 3.14;
		System.out.println("float의 범위:"+Float.MIN_VALUE+"~"+Float.MAX_VALUE);
		System.out.println("double의 범위:"+Double.MIN_VALUE+"~"+Double.MAX_VALUE);
		
		// 논리 -> boolean true, false
		
		
	}

}
