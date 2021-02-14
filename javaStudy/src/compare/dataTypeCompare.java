package compare;

public class dataTypeCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 자바는 기본 타입은 == String은 String.equals("문자열")
		
		String str = "사람";
		String str2 = "사람";
		
		if(str.equals(str2)) {
			System.out.println("문자열 일치는 equals");
		}
		
		int su1 = 10;
		int su2 = 10;
		
		if(su1 == su2) {
			System.out.println("실수 일치는 ==");
		}
		
		float flo = 10.5f;
		double dou = 10.5;
		
		if(flo == dou) {
			System.out.println("실수 일치도 ==");
		}
		
		boolean trueBoolean1 = true;
		boolean trueBoolean2 = true;
		
		if(trueBoolean1 == trueBoolean2) {
			System.out.println("불린 일치는 ==");
		}
	}

}
