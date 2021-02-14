package typeChange;

public class TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 자동타입변환
		// 큰 데이터 타입 = 작은 데이터 타입
		long longValue = 500000;
		double doubleValue = longValue;
		System.out.println(doubleValue);
		
		// 강제타입변환
		// 작은 데이터 타입 = (작은 데이터 타입) 큰 데이터 타입
		int intValue = 44032;
		char charValue = (char) intValue;
		System.out.println(charValue);
		
		long longValue2 = 500;
		int intValue2 = (int) longValue2;
		System.out.println(longValue2);
		
		// 실수타입을 정수로 변환하면 소수점은 버려진다.
		double doubleVlue = 1000.3;
		int double_int = (int)doubleVlue;
		System.out.println(double_int);
		
		long su = 50000000000L;
		int ss = (int) su;
		System.out.println(ss);
		

		
	}

}
